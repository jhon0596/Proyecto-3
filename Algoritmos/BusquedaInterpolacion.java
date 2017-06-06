package Algoritmos;

import EstructurasDeDatosDash.LinkList;

/**
 * Created by Gabriel on 5/22/2017.
 */
public class BusquedaInterpolacion {
    public static int interPolationSearch(LinkList lista, int input){
        int minIndex =0;
        int maxIndex = lista.getTamaño()-1;
        int medio;
        while(lista.getNodoEspecifico(minIndex).getT().compareTo(input)<=0&&lista.getNodoEspecifico(maxIndex).getT().compareTo(input)>=0){
            if(lista.getNodoEspecifico(maxIndex).getT().compareTo(lista.getNodoEspecifico(minIndex).getT())==0){
                return (minIndex + maxIndex)/2;
            }
            medio = minIndex+((input-(int)lista.getNodoEspecifico(minIndex).getT())*(maxIndex-minIndex)) / ((int)lista.getNodoEspecifico(maxIndex).getT()-(int)lista.getNodoEspecifico(minIndex).getT());
            if(lista.getNodoEspecifico(medio).getT().compareTo(input)<0){
                minIndex = medio+1;
            }
            else if(lista.getNodoEspecifico(medio).getT().compareTo(input)>0){
                maxIndex = medio+1;
            }
            else{
                return medio;
            }
        }
        if(lista.getNodoEspecifico(minIndex).getT().compareTo(input)==0){
            return minIndex;
        }
        else{
            return -1;
        }

    }

    public static void main(String[] args) {
        LinkList lista = new LinkList();
        lista.insertFirstLink(15);
        lista.insertFirstLink(14);
        lista.insertFirstLink(13);
        lista.insertFirstLink(12);
        lista.insertFirstLink(11);
        System.out.println(interPolationSearch(lista,14));
    }
}
