
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
    } 
    
    // função que desenha o bloco no painel
    private void drawBlock(Graphics g, TetrisBlock block)
    {
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int [][] shape = block.getShape();
        
        for (int row = 0; row < h; row++) 
        {
            for(int col = 0; col < w; col++)
            {
                if (shape[row][col] == 1)
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
    
    
    public boolean blockCheck()
    {
     for (int i = 0; i < board.length; i++) 
     {
         for (int j = 0; j < board.length; j++)
         {
            Color blockColor = board[i][j].getColor();
            boolean acc = true;
            //for (int a in blockL.getAdjacent()) {
            //   acc = acc && (board[i + a.getX()][j + a.getY()].getColor() == blockColor);
            //}
            if (acc == false)
            {
                return false;
            }
         }
     }
    }
    
    // proximo passo seria um gerador de blocks
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int rand = generator.nextInt(blocks.length);
        drawBlock(g, blocks[rand]);
        
        int rand2 = generator.nextInt(blocks.length);
        blocks[rand2].setY(6);
        drawBlock(g, blocks[rand2]);
        
        int rand3 = generator.nextInt(blocks.length);
        blocks[rand3].setY(11);
        drawBlock(g, blocks[rand3]);
    }
}
