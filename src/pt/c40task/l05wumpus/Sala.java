package src.pt.c40task.l05wumpus;

/**
 * A classe Sala guarda uma lista dos Componentes polimórficos que se encontram
 * em seu interior. Essa classe é responsável por manipular tal lista, conforme
 * novos componentes entram e saem das salas. 
 *
 * Além disso, essa classe garante que a impressão de cada sala ocorre de
 * maneira correta, isto é, respeitando a ocultação de salas não visitadas e a
 * priorização de componentes presentes.
 */
public class Sala {
    // com as regras atuais, no máximo seis componentes ocupam uma sala. Isso
    // acontece quando uma sala cercada de 3 Buracos contém o Herói e o Ouro ou
    // o Wumpus.
    private static final int default_size = 5;
    private Componente[] comps;
    private boolean visited;

    public Sala(int size, boolean visited) {
        this.comps = new Componente[size];
        this.visited = visited;
    }

    public Sala() {
        this(default_size, false);
    }

    /**
     * Retorna a lista de componentes presentes em uma sala
     * 
     * @return Componente[]
     */
    public Componente[] getComps() {
        return comps;
    }

    /**
     * Retorna o estado de visitação de uma sala
     * 
     * @return boolean <code>true</code> se a sala já foi visitada pelo Heroi
     * <code>false</code> caso contrário
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Atualiza o estado de visitação de uma sala
     * 
     * @param visited <code>true</code> se a sala já foi visitada pelo Heroi
     * <code>false</code> caso contrário
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Retorna o número de componentes que cabem numa sala
     * 
     * @return tamanho do vetor de componentes
     */
    public int getSize() {
        return comps.length;
    }

    /**
     * Adiciona um componente que entra na sala, na primeira posição vazia
     * encontrada na lista de componentes presentes na sala
     * 
     * @param comp componente a ser adicionado
     */
    public void enter(Componente comp) {
        for (int i = 0; i < this.getSize(); i++)
            if (this.comps[i] == null)
                this.comps[i] = comp;
    }

    /**
     * Remove um componente que sai da sala
     * 
     * @param comp componente a ser removido
     */
    public void leave(Componente comp) {
        this.comps[this.indexOf(comp)] = null;
    }

    /**
     * Gera um caracter que representa a sala, levando em conta o estado de
     * visitação da sala e a priorização dos componentes nela presentes.
     * DESTAQUE: ponto único de retorno
     * 
     * @return char caracter que representa a sala
     */
    public char toChar() {
        int maxp = 0;
        char current = '-';

        if (this.visited)
            current = '#';
        for (int i = 0; i < this.getSize(); i++)
            if (this.comps[i].getPriority() > maxp) {
                maxp = this.comps[i].getPriority();
                current = this.comps[i].toChar();
            }

        return current;
    }

    public boolean hasOuro(){
        return has("Ouro");
    }

    public boolean hasWumpus(){
        return has("Wumpus");
    }

    public boolean hasBuraco(){
        return has("Buraco");
    }

    private boolean has(String classname){
        boolean result = false;
        for (int i = 0; i < this.getSize(); i++){
            if (this.comps[i].toString() == classname){
                result = true;
            }
        }
        return result;
    }

    public Componente getWumpus(){
        Componente wumpus = null;
        for (int i = 0; i < this.getSize(); i++){
            if (this.comps[i].toString() == "Wumpus"){
                wumpus = this.comps[i];
            }
        }
        return wumpus;
    }

    /**
     * Busca um componente na lista dos que estão presentes na sala
     * 
     * @param comp componente a ser buscado
     * @return int índice do componente se encontrado, -1 caso contrário
     */
    private int indexOf(Componente comp) {
        int index = -1;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.comps[i] == comp) {
                index = i;
            }
        }
        return index;
    }

}
