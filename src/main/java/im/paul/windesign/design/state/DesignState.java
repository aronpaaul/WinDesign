package im.paul.windesign.design.state;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Внутреннее состояние выбранных дизайнов игроков.
 */
public class DesignState {
    private final Map<String, String> playerColors = new HashMap<>();
    private final Map<String, String> playerTags = new HashMap<>();
    private final Map<String, String> playerTagsColor = new HashMap<>();
    private final Map<String, String> playerPrefix = new HashMap<>();
    private final Map<String, String> playerBrackets = new HashMap<>();
    private final Map<String, String> playerBracketsColor = new HashMap<>();
    private final Map<String, String> playerPrefixColor = new HashMap<>();
    private final Map<String, String> playerPrefixCustom = new HashMap<>();
    private final Map<String, String> playerPrefixColorCustom = new HashMap<>();
    private final Map<String, String> playerCustomTag = new HashMap<>();

    /**
     * Проверяет, задан ли цвет ника.
     *
     * @param playerName ник игрока
     * @return true если цвет задан
     */
    public boolean hasNameColor(String playerName) {
        return this.playerColors.containsKey(playerName);
    }

    /**
     * Возвращает ключ цвета ника.
     *
     * @param playerName ник игрока
     * @return ключ цвета
     */
    public String getNameColorKey(String playerName) {
        return this.playerColors.get(playerName);
    }

    /**
     * Устанавливает ключ цвета ника.
     *
     * @param playerName ник игрока
     * @param key ключ цвета
     */
    public void setNameColorKey(String playerName, String key) {
        this.putOrRemove(this.playerColors, playerName, key);
    }

    /**
     * Проверяет, задан ли тег.
     *
     * @param playerName ник игрока
     * @return true если тег задан
     */
    public boolean hasTag(String playerName) {
        return this.playerTags.containsKey(playerName);
    }

    /**
     * Возвращает ключ тега.
     *
     * @param playerName ник игрока
     * @return ключ тега
     */
    public String getTagKey(String playerName) {
        return this.playerTags.get(playerName);
    }

    /**
     * Устанавливает ключ тега.
     *
     * @param playerName ник игрока
     * @param key ключ тега
     */
    public void setTagKey(String playerName, String key) {
        this.putOrRemove(this.playerTags, playerName, key);
    }

    /**
     * Возвращает ключ цвета тега.
     *
     * @param playerName ник игрока
     * @return ключ цвета тега
     */
    public String getTagColorKey(String playerName) {
        return this.playerTagsColor.get(playerName);
    }

    /**
     * Устанавливает ключ цвета тега.
     *
     * @param playerName ник игрока
     * @param key ключ цвета
     */
    public void setTagColorKey(String playerName, String key) {
        this.putOrRemove(this.playerTagsColor, playerName, key);
    }

    /**
     * Возвращает ключ префикса.
     *
     * @param playerName ник игрока
     * @return ключ префикса
     */
    public String getPrefixKey(String playerName) {
        return this.playerPrefix.get(playerName);
    }

    /**
     * Устанавливает ключ префикса.
     *
     * @param playerName ник игрока
     * @param key ключ префикса
     */
    public void setPrefixKey(String playerName, String key) {
        this.putOrRemove(this.playerPrefix, playerName, key);
    }

    /**
     * Возвращает ключ цвета префикса.
     *
     * @param playerName ник игрока
     * @return ключ цвета префикса
     */
    public String getPrefixColorKey(String playerName) {
        return this.playerPrefixColor.get(playerName);
    }

    /**
     * Устанавливает ключ цвета префикса.
     *
     * @param playerName ник игрока
     * @param key ключ цвета
     */
    public void setPrefixColorKey(String playerName, String key) {
        this.putOrRemove(this.playerPrefixColor, playerName, key);
    }

    /**
     * Проверяет, установлен ли кастомный админский тег.
     *
     * @param playerName ник игрока
     * @return true если кастомный тег задан
     */
    public boolean hasCustomTag(String playerName) {
        return this.playerCustomTag.containsKey(playerName);
    }

    /**
     * Возвращает кастомный админский тег.
     *
     * @param playerName ник игрока
     * @return текст тега или null
     */
    public String getCustomTag(String playerName) {
        return this.playerCustomTag.get(playerName);
    }

    /**
     * Устанавливает кастомный админский тег.
     *
     * @param playerName ник игрока
     * @param value текст тега
     */
    public void setCustomTag(String playerName, String value) {
        this.putOrRemove(this.playerCustomTag, playerName, value);
    }

