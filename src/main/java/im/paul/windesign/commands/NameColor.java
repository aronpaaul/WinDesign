package im.paul.windesign.commands;

import im.paul.windesign.WinDesign;
import im.paul.windesign.commands.args.ArgumentParser;
import im.paul.windesign.commands.handlers.AdminClearHandler;
import im.paul.windesign.commands.handlers.AdminTagHandler;
import im.paul.windesign.commands.handlers.DesignActionHandler;
import im.paul.windesign.commands.menu.DesignMenuHandler;
import im.paul.windesign.util.MenuSettings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NameColor implements CommandExecutor {
   /**
    * Точка входа для всех команд WinDesign и алиасов.
    *
    * @param sender отправитель команды
    * @param cmd объект команды
    * @param label использованный ярлык
    * @param args аргументы команды
    * @return true если команда обработана
    */
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (!(sender instanceof Player)) {
         WinDesign.getInstance().getMessages().send(sender, "errors.not-player");
         return true;
      }

      Player player = (Player)sender;
      String cmdName = cmd.getName().toLowerCase();
      if (!cmdName.equals("windesign")) {
         String[] mappedArgs = ArgumentParser.map(cmdName, args);
         if (mappedArgs == null) {
            WinDesign.getInstance().getMessages().send(player, "errors.invalid-command");
            return true;
         }

         args = mappedArgs;
      }

      String requestedDesignType = resolveRequestedDesignType(args);
      if (requestedDesignType != null) {
         MenuSettings menuSettings = WinDesign.getInstance().getMenuSettings();
         if (!menuSettings.isDesignTypeEnabled(requestedDesignType)) {
            String disabledMessage = menuSettings.getTypeDisabledMessage();
            player.sendMessage(WinDesign.getInstance().getMessages().colorize(disabledMessage));
            return true;
         }
      }

      Boolean handled = DesignActionHandler.handle(player, args);
      if (handled != null) {
         return handled;
      }

      handled = AdminClearHandler.handle(player, args);
      if (handled != null) {
         return handled;
      }

      handled = AdminTagHandler.handle(player, args);
      if (handled != null) {
         return handled;
      }

      return DesignMenuHandler.handle(player, args);
   }

   private static String resolveRequestedDesignType(String[] args) {
      if (args.length == 0) {
         return null;
      }

      MenuSettings menuSettings = WinDesign.getInstance().getMenuSettings();
      String action = args[0].toLowerCase();

      String directType = menuSettings.normalizeDesignType(action);
      if (directType != null) {
         return directType;
      }

      if (action.equals("select")) {
         return "namecolor";
      }
      if (action.equals("selectprefix")) {
         return "prefix";
      }
      if (action.equals("selectprefixcolor")) {
         return "prefixcolor";
      }
      if (action.equals("buytag") || action.equals("selecttag")) {
         return "tags";
      }
      if (action.equals("buytagcolor") || action.equals("selecttagcolor")) {
         return "tagscolor";
      }
      if (action.equals("buybrackets") || action.equals("selectbrackets")) {
         return "brackets";
      }
      if (action.equals("buybracketscolor") || action.equals("selectbracketscolor")) {
         return "bracketscolor";
      }
      if (action.equals("deldesign") && args.length >= 2) {
         return menuSettings.normalizeDesignType(args[1]);
      }

      return null;
   }
}

