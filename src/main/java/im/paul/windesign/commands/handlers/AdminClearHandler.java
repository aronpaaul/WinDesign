package im.paul.windesign.commands.handlers;

import im.paul.windesign.WinDesign;
import im.paul.windesign.util.Messages;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

/**
 * Админ-обработчик очистки конкретного типа дизайна у указанного игрока.
 */
public final class AdminClearHandler {
    private static final long CONFIRM_TIMEOUT_MILLIS = 30_000L;
    private static final Map<UUID, PendingClearRequest> PENDING_CONFIRMATIONS = new HashMap<>();

    private AdminClearHandler() {
    }

    /**
     * Обрабатывает команду /windesign clear <ник> <тип>.
     *
     * @param player администратор, вызвавший команду
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("clear")) {
            return null;
        }

        Messages messages = WinDesign.getInstance().getMessages();
        if (!player.hasPermission("windesign.admin.clear")) {
            messages.send(player, "errors.no-permission");
            return true;
        }

        if (args.length < 3) {
            player.sendMessage("§cИспользование: /windesign clear <ник> <тип>");
            return true;
        }

        String targetName = args[1];
        String normalizedType = normalizeType(args[2]);
        if (normalizedType == null) {
            player.sendMessage("§cНеизвестный тип дизайна: " + args[2]);
            return true;
        }

        long now = System.currentTimeMillis();
        clearExpiredConfirmations(now);
        UUID adminId = player.getUniqueId();
        PendingClearRequest pending = PENDING_CONFIRMATIONS.get(adminId);

        if (pending == null || !pending.matches(targetName, normalizedType)) {
            PENDING_CONFIRMATIONS.put(adminId, new PendingClearRequest(targetName, normalizedType, now + CONFIRM_TIMEOUT_MILLIS));
            messages.send(
                    player,
                    "admin-clear.confirm",
                    "%target%",
                    targetName,
                    "%type%",
                    normalizedType,
                    "%seconds%",
                    String.valueOf(CONFIRM_TIMEOUT_MILLIS / 1000L)
            );
            return true;
        }

        PENDING_CONFIRMATIONS.remove(adminId);
        boolean cleared = WinDesign.getInstance().getDesignService().clearPlayerDesignType(targetName, normalizedType);
        if (!cleared) {
            player.sendMessage("§cНеизвестный тип дизайна: " + args[2]);
            return true;
        }

        player.sendMessage("§aДанные типа §e" + normalizedType + "§a для игрока §e" + targetName + "§a очищены.");
        return true;
    }

    private static String normalizeType(String type) {
        if (type == null) {
            return null;
        }

        String normalized = type.toLowerCase(Locale.ROOT);
        if (normalized.equals("namecolor") || normalized.equals("color") || normalized.equals("name-color")) {
            return "namecolor";
        }
        if (normalized.equals("tag")) {
            return "tag";
        }
        if (normalized.equals("tagcolor") || normalized.equals("tag-color")) {
            return "tagcolor";
        }
        if (normalized.equals("prefix")) {
            return "prefix";
        }
        if (normalized.equals("prefixcolor") || normalized.equals("prefix-color")) {
            return "prefixcolor";
        }
        if (normalized.equals("brackets") || normalized.equals("bracket")) {
            return "brackets";
        }
        if (normalized.equals("bracketscolor") || normalized.equals("brackets-color") || normalized.equals("bracketcolor")) {
            return "bracketscolor";
        }
        if (normalized.equals("all")) {
            return "all";
        }
        return null;
    }

    private static void clearExpiredConfirmations(long now) {
        PENDING_CONFIRMATIONS.entrySet().removeIf(entry -> entry.getValue().expiresAtMillis <= now);
    }

    private static final class PendingClearRequest {
        private final String targetName;
        private final String designType;
        private final long expiresAtMillis;

        private PendingClearRequest(String targetName, String designType, long expiresAtMillis) {
            this.targetName = targetName;
            this.designType = designType;
            this.expiresAtMillis = expiresAtMillis;
        }

        private boolean matches(String targetName, String designType) {
            return this.targetName.equalsIgnoreCase(targetName) && this.designType.equalsIgnoreCase(designType);
        }
    }
}
