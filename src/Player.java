import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
public class Player extends Entity {
    GamePanel gp;
    final int GROUND = 255;
    private int slow = 10;
    private Image[] img = new Image[19*slow];
    private int i = 0;
    private int health = 100;
    private int dir = 2; //0 is left, 1 is right, 2 is facing front
    private boolean isHit;
    public void getSpriteSheet(){
        if(spriteSheet == null){
            File f = new File("images/character spritesheets/spritesheet v.1.png");
        try {
            spriteSheet = ImageIO.read(f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
    public void loadImageSprites(){
        int imgX = 0;
        int imgY = 0;
        for(int j = 0; j < 19*slow; j+=slow){
           Image i = ((BufferedImage)spriteSheet).getSubimage(imgX,imgY,SQUARE_X,SQUARE_Y);
           for(int k = 0; k < slow; k++){
               img[j+k] = i;
           }
           imgX += SQUARE_X;
        }
    }
    public Player(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
        getSpriteSheet();
        loadImageSprites();
    }
    public void setDefaultValues(){
        x = 10;
        y = GROUND-65;
        speed = 2;
    }
    public void update(){
        if(dir == 0){
            setX(-speed);
        }
        else if(dir == 1){
            setX(speed);
        }

    }
    public void setDir(int d){
        dir = d;
    }
    public void setX(int move){
        x += move;
    }
    public void draw(Graphics g){
        //if(dir == 2){
            g.drawImage(img[i%img.length], x, y, null);
            i++;
        //}
    }
}
