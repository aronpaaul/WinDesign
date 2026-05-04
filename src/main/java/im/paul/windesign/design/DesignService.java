package im.paul.windesign.design;

import im.paul.windesign.database.io.JsonDesignStore;
import im.paul.windesign.database.io.SqliteDesignRepository;
import im.paul.windesign.design.persistence.DesignPersistenceService;
import im.paul.windesign.design.service.BracketsService;
import im.paul.windesign.design.service.NameColorService;
import im.paul.windesign.design.service.PrefixService;
import im.paul.windesign.design.service.TagService;
import im.paul.windesign.design.service.TabTitleService;
import im.paul.windesign.design.state.DesignState;
import im.paul.windesign.hooks.luckperms.LuckPermsHook;
import im.paul.windesign.hooks.playerpoints.PlayerPointsHook;
import java.util.Locale;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Центральный сервис для работы с дизайнами игроков.
 */
public class DesignService {
    private final DesignState state;
    private final DesignPersistenceService persistenceService;
    private final NameColorService nameColorService;
    private final PrefixService prefixService;
    private final TagService tagService;
    private final TabTitleService tabTitleService;
    private final BracketsService bracketsService;
    private final LuckPermsHook luckPermsHook;
    private final PlayerPointsHook playerPointsHook;

    /**
     * Создаёт сервис дизайнов.
     *
     * @param plugin экземпляр плагина
     * @param debug режим отладки
     * @param luckPermsHook хук LuckPerms
     * @param playerPointsHook хук PlayerPoints
     * @param designRepository репозиторий SQLite
     * @param jsonDesignStore хранилище JSON для миграции
     */
    public DesignService(JavaPlugin plugin, boolean debug, LuckPermsHook luckPermsHook, PlayerPointsHook playerPointsHook,
                         SqliteDesignRepository designRepository, JsonDesignStore jsonDesignStore) {
        this.luckPermsHook = luckPermsHook;
        this.playerPointsHook = playerPointsHook;
        this.state = new DesignState();
        this.persistenceService = new DesignPersistenceService(plugin, debug, designRepository, jsonDesignStore, this.state);
        this.nameColorService = new NameColorService(plugin, this.state, this.persistenceService);
        this.prefixService = new PrefixService(plugin, this.state, this.persistenceService, luckPermsHook);
        this.tagService = new TagService(plugin, this.state, this.persistenceService);
        this.tabTitleService = new TabTitleService(plugin);
        this.bracketsService = new BracketsService(plugin, this.state, this.persistenceService);
    }

    /**
     * Инициализирует сервис и миграции.
     */
    public void init() {
        this.persistenceService.init();
    }

    /**
     * Завершает работу сервиса и сохраняет данные.
     */
    public void shutdown() {
        this.persistenceService.shutdown();
    }

    /**
     * Загружает данные игрока в память.
     *
     * @param playerName ник игрока
     */
    public void loadPlayerData(String playerName) {
        this.persistenceService.loadPlayerData(playerName);
    }

    /**
     * Сохраняет данные игрока.
     *
     * @param playerName ник игрока
     */
    public void savePlayerData(String playerName) {
        this.persistenceService.savePlayerData(playerName);
    }

    /**
     * Очищает кэш данных игрока.
     *
     * @param playerName ник игрока
     */
    public void clearPlayerData(String playerName) {
        this.state.clearPlayerData(playerName);
    }

    /**
     * Возвращает цвет ника игрока.
     *
     * @param player игрок
     * @return цвет ника
     */
    public String getPlayerColor(Player player) {
        return this.nameColorService.getPlayerColor(player);
    }

    /**
     * Возвращает ключ выбранного цвета ника.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerColorNumber(Player player) {
        return this.nameColorService.getPlayerColorNumber(player);
    }

    /**
     * Устанавливает цвет ника игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerColor(Player player, String colorKey) {
        this.nameColorService.setPlayerColor(player, colorKey);
    }

    /**
     * Устанавливает кастомный HEX-цвет ника по имени игрока.
     *
     * @param playerName ник игрока
     * @param hexColor HEX-цвет (RRGGBB, #RRGGBB или &#RRGGBB)
     * @return true если цвет валиден и сохранён
     */
    public boolean setPlayerCustomNameColor(String playerName, String hexColor) {
        if (playerName == null || playerName.trim().isEmpty()) {
            return false;
        }

        this.loadPlayerData(playerName);
        return this.nameColorService.setPlayerCustomColor(playerName, hexColor);
    }

    /**
     * Возвращает префикс без цветовых кодов.
     *
     * @param player игрок
     * @return префикс без кодов цвета
     */
    public String getFormattedPrefix(Player player) {
        return this.prefixService.getFormattedPrefix(player);
    }

