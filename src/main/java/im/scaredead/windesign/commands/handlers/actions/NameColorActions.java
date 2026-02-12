package im.scaredead.windesign.commands.handlers.actions;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Обработчик действий выбора/сброса цвета ника.
 */
public final class NameColorActions {
    private NameColorActions() {
    }

    /**
     * Обрабатывает выбор и сброс цвета ника.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        Messages messages = WinDesign.getInstance().getMessages();
        if (args.length == 2 && args[0].equalsIgnoreCase("select")) {
            String colorKey = args[1];
            if (player.hasPermission("windesign.namecolor." + colorKey)) {
                WinDesign.getInstance().setPlayerColor(player, colorKey);
                String nameColor = WinDesign.getInstance().getPlayerColor(player);
                messages.send(player, "success.installed-color", "%value%", nameColor);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("deldesign")
                && args[1].equalsIgnoreCase("namecolor")) {
            WinDesign.getInstance().setPlayerColor(player, null);
            String nameColor = WinDesign.getInstance().getPlayerColor(player);
            messages.send(player, "success.installed-color", "%value%", nameColor);
            return true;
        }

        return null;
    }
}
