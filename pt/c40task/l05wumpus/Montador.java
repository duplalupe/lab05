package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Montador {
    private Caverna cave;
    private String[][] caveStrings;
    
    public Montador(String[][] caveStrings){
        this.caveStrings = caveStrings;
    }

    public void montarCaverna(){
        Coordenada coord;
        Componente comp;
        int lin;
        int col;

        for (int i = 0; i < cave.getSize() * cave.getSize(); i++){
            
            lin = Integer.parseInt(caveStrings[i][0]);
            col = Integer.parseInt(caveStrings[i][1]);
            coord = new Coordenada(lin, col);

            switch(caveStrings[i][2]){
                case "P":
                    comp = new Heroi();
                case "B":
                    comp = new Buraco(coord);
                case "O":
                    comp = new Ouro(coord);
                case "W":
                    comp = new Wumpus(coord);
                default:
                    comp = null;
            }

        }
    }
}
