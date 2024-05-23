import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Game extends JFrame {
    public static void runGame() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space shooter");
        window.setSize(425, 400);
        window.setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.add(new Canvas());
    }


}
