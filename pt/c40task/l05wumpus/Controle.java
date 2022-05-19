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

    public void postMove() {
        this.score -= 15;

        // atira a flecha se ela está equipada
        if (this.heroi.isArrowEquiped()){
            this.heroi.shoot();
            this.score -= 100;

            if (!this.heroi.getSala().hasWumpus()){
                this.score += 500;
            }
        }

        // se entrar em uma sala com Wumpus, o jogador perde pontos e o jogo
        if (this.heroi.getSala().hasWumpus()) {
            this.score -= 1000;
            this.lose();
        }

        // se entrar em uma sala com Buraco, o jogador perde pontos e o jogo
        if (this.sala.hasBuraco()) {
            this.score -= 1000;
            this.lose();
        }
    }

    public void moveUp(){
        Coordenada dest = this.heroi.getCoord().upward();
        if (dest != null){
            this.heroi.mv(dest);
            this.postMove();
        }
    }

    public void moveDown(){
        Coordenada dest = this.heroi.getCoord().downward();
        if (dest){
            this.heroi.mv(dest);
            this.postMove();
        }
    }

    public void moveLeft(){
        Coordenada dest = this.heroi.getCoord().leftward();
        if (dest){
            this.heroi.mv(dest);
            this.postMove();
        }
    }
    public void moveRight(){
        Coordenada dest = this.heroi.getCoord().rightward();
        if (dest){
            this.heroi.mv(dest);
            this.postMove();
        }
    }

    public void equipArrow(){}

    public int comandos(char command) {
        command = Character.toLowerCase(command);
        if (command == 'w') {
            moveUp();
        }
        else if (command == 's') {
            moveDown();
        }
        else if (command = 'd') {
            moveRight();
        }
        else if (command = 'a') {
            moveLeft();
        }
        else if (command = 'k') {
            heroi.equipArrow();
        }
        else if (command = 'c') {
            heroi.captGold();
        }
        else if (command = 'q') {
            heroi.quit();
        }
        else {
            return -1; // condição de comando inválido
        }
    }
}
