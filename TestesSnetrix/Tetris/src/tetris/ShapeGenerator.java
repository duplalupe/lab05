
package tetris;
import java.awt.Color;
import java.util.ArrayList;


public class ShapeGenerator {
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
}
