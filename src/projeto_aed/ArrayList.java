
package projeto_aed;

import java.util.Arrays;

class ArrayList {
    int tamanho = 0;
    Object[] array;
    int tamanhoInicial = 10;
    public ArrayList(){
        array = new Object[10];
    }
}
class ArrayListFunctions {
    static void aumentaArray(ArrayList lista) {
        int novoTamanho;
        novoTamanho = (int)(lista.array.length * (5.0 / 3.0));
        lista.array = Arrays.copyOf(lista.array, novoTamanho);
    }
    static void add(ArrayList lista, Object objeto) {
        if(lista.tamanho == lista.array.length) {
            aumentaArray(lista);
        }
        lista.array[lista.tamanho] = objeto;
        lista.tamanho++;
    }
    static Object get(ArrayList lista, int indice) {
       return lista.array[indice];
    }
    
}

