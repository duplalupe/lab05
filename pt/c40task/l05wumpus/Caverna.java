package pt.c40task.l05wumpus;

public class Caverna {
    private static final int default_size = 4;
    private Sala[][] salas;

    public Caverna(int size){
        if (size >= 1)
            this.salas = new Sala[size][size];
    }

    public Caverna(){
        this(default_size);
    }

    public static int getDefaultSize() {
        return default_size;
    }

    public int getSize() {
        return this.getSalas()[0].length;
    }

    public Sala[][] getSalas() {
        return salas;
    }

    public void setSalas(Sala[][] salas) {
        this.salas = salas;
    }

    public char[][] salasToChars(){
        char[]
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
