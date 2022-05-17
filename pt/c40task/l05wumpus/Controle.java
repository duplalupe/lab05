package pt.c40task.l05wumpus;

public class Controle {
    private String name;
    private int score;
    private char status;
    private Heroi heroi;

    public void setName(String name) {
        this.name = name;
    }

    public void getScore(int score) {
        this.score = score;
    }

    public void getStatus(char status) {
        this.status = status;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public int moveUp(){
        if (this.heroi.getCoord().getLin() != 1){
            Coordenada dest = new Coordenada(this.heroi.getCoord().getLin() - 1, this.heroi.getCoord().getCol());
            this.heroi.mv(dest);
        }
        
    }
}
