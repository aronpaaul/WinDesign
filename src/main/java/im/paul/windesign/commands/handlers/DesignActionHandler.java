package im.paul.windesign.commands.handlers;

import im.paul.windesign.commands.handlers.actions.BracketsActions;
import im.paul.windesign.commands.handlers.actions.NameColorActions;
import im.paul.windesign.commands.handlers.actions.PrefixActions;
import im.paul.windesign.commands.handlers.actions.TagActions;
import org.bukkit.entity.Player;

/**
 * Маршрутизатор команд на конкретные обработчики действий.
 */
public final class DesignActionHandler {
    private DesignActionHandler() {
    }

    /**
     * Делегирует обработку в конкретные обработчики.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если обработано, иначе null
     */
    public static Boolean handle(Player player, String[] args) {
        Boolean handled = NameColorActions.handle(player, args);
        if (handled != null) {
            return handled;
        }

        handled = PrefixActions.handle(player, args);
        if (handled != null) {
            return handled;
        }

        handled = TagActions.handle(player, args);
        if (handled != null) {
            return handled;
        }

        handled = BracketsActions.handle(player, args);
        if (handled != null) {
            return handled;
        }

        return null;
    }
}

