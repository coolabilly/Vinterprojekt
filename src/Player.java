import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class Player {

    Canvas canvas;
    public int yPos = 12;
    public int xPos = 8;
    public int bulletY;
    public int bulletX;
    public int health = 25;
    int score = 0;
    public static boolean shoot = false;

    private int playerScore = 0;


    public Player(Canvas canvas) {
        this.canvas = canvas;
    }

    boolean isAlive = true;

    //Method that draws player
    public void drawPlayer(Graphics g, int gridSize) {
        if (isAlive == true) {
            g.setColor(Color.white);
            g.fillRect(this.xPos * gridSize, this.yPos * gridSize, this.health, this.health);
            System.out.println(this.xPos * gridSize + " " + this.yPos * gridSize);
        }
    }

    //Method that let player move
    public void move(KeyEvent e, int width, int height, ArrayList<Enemy> enemies) {

        if (e.getKeyChar() == 'w') {
            this.yPos--;
            if (this.yPos < 0) this.yPos = 0;
        }
        if (e.getKeyChar() == 's') {
            this.yPos++;
            if (this.yPos > height) this.yPos = height;
        }
        if (e.getKeyChar() == 'a') {
            this.xPos--;
            if (this.xPos < 0) this.xPos = 0;
        }
        if (e.getKeyChar() == 'd') {
            this.xPos++;
            if (this.xPos > width) {
                this.xPos = width;
            }
        }
    }

    //Method that lets the player shoot if "h" is pressed
    public void playerShoot(KeyEvent e, ArrayList<Bullet> bullets) {
        if (e.getKeyChar() == 'h' && isAlive) {
            bullets.add(new Bullet(this.xPos, this.yPos, Color.white, "up"));
        }
    }

    //Method that moves the bullet
    public void moveBullet() {
        bulletY--;
    }

    //Method that draws the bullet
    public void drawBullet(Graphics g, int gridSize) {
        g.setColor(Color.white);
        g.fillRect(bulletX * gridSize + gridSize / 2 - 2, bulletY * gridSize, 4, 15);
    }

    //Method that checks collisions
    public void checkCollision(ArrayList<Enemy> enemies, ArrayList<Bullet> bullets) {
        for (int j = 0; j < enemies.size(); j++) {
            Enemy enemy = enemies.get(j);
            //Checks between player and enemy
            if (this.xPos == enemy.xPos && this.yPos == enemy.yPos) {
                isAlive = false;
            }
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                //Checks collision between bullet and enemy
                if (bullet.yPos == enemy.yPos && bullet.xPos == enemy.xPos) {
                    enemies.remove(enemy);
                    bullets.remove(bullet);
                    score++;
                    i--;
                    //Checks collision between enemy bullet and player
                } else if (bullet.yPos == this.yPos && bullet.xPos == this.xPos) {
                    this.isAlive = false;
                }
            }
        }



    }
}


