
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class GameArea1 extends JPanel
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private TetrisBlock[][] board;
    
    Random generator = new Random();
    
    // shape feito, nesse caso um L, o que tem que descobrir é como gerar esse shape nesse formato ai, de colunas
    
    private Coordenada coord1;
    private Coordenada coord2;
    private Coordenada coord3;
    private Coordenada coord4;
    private Coordenada[] shapeL = new Coordenada[4];
    private Coordenada[] shapeJ = new Coordenada[4];
    private Coordenada[] shapeO = new Coordenada[4];
    private Coordenada[] shapeS = new Coordenada[4];
    private Coordenada[] shapeZ = new Coordenada[4];
    private Coordenada[] shapeI = new Coordenada[4];
    private Coordenada[] shapeT = new Coordenada[4];
    public Coordenada coordA;
    public Coordenada coordB;
    
    public Coordenada[][] shapes = new Coordenada[7][7];
    
    
    
    
    public GameArea1(JPanel placeholder, int columns)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        
        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
        coordA = new Coordenada(1,1, Color.BLUE);
        coordB = new Coordenada(2,1, Color.BLUE);
        spawnBlockL(coordA);
        spawnBlockJ(coordB);
        spawnBlockO(coordA);
        spawnBlockS(coordB);
        spawnBlockZ(coordA);
        spawnBlockI(coordA);
        spawnBlockT(coordA);
        
    } 
    
    // função que desenha o bloco no painel
    
    private void drawShape(Graphics g, Coordenada[] shapeV) 
    {
        int h = 4;
        int w = 4;
        
        for (int row = 0; row < h; row++)
        {
            for(int col = 0; col < w; col++)
            {
                for (int a = 0; a < shapeV.length; a++)
                {
                    if (shapeV[a].getY() == row && shapeV[a].getX() == col)
                    {
                        Color c = shapeV[a].getColor();
                        int x = (shapeV[a].getX()) * gridCellSize;
                        int y = (shapeV[a].getY()) * gridCellSize; 
                    
                        g.setColor(c);
                        g.fillRect(x,y, gridCellSize, gridCellSize);
                        g.setColor(Color.black);
                        g.drawRect(x,y, gridCellSize, gridCellSize);
                    }
                }
            }
        }
        
    }
    
    public void spawnBlockL(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.BLUE);
        coord2 = new Coordenada(x,y + 1, Color.BLUE);
        coord3 = new Coordenada(x,y + 2, Color.BLUE);
        coord4 = new Coordenada(x+1,y + 2, Color.BLUE);
        shapeL[0] = coord1;
        shapeL[1] = coord2;
        shapeL[2] = coord3;
        shapeL[3] = coord4;
        shapes[0] = shapeL;
    }
    
    public void spawnBlockJ(Coordenada pivo)
    {
        int y = pivo.getY();
        int x = pivo.getX();
        coord1 = new Coordenada(x,y, Color.GREEN);
        coord2 = new Coordenada(x,y + 1, Color.GREEN);
        coord3 = new Coordenada(x,y + 2, Color.GREEN);
        coord4 = new Coordenada(x - 1,y + 2, Color.GREEN);
        shapeJ[0] = coord1;
        shapeJ[1] = coord2;
        shapeJ[2] = coord3;
        shapeJ[3] = coord4;
        shapes[1] = shapeJ;
    }
    
    public void spawnBlockO(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.MAGENTA);
        coord2 = new Coordenada(x + 1,y, Color.MAGENTA);
        coord3 = new Coordenada(x,y + 1, Color.MAGENTA);
        coord4 = new Coordenada(x + 1,y + 1, Color.MAGENTA);
        shapeO[0] = coord1;
        shapeO[1] = coord2;
        shapeO[2] = coord3;
        shapeO[3] = coord4;
        shapes[2] = shapeO;
    }
    
    public void spawnBlockS(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.ORANGE);
        coord2 = new Coordenada(x + 1,y, Color.ORANGE);
        coord3 = new Coordenada(x,y+1, Color.ORANGE);
        coord4 = new Coordenada(x -1,y+1, Color.ORANGE);
        shapeS[0] = coord1;
        shapeS[1] = coord2;
        shapeS[2] = coord3;
        shapeS[3] = coord4;
        shapes[3] = shapeS;
    }
    
    public void spawnBlockZ(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.PINK);
        coord2 = new Coordenada(x + 1,y, Color.PINK);
        coord3 = new Coordenada(x+1,y+1, Color.PINK);
        coord4 = new Coordenada(x +2,y+1, Color.PINK);
        shapeZ[0] = coord1;
        shapeZ[1] = coord2;
        shapeZ[2] = coord3;
        shapeZ[3] = coord4;
        shapes[4] = shapeZ;
    }
    
    public void spawnBlockI(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.RED);
        coord2 = new Coordenada(x,y+1, Color.RED);
        coord3 = new Coordenada(x,y+2, Color.RED);
        coord4 = new Coordenada(x,y+3, Color.RED);
        shapeI[0] = coord1;
        shapeI[1] = coord2;
        shapeI[2] = coord3;
        shapeI[3] = coord4;
        shapes[5] = shapeI;
    }
    
    public void spawnBlockT(Coordenada pivo)
    {
        int x = pivo.getX();
        int y = pivo.getY();
        coord1 = new Coordenada(x,y, Color.YELLOW);
        coord2 = new Coordenada(x + 1,y, Color.YELLOW);
        coord3 = new Coordenada(x + 1,y+1, Color.YELLOW);
        coord4 = new Coordenada(x+2,y, Color.YELLOW);
        shapeT[0] = coord1;
        shapeT[1] = coord2;
        shapeT[2] = coord3;
        shapeT[3] = coord4;
        shapes[6] = shapeT;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int rand = generator.nextInt(shapes.length);
        drawShape(g, shapes[rand]);
    }
}

