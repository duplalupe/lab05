package src.pt.c40task.l05wumpus;

public class Caverna {
    private static final int default_size = 4;
    private static final Coordenada default_entrance = new Coordenada(1, 1);
    private Sala[][] salas;
    private Coordenada entrance;

    public Caverna(int size, Coordenada entrance){
        if (size >= 1)
            this.salas = new Sala[size][size];
            this.entrance = entrance;
    }

    public Caverna(){
        this(default_size, default_entrance);
    }

    public Coordenada getEntrance(){
        return this.entrance;
    }

    public Coordenada getExit(){
        return this.entrance;
    }

    public int getSize() {
        return this.salas.length;
    }

    public Sala getSalaAt(Coordenada coord){
        int lin = coord.getZeroBasedLin();
        int col = coord.getZeroBasedCol();
        return this.salas[lin][col];
    }

    public String[][] salasToStrings(){
        String[][] result = new String[this.getSize()][this.getSize()];
        for (int i = 0; i < this.getSize(); i++){
            for (int j = 0; j < this.getSize(); j++){
                result[i][j] = Character.toString(this.salas[i][j].toChar());
            }
        }
        return result;
    }

    public char[][] salasToChars(){
        String[][] caveStrings = this.salasToStrings();
        char[][] caveChars = new char[this.getSize()][this.getSize()];
        for (int i = 0; i < this.getSize(); i++){
            for (int j = 0; j < this.getSize(); j++){
                caveChars[i][j] = caveStrings[i][j].charAt(0);
            }
        }
        return caveChars; 
    }

    public void printCave(){
        String[][] caveStrings = this.salasToStrings();
        for (int l = 0; l < caveStrings.length; l++) {
            for (int c = 0; c < caveStrings[l].length; c++)
               System.out.print(caveStrings[l][c] + ((c < caveStrings[l].length-1) ? ", " : ""));
            System.out.println();
         }
    }

    public void place(Componente comp){
        int lin = comp.getCoord().getZeroBasedLin();
        int col = comp.getCoord().getZeroBasedCol();
        this.salas[lin][col].enter(comp);
    }

    public void displace(Componente comp){
        int lin = comp.getCoord().getZeroBasedLin();
        int col = comp.getCoord().getZeroBasedCol();
        this.salas[lin][col].leave(comp);
    }
}
