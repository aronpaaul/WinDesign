package im.paul.windesign.commands.args;

/**
 * Утилита для преобразования аргументов алиасов в команды WinDesign.
 */
public final class ArgumentParser {
    private ArgumentParser() {
    }

    /**
     * Преобразует аргументы алиаса в формат внутренних действий.
     *
     * @param cmdName имя команды
     * @param args аргументы пользователя
     * @return массив с действием и параметром либо null
     */
    public static String[] map(String cmdName, String[] args) {
        if (cmdName.equalsIgnoreCase("brackets")) {
            return mapBracketsArgs(args);
        } else if (cmdName.equalsIgnoreCase("prefix")) {
            return mapPrefixArgs(args);
        } else if (cmdName.equalsIgnoreCase("tag")) {
            return mapTagArgs(args);
        } else if (cmdName.equalsIgnoreCase("namecolor")) {
            return mapNameColorArgs(args);
        } else {
            return null;
        }
    }

    /**
     * Преобразует аргументы команды скобок.
     *
     * @param args аргументы
     * @return массив действий
     */
    private static String[] mapBracketsArgs(String[] args) {
        if (args.length == 0) {
            return new String[]{"brackets"};
        }

        if (args[0].equalsIgnoreCase("color")) {
            if (args.length == 1) {
                return new String[]{"bracketscolor"};
            }

            String action = args[1];
            if (action.equalsIgnoreCase("select") && args.length >= 3) {
                return new String[]{"selectbracketscolor", args[2]};
            } else if (action.equalsIgnoreCase("buy") && args.length >= 3) {
                return new String[]{"buybracketscolor", args[2]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "bracketscolor"};
            } else {
                return new String[]{"bracketscolor"};
            }
        } else {
            String action = args[0];
            if (action.equalsIgnoreCase("select") && args.length >= 2) {
                return new String[]{"selectbrackets", args[1]};
            } else if (action.equalsIgnoreCase("buy") && args.length >= 2) {
                return new String[]{"buybrackets", args[1]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "brackets"};
            } else {
                return new String[]{"brackets"};
            }
        }
    }

    /**
     * Преобразует аргументы команды префикса.
     *
     * @param args аргументы
     * @return массив действий
     */
    private static String[] mapPrefixArgs(String[] args) {
        if (args.length == 0) {
            return new String[]{"prefix"};
        }

        if (args[0].equalsIgnoreCase("color")) {
            if (args.length == 1) {
                return new String[]{"prefixcolor"};
            }

            String action = args[1];
            if (action.equalsIgnoreCase("select") && args.length >= 3) {
                return new String[]{"selectprefixcolor", args[2]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "prefixcolor"};
            } else {
                return new String[]{"prefixcolor"};
            }
        } else {
            String action = args[0];
            if (action.equalsIgnoreCase("select") && args.length >= 2) {
                return new String[]{"selectprefix", args[1]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "prefix"};
            } else {
                return new String[]{"prefix"};
            }
        }
    }

    /**
     * Преобразует аргументы команды тегов.
     *
     * @param args аргументы
     * @return массив действий
     */
    private static String[] mapTagArgs(String[] args) {
        if (args.length == 0) {
            return new String[]{"tags"};
        }

        if (args[0].equalsIgnoreCase("color")) {
            if (args.length == 1) {
                return new String[]{"tagscolor"};
            }

            String action = args[1];
            if (action.equalsIgnoreCase("select") && args.length >= 3) {
                return new String[]{"selecttagcolor", args[2]};
            } else if (action.equalsIgnoreCase("buy") && args.length >= 3) {
                return new String[]{"buytagcolor", args[2]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "tagcolor"};
            } else {
                return new String[]{"tagscolor"};
            }
        } else {
            String action = args[0];
            if (action.equalsIgnoreCase("select") && args.length >= 2) {
                return new String[]{"selecttag", args[1]};
            } else if (action.equalsIgnoreCase("buy") && args.length >= 2) {
                return new String[]{"buytag", args[1]};
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
                return new String[]{"deldesign", "tag"};
            } else {
                return new String[]{"tags"};
            }
        }
    }

    /**
     * Преобразует аргументы команды цвета ника.
     *
     * @param args аргументы
     * @return массив действий
     */
    private static String[] mapNameColorArgs(String[] args) {
        if (args.length == 0) {
            return new String[]
                    {
                            "namecolor"
                    };
        }

        String action = args[0];
        if (action.equalsIgnoreCase("select") && args.length >= 2) {
            return new String[]{"select", args[1]};
        } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("remove") || action.equalsIgnoreCase("reset")) {
            return new String[]{"deldesign", "namecolor"};
        } else {
            return new String[]{"namecolor"};
        }
    }
}

