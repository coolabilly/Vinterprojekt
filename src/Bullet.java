import java.awt.*;

public class Bullet {

    int xPos;
    int yPos;

     Color color;
    public Bullet(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void move(){
        this.yPos++;
    }

    public void draw(Graphics g, int gridSize) {
        g.setColor(Color.yellow);
        g.fillRect(this.xPos * gridSize + gridSize / 2 - 2, this.yPos * gridSize, 4, 15);
    }

    public void destroy() {
        this.color = Color.black;
    }
}
