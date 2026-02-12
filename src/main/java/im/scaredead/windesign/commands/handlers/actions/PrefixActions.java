package im.scaredead.windesign.commands.handlers.actions;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.util.Messages;
import org.bukkit.entity.Player;

/**
 * Обработчик действий выбора/сброса префикса и его цвета.
 */
public final class PrefixActions {
    private PrefixActions() {
    }

    /**
     * Обрабатывает выбор и сброс префикса и цвета префикса.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        Messages messages = WinDesign.getInstance().getMessages();
        if (args.length == 2 && args[0].equalsIgnoreCase("selectprefix")) {
            String prefixKey = args[1];
            if (player.hasPermission("windesign.prefix." + prefixKey)) {
                WinDesign.getInstance().setPlayerPrefix(player, prefixKey);
                String prefix = WinDesign.getInstance().getPlayerPrefix(player);
                if (prefix == null) {
                    prefix = "";
                }
                String prefixColor = WinDesign.getInstance().getEffectivePrefixColor(player);
                String displayPrefix = prefix;
                if (prefixColor != null && !prefixColor.isEmpty()) {
                    displayPrefix = prefixColor + prefix;
                }
                messages.send(player, "success.installed", "%value%", displayPrefix);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("selectprefixcolor")) {
            String colorKey = args[1];
            if (player.hasPermission("windesign.prefixcolor." + colorKey)) {
                WinDesign.getInstance().setPlayerPrefixColor(player, colorKey);
                String prefixColor = WinDesign.getInstance().getEffectivePrefixColor(player);
                if (prefixColor == null || prefixColor.isEmpty()) {
                    String key = WinDesign.getInstance().getPlayerPrefixColorNumber(player);
                    String configColor = WinDesign.getInstance().getConfig().getString("prefix-colors." + key);
                    if (configColor != null) {
                        prefixColor = configColor;
                    }
                }
                if (prefixColor == null) {
                    prefixColor = "";
                }
                messages.send(player, "success.installed-color", "%value%", prefixColor);
            } else {
                messages.send(player, "errors.no-permission");
            }

            return true;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("deldesign")) {
            String key = args[1];
            if (key.equalsIgnoreCase("prefix")) {
                WinDesign.getInstance().setPlayerPrefix(player, null);
                String prefix = WinDesign.getInstance().getPlayerPrefix(player);
                if (prefix == null) {
                    prefix = "";
                }
                String prefixColor = WinDesign.getInstance().getEffectivePrefixColor(player);
                String displayPrefix = prefix;
                if (prefixColor != null && !prefixColor.isEmpty()) {
                    displayPrefix = prefixColor + prefix;
                }
                messages.send(player, "success.installed", "%value%", displayPrefix);
                return true;
            }
            if (key.equalsIgnoreCase("prefixcolor")) {
                WinDesign.getInstance().setPlayerPrefixColor(player, null);
                String prefixColor = WinDesign.getInstance().getEffectivePrefixColor(player);
                if (prefixColor == null || prefixColor.isEmpty()) {
                    String colorKey = WinDesign.getInstance().getPlayerPrefixColorNumber(player);
                    String configColor = WinDesign.getInstance().getConfig().getString("prefix-colors." + colorKey);
                    if (configColor != null) {
                        prefixColor = configColor;
                    }
                }
                if (prefixColor == null) {
                    prefixColor = "";
                }
                messages.send(player, "success.installed-color", "%value%", prefixColor);
                return true;
            }
        }

        return null;
    }
}
