package pt.c40task.l05wumpus;

public class Brisa extends Componente {
    private static final int priority = 1;
    private static final char representation = 'b';

    public int getPriority(){
        return Brisa.priority;
    }

    public char toChar(){
        return Brisa.representation;
    }

    public String toString(){
        return "Brisa";
    }
}
