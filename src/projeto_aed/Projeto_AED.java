
package projeto_aed;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

class escreverFunctions{
  static void escrever(String[] resultados) {
    try{
      String nomeFicheiroResultados = "resultados.txt";
      String newLine = System.getProperty("line.separator");
      File ficheiro = new File(nomeFicheiroResultados);
      FileWriter escritor = new FileWriter(ficheiro);
      for(int j=0; j<resultados.length; j++) {
      String texto = resultados[j] + newLine;
      escritor.write(texto);
      }
      escritor.close();
    }catch(IOException err){
      System.out.println("Ocorreu um erro: " + err);
    }
  }
}

class Musica {

    String titulo;
    int idInterprete;
    int ano;
    int idGenero;
    int posicao;

    public Musica() {
    }

    public Musica(String titulo,int idInterprete, int ano, int idGenero, int posicao) {
        this.titulo = titulo;
        this.idInterprete = idInterprete;
        this.ano = ano;
        this.idGenero = idGenero;
        this.posicao = posicao;
    }
    @Override
    public String toString() {
      return titulo + " " + idInterprete + " " + ano + " " + idGenero + " " + posicao;
    }
}

class Interprete {

    int id;
    String nome;

    public Interprete() {
    }

    public Interprete(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    @Override
    public String toString() {
      return id + ":" + nome;
    }
}

public class Projeto_AED {
    
    public static void main(String[] args) {
        
        
        ArrayList musicas = new ArrayList();
        ArrayList musicos = new ArrayList();
        String[] resultado = new String[15];
        
        lerFicheirosFunctions.lerFicheiroMusicas(musicas);
        lerFicheirosFunctions.lerFicheiroInterpretes(musicos);        

        musicas = QuickSortFunctions.ordenarMusicasPorPosicao(musicas);
        
        
        //pergunta 1
        String primeiraMusica = ((Musica)ArrayListFunctions.get(musicas, 0)).titulo;
        resultado[0] = primeiraMusica;
        //pergunta 2
        String ultimaMusica = ((Musica)ArrayListFunctions.get(musicas, musicas.tamanho - 1)).titulo;
        resultado[1] = ultimaMusica;
        //pergunta3
        resultado[2] = temKavinsky(musicos);
        //pergunta4
        resultado[3] = musicasAntesRacer(musicas);
        //pergunta 5
        resultado[4] = musicasAposParanoid(musicas);
        //pergunta 6
        resultado[5] = musicaAntesBoulevard(musicas, musicos);
        //pergunta 7
        resultado[6] = musicaDepoisTakeMyBreathAway(musicas, musicos);
        //pergunta 8
        resultado[7] = generosPopERock(musicas, musicos);
        //pergunta 9
        resultado[8] = generosEletronicaJazz(musicas, musicos);
        //pergunta 10
        resultado[9] = anoMaisAntigo(musicas);
        //pergunta11
        resultado[10] = anoMaisRecente(musicas);
        //pergunta12
        resultado[11] = interpretesNaoPresentes(musicas, musicos);
        //pergunta13
        resultado[12] = anoComMenosMusicas(musicas, musicos);
        
        escreverFunctions.escrever(resultado);

    
    
    
  }
  
  static String temKavinsky(ArrayList musicos) {
        String nomeAProcurar = "Kavinsky";
        int count = 0;
        for(int i = 0; i < musicos.tamanho; i++) {
            if(((Interprete)ArrayListFunctions.get(musicos, i)).nome.equals(nomeAProcurar)) {
                count++;
            }
        }
        if(count == 0) {
            return "Não";
        }else{            
            return "Sim";
        }
    }
    
