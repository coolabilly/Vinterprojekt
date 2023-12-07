import javax.swing.*;
import java.awt.*;

public class Gameboard extends JPanel {
    int tileSize = 48;
    int columns = 9 ;
    int rows = 10;
    int screenWidth = tileSize * columns;
    int sceeenHeight = tileSize * rows;

    public Gameboard (){
        this.setPreferredSize(new Dimension(screenWidth, sceeenHeight));
        this.setBackground(Color.black);
    }

}
