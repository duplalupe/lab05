
package tetris;
import java.awt.Color;


public class Coordenada {
    int x;
    int y;
    Color color;
    
    
    public Coordenada(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setX(int val)
    {
        this.x = val;
    }
    
    public void setY(int val)
    {
        this.y = val;
    }
}
