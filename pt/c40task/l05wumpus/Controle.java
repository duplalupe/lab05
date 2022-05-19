package pt.c40task.l05wumpus;

public class Controle {
    private String name;
    private int score;
    private char status;
    private Heroi heroi;
    private char command;

    public Controle(String name, int score, char status, Heroi heroi, char command){
        this.name = name;
        this.score = score;
        this.status = status;
        this.heroi = heroi;
        this.command = command;
    }

    public Controle(){
        this("", 0, 'p', null, ' ');
    }

    public void setCommand(char command){
        this.command = Character.toLowerCase(command);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public char getStatus() {
        return this.status;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
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
        if (dest != null){
            this.heroi.mv(dest);
            this.postMove();
        }
    }

    public void moveLeft(){
        Coordenada dest = this.heroi.getCoord().leftward();
        if (dest != null){
            this.heroi.mv(dest);
            this.postMove();
        }
    }
    public void moveRight(){
        Coordenada dest = this.heroi.getCoord().rightward();
        if (dest != null){
            this.heroi.mv(dest);
            this.postMove();
        }
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
        if (this.heroi.getSala().hasBuraco()) {
            this.score -= 1000;
            this.lose();
        }
    }

    public void equipArrow(){
        this.heroi.equipArrow();
    }

    public void captureGold(){
        this.heroi.captureGold();
    }

    public void invalidCommand(){
        System.out.println("Comando inválido!");
    }

    public void win(){
        this.status = 'w';
    }

    public void lose(){
        this.status = 'l';
    }

    public void quit(){
        this.status = 'q';
    }

    public void turn() {
        if (this.heroi.isAtExit() && this.heroi.isCarryingGold()){
            this.win();
        }
        switch(this.command){
            case 'w':
                this.moveUp();
                break;
            case 's':
                this.moveDown();
                break;
            case 'd':
                this.moveRight();
                break;
            case 'a':
                this.moveLeft();
                break;
            case 'k':
                this.equipArrow();
                break;
            case 'c':
                this.captureGold();
                break;
            case 'q':
                this.quit();
                break;
            default:
                this.invalidCommand();
        }
    }
}
