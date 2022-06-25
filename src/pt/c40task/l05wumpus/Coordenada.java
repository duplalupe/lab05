package src.pt.c40task.l05wumpus;

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

    public static boolean equals(Coordenada a, Coordenada b){
        return a.getLin() == b.getLin() && a.getCol() == b.getCol();
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

    public Coordenada[] getAdjacent(){
        Coordenada[] adjacents = new Coordenada[this.getAmountOfAdjacent()];
        int currentIndex = 0;        
        if (this.leftward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
        if (this.rightward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
        if (this.upward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
        if (this.downward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
        return adjacents;
    }

    private int getAmountOfAdjacent(){
        int adj = 0;
        if (this.leftward() != null)
            adj++;
        if (this.rightward() != null)
            adj++;
        if (this.upward() != null)
            adj++;
        if (this.downward() != null)
            adj++;
        return adj;
    }

    public Coordenada leftward(){
        return new Coordenada(this.getLin(), this.getCol() - 1);
    }

    public Coordenada rightward(){
        return new Coordenada(this.getLin(), this.getCol() + 1);
    }

    public Coordenada upward(){
        return new Coordenada(this.getLin() + 1, this.getCol());
    }

    public Coordenada downward(){
        return new Coordenada(this.getLin() - 1, this.getCol());
    }

    private boolean validate() {
        return (lin >= 1 && lin <= this.getMax() &&
                col >= 1 && col <= this.getMax());
    }
}
