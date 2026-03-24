package im.paul.windesign.database.io;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Чтение JSON-файлов для миграции старых данных.
 */
public class JsonDesignStore {
    private final JavaPlugin plugin;
    private final boolean debug;

    /**
     * Создаёт читатель JSON для миграции.
     *
     * @param plugin экземпляр плагина
     * @param debug режим отладки
     */
    public JsonDesignStore(JavaPlugin plugin, boolean debug) {
        this.plugin = plugin;
        this.debug = debug;
    }

    /**
     * Читает карту строк из JSON-файла.
     *
     * @param fileName имя файла в папке плагина
     * @return карта данных или пустая карта
     */
    public Map<String, String> readMap(String fileName) {
        File jsonFile = new File(this.plugin.getDataFolder(), fileName);
        if (!jsonFile.exists()) {
            return new HashMap();
        }

        try {
            FileReader reader = new FileReader(jsonFile);
            Throwable var4 = null;

            try {
                Type mapType = Map.class;
                Map<String, String> data = (Map)(new Gson()).fromJson(reader, mapType);
                return data != null ? data : new HashMap();
            } catch (Throwable var13) {
                var4 = var13;
                throw var13;
            } finally {
                if (reader != null) {
                    if (var4 != null) {
                        try {
                            reader.close();
                        } catch (Throwable var12) {
                            var4.addSuppressed(var12);
                        }
                    } else {
                        reader.close();
                    }
                }
            }
        } catch (IOException var15) {
            if (this.debug) {
                this.plugin.getLogger().warning("WinDesign » Ошибка чтения файла " + fileName + " для миграции.");
            }
        } catch (JsonParseException var16) {
            if (this.debug) {
                this.plugin.getLogger().warning("WinDesign » Ошибка JSON в файле " + fileName + " для миграции.");
            }
        }

        return new HashMap();
    }
}

