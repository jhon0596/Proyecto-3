package Algoritmos;

import EstructurasDeDatosDash.Link;
import EstructurasDeDatosDash.LinkList;
import org.junit.Test;

public class quicksort {
    public static void swap(int posicion1, int posicion2, LinkList lista) {
        Link link1 = lista.getNodoEspecifico(posicion1);
        Link link2 = lista.getNodoEspecifico(posicion2);
        Link temp = new Link(link1.getT());
        link1.setT(link2.getT());
        link2.setT(temp.getT());
    }
	public static LinkList quickSort(LinkList lista) {
		int x = lista.getTamaño();
		return quicksort2(lista,0,x-1);
	}
	private static LinkList quicksort2(LinkList lista,int low, int high) {
        int i = low, j = high;
        int pivote = low + (high-low)/2;
        Link pivoteFinal = lista.getNodoEspecifico(pivote);
        while (i <= j) {

                //while (((String) ((Ingrediente) lista.obtenerPorPosicion(i).getDataT()).getNombre()).compareToIgnoreCase((String) ((Ingrediente) pivoteFinal.getDataT()).getNombre())<0) {
                  while(lista.getNodoEspecifico(i).getT().compareTo(pivoteFinal.getT())<0){//comparacion si es menor se aumenta limite derecho
                        i++;
                }
                
                //while (((String) ((Ingrediente) lista.obtenerPorPosicion(j).getDataT()).getNombre()).compareToIgnoreCase((String) ((Ingrediente) pivoteFinal.getDataT()).getNombre())>0) {
                  while(lista.getNodoEspecifico(j).getT().compareTo(pivoteFinal.getT())>0){//se reduce limite derecho
                        j--;
                }

               
                if (i <= j) {//se comparan si es menor
                        swap(i,j,lista);
                        i++;
                        j--;
                }
        }
        
        if (low < j)
                quicksort2(lista,low, j);//se realiza el quicksort al resto de la lista por la parte izquierda
        if (i < high)
                quicksort2(lista,i, high);//se realiza quicksort a la parte derecha de la lista
        return lista;
    }

    public static void main(String[] args) {
        LinkList lista = new LinkList();
        lista.insertFirstLink(10);
        lista.insertFirstLink(5);
        lista.insertFirstLink(7);
        lista.insertFirstLink(2);
        lista.insertFirstLink(15);
        lista = quickSort(lista);
        lista.display();
    }

}
