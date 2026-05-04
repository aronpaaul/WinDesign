package im.paul.windesign.commands.menu;

import im.paul.windesign.WinDesign;
import im.paul.windesign.util.ColorUtil;
import im.paul.windesign.util.MenuSettings;
import im.paul.windesign.util.Messages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Построение и вывод интерактивных меню дизайна.
 */
public final class DesignMenuHandler {
    private static final List<String> NAME_COLOR_DEFAULT_KEYS = numericKeys(1, 10);
    private static final List<String> PREFIX_DEFAULT_KEYS = Collections.unmodifiableList(Arrays.asList(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
            "staff", "agent", "techadmin", "admin"
    ));
    private static final List<String> PREFIX_COLOR_DEFAULT_KEYS = numericKeys(1, 18);
    private static final List<String> TAG_DEFAULT_KEYS = numericKeys(1, 32);
    private static final List<String> TAG_COLOR_DEFAULT_KEYS = numericKeys(1, 17);
    private static final List<String> BRACKETS_DEFAULT_KEYS = numericKeys(1, 16);
    private static final List<String> BRACKETS_COLOR_DEFAULT_KEYS = numericKeys(1, 17);

    private DesignMenuHandler() {
    }

    private static int getCost(FileConfiguration config, String basePath) {
        if (config.contains(basePath + ".summa")) {
            return config.getInt(basePath + ".summa");
        }
        return config.getInt(basePath + ".price");
    }

    /**
     * Строит и показывает меню на основе аргументов команды.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если меню было показано, иначе false
     */
    public static boolean handle(Player player, String[] args) {
        if (args.length != 1) {
            return false;
        }

        WinDesign plugin = WinDesign.getInstance();
        Messages messages = plugin.getMessages();
        FileConfiguration config = plugin.getConfig();
        MenuSettings menuSettings = plugin.getMenuSettings();

        String menuType = menuSettings.normalizeDesignType(args[0]);
        if (menuType == null) {
            return false;
        }

        if (menuType.equals("namecolor")) {
            renderNameColorMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("prefix")) {
            renderPrefixMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("prefixcolor")) {
            renderPrefixColorMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("tags")) {
            renderTagsMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("tagscolor")) {
            renderTagsColorMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("brackets")) {
            renderBracketsMenu(player, messages, config, menuSettings);
            return true;
        }
        if (menuType.equals("bracketscolor")) {
            renderBracketsColorMenu(player, messages, config, menuSettings);
            return true;
        }

        return false;
    }

