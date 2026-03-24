package im.paul.windesign;

import im.paul.windesign.commands.NameColor;
import im.paul.windesign.commands.TabCompleters;
import im.paul.windesign.database.DatabaseManager;
import im.paul.windesign.database.io.JsonDesignStore;
import im.paul.windesign.database.io.SqliteDesignRepository;
import im.paul.windesign.design.DesignService;
import im.paul.windesign.hooks.luckperms.LuckPermsHook;
import im.paul.windesign.hooks.playerpoints.PlayerPointsHook;
import im.paul.windesign.listeners.PlayerDataListener;
import im.paul.windesign.placeholders.BracketsPlaceholderExpansion;
import im.paul.windesign.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Главный класс плагина WinDesign.
 */
public final class WinDesign extends JavaPlugin {
    private static WinDesign instance;
    private PlayerPointsHook playerPointsHook;
    private LuckPermsHook luckPermsHook;
    private BracketsPlaceholderExpansion bracketsPlaceholderExpansion;
    private boolean debug;
    private DatabaseManager databaseManager;
    private SqliteDesignRepository designRepository;
    private JsonDesignStore jsonDesignStore;
    private DesignService designService;
    private Messages messages;

    /**
     * Инициализирует плагин, сервисы, команды и слушатели.
     */
    public void onEnable() {
        this.debug = this.getConfig().getBoolean("debug");
        instance = this;
        this.saveDefaultConfig();
        this.messages = new Messages(this);
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.bracketsPlaceholderExpansion = new BracketsPlaceholderExpansion(this);
            this.bracketsPlaceholderExpansion.register();
        } else {
            this.getLogger().warning(this.messages.color("errors.placeholderapi-missing"));
        }

