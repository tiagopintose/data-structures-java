
package projeto_aed;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


class lerFicheirosFunctions {
  static void lerFicheiroMusicas(ArrayList musicas) {

    String nomeFicheiro = "musicas.txt";
    
    try{
      File ficheiro = new File(nomeFicheiro);
      Scanner leitorFicheiro = new Scanner(ficheiro);
      
      while(leitorFicheiro.hasNextLine()) {
        String linha = leitorFicheiro.nextLine();
        
        String dados[] = linha.split(" : ");
        
        String titulo = dados[0];
        int idInterprete = Integer.parseInt(dados[1]);
        int ano = Integer.parseInt(dados[2]);
        int idGenero = Integer.parseInt(dados[3]);
        int posicao = Integer.parseInt(dados[4]);
        
        Musica musica = new Musica(titulo, idInterprete, ano, idGenero, posicao);
        
        ArrayListFunctions.add(musicas, musica);
      }
      leitorFicheiro.close();
    }catch(FileNotFoundException exception) {
      String mensagem = "Erro: o ficheiro " + nomeFicheiro + "nao foi encontrado.";
      System.out.println(mensagem);
    }
        
  }
  static void lerFicheiroInterpretes(ArrayList musicos) {
    String nomeFicheiro = "interpretes.txt";
    
    try{
      File ficheiro = new File(nomeFicheiro);
      Scanner leitorFicheiro = new Scanner(ficheiro);
      
      while(leitorFicheiro.hasNextLine()) {
        String linha = leitorFicheiro.nextLine();
        
        String dados[] = linha.split(":");
        
        int id = Integer.parseInt(dados[0]);
        String nome = dados[1];
        
        Interprete musico = new Interprete(id, nome);
        
        ArrayListFunctions.add(musicos, musico);
      }
      leitorFicheiro.close();
    }catch(FileNotFoundException exception) {
      String mensagem = "Erro: o ficheiro " + nomeFicheiro + "nao foi encontrado.";
      System.out.println(mensagem);
    }
  }
}
