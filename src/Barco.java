import java.util.Arrays;

public class Barco {

    private Trozo[] trozos;           //<<R>>


    public Barco(int longitud) {
        assert longitud>=1:
                String.format("La longitud debe ser >=1 (longitud=%d)", longitud);
        trozos=new Trozo[longitud];
        for (int i=0; i<longitud; i++) {
            trozos[i]=new Trozo();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trozos.length; i++) {
            sb.append(trozos[i].toString());
        }
        return sb.toString();
    }
}
