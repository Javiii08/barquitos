import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TableroPropio {
    private Casilla[][] casillas;
    private boolean agua;

    public TableroPropio() {
        rellenarConAgua();
    }
    private void rellenarConAgua() {
        casillas = new Casilla[10][10];
        for (int i = 0; i < filas(); i++) {
            for (int j = 0; j < columnas(); j++) {
                casillas[i][j] = new Casilla(agua=true);
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
        Casilla[] casillas=new Casilla[barco.longitud()];
        Coordenada aux=new Coordenada(c.getFila(), c.getColumna());
        for (int i = 0; i < barco.longitud(); i++) {
            if (esCoordenada(aux))
                casillas[i]=getCasilla(aux);
            else
                return false;
            if (o.equals(TipoOrientacion.HORIZONTAL)) {
                aux.setFila(char)(aux.getFila()+1));
            }
            else if (o.equals(TipoOrientacion.VERTICAL)) {
                aux.setColumna(int)(aux.getColumna()+1));
            }
            else {            //Programación defensiva
                System.err.println("Tipo de orientación desconocida");
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
    private Casilla getCasilla(@NotNull Casilla[] casillas) {
        return casillas[c.getFila()-Coordenada.getMinFila()][c.getColumna()-Coordenada.getMinColumna()];
    }
}
