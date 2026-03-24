package im.paul.windesign.database.model;

/**
 * Модель данных дизайна игрока для хранения в базе.
 */
public class PlayerDesign {
    private final String nameColor;
    private final String tag;
    private final String tagColor;
    private final String prefix;
    private final String brackets;
    private final String bracketsColor;
    private final String prefixColor;
    private final String prefixCustom;
    private final String prefixColorCustom;

    /**
     * Создаёт объект данных дизайна игрока.
     *
     * @param nameColor цвет ника
     * @param tag тег
     * @param tagColor цвет тега
     * @param prefix префикс
     * @param brackets скобки
     * @param bracketsColor цвет скобок
     * @param prefixColor цвет префикса
     * @param prefixCustom флаг кастомного префикса
     * @param prefixColorCustom флаг кастомного цвета префикса
     */
    public PlayerDesign(String nameColor, String tag, String tagColor, String prefix, String brackets, String bracketsColor,
                        String prefixColor, String prefixCustom, String prefixColorCustom) {
        this.nameColor = nameColor;
        this.tag = tag;
        this.tagColor = tagColor;
        this.prefix = prefix;
        this.brackets = brackets;
        this.bracketsColor = bracketsColor;
        this.prefixColor = prefixColor;
        this.prefixCustom = prefixCustom;
        this.prefixColorCustom = prefixColorCustom;
    }

    /**
     * Возвращает цвет ника.
     *
     * @return цвет ника
     */
    public String getNameColor() {
        return this.nameColor;
    }

    /**
     * Возвращает тег.
     *
     * @return тег
     */
    public String getTag() {
        return this.tag;
    }

    /**
     * Возвращает цвет тега.
     *
     * @return цвет тега
     */
    public String getTagColor() {
        return this.tagColor;
    }

    /**
     * Возвращает префикс.
     *
     * @return префикс
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Возвращает скобки.
     *
     * @return скобки
     */
    public String getBrackets() {
        return this.brackets;
    }

    /**
     * Возвращает цвет скобок.
     *
     * @return цвет скобок
     */
    public String getBracketsColor() {
        return this.bracketsColor;
    }

    /**
     * Возвращает цвет префикса.
     *
     * @return цвет префикса
     */
    public String getPrefixColor() {
        return this.prefixColor;
    }

    /**
     * Возвращает флаг кастомного префикса.
     *
     * @return значение флага
     */
    public String getPrefixCustom() {
        return this.prefixCustom;
    }

    /**
     * Возвращает флаг кастомного цвета префикса.
     *
     * @return значение флага
     */
    public String getPrefixColorCustom() {
        return this.prefixColorCustom;
    }
}

