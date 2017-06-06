package Algoritmos;


import EstructurasDeDatosDash.LinkList;

import java.util.Arrays;

/**
 * Created by Gabriel on 6/2/2017.
 */
public class Hash {
   private int[] arrayHash;
   private int tamañoArray;
    private int tamañoTotal;

    public Hash(int tamañoArray){
        this.tamañoArray = tamañoArray;
        this.arrayHash = new int[tamañoArray];
         Arrays.fill(arrayHash,-1);

    }
    public void funcionHash2(LinkList valoresDeArray, int[]arrayHash) {
        tamañoTotal = valoresDeArray.getTamaño();
        for(int contador = 0;contador<valoresDeArray.getTamaño();contador++){
            int nuevoElemento = (int) valoresDeArray.getNodoEspecifico(contador).getT();
            int nuevoElementoIndex = (nuevoElemento%valoresDeArray.getTamaño());
            while(arrayHash[nuevoElementoIndex]!=-1){
                ++nuevoElementoIndex;
                nuevoElementoIndex %= tamañoArray;

            }
            arrayHash[nuevoElementoIndex] = nuevoElemento;
        }
    }
    public  int findHash(int valor){
        int index = valor%tamañoTotal;
        while(arrayHash[index]!=-1){
            if(arrayHash[index]==valor){
                return arrayHash[index];
            }
            index++;
            index %= tamañoArray;
        }
        return Integer.parseInt(null);

    }

    public int getTamañoArray() {
        return tamañoArray;
    }

    public int[] getArrayHash() {
        return arrayHash;
    }

}
