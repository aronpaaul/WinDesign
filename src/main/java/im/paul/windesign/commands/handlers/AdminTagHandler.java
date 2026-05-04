package im.paul.windesign.commands.handlers;

import im.paul.windesign.WinDesign;
import im.paul.windesign.design.service.TabTitleService;
import im.paul.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Админ-команда установки кастомного титула игрока только в TAB.
 */
public final class AdminTagHandler {
    private AdminTagHandler() {
    }

    /**
     * Обрабатывает команду /windesign admin tag set <текст>.
     *
     * @param player игрок, вызвавший команду
     * @param args аргументы команды
     * @return true если команда обработана, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("admin")) {
            return null;
        }

        Messages messages = WinDesign.getInstance().getMessages();
        if (!player.hasPermission("windesign.admin")) {
            messages.send(player, "errors.no-permission");
            return true;
        }

        if (args.length < 3 || !args[1].equalsIgnoreCase("tag") || !args[2].equalsIgnoreCase("set")) {
            messages.send(player, "admin-tag.usage");
            return true;
        }

        if (args.length < 4) {
            messages.send(player, "admin-tag.empty");
            return true;
        }

        StringBuilder titleBuilder = new StringBuilder();
        for (int index = 3; index < args.length; index++) {
            if (index > 3) {
                titleBuilder.append(' ');
            }
            titleBuilder.append(args[index]);
        }

        String rawTitle = titleBuilder.toString();
        TabTitleService.Result result = WinDesign.getInstance().getDesignService()
                .setPlayerCustomTabTitle(player.getName(), rawTitle);

        if (result == TabTitleService.Result.TAB_NOT_AVAILABLE) {
            messages.send(player, "errors.tab-not-found");
            return true;
        }
        if (result == TabTitleService.Result.EMPTY_VALUE) {
            messages.send(player, "admin-tag.empty");
            return true;
        }
        if (result == TabTitleService.Result.INVALID_PLAYER || result == TabTitleService.Result.COMMAND_FAILED) {
            messages.send(player, "errors.tab-command-failed");
            return true;
        }

        messages.send(player, "admin-tag.success", "%value%", rawTitle);
        return true;
    }
}
