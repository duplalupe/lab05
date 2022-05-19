package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente {
    private static final int priority = 3;
    private static final char representation = 'P';
    private static final int default_arrows = 1;
    private int arrows;
    private boolean arrowEquiped;
    private boolean carryingGold;

    public Heroi(Coordenada coord, Caverna cave, int arrows, boolean arrowEquiped) {
        this.setCoord(coord);
        this.setCave(cave);
        this.arrows = arrows;
        this.arrowEquiped = arrowEquiped;
    }

    public Heroi(Coordenada coord, Caverna cave) {
        this(coord, cave, Heroi.default_arrows, false);
    }

    public Heroi(Caverna cave) {
        this(cave.getEntrance(), cave, Heroi.default_arrows, false);
    }

    public int getPriority() {
        return Heroi.priority;
    }

    public boolean isCarryingGold() {
        return this.carryingGold;
    }

    public void setCarryingGold(boolean carryingGold) {
        this.carryingGold = carryingGold;
    }

    public void captureGold() {
        if (this.getSala().hasOuro())
            this.setCarryingGold(true);
    }

    public char toChar() {
        return Heroi.representation;
    }

    public String toString() {
        return "Heroi";
    }

    public boolean isArrowEquiped() {
        return arrowEquiped;
    }

    public void setArrowEquiped(boolean arrowEquiped) {
        this.arrowEquiped = arrowEquiped;
    }

    public void equipArrow() {
        this.setArrowEquiped(true);
    }

    public void mv(Coordenada dest) {
        // verificacao do heroi indo a uma sala fora da caverna
        this.rm();
        this.setCoord(dest);
        this.add();
        if (arrowEquiped) {
            this.shoot();
            this.arrowEquiped = false;
        }
    }

    public boolean isAtExit() {
        return Coordenada.equals(this.getCoord(), this.getCave().getExit());
    }

    private boolean isLucky() {
        Random rand = new Random();
        int bin = rand.nextInt() % 2;
        return (bin == 1);
    }

    private void consumeArrow() {
        this.arrows = this.arrows - 1;
    }

    public void shoot() {
        this.consumeArrow();
        this.arrowEquiped = false;
        if (this.getSala().hasWumpus()) {
            Componente wumpus = this.getSala().getWumpus();
            if (this.isLucky())
                wumpus.rm();
        }
    }
}