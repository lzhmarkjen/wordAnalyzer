public class Char {
    public static boolean isSpace(char c) {
        return c == ' ';
    }

    public static boolean isNewline(char c) {
        return c == '\n';
    }

    public static boolean isTab(char c) {
        return c == '\t';
    }

    public static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isColon(char c) {
        return c == ':';
    }

    public static boolean isComma(char c) {
        return c == ',';
    }

    public static boolean isSemi(char c) {
        return c == ';';
    }

    public static boolean isEqu(char c) {
        return c == '=';
    }

    public static boolean isPlus(char c) {
        return c == '+';
    }

    public static boolean isMinus(char c) {
        return c == '-';
    }

    public static boolean isDivi(char c) {
        return c == '/';
    }

    public static boolean isStar(char c) {
        return c == '*';
    }

    public static boolean isLpar(char c) {
        return c == '(';
    }

    public static boolean isRpar(char c) {
        return c == ')';
    }

}
