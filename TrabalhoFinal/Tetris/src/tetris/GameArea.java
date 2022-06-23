
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class GameArea extends JPanel
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock[][] board;
    
    Random generator = new Random();
    
    // shape feito, nesse caso um L, o que tem que descobrir é como gerar esse shape nesse formato ai, de colunas
    private TetrisBlock blockL; 
    private TetrisBlock blockJ; 
    private TetrisBlock block0; 
    private TetrisBlock blockI; 
    private TetrisBlock blockS; 
    private TetrisBlock blockZ; 
    private TetrisBlock blockT;
    private TetrisBlock[] blocks = new TetrisBlock[7];
    
    private Coordenada coord1;
    private Coordenada coord2;
    private Coordenada coord3;
    private Coordenada coord4;
    private Coordenada[] shape = new Coordenada[4];
    
    
    
    
    public GameArea(JPanel placeholder, int columns)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        
        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
        spawnBlock();
        spawnBlock2();
        
    } 
    
    // função que desenha o bloco no painel
    private void drawBlock(Graphics g, TetrisBlock block)
    {
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int [][] s = block.getShape();
        
        for (int row = 0; row < h; row++) 
        {
            for(int col = 0; col < w; col++)
            {
                if (s[row][col] == 1)
                {
                    int x = (block.getX() + col) * gridCellSize;
                    int y = (block.getY() + row) * gridCellSize; 
                    
                    g.setColor(c);
                    g.fillRect(x,y, gridCellSize, gridCellSize);
                    g.setColor(Color.black);
                    g.drawRect(x,y, gridCellSize, gridCellSize);
                }
            }
        }
    }
    
    private void drawShape(Graphics g, Coordenada[] shapeV) 
    {
        int h = 3;
        int w = 2;
        
        for (int row = 0; row < h; row++)
        {
            for(int col = 0; col < w; col++)
            {
                for (int a = 0; a < shapeV.length; a++)
                {
                    if (shapeV[a].getX() == col && shapeV[a].getY() == row)
                    {
                        Color c = shapeV[a].getColor();
                        int x = (shapeV[a].getX() + col) * gridCellSize;
                        int y = (shapeV[a].getY() + row) * gridCellSize; 
                    
                        g.setColor(c);
                        g.fillRect(x,y, gridCellSize, gridCellSize);
                        g.setColor(Color.black);
                        g.drawRect(x,y, gridCellSize, gridCellSize);
                    }
                }
            }
        }
        
    }
    
    public void spawnBlock2()
    {
        coord1 = new Coordenada(0,0, Color.BLUE);
        coord2 = new Coordenada(0,1, Color.BLUE);
        coord3 = new Coordenada(0,2, Color.BLUE);
        coord4 = new Coordenada(1,2, Color.BLUE);
        shape[0] = coord1;
        shape[1] = coord2;
        shape[2] = coord3;
        shape[3] = coord4;
    }
    
    public void spawnBlock()
    {
        blockL = new TetrisBlock(new int[][] {{1,0}, {1,0}, {1,1}}, Color.BLUE);
        blockJ = new TetrisBlock(new int[][] {{0,1}, {0,1}, {1,1}}, Color.GREEN);
        block0 = new TetrisBlock(new int[][] {{1,1}, {1,1}}, Color.MAGENTA);
        blockS = new TetrisBlock(new int[][] {{0,1,1}, {1,1,0}}, Color.ORANGE);
        blockI = new TetrisBlock(new int[][] {{1,0}, {1,0}, {1,0}, {1,0}}, Color.PINK);
        blockZ = new TetrisBlock(new int[][] {{1,1,0}, {0,1,1}}, Color.RED);
        blockT = new TetrisBlock(new int[][] {{1,1,1}, {0,1,0}}, Color.YELLOW);
        blocks[0] = blockL;
        blocks[1] = blockJ;
        blocks[2] = block0;
        blocks[3] = blockS;
        blocks[4] = blockI;
        blocks[5] = blockZ;
        blocks[6] = blockT;
    }
    
    
    // proximo passo seria um gerador de blocks
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawShape(g, shape);
        
        //int rand = generator.nextInt(blocks.length);
        //drawBlock(g, blocks[rand]);
        
        //int rand2 = generator.nextInt(blocks.length);
        //blocks[rand2].setY(2 + blocks[rand].getHeight() + 1);
        //drawBlock(g, blocks[rand2]);
        
        //int rand3 = generator.nextInt(blocks.length);
        //blocks[rand3].setY(2 + blocks[rand].getHeight() + 1 + blocks[rand2].getHeight() + 1);
        //drawBlock(g, blocks[rand3]);
    }
}

// começa com coordenada [0,0] com x = 0, y = 0; no L por exemplo, deveriam ser coordenadas [x+1,y],
// [x+2,y], [x+2,y+1], com os termos de 0, [0,0] [1,0] [2,0] [2,1] essas coordenadas devem ser setadas para true
// se a coordenada for true, desenha aquele quadradinho; tem que deixar o isThere como falso de novo
// ou seja, o pivo é o 0,0 e o resto segue isso. já começa pintando o 0,0, ele sempre vai ser pintado, ai a partir disso
// que cada figura é pintada. da pra fazer uma lista de coordenadas, sendo coordenada uma classe com (i,j). ai tem um for de i
// dentro dele um for de j e ai coloca uma iteraçao pela lista de coordenada. se i == coord.getX e j == coord.getY
// ai pinta aquela casa. se não for, passa pra proxima coordenada, até acabar.
