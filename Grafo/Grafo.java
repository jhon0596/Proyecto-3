package EstructurasDeDatosDash;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Gabriel on 5/27/2017.
 */
public class Grafo {
    private int cantFilas;
    private int cantColumnas;
    private int cantInsertados;
    private int INF = 99999999;
    private int[][] matriz;
    private NodoGrafo[] arrayReferencia;
    public Grafo(int cantNodos){
        matriz = new int[cantNodos][cantNodos];//matriz que representa al grafo

        arrayReferencia = new NodoGrafo[cantNodos];
        this.cantColumnas = cantNodos;
        this.cantFilas = cantNodos;
        this.cantInsertados = 0;
    }

    public void adherirNodo(Comparable valorNodo){
        NodoGrafo nodoInsertar = new NodoGrafo(valorNodo);
        if(cantInsertados == cantFilas){
            System.out.println("La cantidad maxima de nodos para este grafo a sido alcanzada");
        }
        else{
            arrayReferencia[cantInsertados] = nodoInsertar;
            matriz[cantInsertados][cantInsertados] = 0;
            cantInsertados+=1;
        }
    }
    public void adherirConexionDirigda(Comparable valor1,Comparable valor2,int pesoConeccion){//establece un eje con direccion va del nodoConectar1 al nodoConectar2
        int x = 0;
        while(arrayReferencia[x].getValor().compareTo(valor1)!=0){
            x+=1;
        }
        int posicionNodo1 = x;
        int y = 0;
        while(arrayReferencia[y].getValor().compareTo(valor2)!=0){
            y+=1;
        }
        int posicionNodo2 = y;
        matriz[posicionNodo1][posicionNodo2] = pesoConeccion;
    }

