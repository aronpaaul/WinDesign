package im.paul.windesign.design.service;

import im.paul.windesign.design.persistence.DesignPersistenceService;
import im.paul.windesign.design.prefix.GroupPrefixRegistry;
import im.paul.windesign.design.state.DesignState;
import im.paul.windesign.hooks.luckperms.LuckPermsHook;
import im.paul.windesign.util.ColorUtil;
import java.util.Objects;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис управления префиксами и цветами префиксов.
 */
public class PrefixService {
    private final JavaPlugin plugin;
    private final DesignState state;
    private final DesignPersistenceService persistenceService;
    private final LuckPermsHook luckPermsHook;

    public PrefixService(JavaPlugin plugin, DesignState state, DesignPersistenceService persistenceService,
                         LuckPermsHook luckPermsHook) {
        this.plugin = plugin;
        this.state = state;
        this.persistenceService = persistenceService;
        this.luckPermsHook = luckPermsHook;
    }

    /**
     * Возвращает префикс без символов цвета (&).
     *
     * @param player игрок
     * @return отформатированный префикс
     */
    public String getFormattedPrefix(Player player) {
        return getLuckPermsPrefix(player).replaceAll("[&]", "");
    }

    /**
     * Возвращает префикс без HEX-цветов.
     *
     * @param player игрок
     * @return префикс без HEX-цветов
     */
    public String getFormattedPrefixColor(Player player) {
        return getLuckPermsPrefix(player).replaceAll("&#[0-9a-fA-F]{6}", "");
    }

    /**
     * Извлекает первый цветовой код из префикса LuckPerms.
     *
     * @param player игрок
     * @return цветовой код
     */
    public String getLuckPermsPrefixColorCode(Player player) {
        String prefix = this.getLuckPermsPrefix(player);
        return ColorUtil.extractFirstColorCode(prefix);
    }

    /**
     * Возвращает итоговый цвет префикса с учётом настроек игрока.
     *
     * @param player игрок
     * @return цвет префикса
     */
    public String getEffectivePrefixColor(Player player) {
        if (this.hasCustomPrefixColor(player)) {
            String color = this.getPrefixPlayerColor(player);
            return Objects.equals(color, "upper") ? this.getLuckPermsPrefixColorCode(player) : color;
        }

        if (this.hasCustomPrefix(player)) {
            return this.getLuckPermsPrefixColorCode(player);
        }

        return "";
    }

    /**
     * Возвращает префикс LuckPerms.
     *
     * @param player игрок
     * @return префикс
     */
    public String getLuckPermsPrefix(Player player) {
        return this.luckPermsHook.getPrefix(player);
    }

    /**
     * Возвращает текущий префикс игрока.
     *
     * @param player игрок
     * @return префикс
     */
    public String getPlayerPrefix(Player player) {
        String playerName = player.getName();
        if (this.hasCustomPrefix(player) && this.state.getPrefixKey(playerName) != null) {
            FileConfiguration config = this.plugin.getConfig();
            String key = this.state.getPrefixKey(playerName);
            return config.getString("prefix." + key);
        }

        if (!this.hasCustomPrefixColor(player)) {
            return this.getLuckPermsPrefix(player);
        }

        return ColorUtil.stripColors(this.getLuckPermsPrefix(player));
    }

    /**
     * Проверяет, установлен ли кастомный префикс.
     *
     * @param player игрок
     * @return true если префикс задан вручную
     */
    public boolean hasCustomPrefix(Player player) {
        return this.state.hasCustomPrefix(player.getName());
    }

    /**
     * Проверяет, установлен ли кастомный цвет префикса.
     *
     * @param player игрок
     * @return true если цвет задан вручную
     */
    public boolean hasCustomPrefixColor(Player player) {
        return this.state.hasCustomPrefixColor(player.getName());
    }

    /**
     * Возвращает ключ выбранного префикса.
     *
     * @param player игрок
     * @return ключ префикса
     */
    public String getPlayerPrefixNumber(Player player) {
        String playerName = player.getName();
        return this.hasCustomPrefix(player) ? this.state.getPrefixKey(playerName) : this.resolveDefaultPrefixKey(player);
    }

    /**
     * Устанавливает префикс игрока.
     *
     * @param player игрок
     * @param colorKey ключ префикса
     */
    public void setPlayerPrefix(Player player, String colorKey) {
        String playerName = player.getName();
        if (colorKey != null) {
            this.state.setPrefixKey(playerName, colorKey);
            this.state.setPrefixCustomValue(playerName, "true");
        } else {
            this.state.setPrefixKey(playerName, null);
            this.state.setPrefixCustomValue(playerName, null);
        }

        this.persistenceService.savePlayerData(playerName);
    }

    /**
     * Возвращает цвет префикса игрока (или признак использования цвета группы).
     *
     * @param player игрок
     * @return цвет префикса либо "upper"
     */
    public String getPrefixPlayerColor(Player player) {
        String playerName = player.getName();
        if (this.hasCustomPrefixColor(player)) {
            FileConfiguration config = this.plugin.getConfig();
            String key = this.state.getPrefixColorKey(playerName);
            return config.getString("prefix-colors." + key);
        }

        return "upper";
    }

    /**
     * Возвращает ключ выбранного цвета префикса.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerPrefixColorNumber(Player player) {
        String playerName = player.getName();
        return this.hasCustomPrefixColor(player) ? this.state.getPrefixColorKey(playerName)
                : this.resolveDefaultPrefixColorKey(player);
    }

    /**
     * Устанавливает цвет префикса игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerPrefixColor(Player player, String colorKey) {
        String playerName = player.getName();
        if (colorKey != null) {
            this.state.setPrefixColorKey(playerName, colorKey);
            this.state.setPrefixColorCustomValue(playerName, "true");
        } else {
            this.state.setPrefixColorKey(playerName, null);
            this.state.setPrefixColorCustomValue(playerName, null);
        }

        this.persistenceService.savePlayerData(playerName);
    }

    private String getPrimaryGroup(Player player) {
        return this.luckPermsHook.getPrimaryGroup(player);
    }

    private String resolveDefaultPrefixKey(Player player) {
        String group = this.getPrimaryGroup(player);
        if (group != null) {
            String key = GroupPrefixRegistry.getPrefixKey(group);
            if (key != null) {
                return key;
            }
        }

        return "1";
    }

    private String resolveDefaultPrefixColorKey(Player player) {
        String lpPrefix = this.getLuckPermsPrefix(player);
        String lpHex = ColorUtil.normalizeHexColor(lpPrefix);
        if (lpHex == null) {
            return this.resolveDefaultPrefixKey(player);
        }

        FileConfiguration config = this.plugin.getConfig();
        if (config.isConfigurationSection("prefix-colors")) {
            for (String key : config.getConfigurationSection("prefix-colors").getKeys(false)) {
                String value = config.getString("prefix-colors." + key);
                String configHex = ColorUtil.normalizeHexColor(value);
                if (configHex != null && configHex.equalsIgnoreCase(lpHex)) {
                    return key;
                }
            }
        }

        return this.resolveDefaultPrefixKey(player);
    }
}

