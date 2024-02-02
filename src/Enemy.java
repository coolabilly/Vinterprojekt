import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Enemy {

    boolean isAlive = true;
    public int health = 25;

    public int bulletY;
    public int bulletX;

    public Color color;
    Random rand = new Random();
    public int yPos = rand.nextInt(2, 6);
    public int xPos = rand.nextInt(5, 9);

    public int direction;


    public Enemy(Color color) {
        this.color = color;
    }

    public void move(int width, int height) {
        direction = rand.nextInt(1, 5);

        switch (rand.nextInt(1, 5)) {
            case 1 -> {
                if (this.xPos != width - 1) this.xPos++;
            }
            case 2 -> {
                if (this.xPos != 0) this.xPos--;
            }
            case 3 -> {
                if (this.yPos != height - 2) this.yPos++;
            }
            case 4 -> {
                if (this.yPos != 0) this.yPos--;
            }
        }
    }

    public void setColor(Color color) {
        this.color = Color.black;
    }

    public void drawEnemy(Graphics g, int gridSize) {
        g.setColor(this.color);
        g.fillRect(this.xPos * gridSize + (25 - this.health)/2, this.yPos * gridSize, this.health, this.health);
        //System.out.println(this.xPos * gridSize + " " + this.yPos * gridSize);
    }

    public void enemyShoot (){
        bulletY = yPos;
        bulletX = xPos;
    }

    public void moveBullet(){
        bulletY++;
    }

    public void drawBullet(Graphics g, int gridSize) {
        g.setColor(Color.yellow);
        g.fillRect(bulletX * gridSize + gridSize / 2 - 2, bulletY * gridSize, 4, 15);
    }


    public void isHit(){
        health = health - 9;
    }
    public void death(){
        if (isAlive == false) {

        }
    }
}
