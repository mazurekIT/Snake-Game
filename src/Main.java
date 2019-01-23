
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();


        obj.setBounds(10,10,1000,700);
        obj.setBackground(Color.BLACK);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        obj.add(gameplay);

    }
}
