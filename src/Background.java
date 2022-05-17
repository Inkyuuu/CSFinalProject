import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Background {
    private Image[] bkg = new Image[8];
    public static final Dimension d = new Dimension(560, 290);
    private int i = 0;
    public final int REFRESH = 60;
    Timer timer;
    public Background(){
        loadImages();
        timer = new Timer(REFRESH, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				i++;
			}
		});
        timer.start();

    }
    public void loadImages(){
        for(int i = 0; i < 8; i++){
            File f = new File("images/bkg/frame_" + i + "_delay-0.1s.png");
            try {
                Image img = ImageIO.read(f);
                bkg[i] = img;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void drawBkg(Graphics g){
        g.drawImage(bkg[i%bkg.length], 0, 0, null);
    }

}