    public void adherirConexionNoDirigida(Comparable valor1,Comparable valor2,int pesoConeccion){
        int x = 0;
        while(arrayReferencia[x].getValor().compareTo(valor1)!=0){
            x+=1;
        }
        int posicionNodo1 = x;
        int y = 0;
        while(arrayReferencia[y].getValor().compareTo(valor2)!=0){
            y+=1;
        }
        int posicionNodo2 = y;
        matriz[posicionNodo1][posicionNodo2] = pesoConeccion;
        matriz[posicionNodo2][posicionNodo1] = pesoConeccion;
    }
    public Comparable[] recorrerAnchura(Comparable ValorNodoInicial){
        int posicionArray = 0;
        Comparable[] resultado = new Comparable[cantFilas];
        boolean[] revisado = new boolean[cantFilas];
        Cola colaAnchura = new Cola();
        int x = 0;
        while(arrayReferencia[x].getValor().compareTo(ValorNodoInicial)!=0){
            x+=1;
        }
        revisado[x] =true;
        colaAnchura.encolar(arrayReferencia[x].getValor());
        while(colaAnchura.getTope()!=null){
            ValorNodoInicial = colaAnchura.pop().getT();
            x = 0;
            while(arrayReferencia[x].getValor().compareTo(ValorNodoInicial)!=0){
                x+=1;
            }
            System.out.println(ValorNodoInicial + " ");
            int y = 0;
            resultado[posicionArray] = ValorNodoInicial;
            posicionArray++;
            while(y<=cantColumnas-1){
                if(matriz[x][y]!=0){
                    if(revisado[y] == false){
                        colaAnchura.encolar(arrayReferencia[y].getValor());
                        revisado[y]=true;
                        y++;
                    }
                    else{
                        y++;
                    }
                }
                else{
                    y++;
                }
            }
        }
        return resultado;

    }
    public Comparable[] recorrerProfundidad(Comparable ValorNodoInicial){
        int posicionArray = 0;
        Comparable[] resultado = new Comparable[cantFilas];
        boolean[] revisado = new boolean[cantFilas];
        Pila pilaProfundidad = new Pila();
        int x = 0;
        while(arrayReferencia[x].getValor().compareTo(ValorNodoInicial)!=0){
            x+=1;
        }
        revisado[x] =true;
        pilaProfundidad.push(arrayReferencia[x].getValor());
        while(pilaProfundidad.getTope()!=null){
            ValorNodoInicial = pilaProfundidad.pop().getT();
            x = 0;
            while(arrayReferencia[x].getValor().compareTo(ValorNodoInicial)!=0){
                x+=1;
            }
            System.out.println(ValorNodoInicial + " ");
            int y = 0;
            resultado[posicionArray] = ValorNodoInicial;
            posicionArray++;
            while(y<=cantColumnas-1){
                if(matriz[x][y]!=0){
                    if(revisado[y] == false){
                        pilaProfundidad.push(arrayReferencia[y].getValor());
                        revisado[y]=true;
                        y++;
                    }
                    else{
                        y++;
                    }
                }
                else{
                    y++;
                }
            }
        }
        return resultado;

    }
    public int[] Djikstra(Comparable ValorNodoInicial){
        int caminosCortos[] = new int[cantFilas];
        Boolean[] revisado = new Boolean[cantFilas];
        for(int x = 0;x<cantFilas;x++){
            caminosCortos[x] = Integer.MAX_VALUE;//infinito
            revisado[x] = false;
        }
        int x2=0;
        while(arrayReferencia[x2].getValor().compareTo(ValorNodoInicial)!=0){
            x2+=1;
        }
        caminosCortos[x2] = 0;//o ya que es la posicion al nodo en el que ya estoy
        for(int contador = 0;contador<cantFilas-1;contador++){
            int u = esDistanciaMinima(caminosCortos,revisado);//revisa si el nuevo valor es minimo o no si lo es lo retorna
            revisado[u] = true;//lo pone como true ya que ya fue revisado
            for(int contador2 =0;contador2<cantFilas;contador2++){//recorre el array
                if (!revisado[contador2] && matriz[u][contador2]!=0 && caminosCortos[u] != Integer.MAX_VALUE && caminosCortos[u]+matriz[u][contador2] <caminosCortos[contador2]){//revisa si tiene una coneccion en la matriz y si el nuevo camino si es menor
                    caminosCortos[contador2] = caminosCortos[u] + matriz[u][contador2];

                }
            }
        }
        return caminosCortos;
    }
    public int[][] Floyd(int[][] matrizDeConecciones){
        for(int contador = 0;contador<cantFilas;contador++){
            for(int contador2=0;contador2<cantFilas;contador2++){
                if(matrizDeConecciones[contador][contador2]==0){
                    matrizDeConecciones[contador][contador2] = INF;
                }
            }
        }
        int caminosCortos[][] = new int[cantFilas][cantFilas];
        int x;//contador
        int y;//contador
        int z;//contador
        for(x=0;x<cantFilas;x++){
            for(y=0;y<cantFilas;y++){
                caminosCortos[x][y] = matrizDeConecciones[x][y];
            }
        }
        for(z=0;z<cantFilas;z++){//recorrer
            for(x=0;x<cantFilas;x++){//recorrer filas
                for(y=0;y<cantFilas;y++){//recorrer columnas
                    if(caminosCortos[x][z]+caminosCortos[z][y]<caminosCortos[x][y]){//comparacion del camino que se tiene actual
                        if(caminosCortos[x][z]+caminosCortos[z][y]!=0){
                            caminosCortos[x][y] = caminosCortos[x][z] + caminosCortos[z][y];
                        }
                    }
                }
            }
        }
        return caminosCortos;
    }
    public int[][] Warshall(int[][]matrizDeConecciones){
        for(int contador = 0;contador<cantFilas;contador++){
            for(int contador2=0;contador2<cantFilas;contador2++){
                if(matrizDeConecciones[contador][contador2]==0){
                    if(contador == contador2){

                    }
                    else{
                        matrizDeConecciones[contador][contador2] = INF;
                    }
                }
            }
        }
        int caminosCortos[][] = new int[cantFilas][cantFilas];
        int x;//contador
        int y;//contador
        int z;//contador
        for(x=0;x<cantFilas;x++){
            for(y=0;y<cantFilas;y++){
                caminosCortos[x][y] = matrizDeConecciones[x][y];
            }
        }
        for(z=0;z<cantFilas;z++){//recorrer
            for(x=0;x<cantFilas;x++){//recorrer filas
                for(y=0;y<cantFilas;y++){//recorrer columnas
                    if(caminosCortos[x][z]+caminosCortos[z][y]<=caminosCortos[x][y]&&caminosCortos[x][z]!=INF&&caminosCortos[z][y]!=INF){//comparacion del camino que se tiene actual
                        if(caminosCortos[x][z]+caminosCortos[z][y]!=0){
                            caminosCortos[x][y] = 1;
                        }
                    }
                }
            }
        }
        return caminosCortos;
    }
    public int[][] Prim(int[][]matrizDeConecciones){
        int[][] matrizMST = new int[cantFilas][cantFilas];
        int[] MST = new int[cantFilas];//lista que representara el minimal spanning tree
        int[] minimosValores = new int[cantFilas];
        Boolean[] revisado = new Boolean[cantFilas];
        for(int contador =0;contador<cantFilas;contador++){
            minimosValores[contador] = INF;
            revisado[contador] = false;
        }
        minimosValores[0]=0;//inicial ruta a el mismo es 0
        MST[0] = -1;
        for(int contador2=0;contador2<cantFilas-1;contador2++){//cantidad de vertices sera cantidad de nodos -1
            int minimo = esDistanciaMinima(minimosValores,revisado);
            revisado[minimo] = true;//ya se visito este nodo
            for(int contador3=0; contador3<cantFilas;contador3++){
                if(matrizDeConecciones[minimo][contador3]!=0&&revisado[contador3]==false&&matrizDeConecciones[minimo][contador3]< minimosValores[contador3]){
                    matrizMST[minimo][contador3] = matrizDeConecciones[minimo][contador3];
                    MST[contador3] = minimo;
                    minimosValores[contador3] = matrizDeConecciones[minimo][contador3];
                }
            }
        }
        return generarMST(MST,cantFilas,matrizDeConecciones);


    }
    public int esDistanciaMinima(int caminosCortos[], Boolean revisado[]) {
        int mininmo = Integer.MAX_VALUE;
        int min_index=-1;
        for (int contador = 0; contador < cantFilas; contador++){
            if (revisado[contador] == false && caminosCortos[contador] < mininmo) {//revisa si el nodo ya se uso y si no es igual a infinito en la primera revision luego lo compara con los valores del arreglo
                mininmo = caminosCortos[contador];
                min_index = contador;
            }
        }
        return min_index;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public NodoGrafo[] getArrayReferencia() {
        return arrayReferencia;
    }
    public int[][] generarMST(int MST[], int n, int matrizDeConecciones[][]) {
        int[][] matrizFinal = new int[cantFilas][cantFilas];
        for (int i = 1; i < cantFilas; i++){
            matrizFinal[i][MST[i]] = matrizDeConecciones[i][MST[i]];
            matrizFinal[MST[i]][i] = matrizDeConecciones[i][MST[i]];
        }
        return matrizFinal;
    }


    public static void main(String[] args) {
        Grafo prueba  = new Grafo(6);

        prueba.adherirNodo(1);
        prueba.adherirNodo(2);
        prueba.adherirNodo(3);
        prueba.adherirNodo(4);
        prueba.adherirNodo(5);
        prueba.adherirNodo(6);
        /*
        prueba.adherirConexionDirigda(1,2,2);
        prueba.adherirConexionDirigda(1,6,4);
        prueba.adherirConexionDirigda(4,1,6);
        prueba.adherirConexionDirigda(4,3,9);
        prueba.adherirConexionDirigda(3,1,12);
        prueba.adherirConexionDirigda(3,6,14);
        prueba.adherirConexionDirigda(6,2,10);
        prueba.adherirConexionDirigda(6,5,19);
        prueba.adherirConexionDirigda(5,4,22);
        System.out.println(prueba.Warshall(prueba.matriz)[0][0]);
        System.out.println(prueba.Warshall(prueba.matriz)[0][1]);
        System.out.println(prueba.Warshall(prueba.matriz)[0][2]);
        System.out.println(prueba.Warshall(prueba.matriz)[0][3]);
        System.out.println(prueba.Warshall(prueba.matriz)[0][4]);
        System.out.println(prueba.Warshall(prueba.matriz)[0][5]);
        */
        prueba.adherirConexionNoDirigida(1,2,2);
        prueba.adherirConexionNoDirigida(1,3,2);
        prueba.adherirConexionNoDirigida(1,4,3);
        prueba.adherirConexionNoDirigida(1,5,1);
        prueba.adherirConexionNoDirigida(2,3,2);
        prueba.adherirConexionNoDirigida(2,4,2);
        prueba.adherirConexionNoDirigida(2,6,1);
        prueba.adherirConexionNoDirigida(3,5,3);
        prueba.adherirConexionNoDirigida(4,6,1);
        prueba.adherirConexionNoDirigida(5,6,1);
        System.out.println(prueba.Prim(prueba.getMatriz())[0][2]);
        System.out.println(prueba.Prim(prueba.getMatriz())[0][4]);
        System.out.println(prueba.Prim(prueba.getMatriz())[1][5]);
        System.out.println(prueba.Prim(prueba.getMatriz())[3][5]);
        System.out.println(prueba.Prim(prueba.getMatriz())[4][5]);
        System.out.println(prueba.Prim(prueba.getMatriz())[0][0]);

    }
}
