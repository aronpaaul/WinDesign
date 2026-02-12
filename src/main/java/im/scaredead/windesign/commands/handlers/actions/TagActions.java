package im.scaredead.windesign.commands.handlers.actions;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Обработчик действий покупки/выбора/сброса тегов и их цвета.
 */
public final class TagActions {
    private TagActions() {
    }

    /**
     * Обрабатывает покупку, выбор и сброс тегов.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        Messages messages = WinDesign.getInstance().getMessages();
        if (args.length == 2 && args[0].equalsIgnoreCase("buytag")) {
            String tagKey = args[1];
            if (WinDesign.getInstance().getConfig().contains("tags." + tagKey)) {
                int requiredSum = WinDesign.getInstance().getConfig().getInt("tags." + tagKey + ".summa");
                if (WinDesign.getInstance().getPoints(player) >= requiredSum) {
                    WinDesign.getInstance().addPermission(player, "windesign.tag." + tagKey);
                    WinDesign.getInstance().setPlayerTag(player, tagKey);
                    WinDesign.getInstance().takePoints(player, requiredSum);
                    messages.send(player, "success.buy-success");
                } else {
                    messages.send(player, "errors.not-enough-tokens");
                }
            } else {
                messages.send(player, "errors.tag-not-exists");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("selecttag")) {
            String tagKey = args[1];
            if (player.hasPermission("windesign.tag." + tagKey)) {
                WinDesign.getInstance().setPlayerTag(player, tagKey);
                String tag = WinDesign.getInstance().getPlayerTag(player);
                String tagColor = WinDesign.getInstance().getPlayerTagColor(player);
                String displayTag = tag == null ? "" : tagColor + tag;
                if (displayTag.isEmpty()) {
                    messages.send(player, "success.installed-empty");
                } else {
                    messages.send(player, "success.installed", "%value%", displayTag);
                }
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("buytagcolor")) {
            String tagKey = args[1];
            if (WinDesign.getInstance().getConfig().contains("tags-colors." + tagKey)) {
                int requiredSum = WinDesign.getInstance().getConfig().getInt("tags-colors." + tagKey + ".summa");
                if (WinDesign.getInstance().getPoints(player) >= requiredSum) {
                    WinDesign.getInstance().setPlayerTagColor(player, tagKey);
                    WinDesign.getInstance().addPermission(player, "windesign.tagcolor." + tagKey);
                    WinDesign.getInstance().takePoints(player, requiredSum);
                    messages.send(player, "success.buy-success-full");
                } else {
                    messages.send(player, "errors.not-enough-tokens");
                }
            } else {
                messages.send(player, "errors.tag-not-exists");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("selecttagcolor")) {
            String tagKey = args[1];
            if (player.hasPermission("windesign.tagcolor." + tagKey)) {
                WinDesign.getInstance().setPlayerTagColor(player, tagKey);
                String tagColor = WinDesign.getInstance().getPlayerTagColor(player);
                messages.send(player, "success.installed-color", "%value%", tagColor);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("deldesign")) {
            String key = args[1];
            if (key.equalsIgnoreCase("tag")) {
                WinDesign.getInstance().setPlayerTag(player, null);
                String tag = WinDesign.getInstance().getPlayerTag(player);
                String tagColor = WinDesign.getInstance().getPlayerTagColor(player);
                String displayTag = tag == null ? "" : tagColor + tag;
                if (displayTag.isEmpty()) {
                    messages.send(player, "success.installed-empty");
                } else {
                    messages.send(player, "success.installed", "%value%", displayTag);
                }
                return true;
            }
            if (key.equalsIgnoreCase("tagcolor")) {
                WinDesign.getInstance().setPlayerTagColor(player, null);
                String tagColor = WinDesign.getInstance().getPlayerTagColor(player);
                messages.send(player, "success.installed-color", "%value%", tagColor);
                return true;
            }
        }

        return null;
    }
}
