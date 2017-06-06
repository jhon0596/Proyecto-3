package Algoritmos;
import EstructurasDeDatosDash.*;
import org.junit.Test;


/**
 * Created by Gabriel on 5/20/2017.
 */
public class SelectionSort {


    public static LinkList selectionSort(LinkList lista){
        for (int contador =0; contador<lista.getTamaño()-1;contador++){
            int puntero = contador;
            for(int pos1 = contador+1;pos1<lista.getTamaño();pos1++){//comparacion de pos1 con la lista
                if(lista.getNodoEspecifico(pos1).getT().compareTo(lista.getNodoEspecifico(puntero).getT())<0){//si es menor
                    puntero = pos1;
                }
            }
            Comparable numeroMenor = lista.getNodoEspecifico(puntero).getT();// se consigue el numero menor y se sustituye
            lista.getNodoEspecifico(puntero).setT(lista.getNodoEspecifico(contador).getT());
            lista.getNodoEspecifico(contador).setT(numeroMenor);
        }
        return lista;

    }

    public static void main(String[] args) {
        LinkList lista = new LinkList();
        lista.insertFirstLink(10);
        lista.insertFirstLink(5);
        lista.insertFirstLink(7);
        lista.insertFirstLink(2);
        lista.insertFirstLink(15);
        lista = selectionSort(lista);
        lista.display();

    }

}

