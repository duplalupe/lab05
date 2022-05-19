package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente {
    private static final int priority = 3;
    private static final char representation = 'P';
    private static final Coordenada initialCoord = new Coordenada(1, 1);
    private int arrows;
    private boolean arrowEquiped;
    private boolean foundGold;

    public int getPriority(){
        return Heroi.priority;
    }

    public char toChar(){
        return Heroi.representation;
    }

    public String toString(){
        return "Heroi";
    }

    public boolean isArrowEquiped(){
        return arrowEquiped;
    }

    public Heroi(Coordenada coord, int arrows, boolean arrowEquiped){
        this.setCoord(coord);
        this.arrows = arrows;
        this.arrowEquiped = arrowEquiped;
    }

    public Heroi(){
        this(Heroi.initialCoord, 1, false);
    }

    public void mv(Coordenada dest){
        // verificacao do heroi indo a uma sala fora da caverna
        this.rm();
        this.setCoord(dest);
        this.add();
        if (arrowEquiped){
            this.shoot();
            this.arrowEquiped = false;
        }
    }

    public void respawn(){
        this.mv(Heroi.initialCoord);
    }

    private boolean isLucky(){
        Random rand = new Random();
        int bin = rand.nextInt() % 2;
        return (bin == 1);
    }

    public void shoot(){
        this.arrows--;
        this.arrowEquiped = false;
        if (this.getSala().hasWumpus()){
            Wumpus wumpus = this.getSala().getWumpus();
            if (this.isLucky())
                wumpus.rm();
        }
    }
}