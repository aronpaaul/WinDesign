package im.scaredead.windesign.commands;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.commands.args.ArgumentParser;
import im.scaredead.windesign.commands.handlers.DesignActionHandler;
import im.scaredead.windesign.commands.menu.DesignMenuHandler;
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

      Boolean handled = DesignActionHandler.handle(player, args);
      if (handled != null) {
         return handled;
      }

      return DesignMenuHandler.handle(player, args);
   }
}
