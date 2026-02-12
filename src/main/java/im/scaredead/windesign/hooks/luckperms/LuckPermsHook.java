package im.scaredead.windesign.hooks.luckperms;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

/**
 * Хелпер для работы с LuckPerms.
 */
public class LuckPermsHook {
    /**
     * Возвращает префикс игрока из LuckPerms.
     *
     * @param player игрок
     * @return префикс или пустая строка
     */
    public String getPrefix(Player player) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        if (user != null) {
            String prefix = user.getCachedData().getMetaData().getPrefix();
            return prefix != null ? prefix : "";
        }

        return "";
    }

    /**
     * Возвращает основную группу игрока.
     *
     * @param player игрок
     * @return группа или null
     */
    public String getPrimaryGroup(Player player) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        return user != null ? user.getPrimaryGroup() : null;
    }

    /**
     * Выдаёт игроку пермишен.
     *
     * @param player игрок
     * @param permission пермишен
     */
    public void addPermission(Player player, String permission) {
        LuckPerms luckPerms = LuckPermsProvider.get();
        User user = luckPerms.getUserManager().getUser(player.getUniqueId());
        if (user == null) {
            return;
        }

        Node node = Node.builder(permission).value(true).build();
        user.data().add(node);
        luckPerms.getUserManager().saveUser(user);
    }
}
