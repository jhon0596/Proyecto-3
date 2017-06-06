package Algoritmos;

import EstructurasDeDatosDash.Link;
import EstructurasDeDatosDash.LinkList;
import org.junit.Test;

public class insertionsort {

	public static void swap(int posicion1, int posicion2, LinkList lista) {
		Link link1 = lista.getNodoEspecifico(posicion1);
		Link link2 = lista.getNodoEspecifico(posicion2);
		Link temp = new Link(link1.getT());
		link1.setT(link2.getT());
		link2.setT(temp.getT());
	}

	public static LinkList insertionSort(LinkList lista){
		int i,j;//punteros de comparacion
		Comparable key;
		for (j = 1; j < lista.getTamaño(); j++) {//se posicion 1 con todo y se va avanzando
			key = lista.getNodoEspecifico(j).getT();
		    i = j - 1;
		    while (i >= 0) {//si es mayor se intercambia
		      //if (key.compareTo( ((Ingrediente) lista.obtenerPorPosicion(i).getDataT()).getNombre()) > 0) {
				if(key.compareTo(lista.getNodoEspecifico(i).getT())>0){
		        break;
		      }
		      swap(i+1,i,lista);//intercambio
		      i--;
		    }
		    lista.getNodoEspecifico(i+1).setT(key);
		    i--;
		  }
		  return lista;
		  
		}

	public static void main(String[] args) {
		LinkList lista = new LinkList();
		lista.insertFirstLink("Leo");
		lista.insertFirstLink("Mario");
		lista.insertFirstLink("Raul");
		lista.insertFirstLink("Sebastian");
		lista.insertFirstLink("Gabriel");
		lista = insertionSort(lista);
		lista.display();
	}
}


