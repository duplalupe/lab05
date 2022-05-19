package pt.c40task.l05wumpus;

public class Fedor extends Componente{
    private static final int priority = 2;
    private static final char representation = 'f';
    
    public Fedor(Coordenada coord, Caverna cave){
        this.setCoord(coord);
        this.setCave(cave);
    }

    public int getPriority(){
        return Fedor.priority;
    }

    public char toChar(){
        return Fedor.representation;
    }

    public String toString(){
        return "Fedor";
    }
}
