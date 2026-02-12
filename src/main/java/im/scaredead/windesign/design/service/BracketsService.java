package im.scaredead.windesign.design.service;

import im.scaredead.windesign.design.persistence.DesignPersistenceService;
import im.scaredead.windesign.design.state.DesignState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис управления скобками и их цветами.
 */
public class BracketsService {
    private final JavaPlugin plugin;
    private final DesignState state;
    private final DesignPersistenceService persistenceService;

    public BracketsService(JavaPlugin plugin, DesignState state, DesignPersistenceService persistenceService) {
        this.plugin = plugin;
        this.state = state;
        this.persistenceService = persistenceService;
    }

    /**
     * Возвращает левую скобку игрока.
     *
     * @param player игрок
     * @return левая скобка
     */
    public String getPlayerBracketsLeft(Player player) {
        String playerName = player.getName();
        String key = this.state.getBracketsKey(playerName);
        if (key != null) {
            FileConfiguration config = this.plugin.getConfig();
            return config.getString("brackets." + key + ".left");
        }
        return "[";
    }

    /**
     * Возвращает правую скобку игрока.
     *
     * @param player игрок
     * @return правая скобка
     */
    public String getPlayerBracketsRight(Player player) {
        String playerName = player.getName();
        String key = this.state.getBracketsKey(playerName);
        if (key != null) {
            FileConfiguration config = this.plugin.getConfig();
            return config.getString("brackets." + key + ".right");
        }
        return "]";
    }

    /**
     * Возвращает ключ выбранных скобок.
     *
     * @param player игрок
     * @return ключ скобок
     */
    public String getPlayerBracketsNumber(Player player) {
        String playerName = player.getName();
        String key = this.state.getBracketsKey(playerName);
        return key != null ? key : "1";
    }

    /**
     * Устанавливает скобки игрока.
     *
     * @param player игрок
     * @param colorKey ключ скобок
     */
    public void setPlayerBrackets(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setBracketsKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }

    /**
     * Возвращает цвет скобок игрока.
     *
     * @param player игрок
     * @return цвет скобок
     */
    public String getPlayerBracketsColor(Player player) {
        String playerName = player.getName();
        String key = this.state.getBracketsColorKey(playerName);
        if (key != null) {
            FileConfiguration config = this.plugin.getConfig();
            return config.getString("brackets-colors." + key + ".color");
        }
        return "§f";
    }

    /**
     * Возвращает ключ выбранного цвета скобок.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerBracketsColorNumber(Player player) {
        String playerName = player.getName();
        String key = this.state.getBracketsColorKey(playerName);
        return key != null ? key : "1";
    }

    /**
     * Устанавливает цвет скобок игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerBracketsColor(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setBracketsColorKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }
}
