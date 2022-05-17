import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
public class main {
    public static void main(String[] args) {
        final Dimension d = new Dimension(560, 310);
        JFrame gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setSize(d);
        gameFrame.setResizable(false);
        GamePanel game = new GamePanel();
        gameFrame.add(game); gameFrame.setVisible(true); game.requestFocusInWindow();
        game.startGameThread();


        
}
}
