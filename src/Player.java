import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class Player {
    public int yPos = 12;
    public int xPos = 8;
    public int bulletY;
    public int bulletX;
    public int health = 25;
    int score = 0;
    public static boolean shoot = false;


    public Player() {
    }

    boolean isAlive = true;

    public void drawPlayer(Graphics g, int gridSize) {
        if(isAlive == true) {
            g.setColor(Color.white);
            g.fillRect(this.xPos * gridSize, this.yPos * gridSize, this.health, this.health);
            System.out.println(this.xPos * gridSize + " " + this.yPos * gridSize);
        }
    }

    public void move(KeyEvent e, int width, int height, ArrayList<Enemy> enemies) {

        if (e.getKeyChar() == 'w') {
            this.yPos--;
            if (this.yPos < 0) this.yPos = 0;
            System.out.println("W");
        }
        if (e.getKeyChar() == 's') {
            this.yPos++;
            if (this.yPos > height) this.yPos = height;
            System.out.println("S");
        }
        if (e.getKeyChar() == 'a') {
            this.xPos--;
            if (this.xPos < 0) this.xPos = 0;
            System.out.println("A");
        }
        if (e.getKeyChar() == 'd') {
            this.xPos++;
            if (this.xPos > width) {
                this.xPos = width;
                while (true) {
                    System.out.println("NOOOOOO");
                }
            }
            System.out.println("D");
        }

    }

    public void playerShoot(KeyEvent e, ArrayList<Bullet> bullets) {
        if (e.getKeyChar() == 'h') {
            bullets.add(new Bullet(this.xPos, this.yPos, Color.white, "up" ));
        }
    }

    public void moveBullet() {
        bulletY--;
    }

    public void drawBullet(Graphics g, int gridSize) {
        g.setColor(Color.white);
        g.fillRect(bulletX * gridSize + gridSize / 2 - 2, bulletY * gridSize, 4, 15);
    }

    public void checkCollision(ArrayList<Enemy> enemies, ArrayList<Bullet> bullets) {
        for (Enemy enemy : enemies) {
            //Checks collision with enemy
            if (this.xPos == enemy.xPos && this.yPos == enemy.yPos) {
                this.isAlive = false;
                break;
            }
           for (Bullet bullet : bullets) {
               if (this.bulletY == enemy.yPos && this.bulletX == enemy.xPos) {
                   enemy.isHit();
                   System.out.println("Hej");
                   score++;
               }
           }
        }
    }
}

