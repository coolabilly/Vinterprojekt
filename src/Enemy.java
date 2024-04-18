import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Enemy {

    boolean isAlive = true;
    public int health = 25;

    static int enemyLevel = 0;
    static int shootingSpeed = 20;
    static int moveSpeed = 20;

    int killedEnemies = 0;

    public int bulletY;
    public int bulletX;

    static Color color = Color.yellow;
    Random rand = new Random();
    public int yPos = rand.nextInt(2, 6);
    public int xPos = rand.nextInt(5, 9);

    public int direction;

    public Enemy() {

    }


    static void levelUp() {
        enemyLevel++;
        switch (enemyLevel) {
            case 1:
                moveSpeed -= 5;
                shootingSpeed -= 5;
                color = Color.blue;
                System.out.println("lvl 2");
                break;

            case 2:
                moveSpeed -= 5;
                shootingSpeed -= 5;
                color = Color.green;
                System.out.println("lvl3");
                break;

            case 3:
                moveSpeed -= 5;
                shootingSpeed -= 5;
                color = Color.red;
                System.out.println("lvl4");
                break;
        }
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

    public void isHit(){
        isAlive = false;
        killedEnemies++;
    }

    public void drawEnemy(Graphics g, int gridSize) {
        if (isAlive == true) {
            g.setColor(color);
            g.fillRect(this.xPos * gridSize + (25 - this.health) / 2, this.yPos * gridSize, this.health, this.health);
            //System.out.println(this.xPos * gridSize + " " + this.yPos * gridSize);
        }
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

}
