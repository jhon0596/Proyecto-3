package EstructurasDeDatosDash;

/**
 * Created by Gabriel on 5/27/2017.
 */
public class NodoGrafo<T extends Comparable<T>> {
    private Comparable valor;

    public NodoGrafo(Comparable valor){
        this.valor = valor;
    }

    public Comparable<T> getValor() {
        return valor;
    }

    public void setValor(Comparable valor) {
        this.valor = valor;
    }
}
