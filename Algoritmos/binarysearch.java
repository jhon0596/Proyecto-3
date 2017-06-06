package Algoritmos;

import EstructurasDeDatosDash.Link;
import EstructurasDeDatosDash.LinkList;
import org.junit.Test;

/**
 * Created by Gabriel on 5/21/2017.
 */
public class binarysearch {
    public static Link binarySearch(LinkList lista,Comparable input){//input es el valor que se desea buscar
        return binarySearch(lista,input,0,lista.getTamaño()-1);
    }
    public static Link binarySearch(LinkList lista, Comparable input, int minindex, int maxindex){
        Comparable comparar1 = input;
        while(maxindex>=minindex){//mientras aun se tiene una lista
            int middle = (maxindex + minindex)/2;//la mitad de la lista
            Comparable comparar2= lista.getNodoEspecifico(middle).getT();
            if(comparar2.compareTo(comparar1)<0){//se compara si es mayor menor o igual
                minindex = middle+1;
            }else if(comparar2.compareTo(comparar1)>0){
                maxindex = middle-1;
            }else{
                return lista.getNodoEspecifico(middle);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkList lista = new LinkList();
        lista.insertFirstLink(15);
        lista.insertFirstLink(14);
        lista.insertFirstLink(13);
        lista.insertFirstLink(12);
        lista.insertFirstLink(11);
        System.out.println(binarySearch(lista,14));
    }
}
