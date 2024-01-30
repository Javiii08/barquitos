public class Coordenada {
    private static char minFila = 'A';
    private static char maxFila = 'J';
    private static int minColumna = 1;
    private static int maxColumna = 10;
    private char fila;
    private int columna;

    public Coordenada(char fila, int columna) {
        setFila(fila);
        setColumna(columna);
    }

    public static char getMinFila() {
        return minFila;
    }

    public static char getMaxFila() {
        return maxFila;
    }

    public static int getMinColumna() {
        return minColumna;
    }

    public static int getMaxColumna() {
        return maxColumna;
    }

    public void setFila(char fila) {
        assert esFila(fila):
                String.format("La fila %c no es valida [%c, %c]", fila, minFila, maxFila);
        this.fila = fila;
    }

    public void setColumna(int columna) {
        assert esColumna(columna):
                String.format("La columnaa %d no es valida [%d, %d]", columna, minColumna, maxColumna);
        this.columna = columna;
    }

    public char getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public static boolean esFila(char fila) {
       return minFila <= fila && maxFila >= fila;
   }
   public static boolean esColumna(int columna) {
        return minColumna <= columna && maxColumna >= columna;
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Encabezado con números [columnas]
        sb.append(" ");
        for (int i = Coordenada.getMinColumna(); i <= Coordenada.getMaxColumna(); i++) {
            sb.append(String.format("%d", i));
        }
        sb.append("\n");
        //Filas
        for (int i = Coordenada.getMinFila(); i <= Coordenada.getMaxFila(); i++) {
            System.out.printf("\n%d", i);
            sb.append(String.format("%c", Coordenada.getMinFila()));
            for (char c = (char) Coordenada.getMinColumna(); c <= Coordenada.getMaxColumna(); c++) {
                sb.append(String.format("%c", c));

            }
        }
        return String.format("(%c, %d)", fila, columna);
    }
}
