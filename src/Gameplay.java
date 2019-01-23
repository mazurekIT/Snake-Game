import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private ImageIcon titleImage;


    public Gameplay() {


    }

    public void paint (Graphics g){
        //draw title image border
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);

        //draw title image
        titleImage = new ImageIcon("assets/snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);

        // draw border for gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24, 74 ,851 , 577);

        //draw bacground for bacground
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25, 75, 850, 575);
    }
}
