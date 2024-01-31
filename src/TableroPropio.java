import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TableroPropio {
    private Casilla[][] casillas;

    public TableroPropio() {
        rellenarConAgua();
    }

    private void rellenarConAgua() {
        casillas = new Casilla[10][10];
        for (int i = 0; i < filas(); i++) {
            for (int j = 0; j < columnas(); j++) {
                casillas[i][j] = new Casilla(true);
            }
        }

    }

    private int filas() {
        return Coordenada.getMaxFila() - Coordenada.getMinFila() + 1;
    }

    private int columnas() {
        return Coordenada.getMaxColumna() - Coordenada.getMinColumna() + 1;
    }

    public boolean colocar(@NotNull Barco barco, @NotNull Coordenada c, @NotNull TipoOrientacion o) {
        if (!esCoordenada(c)) return false;
        //Comprobar si todas las casillas que va a ocupar el barco son agua
        Casilla[] casillas = new Casilla[barco.longitud()];
        Coordenada aux = new Coordenada(c.getFila(), c.getColumna());
        for (int i = 0; i < barco.longitud(); i++) {
            if (esCoordenada(aux))
                casillas[i] = getCasilla(aux);
            else
                return false;
            if (o.equals(TipoOrientacion.HORIZONTAL)) {
                aux.setFila((char) (aux.getFila() + 1));
            } else if (o.equals(TipoOrientacion.VERTICAL)) {
                aux.setColumna(aux.getColumna() + 1);
            } else {                                                         //Programación defensiva
                System.err.println("Tipo de orientación desconocida");
                System.exit(1);
            }
        }
        if (!esAgua(casillas)) {
            return false;
        }
        Casilla casilla;
        // Coordenada donde hay que colocar el barco
        Coordenada posicion = new Coordenada(c.getFila(), c.getColumna());
        for (int i = 0; i < barco.longitud(); i++) {
            casilla = getCasilla(posicion);
            casilla.colocarTrozo(barco.getTrozo(i));
            if (o.equals(TipoOrientacion.HORIZONTAL)) {
                posicion.setColumna(posicion.getColumna() + 1);
            } else if (o.equals(TipoOrientacion.VERTICAL)) {
                posicion.setFila((char) (posicion.getFila() + 1));
            } else {                                                         //Programación defensiva
                System.err.printf("Tipo de orientación desconocida (orientacion=%s)\n", o);
                System.exit(1);
            }
        }
        return true;
    }

    private boolean esAgua(@NotNull Casilla[] casillas) {
        for (Casilla casilla : casillas) {
            if (!casilla.esAgua()) return false;
        }
        return true;
    }

    private boolean esCoordenada(@NotNull Coordenada c) {
        return Coordenada.esFila(c.getFila()) && Coordenada.esColumna(c.getColumna());
    }

    private Casilla getCasilla(@NotNull Coordenada c) {
        return casillas[c.getFila() - Coordenada.getMinFila()][c.getColumna() - Coordenada.getMinColumna()];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //Encabezado con números [columnas]
        sb.append("  ");
        for (int i = Coordenada.getMinColumna(); i < Coordenada.getMaxColumna(); i++) {
            sb.append(String.format(" %d ", i));
        }
        sb.append(" \u2469 ");
        sb.append("\n");

        //filas
        for (char c = Coordenada.getMinFila(); c <= Coordenada.getMaxFila(); c++) {
            sb.append(String.format("%c ", c));
            for (int j = Coordenada.getMinColumna(); j <= Coordenada.getMaxColumna(); j++) {
                sb.append(casillas[c - Coordenada.getMinFila()][j - Coordenada.getMinColumna()]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}