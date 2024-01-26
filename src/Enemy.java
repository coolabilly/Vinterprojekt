import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Enemy {

    boolean isAlive = true;
    public int health = 25;

    public Color color;
    Random rand = new Random();
    public int yPos = rand.nextInt(2, 6);
    public int xPos = rand.nextInt(5, 9);

    public int direction;

    public Enemy(Color color) {
        this.color = color;
    }

    public void move(int width, int height, KeyEvent e) {
        direction = rand.nextInt(1, 5);
        switch (direction) {
            case 1:
                yPos--;
                if (this.yPos > height) this.yPos = height;
                break;
            case 2:
                yPos++;
                if (this.yPos < 0) this.yPos = 0;
                break;
            case 3:
                xPos--;
                if (this.xPos < 0) this.xPos = 0;
                break;
            case 4:
                xPos++;
                if (this.xPos < width) this.xPos = width;
                break;
        }

    }

    public void drawEnemy(Graphics g, int gridSize) {
        g.setColor(this.color);
        g.fillRect(this.xPos * gridSize, this.yPos * gridSize, this.health, this.health);
        System.out.println(this.xPos * gridSize + " " + this.yPos * gridSize);
    }
}
