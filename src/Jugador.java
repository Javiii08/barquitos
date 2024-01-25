import org.jetbrains.annotations.NotNull;

public class Jugador {
    private String apodo;                        //NN, NB, NV
    private Flota flota;                         //NN  <<R>>
    private TableroPropio tableroPropio;         //NN  <<R>>
    private TableroEnemigo tableroEnemigo;       //NN  <<R>>


    public Jugador(String a, Flota f, TableroPropio p, TableroEnemigo e) {
        setApodo(apodo);
        setFlota(flota);
        setTableroPropio(tableroPropio);
        setTableroEnemigo(tableroEnemigo);
    }

    public void setFlota(@NotNull Flota flota) {
        this.flota = flota;
    }

    public void setTableroPropio(@NotNull TableroPropio tableroPropio) {
        this.tableroPropio = tableroPropio;
    }

    public void setTableroEnemigo(@NotNull TableroEnemigo tableroEnemigo) {
        this.tableroEnemigo = tableroEnemigo;
    }

    public void setApodo(@NotNull String apodo) {
        //TODO: VALIDACIÓN
        this.apodo=apodo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "apodo='" + apodo + '\'' +
                ", flota=" + flota +
                ", tableroPropio=" + tableroPropio +
                ", tableroEnemigo=" + tableroEnemigo +
                '}';
    }
}
