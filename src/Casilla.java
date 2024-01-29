import org.jetbrains.annotations.NotNull;

public class Casilla {

    private boolean agua;
    private Trozo trozo;                      //<<R>>

    public Casilla(boolean agua) {

    }

    public Trozo getTrozo() {
        return trozo;
    }

    public void colocarAgua() {
        agua=true;
    }

    public void colocarTrozo(@NotNull Trozo trozo) {
        this.trozo=trozo;
    }
    public boolean esAgua() {
        return agua;
    }
    public boolean estaVacia() {
        return !agua && trozo==null;
    }

    @Override
    public String toString() {
        return "|" + (agua ? "A" : trozo) + "|";
    }
}
