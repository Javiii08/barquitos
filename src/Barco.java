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
    public int longitud() {
        return trozos.length;
    }

    public Trozo getTrozo(int i) {
        assert i>=0 && i<trozos.length:
                String.format("El trozo %d no existe (longitud=%d)", i, trozos.length);
        return trozos[i];
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
