package im.paul.windesign.design.service;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис установки кастомного титула в TAB только для списка игроков.
 */
public class TabTitleService {
    private final JavaPlugin plugin;

    public TabTitleService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Проверяет доступность плагина TAB.
     *
     * @return true если TAB установлен и включён
     */
    public boolean isTabAvailable() {
        return this.plugin.getServer().getPluginManager().isPluginEnabled("TAB");
    }

    /**
     * Устанавливает игроку кастомный tabsuffix в TAB.
     *
     * @param playerName ник игрока
     * @param rawTitle текст титула
     * @return результат выполнения
     */
    public Result setPlayerTabTitle(String playerName, String rawTitle) {
        if (!this.isTabAvailable()) {
            return Result.TAB_NOT_AVAILABLE;
        }
        if (playerName == null || playerName.trim().isEmpty()) {
            return Result.INVALID_PLAYER;
        }
        if (rawTitle == null || rawTitle.trim().isEmpty()) {
            return Result.EMPTY_VALUE;
        }

        String formattedTitle = formatTitle(rawTitle);
        return this.dispatchTabsuffixCommand(playerName, formattedTitle) ? Result.SUCCESS : Result.COMMAND_FAILED;
    }

    /**
     * Удаляет кастомный tabsuffix у игрока в TAB.
     *
     * @param playerName ник игрока
     * @return результат выполнения
     */
    public Result clearPlayerTabTitle(String playerName) {
        if (!this.isTabAvailable()) {
            return Result.TAB_NOT_AVAILABLE;
        }
        if (playerName == null || playerName.trim().isEmpty()) {
            return Result.INVALID_PLAYER;
        }

        return this.dispatchTabsuffixCommand(playerName, null) ? Result.SUCCESS : Result.COMMAND_FAILED;
    }

    private boolean dispatchTabsuffixCommand(String playerName, String value) {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        String command = "tab player " + playerName + " tabsuffix";
        if (value != null) {
            command = command + " \"" + escapeCommandValue(value) + "\"";
        }
        return Bukkit.dispatchCommand(console, command);
    }

    private String formatTitle(String rawTitle) {
        String trimmed = rawTitle.trim();
        if (trimmed.startsWith(" ")) {
            return trimmed;
        }
        return " " + trimmed;
    }

    private String escapeCommandValue(String value) {
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public enum Result {
        SUCCESS,
        TAB_NOT_AVAILABLE,
        INVALID_PLAYER,
        EMPTY_VALUE,
        COMMAND_FAILED
    }
}