    /**
     * Выдаёт игроку пермишен.
     *
     * @param player игрок
     * @param permission пермишен
     */
    public void addPermission(Player player, String permission) {
        this.luckPermsHook.addPermission(player, permission);
    }

    /**
     * Списывает токены игрока.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void takePoints(Player player, int amount) {
        this.playerPointsHook.takePoints(player, amount);
    }

    /**
     * Начисляет токены игроку.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void depositPoints(Player player, int amount) {
        this.playerPointsHook.givePoints(player, amount);
    }

    /**
     * Возвращает количество токенов игрока.
     *
     * @param player игрок
     * @return количество токенов
     */
    public int getPoints(Player player) {
        return this.playerPointsHook.getPoints(player);
    }

    /**
     * Возвращает префикс без HEX-цветов.
     *
     * @param player игрок
     * @return префикс без HEX-цветов
     */
    public String getFormattedPrefixColor(Player player) {
        return this.prefixService.getFormattedPrefixColor(player);
    }

    /**
     * Возвращает первый цветовой код из префикса LuckPerms.
     *
     * @param player игрок
     * @return цветовой код
     */
    public String getLuckPermsPrefixColorCode(Player player) {
        return this.prefixService.getLuckPermsPrefixColorCode(player);
    }

    /**
     * Возвращает итоговый цвет префикса с учётом кастомизации.
     *
     * @param player игрок
     * @return цвет префикса
     */
    public String getEffectivePrefixColor(Player player) {
        return this.prefixService.getEffectivePrefixColor(player);
    }

    /**
     * Возвращает префикс LuckPerms.
     *
     * @param player игрок
     * @return префикс
     */
    public String getLuckPermsPrefix(Player player) {
        return this.prefixService.getLuckPermsPrefix(player);
    }

    /**
     * Возвращает префикс игрока с учётом настроек.
     *
     * @param player игрок
     * @return префикс
     */
    public String getPlayerPrefix(Player player) {
        return this.prefixService.getPlayerPrefix(player);
    }

    /**
     * Проверяет, установлен ли кастомный префикс.
     *
     * @param player игрок
     * @return true если префикс задан вручную
     */
    public boolean hasCustomPrefix(Player player) {
        return this.prefixService.hasCustomPrefix(player);
    }

    /**
     * Проверяет, установлен ли кастомный цвет префикса.
     *
     * @param player игрок
     * @return true если цвет задан вручную
     */
    public boolean hasCustomPrefixColor(Player player) {
        return this.prefixService.hasCustomPrefixColor(player);
    }

    /**
     * Проверяет, установлен ли кастомный тег.
     *
     * @param player игрок
     * @return true если тег задан вручную
     */
    public boolean hasCustomTag(Player player) {
        return this.tagService.hasCustomTag(player);
    }

    /**
     * Возвращает ключ выбранного префикса.
     *
     * @param player игрок
     * @return ключ префикса
     */
    public String getPlayerPrefixNumber(Player player) {
        return this.prefixService.getPlayerPrefixNumber(player);
    }

    /**
     * Устанавливает префикс игрока.
     *
     * @param player игрок
     * @param colorKey ключ префикса
     */
    public void setPlayerPrefix(Player player, String colorKey) {
        this.prefixService.setPlayerPrefix(player, colorKey);
    }

    /**
     * Возвращает цвет префикса игрока.
     *
     * @param player игрок
     * @return цвет префикса
     */
    public String getPrefixPlayerColor(Player player) {
        return this.prefixService.getPrefixPlayerColor(player);
    }

    /**
     * Возвращает ключ цвета префикса.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerPrefixColorNumber(Player player) {
        return this.prefixService.getPlayerPrefixColorNumber(player);
    }

    /**
     * Устанавливает цвет префикса игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerPrefixColor(Player player, String colorKey) {
        this.prefixService.setPlayerPrefixColor(player, colorKey);
    }

    /**
     * Возвращает тег игрока.
     *
     * @param player игрок
     * @return тег
     */
    public String getPlayerTag(Player player) {
        return this.tagService.getPlayerTag(player);
    }

    /**
     * Возвращает ключ выбранного тега.
     *
     * @param player игрок
     * @return ключ тега
     */
    public String getPlayerTagNumber(Player player) {
        return this.tagService.getPlayerTagNumber(player);
    }

    /**
     * Устанавливает тег игрока.
     *
     * @param player игрок
     * @param colorKey ключ тега
     */
    public void setPlayerTag(Player player, String colorKey) {
        this.tagService.setPlayerTag(player, colorKey);
    }

    /**
     * Возвращает цвет тега игрока.
     *
     * @param player игрок
     * @return цвет тега
     */
    public String getPlayerTagColor(Player player) {
        return this.tagService.getPlayerTagColor(player);
    }

