package Algoritmos;

import EstructurasDeDatosDash.Link;
import EstructurasDeDatosDash.LinkList;
import org.junit.Test;

public class shellsort {
	public static LinkList shellSort(LinkList lista){
		int x = lista.getTamaño();
		return shellsort2(lista,x);
	}
	public static LinkList shellsort2(LinkList lista,int nElements){
    	int j;
    	for (int gap = nElements/2;gap>0;gap/=2){//calculo de la distancia de comparacion
    		for (int i = gap;i<nElements;i++){//se compara la posicion i con la distancia del gap
    			Comparable temp = lista.getNodoEspecifico(i).getT();
    			//for(j=i;j>=gap && ((String) ((Ingrediente) lista.obtenerPorPosicion(j-gap).getDataT()).getNombre()).compareToIgnoreCase(temp)>0;j-=gap){
                for(j=i;j>=gap && lista.getNodoEspecifico(j-gap).getT().compareTo(temp)>0;j-=gap){//se realiza la comparacion
    				swap(j,j-gap,lista);
    			}
    			lista.getNodoEspecifico(j).setT(temp);
    		}

    	}
        return lista;
    }
	public static void swap(int posicion1, int posicion2, LinkList lista) {
		Link link1 = lista.getNodoEspecifico(posicion1);
		Link link2 = lista.getNodoEspecifico(posicion2);
		Link temp = new Link(link1.getT());
		link1.setT(link2.getT());
		link2.setT(temp.getT());
	}

    public static void main(String[] args) {
        LinkList lista = new LinkList();
        lista.insertFirstLink(10);
        lista.insertFirstLink(5);
        lista.insertFirstLink(7);
        lista.insertFirstLink(2);
        lista.insertFirstLink(15);
        lista = shellSort(lista);
        lista.display();
    }
    
	
}
