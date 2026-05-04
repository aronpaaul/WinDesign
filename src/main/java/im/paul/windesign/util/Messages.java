package im.paul.windesign.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Утилита для загрузки и форматирования сообщений плагина из messages.yml.
 */
public class Messages {
    private static final Pattern HEX_PATTERN = Pattern.compile("(?i)&#([0-9a-f]{6})");
    private final JavaPlugin plugin;
    private FileConfiguration config;

    /**
     * Создаёт загрузчик сообщений и читает messages.yml.
     *
     * @param plugin экземпляр плагина для доступа к папке данных
     */
    public Messages(JavaPlugin plugin) {
        this.plugin = plugin;
        this.reload();
    }

    /**
     * Перезагружает messages.yml с диска, копируя дефолтный файл при отсутствии.
     */
    public final void reload() {
        File file = new File(this.plugin.getDataFolder(), "messages.yml");
        if (!file.exists()) {
            this.plugin.saveResource("messages.yml", false);
        }
        this.config = YamlConfiguration.loadConfiguration(file);
        try (InputStream stream = this.plugin.getResource("messages.yml")) {
            if (stream != null) {
                YamlConfiguration defaults = YamlConfiguration
                        .loadConfiguration(new InputStreamReader(stream, StandardCharsets.UTF_8));
                this.config.setDefaults(defaults);
            }
        } catch (IOException exception) {
            this.plugin.getLogger().warning("Failed to load default messages.yml: " + exception.getMessage());
        }
    }

    /**
     * Возвращает сырой текст сообщения по ключу.
     *
     * @param key ключ сообщения
     * @return сообщение или сам ключ, если сообщение не найдено
     */
    public String raw(String key) {
        return this.config.getString(key, key);
    }

    /**
     * Возвращает цветное сообщение по ключу.
     *
     * @param key ключ сообщения
     * @return цветное сообщение
     */
    public String color(String key) {
        return colorize(raw(key));
    }

    /**
     * Преобразует HEX и legacy-цвета в формат сообщений Bukkit.
     *
     * @param message исходная строка
     * @return строка с применёнными цветами
     */
    public String colorize(String message) {
        if (message == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', applyHexColors(message));
    }

    /**
     * Форматирует сообщение с подстановками.
     *
     * @param key ключ сообщения
     * @param placeholders пары плейсхолдеров: ключ, значение
     * @return отформатированное сообщение
     */
    public String format(String key, String... placeholders) {
        return applyPlaceholders(color(key), placeholders);
    }

    /**
     * Форматирует переданную строку с подстановками.
     *
     * @param message строка для форматирования
     * @param placeholders пары плейсхолдеров: ключ, значение
     * @return отформатированная строка
     */
    public String formatRaw(String message, String... placeholders) {
        return applyPlaceholders(message, placeholders);
    }

    /**
     * Отправляет сообщение по ключу получателю.
     *
     * @param sender получатель
     * @param key ключ сообщения
     */
    public void send(CommandSender sender, String key) {
        sender.sendMessage(color(key));
    }

    /**
     * Отправляет отформатированное сообщение по ключу получателю.
     *
     * @param sender получатель
     * @param key ключ сообщения
     * @param placeholders пары плейсхолдеров: ключ, значение
     */
    public void send(CommandSender sender, String key, String... placeholders) {
        sender.sendMessage(format(key, placeholders));
    }

    private String applyPlaceholders(String message, String... placeholders) {
        if (placeholders == null || placeholders.length == 0) {
            return message;
        }

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i + 1 < placeholders.length; i += 2) {
            map.put(placeholders[i], placeholders[i + 1]);
        }

        String result = message;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private String applyHexColors(String message) {
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String hex = matcher.group(1);
            StringBuilder replacement = new StringBuilder("§x");
            for (int index = 0; index < hex.length(); index++) {
                replacement.append('§').append(hex.charAt(index));
            }
            matcher.appendReplacement(buffer, Matcher.quoteReplacement(replacement.toString()));
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}

