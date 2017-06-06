package Algoritmos;


import EstructurasDeDatosDash.LinkList;

public class RadixSort {
    public static void sort( LinkList lista)
    {
        int valor1, valor2 = (int)lista.getNodoEspecifico(0).getT();//valores usados para recorrer la lista y conseguir digitos
        int exp = 1;
        int tamañoLista = lista.getTamaño();
        int contador = 0;
        LinkList lista2 = new LinkList();
        while(contador!=10){
            lista2.insertFirstLink(0);
            contador++;
        }
        for (valor1 = 1; valor1 < tamañoLista; valor1++)
            if ((int)lista.getNodoEspecifico(valor1).getT() > valor2)
                valor2 = (int)lista.getNodoEspecifico(valor1).getT();
        while (valor2 / exp > 0)
        {

            int[] arrayDigitos = new int[10];

            for (valor1 = 0; valor1 < tamañoLista; valor1++)
                arrayDigitos[((int)lista.getNodoEspecifico(valor1).getT() / exp) % 10]++;
            for (valor1 = 1; valor1 < 10; valor1++)
                arrayDigitos[valor1] += arrayDigitos[valor1 - 1];
            for (valor1 = tamañoLista - 1; valor1 >= 0; valor1--)
                lista2.getNodoEspecifico(--arrayDigitos[((int)lista.getNodoEspecifico(valor1).getT() / exp) % 10]).setT(lista.getNodoEspecifico(valor1).getT());
            for (valor1 = 0; valor1 < tamañoLista; valor1++)
                lista.getNodoEspecifico(valor1).setT(lista2.getNodoEspecifico(valor1).getT());

            exp *= 10;
        }
    }
    public static LinkList sortStrings(LinkList lista){
        LinkList listaASCII = new LinkList();
        int contador = 0;
        while(contador!=lista.getTamaño()){
            String y = (String) lista.getNodoEspecifico(contador).getT();
            char y2 = y.charAt(0);
            int ascii = (int) y2;
            listaASCII.insertFirstLink(ascii);
            contador++;
        }
        sort(listaASCII);
        LinkList listaOrdenada = new LinkList();
        int contador2 = 0;
        while (contador2!=listaASCII.getTamaño()){
            int contador3=0;
            while(contador3!=listaASCII.getTamaño()){
                String y = (String) lista.getNodoEspecifico(contador3).getT();
                char y2 = y.charAt(0);
                int ascii2 = y2;
                int ascii = (int)listaASCII.getNodoEspecifico(contador2).getT();
                if(ascii==ascii2){
                    listaOrdenada.insertLink(lista.getNodoEspecifico(contador3).getT(),contador2);
                    break;
                }
                else{
                    contador3++;
                }
            }
            contador2++;
        }
        return listaOrdenada;
    }
    public static void main(String[] args)
    {
        LinkList lista = new LinkList();
        lista.insertFirstLink("Pedro");
        lista.insertFirstLink("Ana");
        lista.insertFirstLink("Zane");
        LinkList lista2 = sortStrings(lista);
        lista2.display();
    }
}
