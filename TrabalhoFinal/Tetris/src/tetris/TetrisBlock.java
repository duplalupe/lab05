
package tetris;

import java.awt.Color;

public class TetrisBlock 
{
    private int[][] shape;
    private Color color;
    private int x,y;
    
    public TetrisBlock(int[][] shape, Color color)
    {
        this.shape = shape;
        this.color = color;
        x = 2;
        y = 2;
    }
    
    public int[][] getShape() { return shape;}
    
    public Color getColor() { return color;}
    
    public int getHeight() {return shape.length;}
    
    public int getWidth() {return shape[0].length;}
    
    public int getX() { return x;}
    public void setX(int val) {this.x = val;}
    
    public int getY() { return y;} 
    public void setY(int val) {this.y = val;}
    
    //public int getAdjacent();

    void getAdjacent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
