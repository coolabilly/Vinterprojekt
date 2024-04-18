import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Canvas extends JPanel implements ActionListener {
    Player p = new Player(this);
    public ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList();
    int gridSize = 25;
    public int width = 425;
    public int height = 400;
    int enemyAmount = 3;

    Timer timer;

    public double frames = 0;

    public Canvas() {
        this.setBounds(0, 0, width, height);
        this.setBackground(Color.black);
        this.addKeyListener(new MyKeyAdapter());
        this.setFocusable(true);

        for (int i = 0; i < 3; i++) {
            enemies.add(new Enemy());
        }
        timer = new Timer(50, this);
        timer.start();
    }


    private void Draw(Graphics g) {

        p.drawPlayer(g, gridSize);

        for (Enemy enemy : enemies) {
            enemy.drawEnemy(g, gridSize);
        }

        for (Bullet bullet : bullets) {
            bullet.draw(g, gridSize);
        }

        if (Player.shoot) p.drawBullet(g, gridSize);


    }

    public void update() {
        this.frames++;

        if (this.frames % Enemy.moveSpeed == 0) {
            for (Enemy enemy : enemies) {
                enemy.move(width, height);
            }
        }

        if (this.frames % Enemy.shootingSpeed == 0) {
            for (Enemy enemy : enemies) {
                bullets.add(new Bullet(enemy.xPos, enemy.yPos, Enemy.color, "down"));
            }
        }


        for (Bullet bullet : bullets) {
            bullet.move(frames);
        }

        p.checkCollision(enemies, bullets);
        p.moveBullet();

        enemyLvlUp();


        if (this.frames == 30) this.frames = 0;
    }

    public void removeBullet(Bullet bullet) {
        this.bullets.remove(bullet);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    public void enemyLvlUp() {
        if (enemies.isEmpty()) {
            Enemy.levelUp();
            enemyAmount++;
            for (int i = 0; i < enemyAmount; i++) {
                enemies.add(new Enemy());
            }
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus(true);
        Draw(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }


    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            p.move(e, width, height, enemies);
            p.playerShoot(e, bullets);
            repaint();
        }

    }


}