    /**
     * Проверяет, установлен ли кастомный префикс.
     *
     * @param playerName ник игрока
     * @return true если префикс задан вручную
     */
    public boolean hasCustomPrefix(String playerName) {
        return this.playerPrefixCustom.containsKey(playerName);
    }

    /**
     * Возвращает значение флага кастомного префикса.
     *
     * @param playerName ник игрока
     * @return значение флага
     */
    public String getPrefixCustomValue(String playerName) {
        return this.playerPrefixCustom.get(playerName);
    }

    /**
     * Устанавливает флаг кастомного префикса.
     *
     * @param playerName ник игрока
     * @param value значение флага
     */
    public void setPrefixCustomValue(String playerName, String value) {
        this.putOrRemove(this.playerPrefixCustom, playerName, value);
    }

    /**
     * Проверяет, установлен ли кастомный цвет префикса.
     *
     * @param playerName ник игрока
     * @return true если цвет задан вручную
     */
    public boolean hasCustomPrefixColor(String playerName) {
        return this.playerPrefixColorCustom.containsKey(playerName);
    }

    /**
     * Возвращает значение флага кастомного цвета префикса.
     *
     * @param playerName ник игрока
     * @return значение флага
     */
    public String getPrefixColorCustomValue(String playerName) {
        return this.playerPrefixColorCustom.get(playerName);
    }

    /**
     * Устанавливает флаг кастомного цвета префикса.
     *
     * @param playerName ник игрока
     * @param value значение флага
     */
    public void setPrefixColorCustomValue(String playerName, String value) {
        this.putOrRemove(this.playerPrefixColorCustom, playerName, value);
    }

    /**
     * Возвращает ключ скобок.
     *
     * @param playerName ник игрока
     * @return ключ скобок
     */
    public String getBracketsKey(String playerName) {
        return this.playerBrackets.get(playerName);
    }

    /**
     * Устанавливает ключ скобок.
     *
     * @param playerName ник игрока
     * @param key ключ скобок
     */
    public void setBracketsKey(String playerName, String key) {
        this.putOrRemove(this.playerBrackets, playerName, key);
    }

    /**
     * Возвращает ключ цвета скобок.
     *
     * @param playerName ник игрока
     * @return ключ цвета
     */
    public String getBracketsColorKey(String playerName) {
        return this.playerBracketsColor.get(playerName);
    }

    /**
     * Устанавливает ключ цвета скобок.
     *
     * @param playerName ник игрока
     * @param key ключ цвета
     */
    public void setBracketsColorKey(String playerName, String key) {
        this.putOrRemove(this.playerBracketsColor, playerName, key);
    }

    /**
     * Удаляет все данные конкретного игрока.
     *
     * @param playerName ник игрока
     */
    public void clearPlayerData(String playerName) {
        this.playerColors.remove(playerName);
        this.playerPrefix.remove(playerName);
        this.playerPrefixColor.remove(playerName);
        this.playerPrefixCustom.remove(playerName);
        this.playerPrefixColorCustom.remove(playerName);
        this.playerTags.remove(playerName);
        this.playerTagsColor.remove(playerName);
        this.playerCustomTag.remove(playerName);
        this.playerBrackets.remove(playerName);
        this.playerBracketsColor.remove(playerName);
    }

    /**
     * Очищает кэш всех игроков.
     */
    public void clearAll() {
        this.playerColors.clear();
        this.playerPrefix.clear();
        this.playerPrefixColor.clear();
        this.playerPrefixCustom.clear();
        this.playerPrefixColorCustom.clear();
        this.playerTags.clear();
        this.playerTagsColor.clear();
        this.playerCustomTag.clear();
        this.playerBrackets.clear();
        this.playerBracketsColor.clear();
    }

    /**
     * Собирает список всех игроков, у которых есть данные в кеше.
     *
     * @return набор имён игроков
     */
    public Set<String> collectAllPlayers() {
        Set<String> playerNames = new HashSet<>();
        playerNames.addAll(this.playerColors.keySet());
        playerNames.addAll(this.playerPrefix.keySet());
        playerNames.addAll(this.playerPrefixColor.keySet());
        playerNames.addAll(this.playerPrefixCustom.keySet());
        playerNames.addAll(this.playerPrefixColorCustom.keySet());
        playerNames.addAll(this.playerTags.keySet());
        playerNames.addAll(this.playerTagsColor.keySet());
        playerNames.addAll(this.playerCustomTag.keySet());
        playerNames.addAll(this.playerBrackets.keySet());
        playerNames.addAll(this.playerBracketsColor.keySet());
        return playerNames;
    }

    private void putOrRemove(Map<String, String> map, String playerName, String value) {
        if (value != null) {
            map.put(playerName, value);
        } else {
            map.remove(playerName);
        }
    }
}

