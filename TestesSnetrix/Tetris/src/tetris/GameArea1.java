
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;
import java.util.ArrayList;

public class GameArea1 extends JPanel
{
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    
    private static int getRandom(int min, int max) {
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
}
    
    // shape feito, nesse caso um L, o que tem que descobrir é como gerar esse shape nesse formato ai, de colunas
    public Shape shapeA = generate(getRandom(2,4));
    
    
    public static Shape generate(int size, Color color) {
        ArrayList<Coordinate> blocks = new ArrayList<Coordinate>();
        Coordinate latestBlock = new Coordinate(0, 0);
        blocks.add(latestBlock);
        int minX, maxX, minY, maxY;
        minX = maxX = minY = maxY = 0;
        

        Coordinate newBlock;
        for (int i = 0; i < size; i++) {
            newBlock = latestBlock.clone();
            newBlock = newBlock.towards(Direction.randomDirection());
            if (blocks.contains(newBlock)) {
                i--; // se o bloco sorteado já existir na lista, sortear de novo
            } else {
                blocks.add(newBlock);
                latestBlock = newBlock;

                // atualizar valores mínimos e máximos
                if (newBlock.x < minX) {
                    minX = newBlock.x;
                } else if (newBlock.x > maxX) {
                    maxX = newBlock.x;
                }

                if (newBlock.y < minY) {
                    minY = newBlock.y;
                } else if (newBlock.y > maxY) {
                    maxY = newBlock.y;
                }
            }
        }

        // calcular altura e largura
        int width = maxX - minX + 1;
        int heigth = maxY - minY + 1;

        // usar o block mais pra esquerda e mais pra cima como origem
        // isso vai facilitar o posicionamento dos shapes na tela
        for (Coordinate coord : blocks) {
            coord.x -= minX;
            coord.y -= minY;
        }

        return new Shape(blocks, color, width, heigth);
    }

    public Shape generate(int size) {
        return generate(size, RandomColor.generate());
    }
    
    public GameArea1(JPanel placeholder, int columns)
    {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        
        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
    } 
    
   
    private void drawShape2(Graphics g, ArrayList<Coordinate> shapeV)
    {
        Color c = shapeA.getColor();
        for (int a = 0; a < shapeV.size(); a++)
        {
            int x = (shapeV.get(a).x) * gridCellSize;
            int y = (shapeV.get(a).y) * gridCellSize; 
            g.setColor(c);
                        g.fillRect(x,y, gridCellSize, gridCellSize);
                        g.setColor(Color.black);
                        g.drawRect(x,y, gridCellSize, gridCellSize);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        drawShape2(g, shapeA.getShape());
    }
}