    /**
     * Возвращает ключ цвета тега.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerTagColorNumber(Player player) {
        return this.tagService.getPlayerTagColorNumber(player);
    }

    /**
     * Устанавливает цвет тега игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerTagColor(Player player, String colorKey) {
        this.tagService.setPlayerTagColor(player, colorKey);
    }

    /**
     * Устанавливает кастомный титул игрока только в TAB.
     *
     * @param playerName ник игрока
     * @param title текст титула
     * @return результат выполнения команды TAB
     */
    public TabTitleService.Result setPlayerCustomTabTitle(String playerName, String title) {
        return this.tabTitleService.setPlayerTabTitle(playerName, title);
    }

    /**
     * Удаляет кастомный титул игрока только в TAB.
     *
     * @param playerName ник игрока
     * @return результат выполнения команды TAB
     */
    public TabTitleService.Result clearPlayerCustomTabTitle(String playerName) {
        return this.tabTitleService.clearPlayerTabTitle(playerName);
    }

    /**
     * Возвращает левую скобку игрока.
     *
     * @param player игрок
     * @return левая скобка
     */
    public String getPlayerBracketsLeft(Player player) {
        return this.bracketsService.getPlayerBracketsLeft(player);
    }

    /**
     * Возвращает правую скобку игрока.
     *
     * @param player игрок
     * @return правая скобка
     */
    public String getPlayerBracketsRight(Player player) {
        return this.bracketsService.getPlayerBracketsRight(player);
    }

    /**
     * Возвращает ключ выбранных скобок.
     *
     * @param player игрок
     * @return ключ скобок
     */
    public String getPlayerBracketsNumber(Player player) {
        return this.bracketsService.getPlayerBracketsNumber(player);
    }

    /**
     * Устанавливает скобки игрока.
     *
     * @param player игрок
     * @param colorKey ключ скобок
     */
    public void setPlayerBrackets(Player player, String colorKey) {
        this.bracketsService.setPlayerBrackets(player, colorKey);
    }

    /**
     * Возвращает цвет скобок игрока.
     *
     * @param player игрок
     * @return цвет скобок
     */
    public String getPlayerBracketsColor(Player player) {
        return this.bracketsService.getPlayerBracketsColor(player);
    }

    /**
     * Возвращает ключ цвета скобок.
     *
     * @param player игрок
     * @return ключ цвета скобок
     */
    public String getPlayerBracketsColorNumber(Player player) {
        return this.bracketsService.getPlayerBracketsColorNumber(player);
    }

    /**
     * Устанавливает цвет скобок игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerBracketsColor(Player player, String colorKey) {
        this.bracketsService.setPlayerBracketsColor(player, colorKey);
    }

    /**
     * Сбрасывает конкретный тип дизайна игрока к дефолтному состоянию и сохраняет изменения в БД.
     *
     * @param playerName ник игрока
     * @param designType тип дизайна
     * @return true если тип поддерживается и очистка выполнена
     */
    public boolean clearPlayerDesignType(String playerName, String designType) {
        if (playerName == null || playerName.trim().isEmpty() || designType == null) {
            return false;
        }

        String normalizedType = designType.toLowerCase(Locale.ROOT);
        this.loadPlayerData(playerName);

        if (normalizedType.equals("namecolor")) {
            this.state.setNameColorKey(playerName, "1");
        } else if (normalizedType.equals("tag")) {
            this.state.setTagKey(playerName, null);
            this.clearPlayerCustomTabTitle(playerName);
        } else if (normalizedType.equals("tagcolor")) {
            this.state.setTagColorKey(playerName, "1");
        } else if (normalizedType.equals("prefix")) {
            this.state.setPrefixKey(playerName, null);
            this.state.setPrefixCustomValue(playerName, null);
        } else if (normalizedType.equals("prefixcolor")) {
            this.state.setPrefixColorKey(playerName, null);
            this.state.setPrefixColorCustomValue(playerName, null);
        } else if (normalizedType.equals("brackets")) {
            this.state.setBracketsKey(playerName, "1");
        } else if (normalizedType.equals("bracketscolor")) {
            this.state.setBracketsColorKey(playerName, "1");
        } else if (normalizedType.equals("all")) {
            this.state.setNameColorKey(playerName, "1");
            this.state.setTagKey(playerName, null);
            this.clearPlayerCustomTabTitle(playerName);
            this.state.setTagColorKey(playerName, "1");
            this.state.setPrefixKey(playerName, null);
            this.state.setPrefixCustomValue(playerName, null);
            this.state.setPrefixColorKey(playerName, null);
            this.state.setPrefixColorCustomValue(playerName, null);
            this.state.setBracketsKey(playerName, "1");
            this.state.setBracketsColorKey(playerName, "1");
        } else {
            return false;
        }

        this.savePlayerData(playerName);
        return true;
    }
}

