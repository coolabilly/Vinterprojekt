import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Canvas extends JPanel implements ActionListener {
    Player p = new Player();
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList();
    int gridSize = 25;
    public int width = 425;
    public int height = 400;

    Timer timer;

    public double frames = 0;

    public Canvas() {
        this.setBounds(0, 0, width, height);
        this.setBackground(Color.black);
        this.addKeyListener(new MyKeyAdapter());
        this.setFocusable(true);

        for (int i = 0; i < 3; i++) {
            enemies.add(new Enemy(Color.yellow));
        }
        timer = new Timer(50, this);
        timer.start();
    }


    private void Draw(Graphics g) {

        p.drawPlayer(g, gridSize);

        for (Enemy enemy : enemies) {
            enemy.drawEnemy(g, gridSize);
        }

        for(Bullet bullet: bullets) {
            bullet.draw(g, gridSize);
        }

        if (Player.shoot) p.drawBullet(g, gridSize);


        }

    public void update() {
        this.frames++;

        if (this.frames % 10 == 0) {
            for (Enemy enemy : enemies) {
                enemy.move(width, height);
            }
        }

        if (this.frames == 10) {
            for (Enemy enemy : enemies) {
                bullets.add(new Bullet(enemy.xPos, enemy.yPos, Color.yellow, "down"));
            }
        }


        for(Bullet bullet : bullets) {
            bullet.move(frames);
        }

        p.checkCollision(enemies, bullets);
        p.moveBullet();


        if (this.frames == 30) this.frames = 0;
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

            if (e.getKeyChar() == 'o') enemies.add(new Enemy(Color.red));
        }

    }


}


