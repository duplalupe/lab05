
package tetris;


import java.awt.Point;

public class Coordinate extends Point {
    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Coordinate clone(){
        return new Coordinate(this.x, this.y);
    }

    public Coordinate towards(Direction dir){
        switch(dir){
            case UP -> {
                return new Coordinate(x, y -= 1);
            }
            case DOWN -> {
                return new Coordinate(x, y += 1);
            }
            case RIGHT -> {
                return new Coordinate(x += 1, y);
            }
            case LEFT -> {
                return new Coordinate(x -= 1, y);
            }
        }
        return new Coordinate(x,y);
    }
}