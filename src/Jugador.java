import org.jetbrains.annotations.NotNull;



public class Jugador {
    private String apodo;       // NN, NV, NB
    private Flota flota;
    private TableroPropio tableroPropio;
    private TableroEnemigo tableroEnemigo;
    public Jugador(String a, Flota f, TableroPropio p,TableroEnemigo e){
        setApodo(a);
        setFlota(f);
        setTableroPropio(p);
        setTableroEnemigo(e);
    }

    private void setApodo(@NotNull String a){
        //TODO: 25/01/2024
        this.apodo = a;
    }

    private void setFlota(@NotNull Flota f){
        //TODO: 25/01/2024
    }

    private void setTableroPropio(@NotNull TableroPropio p){
        //TODO: 25/01/2024
    }

    private void setTableroEnemigo(@NotNull TableroEnemigo e){
        //TODO: 25/01/2024
    }

}