package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
    private static final int priority = 4;
    private static final char representation = 'W';

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
        // TODO: adicionar fedor em volta do Wumpus
    }

    @Override
    public void rm(){
        // TODO: remover os fedores em volta do Wumpus
    }
}
