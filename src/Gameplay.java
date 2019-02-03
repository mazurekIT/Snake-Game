import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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

    private int enemyxpos[]={25,50,75,100,125,150,175,200,225,250,275,300,
    325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,
            750,775,800,825,850};
    private int enemyypos[]={25,50,75,100,125,150,175,200,225,250,275,300,
            325,350,375,400,425,450,475,500,525,550,575,600,625};

    private ImageIcon enemyimage;
    private Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);



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

        enemyimage = new ImageIcon("assets/enemy.png");



        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (right) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] + 25;
                } else {
                    snakexlength[r] = snakexlength[r - 1];
                }

                if (snakexlength[r] > 850) {
                    snakexlength[r] = 25;
                }
            }
            repaint();
        }

        if (left) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] - 25;
                } else {
                    snakexlength[r] = snakexlength[r - 1];
                }

                if (snakexlength[r] < 25) {
                    snakexlength[r] = 850;
                }
            }
            repaint();
        }

        if (up) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] - 25;
                } else {
                    snakeylength[r] = snakeylength[r - 1];
                }

                if (snakeylength[r] < 75) {
                    snakeylength[r] = 625;
                }
            }
            repaint();
        }

        if (down) {
            for (int r = lengthofsnake - 1; r >= 0; r--) {
                snakexlength[r + 1] = snakexlength[r];
            }
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] + 25;
                } else {
                    snakeylength[r] = snakeylength[r - 1];
                }

                if (snakeylength[r] > 625) {
                    snakeylength[r] = 75;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