    static String musicasAntesRacer(ArrayList musicas) {
        int count = 0;
        String nomeAProcurar = "Racer";
        int anoMusica = 2013;        
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).titulo.equals(nomeAProcurar) && ((Musica)ArrayListFunctions.get(musicas, i)).ano == anoMusica) {
                break;
            }
            count++;
        }
        return count + "";        
    }
    
    static String musicasAposParanoid(ArrayList musicas) {
        int count = 0;
        int verificaSeJaEntrou = 0;
        String nomeAProcurar = "I Think I'm Paranoid";
        int anoMusica = 1998;
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).titulo.equals(nomeAProcurar) && ((Musica)ArrayListFunctions.get(musicas, i)).ano == anoMusica){
                verificaSeJaEntrou++;
            }
            if(verificaSeJaEntrou != 0) {
                count++;
            }
        }
        return (count - 1) + "";
    }
    
    static String musicaAntesBoulevard(ArrayList musicas, ArrayList musicos) {
        
        String nomeAProcurar = "Boulevard of Broken Dreams";
        int anoMusica = 2004;
        int verificaSeEncontrou = 0;
        int idAProcurar = 0;
        String nomeArtista = "";
        String musicaProcurada = "";
        
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).titulo.equals(nomeAProcurar) && ((Musica)ArrayListFunctions.get(musicas, i)).ano == anoMusica ) {
                musicaProcurada =  ((Musica)ArrayListFunctions.get(musicas, i - 1)).titulo;
                idAProcurar = ((Musica)ArrayListFunctions.get(musicas, i - 1)).idInterprete;
                verificaSeEncontrou++;
                break;
            }   
        }
        for(int i = 0; i < musicos.tamanho; i++) {
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idAProcurar) {
            nomeArtista = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
          }
        }
        if(verificaSeEncontrou != 0) {
          return musicaProcurada + " (" + nomeArtista + ")"; 
        }else{
          return "NENHUM CASO";
        }
        
    }
    static String musicaDepoisTakeMyBreathAway(ArrayList musicas, ArrayList musicos) {
        String nomeAProcurar = "Take my breath away";
        int verificaSeEncontrou = 0;
        int idAProcurar = 0;
        String artistaEncontrado = "";
        String nomeEncontrado = "";
        
        
        for(int i = 0; i < musicas.tamanho + 1; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).titulo.equals(nomeAProcurar) ) {
                verificaSeEncontrou++;
                nomeEncontrado = ((Musica)ArrayListFunctions.get(musicas, i + 1)).titulo;
                idAProcurar = ((Musica)ArrayListFunctions.get(musicas, i + 1)).idInterprete;
                break;
            }
        }
        for(int i = 0; i < musicos.tamanho; i++) {
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idAProcurar) {
            artistaEncontrado = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
            break;
          }
        }
        if(verificaSeEncontrou != 0) {
          return nomeEncontrado + " (" + artistaEncontrado + ")";
        }else{
          return "NENHUM CASO";
        }
        
    }
    static String generosPopERock(ArrayList musicas, ArrayList musicos) {
        int verificaSeJaEncontrou = 0;
        int verificaEntrou = 0;
        int idProcuradoPrimeiro = 2;
        int idProcuradoImediatamenteASeguir = 3;
        String musicaPopPertendida = "NENHUM CASO";
        String musicaRockPertendida = "NENHUM CASO";
        String artistaMusicaPop = "";
        String artistaMusicaRock = "";
        int idMusicaPop = 0;
        int idMusicaRock = 0;
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).idGenero == idProcuradoPrimeiro) {
                if(((Musica)ArrayListFunctions.get(musicas, i + 1)).idGenero == idProcuradoImediatamenteASeguir) {
                    verificaSeJaEncontrou++;
                    musicaPopPertendida = ((Musica)ArrayListFunctions.get(musicas, i)).titulo;
                    idMusicaPop = ((Musica)ArrayListFunctions.get(musicas, i)).idInterprete;
                    musicaRockPertendida = ((Musica)ArrayListFunctions.get(musicas, i + 1)).titulo;
                    idMusicaRock = ((Musica)ArrayListFunctions.get(musicas, i + 1)).idInterprete;
                    break;
                }
            }
        }
        for(int i = 0; i < musicos.tamanho; i++) {
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idMusicaPop) {
            artistaMusicaPop = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
            verificaEntrou++;
          }
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idMusicaRock) {
            artistaMusicaRock = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
            if(verificaEntrou != 0) {
              break;
            }
          }
        }
        if(verificaSeJaEncontrou == 0){
            return musicaPopPertendida;
        }else{
            return musicaPopPertendida + " (" + artistaMusicaPop + ") , " + musicaRockPertendida + " (" + artistaMusicaRock + ")";
        }
    }
    static String generosEletronicaJazz(ArrayList musicas, ArrayList musicos) {
        int verificaSeJaEncontrou = 0;
        int verificaEntrou = 0;
        int idProcuradoPrimeiro = 6;
        int idProcuradoImediatamenteASeguir = 1;
        String musicaEletronicaPertendida = "NENHUM CASO";
        String musicaJazzPertendida = "NENHUM CASO";
        String artistaMusicaEletronica = "";
        String artistaMusicaJazz = "";
        int idMusicaEletronica = 0;
        int idMusicaJazz = 0;
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).idGenero == idProcuradoPrimeiro) {
                if(((Musica)ArrayListFunctions.get(musicas, i + 1)).idGenero == idProcuradoImediatamenteASeguir) {
                    verificaSeJaEncontrou++;
                    musicaEletronicaPertendida = ((Musica)ArrayListFunctions.get(musicas, i)).titulo;
                    idMusicaEletronica = ((Musica)ArrayListFunctions.get(musicas, i)).idInterprete;
                    musicaJazzPertendida = ((Musica)ArrayListFunctions.get(musicas, i + 1)).titulo;
                    idMusicaJazz = ((Musica)ArrayListFunctions.get(musicas, i + 1)).idInterprete;
                    break;
                }
            }
        }
        for(int i = 0; i < musicos.tamanho; i++) {
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idMusicaEletronica) {
            artistaMusicaEletronica = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
            verificaEntrou++;
          }
          if(((Interprete)ArrayListFunctions.get(musicos, i)).id == idMusicaJazz) {
            artistaMusicaJazz = ((Interprete)ArrayListFunctions.get(musicos, i)).nome;
            if(verificaEntrou != 0) {
              break;
            }
          }
        }
        if(verificaSeJaEncontrou == 0){
            return musicaEletronicaPertendida;
        }else{
            return musicaEletronicaPertendida + " (" + artistaMusicaEletronica + ") , " + musicaJazzPertendida + " (" + artistaMusicaJazz + ")";
        }
    }
    static String anoMaisAntigo(ArrayList musicas) {
        int maisAntigo = ((Musica)ArrayListFunctions.get(musicas, 0)).ano;
        int count = 0;
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(maisAntigo > ((Musica)ArrayListFunctions.get(musicas, i)).ano) {
                maisAntigo = ((Musica)ArrayListFunctions.get(musicas, i)).ano;
            }
        }
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).ano == maisAntigo){
                count++;
            }
        }
        if(count >= 10){
            return maisAntigo + " " + count;
        }else{
            return "NENHUM CASO";
        }
    }
    static String anoMaisRecente(ArrayList musicas) {
        int maisRecente = ((Musica)ArrayListFunctions.get(musicas, 0)).ano;
        int count = 0;
        
        for(int i = 0; i < musicas.tamanho; i++) {
            if(maisRecente < ((Musica)ArrayListFunctions.get(musicas, i)).ano) {
                maisRecente = ((Musica)ArrayListFunctions.get(musicas, i)).ano;
            }
        }
        for(int i = 0; i < musicas.tamanho; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).ano == maisRecente){
                count++;
            }
        }
        if(count >= 10){
            return maisRecente + " " + count;
        }else{
            return "NENHUM CASO";
        }
    }
    static String interpretesNaoPresentes(ArrayList musicas, ArrayList musicos) {
      HashSet<String> conjunto = new HashSet();
      ArrayList artstasQueNaoEstaoNaPlayList = new ArrayList();
      
      for(int i = 0; i < musicas.tamanho; i++) {
        conjunto.add(((Interprete)ArrayListFunctions.get(musicos, ((Musica)ArrayListFunctions.get(musicas, i)).idInterprete)).nome);
      }
      
      for(int i = 0; i < musicos.tamanho; i++) {
        if(!(conjunto.contains(((Interprete)ArrayListFunctions.get(musicos, i)).nome))) {
          ArrayListFunctions.add(artstasQueNaoEstaoNaPlayList, ((Interprete)ArrayListFunctions.get(musicos, i)).nome);
        }
      }
      artstasQueNaoEstaoNaPlayList = QuickSortFunctions.ordenarNomesPorOrdemAlfabetica(artstasQueNaoEstaoNaPlayList);
      String retorno = "";
      
      for(int i = 0; i < artstasQueNaoEstaoNaPlayList.tamanho; i++) {
        if(i == artstasQueNaoEstaoNaPlayList.tamanho - 1) {
          retorno += ArrayListFunctions.get(artstasQueNaoEstaoNaPlayList, i);
        }else{
          retorno += ArrayListFunctions.get(artstasQueNaoEstaoNaPlayList, i) + ", ";
        }
      }
      if(ArrayListFunctions.get(artstasQueNaoEstaoNaPlayList, 0) == null) {
        return "NENHUM CASO";
      }else{          
        return retorno;  
      }
        
    }
    static String anoComMenosMusicas(ArrayList musicas, ArrayList musicos) {
        QuickSortFunctions.ordenarMusicasPorAno(musicas); //ordem decrescente
        int count = 0;
        int anoAProcurar = 0;
        int anoMenor = musicas.tamanho;
        
        for(int i = 0; i < musicas.tamanho - 1; i++) {
            if(((Musica)ArrayListFunctions.get(musicas, i)).ano == ((Musica)ArrayListFunctions.get(musicas, i + 1)).ano) {
                count++;
            }else{
                if(count < anoMenor) {
                    anoMenor = count;
                    anoAProcurar = ((Musica)ArrayListFunctions.get(musicas, i)).ano;
                }
                count = 0;
            }
        }
        
        ArrayList musicasDoAnoAProcurar = new ArrayList();
        ArrayList artistasDasRespetivasMusicas = new ArrayList();
        
        for(int i = 0; i < musicas.tamanho;i++) {
            Musica musicaAtual = (Musica)ArrayListFunctions.get(musicas, i);
            if(musicaAtual.ano == anoAProcurar) {
                ArrayListFunctions.add(musicasDoAnoAProcurar, musicaAtual.titulo);          
                for(int j = 0; j < musicos.tamanho; j++) {
                    Interprete musicoAtual = (Interprete)ArrayListFunctions.get(musicos, j);
                    if(musicaAtual.idInterprete == musicoAtual.id) {
                        ArrayListFunctions.add(artistasDasRespetivasMusicas, musicoAtual.nome);
                        break;
                    }
                }
            }
        }
        String retorno = anoAProcurar + " - ";
        QuickSortFunctions.ordenarNomesPorOrdemAlfabetica(musicasDoAnoAProcurar);
        QuickSortFunctions.ordenarNomesPorOrdemAlfabetica(artistasDasRespetivasMusicas);
        
        for(int i = 0; i < musicasDoAnoAProcurar.tamanho; i = i + 2) {
            String musicaAtualNovaLista = (String)ArrayListFunctions.get(musicasDoAnoAProcurar, i);
            String InterpreteAtualNovaLista = (String)ArrayListFunctions.get(artistasDasRespetivasMusicas, i); //têm o mesmo tamanho, por isso não há problema em estar neste for
            
            if(i == musicasDoAnoAProcurar.tamanho - 1) {
                retorno += musicaAtualNovaLista + "(" + InterpreteAtualNovaLista + ")";// + " (" + InterpreteAtualNovaLista + ")";
            }else{
                retorno += musicaAtualNovaLista + "(" + InterpreteAtualNovaLista + "), "; // " (" + InterpreteAtualNovaLista + "), ";
            
            
            }        
        }
        return retorno;
    }
}
    

