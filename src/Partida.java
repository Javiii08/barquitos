import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

public class Partida {
    private Jugador[] jugadores;        // <<R>>
    private Jugador ganador;
    private int turno;
    private TableroPropio[] tablerosPropios;
    private TableroEnemigo[] tablerosEnemigos;
    private Flota[] flotas;


    public Partida(@NotNull String[] apodos) {
        assert apodos.length == 2;
        String.format("El juego debe tener 2 jugadores (nº jugadores=%d)", apodos.length);

        setTurno(0);

        crearTablerosPropios();

        //Crear tableros enemigos
        tablerosEnemigos = new TableroEnemigo[2];
        for (int i = 0; i < tablerosEnemigos.length; i++) {
            tablerosEnemigos[i] = new TableroEnemigo();
        }
        crearFlotas();


        //Crear jugadores
        jugadores = new Jugador[apodos.length];
        for (int i = 0; i < apodos.length; i++) {
            jugadores[i] = new Jugador(apodos[i], flotas[i], tablerosPropios[i], tablerosEnemigos[i]);
        }
    }


    private void setTurno(int turno) {
        assert turno == 0 || turno == 1;
        String.format("El turno debe ser 0 o 1 (turno=%d)", turno);
        this.turno = turno;
    }

    private void crearFlotas() {
        flotas = new Flota[2];
        for (int i = 0; i < flotas.length; i++) {
            flotas[i] = new Flota(new int[]{4, 3, 3, 2, 2, 2, 1, 1, 1, 1});
        }
    }

    private void crearTablerosPropios() {
        tablerosPropios = new TableroPropio[2];
        for (int i = 0; i < tablerosPropios.length; i++) {
            tablerosPropios[i] = new TableroPropio();
        }
    }

    private void colocarFlotas() {
        Barco[] barcos;
        for (int i = 0; i < flotas.length; i++) {
            barcos=flotas[i].getBarcos();
            while (!tablerosPropios[i].colocar(barcos[0], Coordenada.generar(), TipoOrientacion.generar()));
        }
        for (int i =0; i <=1; i++) {
            System.out.println(tablerosPropios[0]);
        }
    }
    public void jugar() {
        colocarFlotas();
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugadores=" + Arrays.toString(jugadores) +
                ", ganador=" + ganador +
                ", turno=" + turno +
                ", tablerosPropios=" + Arrays.toString(tablerosPropios) +
                ", tablerosEnemigos=" + Arrays.toString(tablerosEnemigos) +
                ", flotas=" + Arrays.toString(flotas) +
                '}';
    }
}