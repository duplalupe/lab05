# O Mundo de Wumpus

## Destaque 1

A fim de possibilitar a expansão do código em um futuro, foram estabelecidos parâmetros que pudessem ser modificados, juntamente com a utilização da classe Componentes, de maneira que, caso queira ser adicionado algum componente novo, com diferentes atributos, isso não afete o programa inteiro. Isso pode ser atingido por meio do polimorfismo, juntamente com o uso de herança, dentro da classe Componentes. Como visto na classe, ela possui relação apenas com as classes Coordenada e Caverna, de modo que, se fosse necessária a criação de um novo componente, não alteraria a superclasse, mas sim seriam criados os novos atributos na própria classe de determinado componente.
```java
public abstract class Componente {
    private Coordenada coord;
    private Caverna cave;

    public Coordenada getCoord() {
        return coord;
    }

    public void setCoord(Coordenada coord) {
        this.coord = coord;
    }
```
Tratando-se de uma possível expansão da caverna, por exemplo, sua construção foi estabelecida a partir de um parâmetro, e não um valor fixo, assim, se houvesse a necessidade da mesma expandir, haveria essa possibilidade sem a mudança estrutural do código. Isso permite que não haja uma reestruturação completa caso haja o interesse de expandir o código.
```java
public class Caverna {
    private static final int default_size = 4;
    private Sala[][] salas;

    public Caverna(int size){
        if (size >= 1)
            this.salas = new Sala[size][size];
    }
```

## Destaque 2

A criação da classe chamada Coordenada auxilia em diversos aspectos do código. Por meio do método getAdjacent() foi possível encontrar as coordenadas adjacentes a um determinado componente, especialmente ao redor do Wumpus e do Buraco, a fim de posicionar os fedores e as brisas. Esse método é extremamente essencial na montagem da caverna, com seu uso facilitando o posicionamento de diversos componentes.
```java
public Coordenada[] getAdjacent(){
        Coordenada[] adjacents = new Coordenada[this.getAmountOfAdjacent()];
        int currentIndex = 0;        
        if (this.leftward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
        if (this.rightward() != null){
            adjacents[currentIndex] = this.leftward();
            currentIndex++;
        }
```

Além disso, todas as verificações necessárias para a coordenadas estão dentro da própria classe, não permitindo a criação de uma coordenada inválida por meio do construtor por exemplo, utilizando do encapsulamento para obter esse resultado. A obtenção da coordenada com base zero é também um ponto interessante, presente dentro da própria classe, que auxilia no seu posicionamento.
```java
public Coordenada(int lin, int col) {
        if (this.validate()){
            this.lin = lin;
            this.col = col;
        }
    }
```

## Destaque 3
A movimentação do herói é feita por meio do polimorfismo e encapsulamento de diversas classes. A partir do uso da classe caverna, é iniciado o movimento do herói, movendo-o de sala. Dentro da classe sala existe toda lista de componentes e sua localização, ou seja, com a ligação entre herói e sala, é possível fazer o movimento e saber qual será o componente encontrado na sala de destino. Dessa forma, a ligação entre herói, sala e caverna explora o conceito da delegação de tarefas, não concentrando todo o movimento no herói.
```java
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
```

## Destaque 4
Consideramos o herói dentro do jogo como um agente inteligente, ou seja, quando instanciando, o herói sabe de todas as informações relacionadas a ele dentro da própria classe. Essa fator auxilia no andamento do código de modo que, todas as vezes que é necessário alguma informação sobre o herói, é possível acessa-las por meio do próprio herói, não utilizando outras classes para obtenção daquele atributo. Dessa forma, o próprio objeto sabe os aspectos a que lhe dizem respeito.
```java
public class Heroi extends Componente {
    private static final int priority = 3;
    private static final char representation = 'P';
    private static final int default_arrows = 1;
    private int arrows;
    private boolean arrowEquiped;
    private boolean carryingGold;
```

## Destaque 5
A fim de explorar o encapsulamento, em certos momentos, declaramos todos os atributos como privados, utilizando de Setters e Getters para a obtenção desses atributos. Essa prática auxilia na organização do código, evitando mudanças nos valores de variável fora da classe de onde pertencem e acessos indevidos. Dessa forma, esses valores ainda conseguem ser obtidos em meio necessidade, mas por meio de Setters e Getters, melhorando a dinâmica do código.
```java
public class Montador {
    private Caverna cave;
    private String[][] caveStrings;
    private int numBuracos;
    private int numOuros;
    private int numHerois;
    private int numWumpus;
```
Além disso, variáveis que não precisam ser alcançadas fora da classe são declaradas todas como privadas, evitando acessos incorretos, e não são expostas a Setters e Getters, ou seja, apenas chamam seu construtor, onde os parâmetros são passados, e são acessadas dentro da própria classe. Essa prática evita que sejam escritos Setters e Getters desnecessários mas ao mesmo tempo protegendo o acesso àqueles atributos.
```java
public Montador(Caverna cave, String[][] caveStrings){
        this.cave = cave;
        this.caveStrings = caveStrings;
        this.numBuracos = 0;
        this.numOuros = 0;
        this.numHerois = 0;
        this.numWumpus = 0;
    }
```