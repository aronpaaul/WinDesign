package im.scaredead.windesign.design.service;

import im.scaredead.windesign.design.persistence.DesignPersistenceService;
import im.scaredead.windesign.design.state.DesignState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис управления тегами и цветами тегов.
 */
public class TagService {
    private final JavaPlugin plugin;
    private final DesignState state;
    private final DesignPersistenceService persistenceService;

    public TagService(JavaPlugin plugin, DesignState state, DesignPersistenceService persistenceService) {
        this.plugin = plugin;
        this.state = state;
        this.persistenceService = persistenceService;
    }

    /**
     * Проверяет, установлен ли у игрока кастомный тег.
     *
     * @param player игрок
     * @return true если тег установлен
     */
    public boolean hasCustomTag(Player player) {
        return this.state.hasTag(player.getName());
    }

    /**
     * Возвращает текущий тег игрока.
     *
     * @param player игрок
     * @return тег или null
     */
    public String getPlayerTag(Player player) {
        String playerName = player.getName();
        if (this.state.hasTag(playerName)) {
            FileConfiguration config = this.plugin.getConfig();
            String key = this.state.getTagKey(playerName);
            return config.getString("tags." + key + ".name");
        }
        return null;
    }

    /**
     * Возвращает ключ выбранного тега.
     *
     * @param player игрок
     * @return ключ тега
     */
    public String getPlayerTagNumber(Player player) {
        String playerName = player.getName();
        return this.state.hasTag(playerName) ? this.state.getTagKey(playerName) : "";
    }

    /**
     * Устанавливает тег игрока.
     *
     * @param player игрок
     * @param colorKey ключ тега
     */
    public void setPlayerTag(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setTagKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }

    /**
     * Возвращает текущий цвет тега.
     *
     * @param player игрок
     * @return цвет тега
     */
    public String getPlayerTagColor(Player player) {
        String playerName = player.getName();
        String key = this.state.getTagColorKey(playerName);
        if (key != null) {
            FileConfiguration config = this.plugin.getConfig();
            return config.getString("tags-colors." + key + ".color");
        }
        return "§f";
    }

    /**
     * Возвращает ключ выбранного цвета тега.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerTagColorNumber(Player player) {
        String playerName = player.getName();
        String key = this.state.getTagColorKey(playerName);
        return key != null ? key : "1";
    }

    /**
     * Устанавливает цвет тега.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerTagColor(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setTagColorKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }
}
