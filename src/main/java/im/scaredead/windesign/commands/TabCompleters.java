package im.scaredead.windesign.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/**
 * Таб-комплитер для команд WinDesign.
 */
public class TabCompleters implements TabCompleter {
   /**
    * Формирует подсказки для аргументов команды.
    *
    * @param sender отправитель
    * @param cmd команда
    * @param label метка команды
    * @param args аргументы
    * @return список подсказок или null
    */
   public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
      String cmdName = cmd.getName().toLowerCase();
      ArrayList completions = new ArrayList();
      if (cmdName.equals("windesign")) {
         completions.add("tags");
         completions.add("prefix");
         completions.add("brackets");
         completions.add("namecolor");
         completions.add("tagscolor");
         completions.add("prefixcolor");
         completions.add("bracketscolor");
         return completions;
      }

      if (cmdName.equals("brackets")) {
         if (args.length == 1) {
            completions.add("color");
            completions.add("select");
            completions.add("buy");
            completions.add("del");
            return completions;
         }

         if (args.length == 2 && args[0].equalsIgnoreCase("color")) {
            completions.add("select");
            completions.add("buy");
            completions.add("del");
            return completions;
         }
      }

      if (cmdName.equals("prefix")) {
         if (args.length == 1) {
            completions.add("color");
            completions.add("select");
            completions.add("del");
            return completions;
         }

         if (args.length == 2 && args[0].equalsIgnoreCase("color")) {
            completions.add("select");
            completions.add("del");
            return completions;
         }
      }

      if (cmdName.equals("tag")) {
         if (args.length == 1) {
            completions.add("color");
            completions.add("select");
            completions.add("buy");
            completions.add("del");
            return completions;
         }

         if (args.length == 2 && args[0].equalsIgnoreCase("color")) {
            completions.add("select");
            completions.add("buy");
            completions.add("del");
            return completions;
         }
      }

      if (cmdName.equals("namecolor")) {
         if (args.length == 1) {
            completions.add("select");
            completions.add("del");
            return completions;
         }
      }

      return null;
   }
}
