package im.paul.windesign.design.service;

import im.paul.windesign.design.persistence.DesignPersistenceService;
import im.paul.windesign.design.state.DesignState;
import im.paul.windesign.util.ColorUtil;
import java.util.Locale;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Сервис управления цветом ника игрока.
 */
public class NameColorService {
    private static final String CUSTOM_HEX_PREFIX = "hex:";

    private final JavaPlugin plugin;
    private final DesignState state;
    private final DesignPersistenceService persistenceService;

    public NameColorService(JavaPlugin plugin, DesignState state, DesignPersistenceService persistenceService) {
        this.plugin = plugin;
        this.state = state;
        this.persistenceService = persistenceService;
    }

    /**
     * Возвращает текущий цвет ника игрока.
     *
     * @param player игрок
     * @return цвет ника
     */
    public String getPlayerColor(Player player) {
        String playerName = player.getName();
        if (this.state.hasNameColor(playerName)) {
            return this.resolveStoredNameColor(this.state.getNameColorKey(playerName));
        }
        return "\u00A7f";
    }

    /**
     * Возвращает выбранный номер цвета ника.
     *
     * @param player игрок
     * @return ключ цвета
     */
    public String getPlayerColorNumber(Player player) {
        String playerName = player.getName();
        if (!this.state.hasNameColor(playerName)) {
            return "1";
        }

        String colorKey = this.state.getNameColorKey(playerName);
        if (isCustomHexStorage(colorKey) || normalizePlainHex(colorKey) != null) {
            return "custom";
        }

        return colorKey;
    }

    /**
     * Устанавливает цвет ника игрока.
     *
     * @param player игрок
     * @param colorKey ключ цвета
     */
    public void setPlayerColor(Player player, String colorKey) {
        String playerName = player.getName();
        this.state.setNameColorKey(playerName, colorKey);
        this.persistenceService.savePlayerData(playerName);
    }

    /**
     * Устанавливает кастомный HEX-цвет ника по нику игрока.
     *
     * @param playerName ник игрока
     * @param hexColor HEX-цвет (RRGGBB, #RRGGBB или &#RRGGBB)
     * @return true если цвет валиден и успешно сохранён
     */
    public boolean setPlayerCustomColor(String playerName, String hexColor) {
        String normalizedHex = normalizePlainHex(hexColor);
        if (normalizedHex == null) {
            return false;
        }

        this.state.setNameColorKey(playerName, CUSTOM_HEX_PREFIX + normalizedHex.toLowerCase(Locale.ROOT));
        this.persistenceService.savePlayerData(playerName);
        return true;
    }

    private String resolveStoredNameColor(String storedValue) {
        if (storedValue == null || storedValue.isEmpty()) {
            return "\u00A7f";
        }

        if (isCustomHexStorage(storedValue)) {
            String hex = storedValue.substring(CUSTOM_HEX_PREFIX.length());
            String normalizedHex = normalizePlainHex(hex);
            if (normalizedHex != null) {
                return toLegacyHex(normalizedHex);
            }
        }

        String normalizedHex = normalizePlainHex(storedValue);
        if (normalizedHex != null) {
            return toLegacyHex(normalizedHex);
        }

        FileConfiguration config = this.plugin.getConfig();
        String configuredColor = config.getString("name-colors." + storedValue);
        if (configuredColor != null && !configuredColor.isEmpty()) {
            return configuredColor;
        }

        return storedValue;
    }

    private boolean isCustomHexStorage(String value) {
        return value != null && value.toLowerCase(Locale.ROOT).startsWith(CUSTOM_HEX_PREFIX);
    }

    private String normalizePlainHex(String value) {
        if (value == null) {
            return null;
        }

        String trimmed = value.trim();
        if (trimmed.matches("(?i)^[0-9a-f]{6}$")) {
            return trimmed;
        }

        return ColorUtil.normalizeHexColor(trimmed);
    }

    private String toLegacyHex(String hex) {
        StringBuilder builder = new StringBuilder();
        builder.append('\u00A7').append('x');
        for (int index = 0; index < hex.length(); index++) {
            builder.append('\u00A7').append(Character.toLowerCase(hex.charAt(index)));
        }
        return builder.toString();
    }
}
