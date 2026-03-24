package im.paul.windesign.hooks.playerpoints;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Хелпер для работы с PlayerPoints.
 */
public class PlayerPointsHook {
    private final PlayerPointsAPI playerPointsAPI;

    /**
     * Создаёт хук PlayerPoints и получает API плагина.
     */
    public PlayerPointsHook() {
        PlayerPoints plugin = (PlayerPoints)Bukkit.getPluginManager().getPlugin("PlayerPoints");
        this.playerPointsAPI = plugin != null ? plugin.getAPI() : null;
    }

    /**
     * Возвращает количество токенов игрока.
     *
     * @param player игрок
     * @return количество токенов
     */
    public int getPoints(Player player) {
        return this.playerPointsAPI != null ? this.playerPointsAPI.look(player.getUniqueId()) : 0;
    }

    /**
     * Списывает токены игрока.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void takePoints(Player player, int amount) {
        if (this.playerPointsAPI != null) {
            this.playerPointsAPI.take(player.getUniqueId(), amount);
        }
    }

    /**
     * Начисляет токены игроку.
     *
     * @param player игрок
     * @param amount количество токенов
     */
    public void givePoints(Player player, int amount) {
        if (this.playerPointsAPI != null) {
            this.playerPointsAPI.give(player.getUniqueId(), amount);
        }
    }
}

