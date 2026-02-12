package im.scaredead.windesign.design.persistence;

import im.scaredead.windesign.database.io.JsonDesignStore;
import im.scaredead.windesign.database.io.SqliteDesignRepository;
import im.scaredead.windesign.database.model.PlayerDesign;
import im.scaredead.windesign.design.state.DesignState;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.BiConsumer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис сохранения и загрузки дизайнов игроков (SQLite + миграция из JSON).
 */
public class DesignPersistenceService {
    private final JavaPlugin plugin;
    private final boolean debug;
    private final SqliteDesignRepository designRepository;
    private final JsonDesignStore jsonDesignStore;
    private final DesignState state;

    public DesignPersistenceService(JavaPlugin plugin, boolean debug, SqliteDesignRepository designRepository,
                                    JsonDesignStore jsonDesignStore, DesignState state) {
        this.plugin = plugin;
        this.debug = debug;
        this.designRepository = designRepository;
        this.jsonDesignStore = jsonDesignStore;
        this.state = state;
    }

    /**
     * Инициализирует persistence и при необходимости выполняет миграцию из JSON.
     */
    public void init() {
        this.migrateJsonToDatabaseIfNeeded();
    }

    /**
     * Сохраняет весь кэш в базу данных.
     */
    public void shutdown() {
        this.saveAllPlayersToDatabase();
    }

    /**
     * Загружает данные игрока из базы в память.
     *
     * @param playerName имя игрока
     */
    public void loadPlayerData(String playerName) {
        this.loadPlayerDataFromDatabase(playerName);
    }

    /**
     * Сохраняет данные игрока из памяти в базу.
     *
     * @param playerName имя игрока
     */
    public void savePlayerData(String playerName) {
        this.savePlayerDataToDatabase(playerName);
    }

    private void migrateJsonToDatabaseIfNeeded() {
        if (this.designRepository == null || this.jsonDesignStore == null) {
            return;
        }

        if (!this.designRepository.isEmpty()) {
            return;
        }

        Map<String, String> colors = this.jsonDesignStore.readMap("playerColors.json");
        Map<String, String> prefixes = this.jsonDesignStore.readMap("playerPrefix.json");
        Map<String, String> prefixColors = this.jsonDesignStore.readMap("playerPrefixColors.json");
        Map<String, String> prefixCustom = this.jsonDesignStore.readMap("playerPrefixCustom.json");
        Map<String, String> prefixColorCustom = this.jsonDesignStore.readMap("playerPrefixColorCustom.json");
        Map<String, String> tags = this.jsonDesignStore.readMap("playerTags.json");
        Map<String, String> tagsColors = this.jsonDesignStore.readMap("playerTagsColors.json");
        Map<String, String> brackets = this.jsonDesignStore.readMap("playerBrackets.json");
        Map<String, String> bracketsColors = this.jsonDesignStore.readMap("playerBracketsColor.json");

        boolean empty = colors.isEmpty() && prefixes.isEmpty() && prefixColors.isEmpty() && prefixCustom.isEmpty()
                && prefixColorCustom.isEmpty() && tags.isEmpty() && tagsColors.isEmpty()
                && brackets.isEmpty() && bracketsColors.isEmpty();
        if (empty) {
            return;
        }

        this.applyMap(colors, this.state::setNameColorKey);
        this.applyMap(prefixes, this.state::setPrefixKey);
        this.applyMap(prefixColors, this.state::setPrefixColorKey);
        this.applyMap(prefixCustom, this.state::setPrefixCustomValue);
        this.applyMap(prefixColorCustom, this.state::setPrefixColorCustomValue);
        this.applyMap(tags, this.state::setTagKey);
        this.applyMap(tagsColors, this.state::setTagColorKey);
        this.applyMap(brackets, this.state::setBracketsKey);
        this.applyMap(bracketsColors, this.state::setBracketsColorKey);

        this.saveAllPlayersToDatabase();
        this.state.clearAll();

        if (this.debug) {
            this.plugin.getLogger().info("WinDesign » Миграция JSON -> SQLite выполнена.");
        }
    }

    private void saveAllPlayersToDatabase() {
        if (this.designRepository == null) {
            return;
        }

        for (String playerName : this.state.collectAllPlayers()) {
            this.savePlayerDataToDatabase(playerName);
        }
    }

    private void savePlayerDataToDatabase(String playerName) {
        if (this.designRepository == null) {
            return;
        }

        try {
            this.designRepository.save(playerName, this.buildPlayerDesign(playerName));
        } catch (SQLException e) {
            if (this.debug) {
                this.plugin.getLogger().warning("WinDesign » Ошибка сохранения данных игрока " + playerName + " в SQLite.");
            }
        }
    }

    private void loadPlayerDataFromDatabase(String playerName) {
        if (this.designRepository == null) {
            return;
        }

        try {
            PlayerDesign design = this.designRepository.load(playerName);
            if (design != null) {
                this.applyPlayerDesign(playerName, design);
            } else {
                this.state.clearPlayerData(playerName);
            }
        } catch (SQLException e) {
            if (this.debug) {
                this.plugin.getLogger().warning("WinDesign » Ошибка загрузки данных игрока " + playerName + " из SQLite.");
            }
        }
    }

    private PlayerDesign buildPlayerDesign(String playerName) {
        return new PlayerDesign(
                this.state.getNameColorKey(playerName),
                this.state.getTagKey(playerName),
                this.state.getTagColorKey(playerName),
                this.state.getPrefixKey(playerName),
                this.state.getBracketsKey(playerName),
                this.state.getBracketsColorKey(playerName),
                this.state.getPrefixColorKey(playerName),
                this.state.getPrefixCustomValue(playerName),
                this.state.getPrefixColorCustomValue(playerName)
        );
    }

    private void applyPlayerDesign(String playerName, PlayerDesign design) {
        this.state.setNameColorKey(playerName, design.getNameColor());
        this.state.setTagKey(playerName, design.getTag());
        this.state.setTagColorKey(playerName, design.getTagColor());
        this.state.setPrefixKey(playerName, design.getPrefix());
        this.state.setBracketsKey(playerName, design.getBrackets());
        this.state.setBracketsColorKey(playerName, design.getBracketsColor());
        this.state.setPrefixColorKey(playerName, design.getPrefixColor());
        this.state.setPrefixCustomValue(playerName, design.getPrefixCustom());
        this.state.setPrefixColorCustomValue(playerName, design.getPrefixColorCustom());
    }

    private void applyMap(Map<String, String> map, BiConsumer<String, String> setter) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            setter.accept(entry.getKey(), entry.getValue());
        }
    }
}
