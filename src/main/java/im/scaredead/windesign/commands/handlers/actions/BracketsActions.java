package im.scaredead.windesign.commands.handlers.actions;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Обработчик действий покупки/выбора/сброса скобок и их цвета.
 */
public final class BracketsActions {
    private BracketsActions() {
    }

    /**
     * Обрабатывает покупку, выбор и сброс скобок.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        Messages messages = WinDesign.getInstance().getMessages();
        if (args.length == 2 && args[0].equalsIgnoreCase("buybrackets")) {
            String key = args[1];
            if (WinDesign.getInstance().getConfig().contains("brackets." + key)) {
                int requiredSum = WinDesign.getInstance().getConfig().getInt("brackets." + key + ".summa");
                if (WinDesign.getInstance().getPoints(player) >= requiredSum) {
                    WinDesign.getInstance().addPermission(player, "windesign.brackets." + key);
                    WinDesign.getInstance().takePoints(player, requiredSum);
                    WinDesign.getInstance().setPlayerBrackets(player, key);
                    messages.send(player, "success.buy-success-full");
                } else {
                    messages.send(player, "errors.not-enough-tokens");
                }
            } else {
                messages.send(player, "errors.brackets-not-exists");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("selectbrackets")) {
            String key = args[1];
            if (player.hasPermission("windesign.brackets." + key)) {
                WinDesign.getInstance().setPlayerBrackets(player, key);
                String bracketsColor = WinDesign.getInstance().getPlayerBracketsColor(player);
                String left = WinDesign.getInstance().getPlayerBracketsLeft(player);
                String right = WinDesign.getInstance().getPlayerBracketsRight(player);
                messages.send(player, "success.installed", "%value%", bracketsColor + left + right);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("buybracketscolor")) {
            String key = args[1];
            if (WinDesign.getInstance().getConfig().contains("brackets-colors." + key)) {
                int requiredSum = WinDesign.getInstance().getConfig().getInt("brackets-colors." + key + ".summa");
                if (WinDesign.getInstance().getPoints(player) >= requiredSum) {
                    WinDesign.getInstance().addPermission(player, "windesign.bracketscolor." + key);
                    WinDesign.getInstance().setPlayerBracketsColor(player, key);
                    WinDesign.getInstance().takePoints(player, requiredSum);
                    messages.send(player, "success.buy-success-full");
                } else {
                    messages.send(player, "errors.not-enough-tokens");
                }
            } else {
                messages.send(player, "errors.brackets-not-exists");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("selectbracketscolor")) {
            String key = args[1];
            if (player.hasPermission("windesign.bracketscolor." + key)) {
                WinDesign.getInstance().setPlayerBracketsColor(player, key);
                String bracketsColor = WinDesign.getInstance().getPlayerBracketsColor(player);
                messages.send(player, "success.installed-color", "%value%", bracketsColor);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("deldesign")) {
            String key = args[1];
            if (key.equalsIgnoreCase("brackets")) {
                WinDesign.getInstance().setPlayerBrackets(player, null);
                String bracketsColor = WinDesign.getInstance().getPlayerBracketsColor(player);
                String left = WinDesign.getInstance().getPlayerBracketsLeft(player);
                String right = WinDesign.getInstance().getPlayerBracketsRight(player);
                messages.send(player, "success.installed", "%value%", bracketsColor + left + right);
                return true;
            }
            if (key.equalsIgnoreCase("bracketscolor")) {
                WinDesign.getInstance().setPlayerBracketsColor(player, null);
                String bracketsColor = WinDesign.getInstance().getPlayerBracketsColor(player);
                messages.send(player, "success.installed-color", "%value%", bracketsColor);
                return true;
            }
        }

        return null;
    }
}
