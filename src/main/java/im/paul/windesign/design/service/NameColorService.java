package im.paul.windesign.design.service;

import im.paul.windesign.design.persistence.DesignPersistenceService;
import im.paul.windesign.design.state.DesignState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис управления цветом ника игрока.
 */
public class NameColorService {
    private final JavaPlugin plugin;
    private final DesignState state;
    private final DesignPersistenceService persistenceService;

    public NameColorService(JavaPlugin plugin, DesignState state, DesignPersistenceService persistenceService) {
        this.plugin = plugin;
        this.state = state;
        this.persistenceService = persistenceService;
    }

    /**
     * Возвращает текущий цвет ника игрока.
     *
     * @param player игрок
     * @return цвет ника
     */
    public String getPlayerColor(Player player) {
        String playerName = player.getName();
        if (this.state.hasNameColor(playerName)) {
            FileConfiguration config = this.plugin.getConfig();
            String colorKey = this.state.getNameColorKey(playerName);
            return config.getString("name-colors." + colorKey);
        }
        return "§f";
    }

    /**
     * Возвращает выбранный номер цвета ника.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerColorNumber(Player player) {
        String playerName = player.getName();
        return this.state.hasNameColor(playerName) ? this.state.getNameColorKey(playerName) : "1";
    }

    /**
     * Устанавливает цвет ника игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerColor(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setNameColorKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }
}

