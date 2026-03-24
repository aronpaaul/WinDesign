package im.paul.windesign.design.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * Реестр соответствия групп LuckPerms и ключей префиксов.
 */
public final class GroupPrefixRegistry {
    private static final Map<String, String> GROUP_PREFIX_KEYS = new HashMap<>();

    static {
        GROUP_PREFIX_KEYS.put("default", "1");
        GROUP_PREFIX_KEYS.put("baron", "2");
        GROUP_PREFIX_KEYS.put("strazh", "3");
        GROUP_PREFIX_KEYS.put("hero", "4");
        GROUP_PREFIX_KEYS.put("aspid", "5");
        GROUP_PREFIX_KEYS.put("squid", "6");
        GROUP_PREFIX_KEYS.put("glava", "7");
        GROUP_PREFIX_KEYS.put("elite", "8");
        GROUP_PREFIX_KEYS.put("titan", "9");
        GROUP_PREFIX_KEYS.put("princ", "10");
        GROUP_PREFIX_KEYS.put("knyaz", "11");
        GROUP_PREFIX_KEYS.put("gercog", "12");
    }

    private GroupPrefixRegistry() {
    }

    /**
     * Возвращает ключ префикса для группы.
     *
     * @param group название группы
     * @return ключ префикса или null
     */
    public static String getPrefixKey(String group) {
        if (group == null) {
            return null;
        }

        return GROUP_PREFIX_KEYS.get(group.toLowerCase());
    }
}

