package pt.c40task.l05wumpus;

public class Controle {
    private String name;
    private int score;
    private char status;
    private Heroi heroi;
    private Sala sala;

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

    public int ajustePontuacao() {
        score += 15;
        if (this.heroi.captGold()) {
            score += 1000;
        }
        if (this.sala.isWumpus()) {
            score -= 1000;
        }
        if (this.sala.isBuraco()) {
            score -= 1000;
        }
        if (this.heroi.killWumpus()) {
            score += 500;
        }
        return score;
    }

    public int moveUp(){
        if (this.heroi.getCoord().getLin() != 1){
            Coordenada dest = new Coordenada(this.heroi.getCoord().getLin() - 1, this.heroi.getCoord().getCol());
            this.heroi.mv(dest);
        }
        score = ajustePontuacao();
        return score;
        //checa o que tem na sala dest
    }

    public int moveDown(){
        if (this.heroi.getCoord().getLin() != 4){
            Coordenada dest = new Coordenada(this.heroi.getCoord().getLin() + 1, this.heroi.getCoord().getCol());
            this.heroi.mv(dest);
        }
        //checa o que tem na sala dest
        score = ajustePontuacao();
        return score;
    }

    public int moveLeft(){
        if (this.heroi.getCoord().getCol() != 1){
            Coordenada dest = new Coordenada(this.heroi.getCoord().getLin(), this.heroi.getCoord().getCol() - 1);
            this.heroi.mv(dest);
        }
        //checa o que tem na sala dest
        score = ajustePontuacao();
        return score;
    }
    public int moveRight(){
        if (this.heroi.getCoord().getCol() != 4){
            Coordenada dest = new Coordenada(this.heroi.getCoord().getLin(), this.heroi.getCoord().getCol() + 1);
            this.heroi.mv(dest);
        }
        //checa o que tem na sala dest
        score = ajustePontuacao();
        return score;
    }
}
