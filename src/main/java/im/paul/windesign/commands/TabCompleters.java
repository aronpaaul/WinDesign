package im.paul.windesign.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

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
         if (args.length == 1) {
            completions.add("tags");
            completions.add("prefix");
            completions.add("brackets");
            completions.add("namecolor");
            completions.add("tagscolor");
            completions.add("prefixcolor");
            completions.add("bracketscolor");
            if (sender.hasPermission("windesign.admin")) {
               completions.add("admin");
            }
            if (sender.hasPermission("windesign.admin.clear")) {
               completions.add("clear");
            }
            return completions;
         }

         if (args.length == 2 && args[0].equalsIgnoreCase("admin") && sender.hasPermission("windesign.admin")) {
            completions.add("tag");
            return completions;
         }

         if (args.length == 3 && args[0].equalsIgnoreCase("admin") && args[1].equalsIgnoreCase("tag")
                 && sender.hasPermission("windesign.admin")) {
            completions.add("set");
            return completions;
         }

         if (args.length == 2 && args[0].equalsIgnoreCase("clear")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
               completions.add(onlinePlayer.getName());
            }
            return completions;
         }

         if (args.length == 3 && args[0].equalsIgnoreCase("clear")) {
            completions.add("namecolor");
            completions.add("tag");
            completions.add("tagcolor");
            completions.add("prefix");
            completions.add("prefixcolor");
            completions.add("brackets");
            completions.add("bracketscolor");
            completions.add("all");
            return completions;
         }
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