        this.playerPointsHook = new PlayerPointsHook();
        this.luckPermsHook = new LuckPermsHook();
        this.databaseManager = new DatabaseManager(this, this.debug);
        this.databaseManager.init();
        this.designRepository = new SqliteDesignRepository(this.databaseManager, this.debug);
        this.jsonDesignStore = new JsonDesignStore(this, this.debug);
        this.designService = new DesignService(this, this.debug, this.luckPermsHook, this.playerPointsHook, this.designRepository, this.jsonDesignStore);
        this.designService.init();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            this.designService.loadPlayerData(onlinePlayer.getName());
        }
        if (this.getCommand("windesign") == null) {
            this.getLogger().severe("Command 'windesign' is missing in plugin.yml. Disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        NameColor executor = new NameColor();
        TabCompleters completer = new TabCompleters();
        String[] commandNames = new String[]{"windesign", "brackets", "prefix", "tag", "namecolor"};
        for (String commandName : commandNames) {
            if (this.getCommand(commandName) != null) {
                this.getCommand(commandName).setExecutor(executor);
                this.getCommand(commandName).setTabCompleter(completer);
            }
        }
        this.getServer().getPluginManager().registerEvents(new PlayerDataListener(this.designService), this);
        this.getLogger().info("BracketsPlugin включен!");
    }

    /**
     * Корректно завершает работу плагина и сохраняет данные.
     */
    public void onDisable() {
        if (this.designService != null) {
            this.designService.shutdown();
        }
        if (this.bracketsPlaceholderExpansion != null) {
            this.bracketsPlaceholderExpansion.unregister();
        }

        if (this.databaseManager != null) {
            this.databaseManager.close();
        }
    }

    /**
     * Возвращает singleton-экземпляр плагина.
     *
     * @return экземпляр WinDesign
     */
    public static WinDesign getInstance() {
        return instance;
    }

    /**
     * Возвращает сервис дизайнов.
     *
     * @return сервис дизайна
     */
    public DesignService getDesignService() {
        return this.designService;
    }

    /**
     * Возвращает менеджер сообщений.
     *
     * @return менеджер сообщений
     */
    public Messages getMessages() {
        return this.messages;
    }

    /**
     * Возвращает цвет ника игрока.
     *
     * @param player игрок
     * @return цвет ника
     */
    public String getPlayerColor(Player player) {
        return this.designService.getPlayerColor(player);
    }

    /**
     * Возвращает ключ выбранного цвета ника.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerColorNumber(Player player) {
        return this.designService.getPlayerColorNumber(player);
    }

    /**
     * Устанавливает цвет ника игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerColor(Player player, String colorKey) {
        this.designService.setPlayerColor(player, colorKey);
    }

    /**
     * Возвращает префикс без цветовых кодов.
     *
     * @param player игрок
     * @return префикс без кодов цвета
     */
    public String getFormattedPrefix(Player player) {
        return this.designService.getFormattedPrefix(player);
    }

    /**
     * Выдаёт игроку пермишен.
     *
     * @param player игрок
     * @param permission пермишен
     */
    public void addPermission(Player player, String permission) {
        this.designService.addPermission(player, permission);
    }

    /**
     * Списывает токены игрока.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void takePoints(Player player, int amount) {
        this.designService.takePoints(player, amount);
    }

    /**
     * Начисляет токены игроку.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void depositPoints(Player player, int amount) {
        this.designService.depositPoints(player, amount);
    }

    /**
     * Возвращает количество токенов игрока.
     *
     * @param player игрок
     * @return количество токенов
     */
    public int getPoints(Player player) {
        return this.designService.getPoints(player);
    }

    /**
     * Возвращает префикс без HEX-цветов.
     *
     * @param player игрок
     * @return префикс без HEX-цветов
     */
    public String getFormattedPrefixColor(Player player) {
        return this.designService.getFormattedPrefixColor(player);
    }

    /**
     * Возвращает первый цветовой код из префикса LuckPerms.
     *
     * @param player игрок
     * @return цветовой код
     */
    public String getLuckPermsPrefixColorCode(Player player) {
        return this.designService.getLuckPermsPrefixColorCode(player);
    }

    /**
     * Возвращает итоговый цвет префикса с учётом кастомизации.
     *
     * @param player игрок
     * @return цвет префикса
     */
    public String getEffectivePrefixColor(Player player) {
        return this.designService.getEffectivePrefixColor(player);
    }

    /**
     * Возвращает префикс LuckPerms.
     *
     * @param player игрок
     * @return префикс
     */
    public String getLuckPermsPrefix(Player player) {
        return this.designService.getLuckPermsPrefix(player);
    }

    /**
     * Возвращает префикс игрока с учётом настроек.
     *
     * @param player игрок
     * @return префикс
     */
    public String getPlayerPrefix(Player player) {
        return this.designService.getPlayerPrefix(player);
    }

    /**
     * Проверяет, установлен ли кастомный префикс.
     *
     * @param player игрок
     * @return true если префикс задан вручную
     */
    public boolean hasCustomPrefix(Player player) {
        return this.designService.hasCustomPrefix(player);
    }

    /**
     * Проверяет, установлен ли кастомный цвет префикса.
     *
     * @param player игрок
     * @return true если цвет задан вручную
     */
    public boolean hasCustomPrefixColor(Player player) {
        return this.designService.hasCustomPrefixColor(player);
    }

    /**
     * Проверяет, установлен ли кастомный тег.
     *
     * @param player игрок
     * @return true если тег задан вручную
     */
    public boolean hasCustomTag(Player player) {
        return this.designService.hasCustomTag(player);
    }

    /**
     * Возвращает ключ выбранного префикса.
     *
     * @param player игрок
     * @return ключ префикса
     */
    public String getPlayerPrefixNumber(Player player) {
        return this.designService.getPlayerPrefixNumber(player);
    }

    /**
     * Устанавливает префикс игрока.
     *
     * @param player игрок
     * @param colorKey ключ префикса
     */
    public void setPlayerPrefix(Player player, String colorKey) {
        this.designService.setPlayerPrefix(player, colorKey);
    }

    /**
     * Возвращает цвет префикса игрока.
     *
     * @param player игрок
     * @return цвет префикса
     */
    public String getPrefixPlayerColor(Player player) {
        return this.designService.getPrefixPlayerColor(player);
    }

    /**
     * Возвращает ключ цвета префикса.
     *
     * @param player игрок
     * @return ключ цвета префикса
     */
    public String getPlayerPrefixColorNumber(Player player) {
        return this.designService.getPlayerPrefixColorNumber(player);
    }

    /**
     * Устанавливает цвет префикса игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerPrefixColor(Player player, String colorKey) {
        this.designService.setPlayerPrefixColor(player, colorKey);
    }

    /**
     * Возвращает тег игрока.
     *
     * @param player игрок
     * @return тег
     */
    public String getPlayerTag(Player player) {
        return this.designService.getPlayerTag(player);
    }

    /**
     * Возвращает ключ выбранного тега.
     *
     * @param player игрок
     * @return ключ тега
     */
    public String getPlayerTagNumber(Player player) {
        return this.designService.getPlayerTagNumber(player);
    }

    /**
     * Устанавливает тег игрока.
     *
     * @param player игрок
     * @param colorKey ключ тега
     */
    public void setPlayerTag(Player player, String colorKey) {
        this.designService.setPlayerTag(player, colorKey);
    }

    /**
     * Возвращает цвет тега игрока.
     *
     * @param player игрок
     * @return цвет тега
     */
    public String getPlayerTagColor(Player player) {
        return this.designService.getPlayerTagColor(player);
    }

    /**
     * Возвращает ключ цвета тега.
     *
     * @param player игрок
     * @return ключ цвета тега
     */
    public String getPlayerTagColorNumber(Player player) {
        return this.designService.getPlayerTagColorNumber(player);
    }

    /**
     * Устанавливает цвет тега игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerTagColor(Player player, String colorKey) {
        this.designService.setPlayerTagColor(player, colorKey);
    }

    /**
     * Возвращает левую скобку игрока.
     *
     * @param player игрок
     * @return левая скобка
     */
    public String getPlayerBracketsLeft(Player player) {
        return this.designService.getPlayerBracketsLeft(player);
    }

    /**
     * Возвращает правую скобку игрока.
     *
     * @param player игрок
     * @return правая скобка
     */
    public String getPlayerBracketsRight(Player player) {
        return this.designService.getPlayerBracketsRight(player);
    }

    /**
     * Возвращает ключ выбранных скобок.
     *
     * @param player игрок
     * @return ключ скобок
     */
    public String getPlayerBracketsNumber(Player player) {
        return this.designService.getPlayerBracketsNumber(player);
    }

    /**
     * Устанавливает скобки игрока.
     *
     * @param player игрок
     * @param colorKey ключ скобок
     */
    public void setPlayerBrackets(Player player, String colorKey) {
        this.designService.setPlayerBrackets(player, colorKey);
    }

    /**
     * Возвращает цвет скобок игрока.
     *
     * @param player игрок
     * @return цвет скобок
     */
    public String getPlayerBracketsColor(Player player) {
        return this.designService.getPlayerBracketsColor(player);
    }

    /**
     * Возвращает ключ цвета скобок.
     *
     * @param player игрок
     * @return ключ цвета скобок
     */
    public String getPlayerBracketsColorNumber(Player player) {
        return this.designService.getPlayerBracketsColorNumber(player);
    }

    /**
     * Устанавливает цвет скобок игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerBracketsColor(Player player, String colorKey) {
        this.designService.setPlayerBracketsColor(player, colorKey);
    }
}

