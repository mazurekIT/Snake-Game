import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;

    private int lengthofsnake = 3;

    private Timer timer;
    private int delay = 100;
    private ImageIcon snakeimage;

    private int moves = 0;


    private ImageIcon titleImage;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;
        }


        //draw title image border
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);

        //draw title image
        titleImage = new ImageIcon("assets/snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);

        // draw border for gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);

        //draw bacground for bacground
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25, 75, 850, 575);

        rightmouth = new ImageIcon("assets/rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        for (int i = 0; i < lengthofsnake; i++) {
            if (i == 0 && right) {
                rightmouth = new ImageIcon("assets/rightmouth.png");
                rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
            }
            if (i == 0 && left) {
                leftmouth = new ImageIcon("assets/leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
            }
            if (i == 0 && up) {
                upmouth = new ImageIcon("assets/upmouth.png");
                upmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
            }
            if (i == 0 && down) {
                downmouth = new ImageIcon("assets/downmouth.png");
                downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
            }

            if (i != 0) {
                snakeimage = new ImageIcon("assets/snakeimage.png");
                snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);

            }
        }


        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
