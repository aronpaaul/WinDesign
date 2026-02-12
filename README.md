# WinDesign

Плагин для настройки дизайна ника, префикса, тегов и скобок с поддержкой PlaceholderAPI и LuckPerms.

**Зависимости**
1. `PlaceholderAPI` (обязательно).
2. `LuckPerms` (обязательно).
3. `PlayerPoints` (нужно только для покупок за токены).

**Команды**
1. `/windesign` — главное меню (алиасы: `/prefix`, `/tag`, `/brackets`, `/namecolor`).
2. `/prefix select <id>` — выбрать префикс.
3. `/prefix color select <id>` — выбрать цвет префикса.
4. `/prefix del` — сбросить префикс.
5. `/tag select <id>` — выбрать тег.
6. `/tag color select <id>` — выбрать цвет тега.
7. `/tag buy <id>` — купить тег за токены.
8. `/tag del` — сбросить тег.
9. `/brackets select <id>` — выбрать скобки.
10. `/brackets color select <id>` — выбрать цвет скобок.
11. `/brackets buy <id>` — купить скобки за токены.
12. `/brackets del` — сбросить скобки.
13. `/namecolor select <id>` — выбрать цвет ника.
14. `/namecolor del` — сбросить цвет ника.

**Плейсхолдеры**
1. `%windesign_color%` — цвет ника.
2. `%windesign_prefix%` — выбранный префикс (или префикс из LuckPerms, если кастомный не выбран).
3. `%windesign_prefixcolor%` — цвет префикса (если не выбран — берётся цвет из LuckPerms).
4. `%windesign_tabprefixcolor%` — цвет префикса + символ `⚡`.
5. `%windesign_bracketscolor%` — цвет скобок.
6. `%windesign_leftbrackets%` — левая скобка.
7. `%windesign_rightbrackets%` — правая скобка.
8. `%windesign_tag%` — тег. Если тег не установлен, плейсхолдер ничего не выводит. Тег уже содержит ведущий пробел.
9. `%windesign_tagcolor%` — цвет тега. Если тег не установлен, плейсхолдер ничего не выводит.
10. `%windesign_tagfull%` — полный тег с цветом и ведущим пробелом (если не установлен — ничего не выводит).

## Форматы чата (PromisedChat)

Пример из референсного конфига разработчика:
```yaml
local: "&#E0A602Ⓛ %javascript_clantag%%windesign_bracketscolor%%windesign_leftbrackets%%windesign_prefixcolor%%windesign_prefix%%windesign_bracketscolor%%windesign_rightbrackets%&r %windesign_color%<player>%windesign_tagcolor%%windesign_tag% &7⇨ &#89FF89<message>"
```

Пояснение:
1. `&#E0A602Ⓛ` — иконка/метка канала с HEX‑цветом.
2. `%javascript_clantag%` — ваш клан‑тег (если есть).
3. `%windesign_bracketscolor%...%windesign_rightbrackets%` — скобки с цветом.
4. `%windesign_prefixcolor%%windesign_prefix%` — цвет + префикс.
5. `&r` — сброс форматирования перед ником.
6. `%windesign_color%<player>` — цвет ника + имя игрока.
7. `%windesign_tagcolor%%windesign_tag%` — цвет тега + тег (ведущий пробел уже внутри плейсхолдера).
8. `&7⇨` — разделитель.
9. `&#89FF89<message>` — цвет сообщения.

## Форматы TAB (TAB / groups.yml)

**Пример для групп** (baron и остальные, как в референсе разработчика):
```yaml
baron:
  tabprefix: "%windesign_tabprefixcolor% %windesign_prefix% &f"
  tagprefix: "%windesign_tabprefixcolor% %windesign_prefix% &f"
```

**Пример для тегов** (`_DEFAULT_`, как в референсе разработчика):
```yaml
_DEFAULT_:
  tabprefix: "%luckperms-prefix%"
  tagprefix: "%luckperms-prefix%"
  customtabname: "%player%"
  customtagname: "%player%" # не забудь включить unlimited nametag mode
  tabsuffix: "%windesign_tagcolor%%windesign_tag%"
  tagsuffix: "%windesign_tagcolor%%windesign_tag%"
```

## База данных

Данные игроков хранятся в SQLite: `plugins/WinDesign/windesign.db`.
Сохранение происходит при выходе игрока и при отключении плагина.