    private static void renderNameColorMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("namecolor", NAME_COLOR_DEFAULT_KEYS),
                config,
                "name-colors.",
                ""
        );

        String selected = safe(WinDesign.getInstance().getPlayerColorNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String permission = "windesign.namecolor." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign select " + key,
                        "/windesign deldesign namecolor"
                );
            } else {
                status = unavailableStatus(messages);
            }

            String value = safe(config.getString("name-colors." + key));
            String line = messages.format("menu.format.color-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderPrefixMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("prefix", PREFIX_DEFAULT_KEYS),
                config,
                "prefix.",
                ""
        );

        String selected = safe(WinDesign.getInstance().getPlayerPrefixNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String permission = "windesign.prefix." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selectprefix " + key,
                        "/windesign deldesign prefix"
                );
            } else {
                status = unavailableStatus(messages);
            }

            String value = safe(config.getString("prefix." + key));
            String line = messages.format("menu.format.value-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderPrefixColorMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("prefixcolor", PREFIX_COLOR_DEFAULT_KEYS),
                config,
                "prefix-colors.",
                ""
        );

        String selected = safe(WinDesign.getInstance().getPlayerPrefixColorNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String permission = "windesign.prefixcolor." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selectprefixcolor " + key,
                        "/windesign deldesign prefixcolor"
                );
            } else {
                status = unavailableStatus(messages);
            }

            TextColor lineColor = resolveTextColor(config.getString("prefix-colors." + key));
            TextComponent colorLabel = Component.text(messages.raw("menu.labels.color-line")).color(lineColor);
            TextComponent dash = Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255));
            player.sendMessage(colorLabel.append(dash).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderTagsMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("tags", TAG_DEFAULT_KEYS),
                config,
                "tags.",
                ".name"
        );

        String selected = safe(WinDesign.getInstance().getPlayerTagNumber(player));
        String tag31Name = safe(config.getString("tags.31.name"));
        String tag32Name = safe(config.getString("tags.32.name"));
        boolean hideTag32 = !tag31Name.isEmpty() && tag31Name.equalsIgnoreCase(tag32Name);

        sendHeader(player, messages);
        for (String key : orderedKeys) {
            if (hideTag32 && key.equals("32")) {
                continue;
            }

            String basePath = "tags." + key;
            String permission = "windesign.tag." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selecttag " + key,
                        "/windesign deldesign tag"
                );
            } else {
                int cost = getCost(config, basePath);
                status = buyStatus(messages, cost, "/windesign buytag " + key);
            }

            String value = safe(config.getString(basePath + ".name"));
            String line = messages.format("menu.format.value-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderTagsColorMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("tagscolor", TAG_COLOR_DEFAULT_KEYS),
                config,
                "tags-colors.",
                ".color"
        );

        String selected = safe(WinDesign.getInstance().getPlayerTagColorNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String basePath = "tags-colors." + key;
            String permission = "windesign.tagcolor." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selecttagcolor " + key,
                        "/windesign deldesign tagcolor"
                );
            } else {
                int cost = getCost(config, basePath);
                status = buyStatus(messages, cost, "/windesign buytagcolor " + key);
            }

            String value = safe(config.getString(basePath + ".color"));
            String line = messages.format("menu.format.color-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderBracketsMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("brackets", BRACKETS_DEFAULT_KEYS),
                config,
                "brackets.",
                ".left"
        );

        String selected = safe(WinDesign.getInstance().getPlayerBracketsNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String basePath = "brackets." + key;
            String permission = "windesign.brackets." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selectbrackets " + key,
                        "/windesign deldesign brackets"
                );
            } else {
                int cost = getCost(config, basePath);
                status = buyStatus(messages, cost, "/windesign buybrackets " + key);
            }

            String value = safe(config.getString(basePath + ".left")) + safe(config.getString(basePath + ".right"));
            String line = messages.format("menu.format.value-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static void renderBracketsColorMenu(Player player, Messages messages, FileConfiguration config, MenuSettings menuSettings) {
        List<String> orderedKeys = filterValidKeys(
                menuSettings.resolveSlots("bracketscolor", BRACKETS_COLOR_DEFAULT_KEYS),
                config,
                "brackets-colors.",
                ".color"
        );

        String selected = safe(WinDesign.getInstance().getPlayerBracketsColorNumber(player));
        sendHeader(player, messages);
        for (String key : orderedKeys) {
            String basePath = "brackets-colors." + key;
            String permission = "windesign.bracketscolor." + key;
            TextComponent status;
            if (player.hasPermission(permission)) {
                status = selectableStatus(
                        messages,
                        selected.equalsIgnoreCase(key),
                        "/windesign selectbracketscolor " + key,
                        "/windesign deldesign bracketscolor"
                );
            } else {
                int cost = getCost(config, basePath);
                status = buyStatus(messages, cost, "/windesign buybracketscolor " + key);
            }

            String value = safe(config.getString(basePath + ".color"));
            String line = messages.format("menu.format.color-entry", "%value%", value);
            player.sendMessage(Component.text(line).append(status));
        }
        sendFooter(player, messages);
    }

    private static List<String> filterValidKeys(List<String> keys, FileConfiguration config, String prefixPath, String suffixPath) {
        List<String> filtered = new ArrayList<>();
        for (String key : keys) {
            String normalizedKey = safe(key).toLowerCase(Locale.ROOT);
            if (normalizedKey.isEmpty()) {
                continue;
            }

            String path = prefixPath + normalizedKey + suffixPath;
            if (!config.contains(path)) {
                continue;
            }

            if (!filtered.contains(normalizedKey)) {
                filtered.add(normalizedKey);
            }
        }
        return filtered;
    }

    private static void sendHeader(Player player, Messages messages) {
        player.sendMessage("");
        player.sendMessage(messages.color("menu.layout.separator"));
        player.sendMessage("");
        player.sendMessage(messages.color("menu.layout.header"));
        player.sendMessage("");
    }

    private static void sendFooter(Player player, Messages messages) {
        player.sendMessage("");
        player.sendMessage(messages.color("menu.layout.footer-1"));
        player.sendMessage(messages.color("menu.layout.footer-2"));
        player.sendMessage(messages.color("menu.layout.footer-3"));
        player.sendMessage(messages.color("menu.layout.footer-4"));
        player.sendMessage(messages.color("menu.layout.footer-3"));
    }

    private static TextComponent selectableStatus(Messages messages, boolean installed, String selectCommand, String resetCommand) {
        if (installed) {
            return Component.text(messages.raw("menu.status.installed"))
                    .color(NamedTextColor.GREEN)
                    .hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))
                    .clickEvent(ClickEvent.runCommand(resetCommand));
        }

        return Component.text(messages.raw("menu.status.available"))
                .color(NamedTextColor.YELLOW)
                .hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))
                .clickEvent(ClickEvent.runCommand(selectCommand));
    }

    private static TextComponent unavailableStatus(Messages messages) {
        return Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED);
    }

    private static TextComponent buyStatus(Messages messages, int cost, String buyCommand) {
        return Component.text(messages.raw("menu.labels.buy"))
                .color(NamedTextColor.GOLD)
                .append(Component.text(cost + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))
                .append(Component.text("]").color(NamedTextColor.GOLD))
                .hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))
                .clickEvent(ClickEvent.runCommand(buyCommand));
    }

    private static TextColor resolveTextColor(String value) {
        String hex = ColorUtil.normalizeHexColor(value);
        if (hex != null && hex.length() == 6) {
            try {
                int red = Integer.parseInt(hex.substring(0, 2), 16);
                int green = Integer.parseInt(hex.substring(2, 4), 16);
                int blue = Integer.parseInt(hex.substring(4, 6), 16);
                return TextColor.color(red, green, blue);
            } catch (NumberFormatException ignored) {
                return TextColor.color(255, 255, 255);
            }
        }

        String firstColorCode = ColorUtil.extractFirstColorCode(value);
        if (firstColorCode.length() >= 2) {
            char colorCode = Character.toLowerCase(firstColorCode.charAt(1));
            return mapLegacyColor(colorCode);
        }

        return TextColor.color(255, 255, 255);
    }

    private static TextColor mapLegacyColor(char colorCode) {
        switch (colorCode) {
            case '0':
                return TextColor.color(0, 0, 0);
            case '1':
                return TextColor.color(0, 0, 170);
            case '2':
                return TextColor.color(0, 170, 0);
            case '3':
                return TextColor.color(0, 170, 170);
            case '4':
                return TextColor.color(170, 0, 0);
            case '5':
                return TextColor.color(170, 0, 170);
            case '6':
                return TextColor.color(255, 170, 0);
            case '7':
                return TextColor.color(170, 170, 170);
            case '8':
                return TextColor.color(85, 85, 85);
            case '9':
                return TextColor.color(85, 85, 255);
            case 'a':
                return TextColor.color(85, 255, 85);
            case 'b':
                return TextColor.color(85, 255, 255);
            case 'c':
                return TextColor.color(255, 85, 85);
            case 'd':
                return TextColor.color(255, 85, 255);
            case 'e':
                return TextColor.color(255, 255, 85);
            case 'f':
                return TextColor.color(255, 255, 255);
            default:
                return TextColor.color(255, 255, 255);
        }
    }

    private static String safe(String value) {
        return value == null ? "" : value;
    }

    private static List<String> numericKeys(int min, int max) {
        List<String> keys = new ArrayList<>();
        for (int value = min; value <= max; value++) {
            keys.add(String.valueOf(value));
        }
        return Collections.unmodifiableList(keys);
    }
}
