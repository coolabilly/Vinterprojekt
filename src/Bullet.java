import java.awt.*;
import java.util.Objects;

public class Bullet {

    int xPos;
    int yPos;

    String dir;
    Color color;
    public Bullet(int xPos, int yPos, Color color, String dir){
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.dir = dir;
    }

    public void move(double frames){
        if (Objects.equals(this.dir, "up")) {
             this.yPos--;
        } else if (frames % 5 == 0){
            this.yPos++;
        }

    }

    public void draw(Graphics g, int gridSize) {
        g.setColor(color);
        g.fillRect(this.xPos * gridSize + gridSize / 2 - 2, this.yPos * gridSize, 4, 15);
    }

}
