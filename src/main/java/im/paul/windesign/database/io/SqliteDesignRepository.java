package im.paul.windesign.database.io;

import im.paul.windesign.database.DatabaseManager;
import im.paul.windesign.database.model.PlayerDesign;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Репозиторий для чтения и записи дизайнов в SQLite.
 */
public class SqliteDesignRepository {
    private final DatabaseManager databaseManager;
    private final boolean debug;

    /**
     * Создаёт репозиторий SQLite.
     *
     * @param databaseManager менеджер соединения
     * @param debug режим отладки
     */
    public SqliteDesignRepository(DatabaseManager databaseManager, boolean debug) {
        this.databaseManager = databaseManager;
        this.debug = debug;
    }

    /**
     * Проверяет, пуста ли таблица данных.
     *
     * @return true если записей нет
     */
    public boolean isEmpty() {
        try (Statement statement = this.databaseManager.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM player_designs")) {
            if (resultSet.next()) {
                return resultSet.getInt(1) == 0;
            }
        } catch (SQLException e) {
            if (this.debug) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * Сохраняет данные дизайна игрока.
     *
     * @param playerName ник игрока
     * @param design данные дизайна
     * @throws SQLException при ошибке записи
     */
    public void save(String playerName, PlayerDesign design) throws SQLException {
        try (PreparedStatement statement = this.databaseManager.getConnection().prepareStatement(
                "INSERT INTO player_designs (player_name, name_color, tag, tag_color, prefix, brackets, brackets_color, prefix_color, prefix_custom, prefix_color_custom) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                        "ON CONFLICT(player_name) DO UPDATE SET " +
                        "name_color=excluded.name_color, " +
                        "tag=excluded.tag, " +
                        "tag_color=excluded.tag_color, " +
                        "prefix=excluded.prefix, " +
                        "brackets=excluded.brackets, " +
                        "brackets_color=excluded.brackets_color, " +
                        "prefix_color=excluded.prefix_color, " +
                        "prefix_custom=excluded.prefix_custom, " +
                        "prefix_color_custom=excluded.prefix_color_custom")) {
            statement.setString(1, playerName);
            statement.setString(2, design.getNameColor());
            statement.setString(3, design.getTag());
            statement.setString(4, design.getTagColor());
            statement.setString(5, design.getPrefix());
            statement.setString(6, design.getBrackets());
            statement.setString(7, design.getBracketsColor());
            statement.setString(8, design.getPrefixColor());
            statement.setString(9, design.getPrefixCustom());
            statement.setString(10, design.getPrefixColorCustom());
            statement.executeUpdate();
        }
    }


    /**
     * Загружает данные дизайна игрока.
     *
     * @param playerName ник игрока
     * @return данные или null
     * @throws SQLException при ошибке чтения
     */
    public PlayerDesign load(String playerName) throws SQLException {
        try (PreparedStatement statement = this.databaseManager.getConnection().prepareStatement(
                "SELECT name_color, tag, tag_color, prefix, brackets, brackets_color, prefix_color, prefix_custom, prefix_color_custom " +
                        "FROM player_designs WHERE player_name=?")) {
            statement.setString(1, playerName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PlayerDesign(
                            resultSet.getString("name_color"),
                            resultSet.getString("tag"),
                            resultSet.getString("tag_color"),
                            resultSet.getString("prefix"),
                            resultSet.getString("brackets"),
                            resultSet.getString("brackets_color"),
                            resultSet.getString("prefix_color"),
                            resultSet.getString("prefix_custom"),
                            resultSet.getString("prefix_color_custom")
                    );
                }
            }
        }

        return null;
    }
}

