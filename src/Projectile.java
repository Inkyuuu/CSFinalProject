import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
public class Projectile {
    private int velocity;
    private int dmg;
    private int x;
    private static int HEIGHT = 220;
    private Image [] imgs0 = new Image[7];
    private Image [] imgs1 = new Image[7];
    private int dir; //0 is left, 1 is right
    private int i = 0;
    public Projectile(int x){
        velocity = 4;
        this.x = x;
        dmg = 20;
        dir = 1;
        loadFire();
    }
    public void loadFire(){
            for(int j = 0; j < 7; j++){
                File f = new File("images/fireball images/fireball-" + 0 + "-"+ j + ".png"); 
                try {
                    Image img = ImageIO.read(f);
                    imgs0[j] = img;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for(int j = 0; j < 7; j++){
                File f = new File("images/fireball images/fireball-" + 1 + "-"+ j + ".png"); 
                try {
                    Image img = ImageIO.read(f);
                    imgs1[j] = img;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }
    public void draw(Graphics g){
        if(dir == 0){
            g.drawImage(imgs0[i%imgs0.length], x, HEIGHT, null);
            i++;
        }
        else{
            g.drawImage(imgs1[i%imgs1.length], x, HEIGHT, null);
            i++;
        }
    }
    public int getX(){
        return x;
    }
    public int getDir(){
        return dir;
    }
    public void update(){
        if(dir == 0){
            x  -= velocity;
        }
        else{
            x += velocity;
        }
    }
}
