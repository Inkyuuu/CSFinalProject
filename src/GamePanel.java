import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel implements Runnable{
    private Image[] bkg = new Image[8];
    public static final int WIDTH = 560;
    public static final int HEIGHT = 290;
    public static final Dimension d = new Dimension(560, 290);
    Thread gameThread;
    public final int REFRESH = 60;
    Timer timer;
    private int i = 0;
    ArrayList <Projectile>proj = new ArrayList<Projectile>();
    ArrayList <Player> players = new ArrayList<Player>();
    Player p = new Player(this);
    Background b = new Background();
    public GamePanel(){
        this.setOpaque(true);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
        addKeys();
        players.add(p);
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        b.drawBkg(g);
        p.draw(g);
        if(proj.size() > 0){
            for(Projectile p : proj){
                p.draw(g);
            }
        }
    }
    public void checkCollisions(){
        if(proj.size() > 0){
            for(int i = 0; i < proj.size(); i++){
                if(proj.get(i).getDir() == 1 && proj.get(i).getX() > WIDTH){
                    proj.remove(i);
                }
                else if(proj.get(i).getDir() == 0 && proj.get(i).getX() < 0){
                    proj.remove(i);
                }
            }
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double drawInterval = 1000000000/REFRESH;
        double delta = 0;
        long timer = 0;
        long currentTime;
        long drawCount = 0;
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
    

            //update and draw
        }
        // TODO Auto-generated method stub
        
    }
    public void update(){
        p.update();
        if(proj.size() > 0){
            for(Projectile p : proj){
                p.update();
            }
        }
        checkCollisions();
    }

    private void addKeys() {
		// this connects keystroke with a command
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rt_key");
		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "lt_key");
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "rt_key_r");
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "lt_key_r");
        this.getInputMap().put(KeyStroke.getKeyStroke("ESC"), "esc_key");
        this.getInputMap().put(KeyStroke.getKeyStroke(' '), "space_key");
        this.getActionMap().put("space_key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
                Projectile t = new Projectile(p.x);
                proj.add(t);
			}
		});
		this.getActionMap().put("esc_key", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hit esc key");
                
			}
		});
		this.getActionMap().put("lt_key_r", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setDir(2);
			}
		});
		this.getActionMap().put("rt_key_r", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setDir(2);
			}
		});
		this.getActionMap().put("rt_key",new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.setDir(1);
			}
		});
		this.getActionMap().put("lt_key",new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.setDir(0);
			}
		});
        for(Object key:this.getInputMap().keys())
             System.out.println(this.getInputMap().get((KeyStroke) key));
	}

}

