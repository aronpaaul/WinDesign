package im.paul.windesign.placeholders;

import java.util.Objects;
import im.paul.windesign.WinDesign;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Плейсхолдеры PlaceholderAPI для WinDesign.
 */
public class BracketsPlaceholderExpansion extends PlaceholderExpansion {
   private final JavaPlugin plugin;

   /**
    * Создаёт расширение PlaceholderAPI.
    *
    * @param plugin экземпляр плагина
    */
   public BracketsPlaceholderExpansion(JavaPlugin plugin) {
      this.plugin = plugin;
   }

   /**
    * Проверяет возможность регистрации расширения.
    *
    * @return true если PlaceholderAPI установлен
    */
   public boolean canRegister() {
      return this.plugin.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null;
   }

   /**
    * Возвращает идентификатор плейсхолдеров.
    *
    * @return идентификатор
    */
   public String getIdentifier() {
      return "windesign";
   }

   /**
    * Возвращает автора расширения.
    *
    * @return автор
    */
   public String getAuthor() {
      return "aronpaul";
   }

   /**
    * Возвращает версию расширения.
    *
    * @return версия
    */
   public String getVersion() {
      return "1.0";
   }

   /**
    * Обрабатывает плейсхолдеры для конкретного игрока.
    *
    * @param player игрок
    * @param identifier идентификатор плейсхолдера
    * @return значение плейсхолдера
    */
   public String onPlaceholderRequest(Player player, String identifier) {
      if (player == null) {
         return "";
      } else if (identifier.equals("color")) {
         return WinDesign.getInstance().getPlayerColor(player);
      } else if (identifier.equals("prefixcolor")) {
         if (WinDesign.getInstance().hasCustomPrefixColor(player)) {
            String color = WinDesign.getInstance().getPrefixPlayerColor(player);
            return Objects.equals(color, "upper") ? WinDesign.getInstance().getLuckPermsPrefixColorCode(player) : color;
         }

         if (WinDesign.getInstance().hasCustomPrefix(player)) {
            return WinDesign.getInstance().getLuckPermsPrefixColorCode(player);
         }

         return "";
      } else if (identifier.equals("tabprefixcolor")) {
         String color = WinDesign.getInstance().getEffectivePrefixColor(player);
         if (color == null || color.isEmpty()) {
            color = WinDesign.getInstance().getLuckPermsPrefixColorCode(player);
         }

         if (color == null || color.isEmpty()) {
            return "";
         }

         return color + "\u26A1";
      } else if (identifier.equals("prefix")) {
         return WinDesign.getInstance().getPlayerPrefix(player);
      } else if (identifier.equals("tag")) {
         String tag = WinDesign.getInstance().getPlayerTag(player);
         return tag == null || tag.isEmpty() ? "" : " " + tag;
      } else if (identifier.equals("tagfull")) {
         if (!WinDesign.getInstance().hasCustomTag(player)) {
            return "";
         }

         String tag = WinDesign.getInstance().getPlayerTag(player);
         if (tag == null || tag.isEmpty()) {
            return "";
         }

         String color = WinDesign.getInstance().getPlayerTagColor(player);
         if (color == null) {
            color = "";
         }

         return " " + color + tag;
      } else if (identifier.equals("tagcolor")) {
         return WinDesign.getInstance().hasCustomTag(player) ? WinDesign.getInstance().getPlayerTagColor(player) : "";
      } else if (identifier.equals("bracketscolor")) {
         return WinDesign.getInstance().getPlayerBracketsColor(player);
      } else if (identifier.equals("leftbrackets")) {
         return WinDesign.getInstance().getPlayerBracketsLeft(player);
      } else {
         return identifier.equals("rightbrackets") ? WinDesign.getInstance().getPlayerBracketsRight(player) : null;
      }
   }
}

