import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JPanel implements KeyListener {
    Player p = new Player();

    Enemy[] enemies = new Enemy[]{new Enemy(Color.yellow), new Enemy(Color.RED)};

    int gridSize = 25;
    public int width = 425;
    public int height = 400;

    public Canvas() {
        this.setBounds(0, 0, width, height);
        this.setBackground(Color.black);
        this.addKeyListener(this);
        this.setFocusable(true);
    }


    private void Draw(Graphics g) {
        p.drawPlayer(g, gridSize);

        for (Enemy enemy: enemies) {
            enemy.drawEnemy(g, gridSize);
        }

         if (Player.shoot) p.drawBullet(g, gridSize);

    }

    public void update(double deltaTime){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus(true);
        Draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {
       p.move(e, this.width, this.height, enemies);
       p.playerShoot(e);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}


