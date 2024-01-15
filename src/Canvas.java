import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JPanel implements KeyListener {
    Player p= new Player();

    int gridSize = 25;
    int width = 425;
    int height = 400;
   public Canvas(){
       this.setBounds(0,0, width,height);
       this.setBackground(Color.black);
       this.addKeyListener(this);
       this.setFocusable(true);
   }

   private void Draw(Graphics g) {
       g.setColor(Color.white);
       g.fillRect(p.xPos * gridSize, p.yPos * gridSize, p.health, p.health);
       System.out.println(p.xPos * gridSize + " " + p.yPos * gridSize);
   }
   @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
       Draw(g);
   }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            p.yPos --;
            if (p.yPos < 0) p.yPos = 0;
            System.out.println("W");
        }
        if (e.getKeyChar() == 's') {
            p.yPos ++;
            if (p.yPos > height) p.yPos = height;
            System.out.println("S");
        }
        if (e.getKeyChar() == 'd') {
            p.xPos ++;
            if (p.xPos > width) p.xPos = width;
            System.out.println("D");
        }
        if (e.getKeyChar() == 'a') {
            p.xPos --;
            if(p.xPos < 0) p.xPos = 0;
            System.out.println("A");
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}


