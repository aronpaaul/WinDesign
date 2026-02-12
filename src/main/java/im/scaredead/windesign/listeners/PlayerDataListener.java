package im.scaredead.windesign.listeners;

import im.scaredead.windesign.design.DesignService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Слушатель загрузки и сохранения данных игрока.
 */
public class PlayerDataListener implements Listener {
    private final DesignService designService;

    /**
     * Создаёт слушатель данных игроков.
     *
     * @param designService сервис дизайна
     */
    public PlayerDataListener(DesignService designService) {
        this.designService = designService;
    }

    /**
     * Загружает данные игрока при входе.
     *
     * @param event событие входа
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.designService.loadPlayerData(event.getPlayer().getName());
    }

    /**
     * Сохраняет данные игрока при выходе.
     *
     * @param event событие выхода
     */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        this.designService.savePlayerData(playerName);
        this.designService.clearPlayerData(playerName);
    }
}
