public enum TipoOrientacion {
    HORIZONTAL, VERTICAL;

    public static TipoOrientacion generar() {
        return values()[new java.util.Random().nextInt(values().length)];
    }
}