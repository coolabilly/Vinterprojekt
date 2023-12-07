import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space shooter");

        Gameboard Gameboard = new Gameboard();
        window.add(Gameboard);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}