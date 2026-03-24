package im.paul.windesign.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Менеджер подключения и инициализации SQLite.
 */
public class DatabaseManager {
    private final JavaPlugin plugin;
    private final boolean debug;
    private Connection connection;
    private File databaseFile;

    /**
     * Создаёт менеджер базы данных.
     *
     * @param plugin экземпляр плагина
     * @param debug режим отладки
     */
    public DatabaseManager(JavaPlugin plugin, boolean debug) {
        this.plugin = plugin;
        this.debug = debug;
    }

    /**
     * Инициализирует базу данных и таблицы.
     */
    public void init() {
        if (!this.plugin.getDataFolder().exists()) {
            this.plugin.getDataFolder().mkdirs();
        }

        this.databaseFile = new File(this.plugin.getDataFolder(), "windesign.db");

        try {
            this.getConnection();
            try (Statement statement = this.connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS player_designs (" +
                        "player_name TEXT PRIMARY KEY," +
                        "name_color TEXT," +
                        "tag TEXT," +
                        "tag_color TEXT," +
                        "prefix TEXT," +
                        "brackets TEXT," +
                        "brackets_color TEXT," +
                        "prefix_color TEXT," +
                        "prefix_custom TEXT," +
                        "prefix_color_custom TEXT" +
                        ")");
            }
        } catch (SQLException e) {
            this.plugin.getLogger().severe("WinDesign » Ошибка инициализации базы данных SQLite.");
            e.printStackTrace();
        }
    }

    /**
     * Возвращает активное соединение с базой данных.
     *
     * @return соединение SQLite
     * @throws SQLException если соединение не удалось открыть
     */
    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.databaseFile.getAbsolutePath());
        }

        return this.connection;
    }

    /**
     * Закрывает соединение с базой данных.
     */
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                if (this.debug) {
                    this.plugin.getLogger().warning("WinDesign » Ошибка закрытия базы данных SQLite.");
                }
            }
        }
    }
}

