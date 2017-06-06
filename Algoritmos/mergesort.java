package Algoritmos;

import EstructurasDeDatosDash.LinkList;
import org.junit.Test;

/**
 * Created by Gabriel on 5/21/2017.
 */
public class mergesort {

    public static LinkList mergeSort(LinkList lista){
        LinkList temp = new LinkList();
        while(temp.getTamaño()!=lista.getTamaño()){
            temp.insertFirstLink(0);
        }
        return mergeSort(lista,temp,0,lista.getTamaño()-1);
    }
    private static LinkList mergeSort(LinkList lista,LinkList temp,int izq,int der){
        if(izq<der){
            int centro = (izq+der)/2;
            mergeSort(lista,temp,izq,centro);//division de listas recursivamente
            mergeSort(lista,temp,centro+1,der);//division de listas recursivamente
            mergeListas(lista,temp,izq,centro+1,der);//se vuelven a unir las listas
            return lista;
        }
        return null;

    }
    private static LinkList mergeListas(LinkList lista,LinkList temp, int izq,int der,int finder){
        int finizq= der-1;
        int izqTemp = izq;
        int num = finder-izq+1;
        while(izq<=finizq&&der<=finder){//comparacion de las listas
            if(lista.getNodoEspecifico(izq).getT().compareTo(lista.getNodoEspecifico(der).getT())<=0){//si es menor se mete en una lista temporal que luego se le metera a la lista que dio el usuario
                temp.getNodoEspecifico(izqTemp++).setT(lista.getNodoEspecifico(izq++).getT());
            }
            else{
                temp.getNodoEspecifico(izqTemp++).setT(lista.getNodoEspecifico(der++).getT());
            }
        }
        while(izq<=finizq){// se inserta lo que resto de la lista
            temp.getNodoEspecifico(izqTemp++).setT(lista.getNodoEspecifico(izq++).getT());
        }
        while(der<=finder){//se inserta lo que resto de la lista
            temp.getNodoEspecifico(izqTemp++).setT(lista.getNodoEspecifico(der++).getT());
        }
        for(int contador = 0; contador<num;contador++, finder--){//se vuevle a insertar a la lista del usuario
            lista.getNodoEspecifico(finder).setT(temp.getNodoEspecifico(finder).getT());
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
        lista = mergeSort(lista);
        lista.display();
    }
}
