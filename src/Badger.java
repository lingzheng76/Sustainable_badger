import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This file displays a badger image and reads keyboard input
 * to move the badger
 * 
 * add this class in the scene
 * 
 * @author Lingzheng
 *
 */
public class Badger extends JPanel implements ActionListener, KeyListener{
  private Timer tm = new Timer(5, this); // ActionListener
  // TODO: change the coordinates
  private int x = 0; // x-axis
  private int y = 20; // y-axis
  private int velX = 0, velY = 0;
  private BufferedImage badgerImage;
  
  public Badger() {
    tm.start();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false); // turn off ctrl, alt keys
    try{
      badgerImage = ImageIO.read(new File("C:\\Users\\mic\\eclipse-workspace\\Hackthon\\src\\rsz_initialBadger.png"));
    } catch(IOException e) {e.printStackTrace();}
    
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    ImageIcon i = new ImageIcon(badgerImage);
    i.paintIcon(this, g, x, y);
  }
   
  @Override
  public void actionPerformed(ActionEvent e) {
    if (x < 0) {
      velX = 0;
      x = 0;
    }
    if (x > 350) {
      velX = 0;
      x = 350;
    }
    x = x + velX;
    y = y + velY;
    repaint();
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode(); // get the key user pressed
    if (key == KeyEvent.VK_LEFT) {
      System.out.println("left pressed");
      velX = velX - 1;
      velY = 0;
    }
    if (key == KeyEvent.VK_RIGHT) {
      System.out.println("right pressed");
      velX = velX + 1;  
      velY = 0;
    }
    //TODO: use initial value
    if (key == KeyEvent.VK_UP) {
      velX = 0;
      velY++;
    }
  }  

  
  @Override
  public void keyReleased(KeyEvent e) {
    velX = 0;
    velY = 0;
    
    
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
}
