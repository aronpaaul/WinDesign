package im.paul.windesign.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Утилиты для извлечения и нормализации цветовых кодов.
 */
public final class ColorUtil {
    private static final Pattern hexAmp = Pattern.compile("(?i)&#[0-9a-f]{6}");
    private static final Pattern hexHash = Pattern.compile("(?i)#[0-9a-f]{6}");
    private static final Pattern hexSection = Pattern.compile("(?i)([§&]x(?:[§&][0-9a-f]){6})");
    private static final Pattern hexLegacy = Pattern.compile("(?i)[§&][0-9a-fk-or]");

    private ColorUtil() {
    }

    /**
     * Ищет первый цветовой код в строке.
     *
     * @param text исходный текст
     * @return найденный код или пустая строка
     */
    public static String extractFirstColorCode(String text) {
        if (text == null) {
            return "";
        }

        Matcher matcher = hexAmp.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }

        matcher = hexHash.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }

        matcher = hexSection.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }

        matcher = hexLegacy.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }

        return "";
    }

    /**
     * Удаляет цветовые коды из строки.
     *
     * @param input исходная строка
     * @return строка без цветов
     */
    public static String stripColors(String input) {
        if (input == null) {
            return "";
        }

        String stripped = input;
        stripped = stripped.replaceAll("(?i)§x(§[0-9A-F]){6}", "");
        stripped = stripped.replaceAll("(?i)&x(&[0-9A-F]){6}", "");
        stripped = stripped.replaceAll("(?i)&#[0-9a-fA-F]{6}", "");
        stripped = stripped.replaceAll("(?i)#[0-9a-fA-F]{6}", "");
        stripped = stripped.replaceAll("(?i)[§&][0-9A-FK-OR]", "");
        return stripped;
    }

    /**
     * Приводит HEX-цвет к стандартному виду без префиксов.
     *
     * @param value строка с цветом
     * @return HEX без префиксов или null
     */
    public static String normalizeHexColor(String value) {
        if (value == null) {
            return null;
        }

        String hex = null;
        Matcher matcher = Pattern.compile("(?i)&#([0-9a-f]{6})").matcher(value);
        if (matcher.find()) {
            hex = matcher.group(1);
        } else {
            matcher = Pattern.compile("(?i)[#]([0-9a-f]{6})").matcher(value);
            if (matcher.find()) {
                hex = matcher.group(1);
            } else {
                matcher = Pattern.compile("(?i)[§&]x([§&][0-9a-f]){6}").matcher(value);
                if (matcher.find()) {
                    String token = matcher.group(0).replaceAll("[§&]x", "").replaceAll("[§&]", "");
                    if (token.length() == 6) {
                        hex = token;
                    }
                }
            }
        }

        return hex != null ? hex.toLowerCase() : null;
    }
}

