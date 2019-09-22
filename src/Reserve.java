public enum Reserve {
    STATIC("static"),
    MAIN("main"),
    INT("int"),
    CHAR("char"),
    FLOAT("float"),
    LONG("long"),
    CONST("const");
    //and more

    private String name;

    Reserve(String s) {
        this.name = s;
    }

    public static boolean isReserve(String s) {
        for (Reserve r : Reserve.values()) {
            if (r.name.equals(s)) {
                return true;
            }
        }
        return false;
    }
}

