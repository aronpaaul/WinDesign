package im.paul.windesign.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Управляет конфигурацией меню дизайнов в menus.yml.
 */
public final class MenuSettings {
    private static final Comparator<String> SLOT_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String left, String right) {
            Integer leftNumber = parseSlotNumber(left);
            Integer rightNumber = parseSlotNumber(right);
            if (leftNumber != null && rightNumber != null) {
                return leftNumber.compareTo(rightNumber);
            }
            if (leftNumber != null) {
                return -1;
            }
            if (rightNumber != null) {
                return 1;
            }
            return left.compareToIgnoreCase(right);
        }
    };

    private final JavaPlugin plugin;
    private FileConfiguration config;

    public MenuSettings(JavaPlugin plugin) {
        this.plugin = plugin;
        this.reload();
    }

    public void reload() {
        File file = new File(this.plugin.getDataFolder(), "menus.yml");
        if (!file.exists()) {
            this.plugin.saveResource("menus.yml", false);
        }
        this.config = YamlConfiguration.loadConfiguration(file);
        try (InputStream stream = this.plugin.getResource("menus.yml")) {
            if (stream != null) {
                YamlConfiguration defaults = YamlConfiguration
                        .loadConfiguration(new InputStreamReader(stream, StandardCharsets.UTF_8));
                this.config.setDefaults(defaults);
            }
        } catch (IOException exception) {
            this.plugin.getLogger().warning("Failed to load default menus.yml: " + exception.getMessage());
        }
    }

    public boolean isDesignTypeEnabled(String designType) {
        String normalizedType = normalizeDesignType(designType);
        if (normalizedType == null) {
            return true;
        }
        return this.config.getBoolean("design-types." + normalizedType, true);
    }

    public String getTypeDisabledMessage() {
        return this.config.getString("messages.design-type-disabled", "&#FC0000Данный тип дизайна отключен.");
    }

    public List<String> resolveSlots(String menuType, Collection<String> defaultItems) {
        String normalizedType = normalizeDesignType(menuType);
        List<String> fallback = new ArrayList<>(defaultItems);
        if (normalizedType == null) {
            return fallback;
        }

        ConfigurationSection slotsSection = this.config.getConfigurationSection("menus." + normalizedType + ".slots");
        if (slotsSection == null) {
            return fallback;
        }

        List<String> slotKeys = new ArrayList<>(slotsSection.getKeys(false));
        Collections.sort(slotKeys, SLOT_COMPARATOR);
        Set<String> orderedItemKeys = new LinkedHashSet<>();
        for (String slotKey : slotKeys) {
            ConfigurationSection slotSection = slotsSection.getConfigurationSection(slotKey);
            if (slotSection == null) {
                continue;
            }
            if (!slotSection.getBoolean("enabled", true)) {
                continue;
            }

            String itemKey = firstNonEmpty(
                    slotSection.getString("item"),
                    slotSection.getString("value"),
                    slotSection.getString("id")
            );
            if (itemKey == null) {
                continue;
            }
            orderedItemKeys.add(itemKey);
        }

        return new ArrayList<>(orderedItemKeys);
    }

    public String normalizeDesignType(String designType) {
        if (designType == null) {
            return null;
        }

        String normalized = designType.toLowerCase(Locale.ROOT);
        if (normalized.equals("namecolor") || normalized.equals("name-color") || normalized.equals("color")) {
            return "namecolor";
        }
        if (normalized.equals("prefix")) {
            return "prefix";
        }
        if (normalized.equals("prefixcolor") || normalized.equals("prefix-color")) {
            return "prefixcolor";
        }
        if (normalized.equals("tag") || normalized.equals("tags")) {
            return "tags";
        }
        if (normalized.equals("tagcolor") || normalized.equals("tag-color") || normalized.equals("tagscolor")) {
            return "tagscolor";
        }
        if (normalized.equals("brackets") || normalized.equals("bracket")) {
            return "brackets";
        }
        if (normalized.equals("bracketscolor")
                || normalized.equals("brackets-color")
                || normalized.equals("bracketcolor")) {
            return "bracketscolor";
        }
        return null;
    }

    private static Integer parseSlotNumber(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private static String firstNonEmpty(String... values) {
        if (values == null) {
            return null;
        }
        for (String value : values) {
            if (value == null) {
                continue;
            }
            String trimmed = value.trim();
            if (!trimmed.isEmpty()) {
                return trimmed;
            }
        }
        return null;
    }
}
