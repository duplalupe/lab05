package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
    private static final int priority = 4;
    private static final char representation = 'W';
    private Componente[] secondary; // polimorfismo

    public Wumpus(Coordenada coord, Caverna cave){
        this.setCoord(coord);
        this.setCave(cave);
        this.secondary = null;
    }

    public int getPriority(){
        return Wumpus.priority;
    }

    public char toChar(){
        return Wumpus.representation;
    }

    public String toString(){
        return "Wumpus";
    }

    @Override
    public void add(){
        super.add();
        Coordenada[] adjacents = this.getCoord().getAdjacent();
        this.secondary = new Componente[adjacents.length];
        for (int i = 0; i < adjacents.length; i++){
            this.secondary[i] = new Fedor(adjacents[i], this.getCave());
            this.secondary[i].add();
        }
    }

    @Override
    public void rm(){
        super.rm();
        for (int i = 0; i < this.secondary.length; i++){
            this.secondary[i].rm();
        }
    }
}
