package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {
      public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      Controle controle = new Controle();
      Caverna cave = new Caverna();

      String caveStrings[][] = tk.retrieveCave();
      Montador mont = new Montador(cave, caveStrings);
      mont.montarCaverna();

      String movements = null;
      Scanner keyboard = null;
      String name;

      if (arquivoMovimentos != null){
         movements = tk.retrieveMovements();
         name = "Alcebiades";
      }
      else {
         keyboard = new Scanner(System.in);
         System.out.print("Qual o seu nome? ");
         name = keyboard.nextLine();
      }


      char command; int current = 0;
      while(controle.getStatus() == 'p'){
         tk.writeBoard(cave.salasToChars(), controle.getScore(), 'P');         
         printApp(cave, name, controle.getScore(), controle.getStatus());

         if (arquivoMovimentos == null)
            command = keyboard.nextLine().charAt(0);
         else
            command = movements.charAt(current);
            current++;

         controle.setCommand(command);
         controle.turn();
      }
      if (controle.getStatus() == 'w'){
         tk.writeBoard(cave.salasToChars(), controle.getScore(), 'W');
         printApp(cave, name, controle.getScore(), controle.getStatus());
      }
      else if (controle.getStatus() == 'q'){
         tk.writeBoard(cave.salasToChars(), controle.getScore(), 'L');
         printApp(cave, name, controle.getScore(), controle.getStatus());
      }

      else {
         tk.writeBoard(cave.salasToChars(), controle.getScore(), 'L');
         printApp(cave, name, controle.getScore(), controle.getStatus());
      }   
      tk.stop();
   }

   private static void printApp(Caverna cave, String name, int score, char status){
      cave.printCave();
      System.out.println("Player: " + name);
      System.out.println("Score: " + score);

      if (status == 'l')
         System.out.println("Voce perdeu =(...");
      if (status == 'q')
         System.out.println("Volte sempre !");
      if (status == 'w')
         System.out.println("Voce ganhou =D !!!");
   }
}
