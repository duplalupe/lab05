package pt.c40task.l05wumpus;

public abstract class Componente {
    private Coordenada coord;
    private Caverna cave;

    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }

    public Caverna getCave() {
        return cave;
    }

    public void setCave(Caverna cave) {
        this.cave = cave;
    }

    public void add() {
        this.cave.place(this);
    }

    public void rm() {
        this.cave.displace(this);
    };

    public abstract int getPriority();
    public abstract char toChar();
}
