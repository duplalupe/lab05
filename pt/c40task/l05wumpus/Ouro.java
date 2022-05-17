package pt.c40task.l05wumpus;

public class Ouro extends Componente {
    private static final int priority = 4;
    private static final char representation = 'O';

    public int getPriority(){
        return Ouro.priority;
    }

    public char toChar(){
        return Ouro.representation;
    }

    public String toString(){
        return "Ouro";
    }
}
