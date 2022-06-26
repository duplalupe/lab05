import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import interfaces.Observer;
import interfaces.strategy.Insert;

public class ShapePanel extends JPanel implements Observer, Insert {
    private final Color BACKGROUND_COLOR = new Color(67, 76, 94);
    private final int DEFAULT_NUMBER_OF_SHAPES = 3;

    private int numberOfShapes;
    private Shape[] shapes;
    private ShapeGenerator generator;
    private RandomColor color;

    public ShapePanel(){
        this.numberOfShapes = DEFAULT_NUMBER_OF_SHAPES;
        this.shapes = new Shape[numberOfShapes];
        this.setBackground(BACKGROUND_COLOR);
    }

    private Shape shape1 = ShapeGenerator.getInstance().generate(4, color.generate());
    private Shape shape2 = ShapeGenerator.getInstance().generate(4, color.generate());
    private Shape shape3 = ShapeGenerator.getInstance().generate(4, color.generate());

    private void drawShape(Graphics g, ArrayList<Coordinate> shapeV, int add, Color c) {
        for (int a = 0; a < shapeV.size(); a++) {
            System.out.println(shapeV.get(a));
            int x = ((shapeV.get(a).x) * 20) + (add/4);
            int y = ((shapeV.get(a).y) * 20) + add;
            g.setColor(c);
            g.fillRect(x,y, 20, 20);
            g.setColor(Color.black);
            g.drawRect(x,y, 20, 20);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShape(g, shape1.getShape(), 100, shape1.getColor());
        drawShape(g, shape2.getShape(), 200, shape2.getColor());
        drawShape(g, shape3.getShape(), 300, shape3.getColor());
        //System.out.println(shape1.getShape());
    }

    @Override // Observer
    public void update(){
        ShapeHunter.getInstance().notifyUpdate();
    }

    @Override
    public void insert() {
        // TODO Auto-generated method stub
        
    }
}
