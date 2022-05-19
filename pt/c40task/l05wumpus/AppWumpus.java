package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

   
   /** 
    * @param args
    */
   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   
   /** 
    * @param arquivoCaverna
    * @param arquivoSaida
    * @param arquivoMovimentos
    */
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      Controle control = new Controle();
      Caverna caverna = new Caverna();
      Heroi hero = new Heroi();
      control.status = 'x';
      String cave[][] = tk.retrieveCave();
      Montador mont = new Montador(cave);


      if (arquivoMovimentos == null) {
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Nome: ");
         String name = keyboard.nextLine();
         controle.setName = name;

         // while jogando --> command = keyboard.nextLine() e vai chamando as funções de comando
      }

      if (arquivoMovimentos != null) {
         String movements = tk.retrieveMovements();
         controle.setName("Alcebiades");

         for (int i = 0; i < movements.length(); i++) {
            controle.comandos(movements.substring(i, i+ 1));
         }

         // while jogando --> command = keyboard.nextLine() e vai chamando as funções de comando
      }
      
   }

}
