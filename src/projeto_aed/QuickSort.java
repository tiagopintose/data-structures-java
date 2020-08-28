

package projeto_aed;


class QuickSortFunctions {
    static ArrayList ordenarMusicasPorPosicao(ArrayList musicas) {
        return ordenarMusicasPos(musicas, 0, musicas.tamanho);
    }
    
    static ArrayList ordenarMusicasPos(ArrayList musicas, int left, int right) {
        if(left < right) {
            int posicaoPivot = partitionMusicas(musicas, left, right - 1);
            
            musicas = ordenarMusicasPos(musicas, left, posicaoPivot);
            musicas = ordenarMusicasPos(musicas, posicaoPivot + 1, right);
        }        
        return musicas;
    }
    
    static int partitionMusicas(ArrayList musicas, int left, int right) {
        int pivot = ((Musica)ArrayListFunctions.get(musicas, right)).posicao;
        int startR = left - 1;
        
        for(int endR = left; endR < right; endR++) {
            if(((Musica)ArrayListFunctions.get(musicas, endR)).posicao <= pivot) {
                startR++;
                
                Musica temp = (Musica)ArrayListFunctions.get(musicas, endR);
                musicas.array[endR] = ArrayListFunctions.get(musicas, startR);
                musicas.array[startR] = temp;
            }
        }
        Musica temp = (Musica)ArrayListFunctions.get(musicas, right);
        musicas.array[right] = ArrayListFunctions.get(musicas, startR + 1);
        musicas.array[startR + 1] = temp;
        
        return startR + 1;        
    }
    
    static ArrayList ordenarNomesPorOrdemAlfabetica(ArrayList nomes) {
        return ordenarAlfabeto(nomes, 0, nomes.tamanho);
    }
    
    static ArrayList ordenarAlfabeto(ArrayList nomes, int left, int right) {
        if(left < right) {
            int posicaoPivot = partitionAlfabeto(nomes, left, right - 1);
            
            nomes = ordenarAlfabeto(nomes, left, posicaoPivot);
            nomes = ordenarAlfabeto(nomes, posicaoPivot + 1, right);
        }        
        return nomes;
    }
    
    static int partitionAlfabeto(ArrayList nomes, int left, int right) {
        String pivot = ((String)ArrayListFunctions.get(nomes, right));
        int startR = left - 1;
        
        
        for(int endR = left; endR < right; endR++) {
            int ola = pivot.compareTo(((String)ArrayListFunctions.get(nomes, endR)));
            if( ola > 0) {
                startR++;
                
                String temp = (String)ArrayListFunctions.get(nomes, endR);
                nomes.array[endR] = ArrayListFunctions.get(nomes, startR);
                nomes.array[startR] = temp;
            }
        }
        String temp = (String)ArrayListFunctions.get(nomes, right);
        nomes.array[right] = ArrayListFunctions.get(nomes, startR + 1);
        nomes.array[startR + 1] = temp;
        
        return startR + 1;        
    }
    
    static ArrayList ordenarMusicasPorAno(ArrayList musicas) {
        return ordenarMusicasAno(musicas, 0, musicas.tamanho);
    }
    
    static ArrayList ordenarMusicasAno(ArrayList musicas, int left, int right) {
        if(left < right) {
            int posicaoPivot = partitionMusicasAno(musicas, left, right - 1);
            
            musicas = ordenarMusicasAno(musicas, left, posicaoPivot);
            musicas = ordenarMusicasAno(musicas, posicaoPivot + 1, right);
        }        
        return musicas;
    }
    
    static int partitionMusicasAno(ArrayList musicas, int left, int right) {
        int pivot = ((Musica)ArrayListFunctions.get(musicas, right)).ano;
        int startR = left - 1;
        
        for(int endR = left; endR < right; endR++) {
            if(((Musica)ArrayListFunctions.get(musicas, endR)).ano >= pivot) {
                startR++;
                
                Musica temp = (Musica)ArrayListFunctions.get(musicas, endR);
                musicas.array[endR] = ArrayListFunctions.get(musicas, startR);
                musicas.array[startR] = temp;
            }
        }
        Musica temp = (Musica)ArrayListFunctions.get(musicas, right);
        musicas.array[right] = ArrayListFunctions.get(musicas, startR + 1);
        musicas.array[startR + 1] = temp;
        
        return startR + 1;        
    }
}
