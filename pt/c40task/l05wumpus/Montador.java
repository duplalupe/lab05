package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Montador {
    private Caverna cave;
    private String[][] caveStrings;
    private int numBuracos = 0;
    private int numOuros = 0;
    private int numHerois = 0;
    private int numWumpus = 0;
    
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
                    numHerois++;
                case "B":
                    comp = new Buraco(coord);
                    numBuracos++;
                case "O":
                    comp = new Ouro(coord);
                    numOuros++;
                case "W":
                    comp = new Wumpus(coord);
                    numWumpus++;
                default:
                    comp = null;
            }

        }
    }
    public boolean verificarCaverna() {
        return (numBuracos >= 2 && numBuracos <= 3) && (numHerois == 1) && (numOuros == 1) && (numWumpus == 1);
    }
}
