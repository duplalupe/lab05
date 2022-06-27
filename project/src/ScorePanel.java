import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import java.awt.Color;
import java.awt.Graphics;

public class ScorePanel extends JPanel {
    private final Color BACKGROUND_COLOR = new Color(175, 179, 188);
    // private final Color BACKGROUND_COLOR = new Color(76, 86, 106);
    private int currentScore = 0;
    private String scoreString;

    private void drawScore(int increment, Graphics g) {
        int score = currentScore + increment;
        g.drawString(Integer.toString(score), 115, 25);
        currentScore = score;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font myFont = new Font("Courier", Font.BOLD, 15);
        g.setFont(myFont);
        g.drawString("Pontuação: ", 25, 25);
        g.drawString("High Score: ", 500, 25);
        drawScore(50, g);
    }
}
