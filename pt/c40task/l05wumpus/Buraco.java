package pt.c40task.l05wumpus;

public class Buraco extends Componente {
    private static final int priority = 4;
    private static final char representation = 'B';

    public Buraco(Coordenada coord){
        this.setCoord(coord);
    }

    public int getPriority(){
        return Buraco.priority;
    }

    public char toChar(){
        return Buraco.representation;
    }

    @Override
    public void add(){
        // TODO: adicionar brisa em volta do Buraco
    }

    @Override
    public void rm(){
        // TODO: remover brisa em volta do Buraco
    }
}
