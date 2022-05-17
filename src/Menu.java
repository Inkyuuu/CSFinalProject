import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class Menu extends JPanel{
    private Image [] imgs = new Image[5];
    private JButton [] buttons = new JButton[4];
    public Menu(){
        loadMenuImg();
        makeButtons();
    }
    public void loadMenuImg(){
        for(int i  = 0; i < 5; i++){
            File f = new File("menu_image_" + i + ".png");
            try {
                Image img = ImageIO.read(f);
                imgs [i] = img;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void makeButtons(){
        for(int i = 1; i < 5; i++){
            ImageIcon icon  = new ImageIcon(imgs[i]);
            JButton button = new JButton(icon);
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
            buttons[i-1] = button;
        }
    }
    public void drawMenu(Graphics g){
        g.drawImage(imgs[0], 0, 0, null);
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setVisible(true);
        }
    }
}
