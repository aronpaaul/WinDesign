package im.paul.windesign.commands.handlers;

import im.paul.windesign.WinDesign;
import im.paul.windesign.design.service.TabTitleService;
import im.paul.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Админ-команда для управления кастомным титулом игрока только в TAB.
 */
public final class AdminTagHandler {
    private AdminTagHandler() {
    }

    /**
     * Обрабатывает команды:
     * /windesign admin tag set <ник> <текст>
     * /windesign admin tag remove <ник>
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

        if (args.length < 3 || !args[1].equalsIgnoreCase("tag")) {
            messages.send(player, "admin-tag.usage");
            return true;
        }

        String action = args[2].toLowerCase();
        if (action.equals("set")) {
            return handleSet(player, args, messages);
        }
        if (action.equals("remove")) {
            return handleRemove(player, args, messages);
        }

        messages.send(player, "admin-tag.usage");
        return true;
    }

    private static boolean handleSet(Player player, String[] args, Messages messages) {
        if (args.length < 5) {
            messages.send(player, "admin-tag.usage");
            return true;
        }

        String targetName = args[3];
        String rawTitle = joinArguments(args, 4);
        WinDesign.getInstance().getDesignService().setPlayerCustomTag(targetName, rawTitle);
        TabTitleService.Result result = WinDesign.getInstance().getDesignService()
                .setPlayerCustomTabTitle(targetName, rawTitle);

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

        messages.send(player, "admin-tag.success", "%target%", targetName, "%value%", rawTitle);
        return true;
    }

    private static boolean handleRemove(Player player, String[] args, Messages messages) {
        if (args.length < 4) {
            messages.send(player, "admin-tag.usage");
            return true;
        }

        String targetName = args[3];
        WinDesign.getInstance().getDesignService().clearPlayerCustomTag(targetName);
        TabTitleService.Result result = WinDesign.getInstance().getDesignService()
                .clearPlayerCustomTabTitle(targetName);

        if (result == TabTitleService.Result.TAB_NOT_AVAILABLE) {
            messages.send(player, "errors.tab-not-found");
            return true;
        }
        if (result == TabTitleService.Result.INVALID_PLAYER || result == TabTitleService.Result.COMMAND_FAILED) {
            messages.send(player, "errors.tab-command-failed");
            return true;
        }

        messages.send(player, "admin-tag.remove-success", "%target%", targetName);
        return true;
    }

    private static String joinArguments(String[] args, int startIndex) {
        StringBuilder builder = new StringBuilder();
        for (int index = startIndex; index < args.length; index++) {
            if (index > startIndex) {
                builder.append(' ');
            }
            builder.append(args[index]);
        }
        return builder.toString();
    }
}
