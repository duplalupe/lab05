package pt.c40task.l05wumpus;

public class Montador {
    private Caverna cave;
    private String[][] caveStrings;
    private int numBuracos;
    private int numOuros;
    private int numHerois;
    private int numWumpus;
    
    public Montador(Caverna cave, String[][] caveStrings){
        this.cave = cave;
        this.caveStrings = caveStrings;
        this.numBuracos = 0;
        this.numOuros = 0;
        this.numHerois = 0;
        this.numWumpus = 0;
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

            if (this.isValid())
                switch(caveStrings[i][2]){
                    case "P":
                        comp = new Heroi(cave);
                        comp.add();
                        this.numHerois++;
                    case "B":
                        comp = new Buraco(coord, cave);
                        comp.add();
                        this.numBuracos++;
                    case "O":
                        comp = new Ouro(coord, cave);
                        comp.add();
                        this.numOuros++;
                    case "W":
                        comp = new Wumpus(coord, cave);
                        comp.add();
                        this.numWumpus++;
                }

        }
    }
    public boolean isValid() {
        return (numBuracos >= 2 && numBuracos <= 3) && (numHerois == 1) && (numOuros == 1) && (numWumpus == 1);
    }
}
