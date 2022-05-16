package pt.c40task.l05wumpus;

public class Coordenada {
    private int lin;
    private int col;
    private Caverna cave;

    public Coordenada(int lin, int col) {
        if (this.validate()){
            this.lin = lin;
            this.col = col;
        }
    }

    public Coordenada() {
        this(1, 1);
    }

    public int getLin() {
        return lin;
    }

    public int getCol() {
        return col;
    }

    public int getZeroBasedLin(){
        return this.getLin() - 1;
    }

    public int getZeroBasedCol(){
        return this.getCol() - 1;
    }

    public void setLinCol(int lin, int col) {
        if (this.validate()) {
            this.lin = lin;
            this.col = col;
        }
    }

    public Caverna getCave() {
        return cave;
    }

    public void setCave(Caverna cave) {
        this.cave = cave;
    }

    public int getMax(){
        return this.cave.getSize();
    }

    private boolean validate() {
        return (lin >= 1 && lin <= this.getMax() &&
                col >= 1 && col <= this.getMax());
    }
}
