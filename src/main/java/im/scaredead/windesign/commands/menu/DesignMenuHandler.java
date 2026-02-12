package im.scaredead.windesign.commands.menu;

import im.scaredead.windesign.WinDesign;
import im.scaredead.windesign.util.Messages;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextComponent.Builder;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Построение и вывод интерактивных меню дизайна.
 */
public final class DesignMenuHandler {
    private DesignMenuHandler() {
    }

    /**
     * Строит и показывает меню на основе аргументов команды.
     *
     * @param player игрок
     * @param args аргументы команды
     * @return true если меню было показано, иначе false
     */
    public static boolean handle(Player player, String[] args) {
        Messages messages = WinDesign.getInstance().getMessages();

            TextComponent color1;
               TextComponent color2;
               TextComponent color3;
               TextComponent color4;
               TextComponent color5;
               TextComponent color6;
               TextComponent color7;
               TextComponent color8;
               TextComponent color9;
               TextComponent color10;
               FileConfiguration var10001;
               String text5;
               String text;
               String text6;
               String text1;
               String text2;
               if (args.length == 1 && args[0].equalsIgnoreCase("namecolor")) {
                  if (player.hasPermission("windesign.namecolor.1")) {
                     color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 1"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("1")) {
                        color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color1 = (TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED);
                  }

                  if (player.hasPermission("windesign.namecolor.2")) {
                     color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 2"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("2")) {
                        color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color2 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.baron")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.3")) {
                     color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 3"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("3")) {
                        color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color3 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.strazh")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.4")) {
                     color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 4"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("4")) {
                        color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color4 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.hero")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.5")) {
                     color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 5"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("5")) {
                        color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color5 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.aspid")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.6")) {
                     color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 6"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("6")) {
                        color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color6 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.squid")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.7")) {
                     color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 7"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("7")) {
                        color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color7 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.8")) {
                     color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 8"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("8")) {
                        color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color8 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.elite")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.9")) {
                     color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 9"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("9")) {
                        color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color9 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.titan")).color(NamedTextColor.WHITE)));
                  }

                  if (player.hasPermission("windesign.namecolor.10")) {
                     color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign select 10"))).build();
                     if (WinDesign.getInstance().getPlayerColorNumber(player).equals("10")) {
                        color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign namecolor"))).build();
                     }
                  } else {
                     color10 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.princ")).color(NamedTextColor.WHITE)));
                  }

                  player.sendMessage("");
                  player.sendMessage(messages.color("menu.layout.separator"));
                  player.sendMessage("");
                  player.sendMessage(messages.color("menu.layout.header"));
                  player.sendMessage("");
                  var10001 = WinDesign.getInstance().getConfig();
                  text = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.1"));
                  player.sendMessage(Component.text(text).append(color1));
                  var10001 = WinDesign.getInstance().getConfig();
                  text2 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.2"));
                  player.sendMessage(Component.text(text2).append(color2));
                  var10001 = WinDesign.getInstance().getConfig();
                  String text3 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.3"));
                  player.sendMessage(Component.text(text3).append(color3));
                  var10001 = WinDesign.getInstance().getConfig();
                  text = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.4"));
                  player.sendMessage(Component.text(text).append(color4));
                  var10001 = WinDesign.getInstance().getConfig();
                  text1 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.5"));
                  player.sendMessage(Component.text(text1).append(color5));
                  var10001 = WinDesign.getInstance().getConfig();
                  text2 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.6"));
                  player.sendMessage(Component.text(text2).append(color6));
                  var10001 = WinDesign.getInstance().getConfig();
                  text = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.7"));
                  player.sendMessage(Component.text(text).append(color7));
                  var10001 = WinDesign.getInstance().getConfig();
                  text = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.8"));
                  player.sendMessage(Component.text(text).append(color8));
                  var10001 = WinDesign.getInstance().getConfig();
                  text5 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.9"));
                  player.sendMessage(Component.text(text5).append(color9));
                  var10001 = WinDesign.getInstance().getConfig();
                  text6 = messages.format("menu.format.color-entry", "%value%", var10001.getString("name-colors.10"));
                  player.sendMessage(Component.text(text6).append(color10));
                  player.sendMessage("");
                  player.sendMessage(messages.color("menu.layout.footer-1"));
                  player.sendMessage(messages.color("menu.layout.footer-2"));
                  player.sendMessage(messages.color("menu.layout.footer-3"));
                  player.sendMessage(messages.color("menu.layout.footer-4"));
                  player.sendMessage(messages.color("menu.layout.footer-3"));
                  return true;
               } else {
                  TextComponent color11;
                  TextComponent color12;
                  if (args.length == 1 && args[0].equalsIgnoreCase("prefix")) {
                     if (player.hasPermission("windesign.prefix.1")) {
                        color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 1"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("1")) {
                           color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color1 = (TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED);
                     }

                     if (player.hasPermission("windesign.prefix.2")) {
                        color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 2"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("2")) {
                           color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color2 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.baron")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.3")) {
                        color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 3"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("3")) {
                           color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color3 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.strazh")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.4")) {
                        color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 4"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("4")) {
                           color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color4 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.hero")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.5")) {
                        color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 5"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("5")) {
                           color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color5 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.aspid")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.6")) {
                        color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 6"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("6")) {
                           color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color6 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.squid")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.7")) {
                        color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 7"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("7")) {
                           color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color7 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.8")) {
                        color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 8"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("8")) {
                           color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color8 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.elite")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.9")) {
                        color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 9"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("9")) {
                           color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color9 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.titan")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.10")) {
                        color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 10"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("10")) {
                           color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color10 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.princ")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.11")) {
                        color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 11"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("11")) {
                           color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color11 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.knyaz")).color(NamedTextColor.WHITE)));
                     }

                     if (player.hasPermission("windesign.prefix.12")) {
                        color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix 12"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("12")) {
                           color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     } else {
                        color12 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.gercog")).color(NamedTextColor.WHITE)));
                     }

                     TextComponent colorStaff = null;
                     if (player.hasPermission("windesign.prefix.staff")) {
                        colorStaff = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix staff"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("staff")) {
                           colorStaff = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     }

                     TextComponent colorAgent = null;
                     if (player.hasPermission("windesign.prefix.agent")) {
                        colorAgent = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix agent"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("agent")) {
                           colorAgent = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     }

                     TextComponent colorTechAdmin = null;
                     if (player.hasPermission("windesign.prefix.techadmin")) {
                        colorTechAdmin = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix techadmin"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("techadmin")) {
                           colorTechAdmin = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     }

                     TextComponent colorAdmin = null;
                     if (player.hasPermission("windesign.prefix.admin")) {
                        colorAdmin = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefix admin"))).build();
                        if (WinDesign.getInstance().getPlayerPrefixNumber(player).equals("admin")) {
                           colorAdmin = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefix"))).build();
                        }
                     }

                     player.sendMessage("");
                     player.sendMessage(messages.color("menu.layout.separator"));
                     player.sendMessage("");
                     player.sendMessage(messages.color("menu.layout.header"));
                     player.sendMessage("");
                     var10001 = WinDesign.getInstance().getConfig();
                     text = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.1"));
                     player.sendMessage(Component.text(text).append(color1));
                     var10001 = WinDesign.getInstance().getConfig();
                     text1 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.2"));
                     player.sendMessage(Component.text(text1).append(color2));
                     var10001 = WinDesign.getInstance().getConfig();
                     text2 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.3"));
                     player.sendMessage(Component.text(text2).append(color3));
                     var10001 = WinDesign.getInstance().getConfig();
                     text = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.4"));
                     player.sendMessage(Component.text(text).append(color4));
                     var10001 = WinDesign.getInstance().getConfig();
                     text = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.5"));
                     player.sendMessage(Component.text(text).append(color5));
                     var10001 = WinDesign.getInstance().getConfig();
                     text5 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.6"));
                     player.sendMessage(Component.text(text5).append(color6));
                     var10001 = WinDesign.getInstance().getConfig();
                     text6 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.7"));
                     player.sendMessage(Component.text(text6).append(color7));
                     var10001 = WinDesign.getInstance().getConfig();
                     String text7 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.8"));
                     player.sendMessage(Component.text(text7).append(color8));
                     var10001 = WinDesign.getInstance().getConfig();
                     String text8 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.9"));
                     player.sendMessage(Component.text(text8).append(color9));
                     var10001 = WinDesign.getInstance().getConfig();
                     String text9 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.10"));
                     player.sendMessage(Component.text(text9).append(color10));
                     var10001 = WinDesign.getInstance().getConfig();
                     String text10 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.11"));
                     player.sendMessage(Component.text(text10).append(color11));
                     var10001 = WinDesign.getInstance().getConfig();
                     String text11 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.12"));
                     player.sendMessage(Component.text(text11).append(color12));
                     if (colorStaff != null) {
                        var10001 = WinDesign.getInstance().getConfig();
                        String text12 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.staff"));
                        player.sendMessage(Component.text(text12).append(colorStaff));
                     }
                     if (colorAgent != null) {
                        var10001 = WinDesign.getInstance().getConfig();
                        String text13 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.agent"));
                        player.sendMessage(Component.text(text13).append(colorAgent));
                     }
                     if (colorTechAdmin != null) {
                        var10001 = WinDesign.getInstance().getConfig();
                        String text14 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.techadmin"));
                        player.sendMessage(Component.text(text14).append(colorTechAdmin));
                     }
                     if (colorAdmin != null) {
                        var10001 = WinDesign.getInstance().getConfig();
                        String text15 = messages.format("menu.format.value-entry", "%value%", var10001.getString("prefix.admin"));
                        player.sendMessage(Component.text(text15).append(colorAdmin));
                     }
                     player.sendMessage(messages.color("menu.layout.footer-1"));
                     player.sendMessage(messages.color("menu.layout.footer-2"));
                     player.sendMessage(messages.color("menu.layout.footer-3"));
                     player.sendMessage(messages.color("menu.layout.footer-4"));
                     player.sendMessage(messages.color("menu.layout.footer-3"));
                     return true;
                  } else {
                     TextComponent color13;
                     TextComponent color14;
                     TextComponent color15;
                     TextComponent color16;
                     TextComponent color17;
                     TextComponent color18;
                     if (args.length == 1 && args[0].equalsIgnoreCase("prefixcolor")) {
                        if (player.hasPermission("windesign.prefixcolor.1")) {
                           color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 1"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("1")) {
                              color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color1 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.2")) {
                           color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 2"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("2")) {
                              color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color2 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.3")) {
                           color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 3"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("3")) {
                              color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color3 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.4")) {
                           color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 4"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("4")) {
                              color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color4 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.5")) {
                           color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 5"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("5")) {
                              color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color5 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.6")) {
                           color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 6"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("6")) {
                              color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color6 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.7")) {
                           color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 7"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("7")) {
                              color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color7 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.8")) {
                           color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 8"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("8")) {
                              color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color8 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.9")) {
                           color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 9"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("9")) {
                              color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color9 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.10")) {
                           color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 10"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("10")) {
                              color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color10 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.11")) {
                           color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 11"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("11")) {
                              color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color11 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.12")) {
                           color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 12"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("12")) {
                              color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color12 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.13")) {
                           color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 13"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("13")) {
                              color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color13 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.14")) {
                           color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 14"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("14")) {
                              color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color14 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.15")) {
                           color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 15"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("15")) {
                              color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color15 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.glava")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.16")) {
                           color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 16"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("16")) {
                              color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color16 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.titan")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.17")) {
                           color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 17"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("17")) {
                              color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color17 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.knyaz")).color(NamedTextColor.WHITE)));
                        }

                        if (player.hasPermission("windesign.prefixcolor.18")) {
                           color18 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectprefixcolor 18"))).build();
                           if (WinDesign.getInstance().getPlayerPrefixColorNumber(player).equals("18")) {
                              color18 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign prefixcolor"))).build();
                           }
                        } else {
                           color18 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.gercog")).color(NamedTextColor.WHITE)));
                        }

                        player.sendMessage("");
                        player.sendMessage(messages.color("menu.layout.separator"));
                        player.sendMessage("");
                        player.sendMessage(messages.color("menu.layout.header"));
                        player.sendMessage("");
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(255, 255, 255))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color1));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(255, 255, 255))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color2));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(210, 209, 254))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color3));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(163, 231, 196))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color4));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(66, 229, 214))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color5));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(0, 254, 244))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color6));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(0, 184, 254))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color7));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(104, 153, 244))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color8));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(255, 131, 83))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color9));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(255, 196, 0))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color10));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(227, 255, 0))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color11));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(92, 255, 0))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color12));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(0, 255, 118))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color13));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(0, 58, 255))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color14));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(129, 0, 255))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color15));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(255, 0, 175))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color16));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(254, 0, 45))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color17));
                        player.sendMessage(((TextComponent)((TextComponent)Component.text(messages.raw("menu.labels.color-line")).color(TextColor.color(194, 0, 0))).append(Component.text(messages.raw("menu.labels.dash")).color(TextColor.color(255, 255, 255)))).append(color18));
                        player.sendMessage("");
                        player.sendMessage(messages.color("menu.layout.footer-1"));
                        player.sendMessage(messages.color("menu.layout.footer-2"));
                        player.sendMessage(messages.color("menu.layout.footer-3"));
                        player.sendMessage(messages.color("menu.layout.footer-4"));
                        player.sendMessage(messages.color("menu.layout.footer-3"));
                        return true;
                     } else {
                        TextComponent var10000;
                        if (args.length == 1 && args[0].equalsIgnoreCase("tags")) {
                           if (player.hasPermission("windesign.tag.1")) {
                              color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 1"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("1")) {
                                 color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color1 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.1.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 1"));
                           }

                           if (player.hasPermission("windesign.tag.2")) {
                              color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 2"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("2")) {
                                 color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color2 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.2.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 2"));
                           }

                           if (player.hasPermission("windesign.tag.3")) {
                              color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 3"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("3")) {
                                 color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color3 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.3.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 3"));
                           }

                           if (player.hasPermission("windesign.tag.4")) {
                              color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 4"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("4")) {
                                 color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color4 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.4.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 4"));
                           }

                           if (player.hasPermission("windesign.tag.5")) {
                              color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 5"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("5")) {
                                 color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color5 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.5.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 5"));
                           }

                           if (player.hasPermission("windesign.tag.6")) {
                              color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 6"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("6")) {
                                 color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color6 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.6.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 6"));
                           }

                           if (player.hasPermission("windesign.tag.7")) {
                              color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 7"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("7")) {
                                 color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color7 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.7.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 7"));
                           }

                           if (player.hasPermission("windesign.tag.8")) {
                              color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 8"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("8")) {
                                 color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color8 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.8.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 8"));
                           }

                           if (player.hasPermission("windesign.tag.9")) {
                              color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 9"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("9")) {
                                 color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color9 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.9.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 9"));
                           }

                           if (player.hasPermission("windesign.tag.10")) {
                              color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 10"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("10")) {
                                 color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color10 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.10.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 10"));
                           }

                           if (player.hasPermission("windesign.tag.11")) {
                              color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 11"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("11")) {
                                 color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color11 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.11.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 11"));
                           }

                           if (player.hasPermission("windesign.tag.12")) {
                              color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 12"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("12")) {
                                 color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color12 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.12.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 12"));
                           }

                           if (player.hasPermission("windesign.tag.13")) {
                              color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 13"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("13")) {
                                 color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color13 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.13.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 13"));
                           }

                           if (player.hasPermission("windesign.tag.14")) {
                              color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 14"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("14")) {
                                 color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color14 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.14.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 14"));
                           }

                           if (player.hasPermission("windesign.tag.15")) {
                              color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 15"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("15")) {
                                 color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color15 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.15.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 15"));
                           }

                           if (player.hasPermission("windesign.tag.16")) {
                              color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 16"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("16")) {
                                 color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color16 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.16.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 16"));
                           }

                           if (player.hasPermission("windesign.tag.17")) {
                              color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 17"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("17")) {
                                 color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color17 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.17.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 17"));
                           }

                           if (player.hasPermission("windesign.tag.18")) {
                              color18 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 18"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("18")) {
                                 color18 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color18 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.18.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 18"));
                           }

                           TextComponent color19;
                           if (player.hasPermission("windesign.tag.19")) {
                              color19 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 19"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("19")) {
                                 color19 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color19 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.19.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 19"));
                           }

                           TextComponent color20;
                           if (player.hasPermission("windesign.tag.20")) {
                              color20 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 20"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("20")) {
                                 color20 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color20 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.20.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 20"));
                           }

                           TextComponent color21;
                           if (player.hasPermission("windesign.tag.21")) {
                              color21 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 21"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("21")) {
                                 color21 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color21 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.21.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 21"));
                           }

                           TextComponent color22;
                           if (player.hasPermission("windesign.tag.22")) {
                              color22 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 22"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("22")) {
                                 color22 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color22 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.22.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 22"));
                           }

                           TextComponent color23;
                           if (player.hasPermission("windesign.tag.23")) {
                              color23 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 23"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("23")) {
                                 color23 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color23 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.23.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 23"));
                           }

                           TextComponent color24;
                           if (player.hasPermission("windesign.tag.24")) {
                              color24 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 24"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("24")) {
                                 color24 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color24 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.24.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 24"));
                           }

                           TextComponent color25;
                           if (player.hasPermission("windesign.tag.25")) {
                              color25 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 25"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("25")) {
                                 color25 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color25 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.25.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 25"));
                           }

                           TextComponent color26;
                           if (player.hasPermission("windesign.tag.26")) {
                              color26 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 26"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("26")) {
                                 color26 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color26 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.26.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 26"));
                           }

                           TextComponent color27;
                           if (player.hasPermission("windesign.tag.27")) {
                              color27 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 27"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("27")) {
                                 color27 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color27 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.27.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 27"));
                           }

                           TextComponent color28;
                           if (player.hasPermission("windesign.tag.28")) {
                              color28 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 28"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("28")) {
                                 color28 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color28 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.28.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 28"));
                           }

                           TextComponent color29;
                           if (player.hasPermission("windesign.tag.29")) {
                              color29 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 29"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("29")) {
                                 color29 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color29 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.29.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 29"));
                           }

                           TextComponent color30;
                           if (player.hasPermission("windesign.tag.30")) {
                              color30 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 30"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("30")) {
                                 color30 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color30 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.30.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 30"));
                           }

                           TextComponent color31;
                           if (player.hasPermission("windesign.tag.31")) {
                              color31 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttag 31"))).build();
                              if (WinDesign.getInstance().getPlayerTagNumber(player).equals("31")) {
                                 color31 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tag"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color31 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags.31.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytag 31"));
                           }

                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.separator"));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.header"));
                           player.sendMessage("");
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.1.name"));
                           player.sendMessage(Component.text(text).append(color1));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.2.name"));
                           player.sendMessage(Component.text(text).append(color2));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.3.name"));
                           player.sendMessage(Component.text(text).append(color3));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.4.name"));
                           player.sendMessage(Component.text(text).append(color4));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.5.name"));
                           player.sendMessage(Component.text(text).append(color5));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.6.name"));
                           player.sendMessage(Component.text(text).append(color6));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.7.name"));
                           player.sendMessage(Component.text(text).append(color7));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.8.name"));
                           player.sendMessage(Component.text(text).append(color8));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.9.name"));
                           player.sendMessage(Component.text(text).append(color9));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.10.name"));
                           player.sendMessage(Component.text(text).append(color10));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.11.name"));
                           player.sendMessage(Component.text(text).append(color11));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.12.name"));
                           player.sendMessage(Component.text(text).append(color12));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.13.name"));
                           player.sendMessage(Component.text(text).append(color13));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.14.name"));
                           player.sendMessage(Component.text(text).append(color14));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.15.name"));
                           player.sendMessage(Component.text(text).append(color15));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.16.name"));
                           player.sendMessage(Component.text(text).append(color16));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.17.name"));
                           player.sendMessage(Component.text(text).append(color17));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.18.name"));
                           player.sendMessage(Component.text(text).append(color18));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.19.name"));
                           player.sendMessage(Component.text(text).append(color19));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.20.name"));
                           player.sendMessage(Component.text(text).append(color20));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.21.name"));
                           player.sendMessage(Component.text(text).append(color21));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.22.name"));
                           player.sendMessage(Component.text(text).append(color22));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.23.name"));
                           player.sendMessage(Component.text(text).append(color23));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.24.name"));
                           player.sendMessage(Component.text(text).append(color24));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.25.name"));
                           player.sendMessage(Component.text(text).append(color25));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.26.name"));
                           player.sendMessage(Component.text(text).append(color26));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.27.name"));
                           player.sendMessage(Component.text(text).append(color27));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.28.name"));
                           player.sendMessage(Component.text(text).append(color28));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.29.name"));
                           player.sendMessage(Component.text(text).append(color29));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.30.name"));
                           player.sendMessage(Component.text(text).append(color30));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.value-entry", "%value%", var10001.getString("tags.31.name"));
                           player.sendMessage(Component.text(text).append(color31));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.footer-1"));
                           player.sendMessage(messages.color("menu.layout.footer-2"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           player.sendMessage(messages.color("menu.layout.footer-4"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           return true;
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("tagscolor")) {
                           if (player.hasPermission("windesign.tagcolor.1")) {
                              color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 1"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("1")) {
                                 color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color1 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.1.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 1"));
                           }

                           if (player.hasPermission("windesign.tagcolor.2")) {
                              color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 2"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("2")) {
                                 color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color2 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.2.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 2"));
                           }

                           if (player.hasPermission("windesign.tagcolor.3")) {
                              color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 3"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("3")) {
                                 color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color3 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.3.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 3"));
                           }

                           if (player.hasPermission("windesign.tagcolor.4")) {
                              color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 4"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("4")) {
                                 color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color4 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.4.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 4"));
                           }

                           if (player.hasPermission("windesign.tagcolor.5")) {
                              color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 5"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("5")) {
                                 color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color5 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.5.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 5"));
                           }

                           if (player.hasPermission("windesign.tagcolor.6")) {
                              color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 6"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("6")) {
                                 color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color6 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.6.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 6"));
                           }

                           if (player.hasPermission("windesign.tagcolor.7")) {
                              color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 7"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("7")) {
                                 color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color7 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.7.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 7"));
                           }

                           if (player.hasPermission("windesign.tagcolor.8")) {
                              color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 8"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("8")) {
                                 color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color8 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.8.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 8"));
                           }

                           if (player.hasPermission("windesign.tagcolor.9")) {
                              color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 9"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("9")) {
                                 color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color9 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.9.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 9"));
                           }

                           if (player.hasPermission("windesign.tagcolor.10")) {
                              color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 10"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("10")) {
                                 color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color10 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.10.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 10"));
                           }

                           if (player.hasPermission("windesign.tagcolor.11")) {
                              color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 11"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("11")) {
                                 color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color11 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.11.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 11"));
                           }

                           if (player.hasPermission("windesign.tagcolor.12")) {
                              color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 12"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("12")) {
                                 color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color12 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.12.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 12"));
                           }

                           if (player.hasPermission("windesign.tagcolor.13")) {
                              color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 13"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("13")) {
                                 color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color13 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.13.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 13"));
                           }

                           if (player.hasPermission("windesign.tagcolor.14")) {
                              color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 14"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("14")) {
                                 color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color14 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.14.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 14"));
                           }

                           if (player.hasPermission("windesign.tagcolor.15")) {
                              color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 15"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("15")) {
                                 color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color15 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.15.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 15"));
                           }

                           if (player.hasPermission("windesign.tagcolor.16")) {
                              color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 16"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("16")) {
                                 color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color16 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.16.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 16"));
                           }

                           if (player.hasPermission("windesign.tagcolor.17")) {
                              color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selecttagcolor 17"))).build();
                              if (WinDesign.getInstance().getPlayerTagColorNumber(player).equals("17")) {
                                 color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign tagcolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color17 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("tags-colors.17.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buytagcolor 17"));
                           }

                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.separator"));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.header"));
                           player.sendMessage("");
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.1.color"));
                           player.sendMessage(Component.text(text).append(color1));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.2.color"));
                           player.sendMessage(Component.text(text).append(color2));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.3.color"));
                           player.sendMessage(Component.text(text).append(color3));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.4.color"));
                           player.sendMessage(Component.text(text).append(color4));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.5.color"));
                           player.sendMessage(Component.text(text).append(color5));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.6.color"));
                           player.sendMessage(Component.text(text).append(color6));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.7.color"));
                           player.sendMessage(Component.text(text).append(color7));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.8.color"));
                           player.sendMessage(Component.text(text).append(color8));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.9.color"));
                           player.sendMessage(Component.text(text).append(color9));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.10.color"));
                           player.sendMessage(Component.text(text).append(color10));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.11.color"));
                           player.sendMessage(Component.text(text).append(color11));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.12.color"));
                           player.sendMessage(Component.text(text).append(color12));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.13.color"));
                           player.sendMessage(Component.text(text).append(color13));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.14.color"));
                           player.sendMessage(Component.text(text).append(color14));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.15.color"));
                           player.sendMessage(Component.text(text).append(color15));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.16.color"));
                           player.sendMessage(Component.text(text).append(color16));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.17.color"));
                           player.sendMessage(Component.text(text).append(color17));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.footer-1"));
                           player.sendMessage(messages.color("menu.layout.footer-2"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           player.sendMessage(messages.color("menu.layout.footer-4"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           return true;
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("brackets")) {
                           if (player.hasPermission("windesign.brackets.1")) {
                              color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 1"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("1")) {
                                 color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color1 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.1.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 1"));
                           }

                           if (player.hasPermission("windesign.brackets.2")) {
                              color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 2"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("2")) {
                                 color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color2 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.2.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 2"));
                           }

                           if (player.hasPermission("windesign.brackets.3")) {
                              color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 3"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("3")) {
                                 color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color3 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.3.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 3"));
                           }

                           if (player.hasPermission("windesign.brackets.4")) {
                              color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 4"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("4")) {
                                 color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color4 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.4.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 4"));
                           }

                           if (player.hasPermission("windesign.brackets.5")) {
                              color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 5"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("5")) {
                                 color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color5 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.5.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 5"));
                           }

                           if (player.hasPermission("windesign.brackets.6")) {
                              color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 6"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("6")) {
                                 color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color6 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.6.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 6"));
                           }

                           if (player.hasPermission("windesign.brackets.7")) {
                              color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 7"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("7")) {
                                 color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color7 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.7.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 7"));
                           }

                           if (player.hasPermission("windesign.brackets.8")) {
                              color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 8"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("8")) {
                                 color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color8 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.8.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 8"));
                           }

                           if (player.hasPermission("windesign.brackets.9")) {
                              color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 9"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("9")) {
                                 color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color9 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.9.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 9"));
                           }

                           if (player.hasPermission("windesign.brackets.10")) {
                              color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 10"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("10")) {
                                 color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color10 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.10.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 10"));
                           }

                           if (player.hasPermission("windesign.brackets.11")) {
                              color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 11"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("11")) {
                                 color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color11 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.11.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 11"));
                           }

                           if (player.hasPermission("windesign.brackets.12")) {
                              color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 12"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("12")) {
                                 color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color12 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.12.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 12"));
                           }

                           if (player.hasPermission("windesign.brackets.13")) {
                              color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 13"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("13")) {
                                 color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color13 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.13.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 13"));
                           }

                           if (player.hasPermission("windesign.brackets.14")) {
                              color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 14"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("14")) {
                                 color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color14 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets.14.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybrackets 14"));
                           }

                           if (player.hasPermission("windesign.brackets.15")) {
                              color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 15"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("15")) {
                                 color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              color15 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.gercog")).color(NamedTextColor.WHITE)));
                           }

                           if (player.hasPermission("windesign.brackets.16")) {
                              color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbrackets 16"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsNumber(player).equals("16")) {
                                 color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign brackets"))).build();
                              }
                           } else {
                              color16 = (TextComponent)((TextComponent)Component.text(messages.raw("menu.status.unavailable")).color(NamedTextColor.RED)).hoverEvent(((TextComponent)Component.text(messages.raw("menu.hover.only-for")).color(NamedTextColor.RED)).append(Component.text(messages.raw("menu.groups.gercog")).color(NamedTextColor.WHITE)));
                           }

                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.separator"));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.header"));
                           player.sendMessage("");
                           String var50 = WinDesign.getInstance().getConfig().getString("brackets.1.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.1.right"));
                           player.sendMessage(Component.text(text).append(color1));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.2.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.2.right"));
                           player.sendMessage(Component.text(text).append(color2));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.3.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.3.right"));
                           player.sendMessage(Component.text(text).append(color3));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.4.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.4.right"));
                           player.sendMessage(Component.text(text).append(color4));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.5.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.5.right"));
                           player.sendMessage(Component.text(text).append(color5));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.6.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.6.right"));
                           player.sendMessage(Component.text(text).append(color6));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.7.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.7.right"));
                           player.sendMessage(Component.text(text).append(color7));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.8.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.8.right"));
                           player.sendMessage(Component.text(text).append(color8));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.9.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.9.right"));
                           player.sendMessage(Component.text(text).append(color9));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.10.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.10.right"));
                           player.sendMessage(Component.text(text).append(color10));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.11.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.11.right"));
                           player.sendMessage(Component.text(text).append(color11));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.12.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.12.right"));
                           player.sendMessage(Component.text(text).append(color12));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.13.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.13.right"));
                           player.sendMessage(Component.text(text).append(color13));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.14.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.14.right"));
                           player.sendMessage(Component.text(text).append(color14));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.15.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.15.right"));
                           player.sendMessage(Component.text(text).append(color15));
                           var50 = WinDesign.getInstance().getConfig().getString("brackets.16.left");
                           text = messages.format("menu.format.value-entry", "%value%", var50 + WinDesign.getInstance().getConfig().getString("brackets.16.right"));
                           player.sendMessage(Component.text(text).append(color16));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.footer-1"));
                           player.sendMessage(messages.color("menu.layout.footer-2"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           player.sendMessage(messages.color("menu.layout.footer-4"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           return true;
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("bracketscolor")) {
                           if (player.hasPermission("windesign.bracketscolor.1")) {
                              color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 1"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("1")) {
                                 color1 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color1 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.1.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 1"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.2")) {
                              color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 2"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("2")) {
                                 color2 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color2 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.2.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 2"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.3")) {
                              color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 3"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("3")) {
                                 color3 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color3 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.3.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 3"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.4")) {
                              color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 4"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("4")) {
                                 color4 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color4 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.4.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 4"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.5")) {
                              color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 5"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("5")) {
                                 color5 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color5 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.5.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 5"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.6")) {
                              color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 6"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("6")) {
                                 color6 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color6 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.6.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 6"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.7")) {
                              color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 7"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("7")) {
                                 color7 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color7 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.7.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 7"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.8")) {
                              color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 8"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("8")) {
                                 color8 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color8 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.8.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 8"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.9")) {
                              color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 9"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("9")) {
                                 color9 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color9 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.9.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 9"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.10")) {
                              color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 10"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("10")) {
                                 color10 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color10 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.10.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 10"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.11")) {
                              color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 11"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("11")) {
                                 color11 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color11 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.11.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 11"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.12")) {
                              color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 12"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("12")) {
                                 color12 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color12 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.12.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 12"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.13")) {
                              color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 13"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("13")) {
                                 color13 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color13 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.13.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 13"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.14")) {
                              color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 14"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("14")) {
                                 color14 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color14 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.14.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 14"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.15")) {
                              color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 15"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("15")) {
                                 color15 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color15 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.15.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 15"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.16")) {
                              color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 16"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("16")) {
                                 color16 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color16 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.16.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 16"));
                           }

                           if (player.hasPermission("windesign.bracketscolor.17")) {
                              color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.available")).color(NamedTextColor.YELLOW)).hoverEvent(Component.text(messages.raw("menu.hover.install")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign selectbracketscolor 17"))).build();
                              if (WinDesign.getInstance().getPlayerBracketsColorNumber(player).equals("17")) {
                                 color17 = (TextComponent)((Builder)((Builder)((Builder)Component.text().content(messages.raw("menu.status.installed")).color(NamedTextColor.GREEN)).hoverEvent(Component.text(messages.raw("menu.hover.reset")).color(NamedTextColor.YELLOW))).clickEvent(ClickEvent.runCommand("/windesign deldesign bracketscolor"))).build();
                              }
                           } else {
                              var10000 = (TextComponent)Component.text(messages.raw("menu.labels.buy")).color(NamedTextColor.GOLD);
                              var10001 = WinDesign.getInstance().getConfig();
                              color17 = (TextComponent)((TextComponent)((TextComponent)((TextComponent)var10000.append(Component.text(var10001.getInt("brackets-colors.17.price") + messages.raw("menu.labels.tokens")).color(NamedTextColor.GREEN))).append(Component.text("]").color(NamedTextColor.GOLD))).hoverEvent(Component.text(messages.raw("menu.hover.buy")).color(NamedTextColor.GREEN))).clickEvent(ClickEvent.runCommand("/windesign buybracketscolor 17"));
                           }

                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.separator"));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.header"));
                           player.sendMessage("");
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.1.color"));
                           player.sendMessage(Component.text(text).append(color1));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.2.color"));
                           player.sendMessage(Component.text(text).append(color2));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.3.color"));
                           player.sendMessage(Component.text(text).append(color3));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.4.color"));
                           player.sendMessage(Component.text(text).append(color4));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.5.color"));
                           player.sendMessage(Component.text(text).append(color5));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.6.color"));
                           player.sendMessage(Component.text(text).append(color6));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.7.color"));
                           player.sendMessage(Component.text(text).append(color7));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.8.color"));
                           player.sendMessage(Component.text(text).append(color8));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.9.color"));
                           player.sendMessage(Component.text(text).append(color9));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.10.color"));
                           player.sendMessage(Component.text(text).append(color10));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.11.color"));
                           player.sendMessage(Component.text(text).append(color11));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.12.color"));
                           player.sendMessage(Component.text(text).append(color12));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.13.color"));
                           player.sendMessage(Component.text(text).append(color13));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.14.color"));
                           player.sendMessage(Component.text(text).append(color14));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.15.color"));
                           player.sendMessage(Component.text(text).append(color15));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.16.color"));
                           player.sendMessage(Component.text(text).append(color16));
                           var10001 = WinDesign.getInstance().getConfig();
                           text = messages.format("menu.format.color-entry", "%value%", var10001.getString("tags-colors.17.color"));
                           player.sendMessage(Component.text(text).append(color17));
                           player.sendMessage("");
                           player.sendMessage(messages.color("menu.layout.footer-1"));
                           player.sendMessage(messages.color("menu.layout.footer-2"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           player.sendMessage(messages.color("menu.layout.footer-4"));
                           player.sendMessage(messages.color("menu.layout.footer-3"));
                           return true;
                        } else {
                           return false;
                        }
                     }
                  }
               }
               }
}
