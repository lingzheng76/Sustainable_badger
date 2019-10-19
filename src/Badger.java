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

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This file displays a badger image and reads keyboard input to move the badger
 * 
 * add this class in the scene
 * 
 * @author Lingzheng
 *
 */
public class Badger {
//	private Timer tm = new Timer(5, this); // ActionListener
	// TODO: change the coordinates
	private int x = 400; // x-axis
	private int y = 350; // y-axis
	private int velX = 0, velY = 0;
	private PImage badgerImage;
	private PApplet processing;

	public Badger(PApplet processing) {
		this.processing = processing;
//		tm.start();
//		addKeyListener(this);
//		setFocusable(true);
//		setFocusTraversalKeysEnabled(false); // turn off ctrl, alt keys
		badgerImage = processing.loadImage("images/badger.png");
		
	}

	public void update() {
		keyPressed();
		processing.image(badgerImage, x, y);
	}
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		ImageIcon i = new ImageIcon(badgerImage);
//		i.paintIcon(this, g, x, y);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (x < 0) {
//			velX = 0;
//			x = 0;
//		}
//		if (x > 350) {
//			velX = 0;
//			x = 350;
//		}
//		x = x + velX;
//		y = y + velY;
//		repaint();
//	}

//	@Override
	public void keyPressed() {
//		int key = e.getKeyCode(); // get the key user pressed
		if(processing.keyPressed && processing.key == processing.CODED) {
//			System.out.print("Pressed");
		if (processing.keyCode == processing.LEFT) {
			System.out.println("left pressed");
			x = x - 2;
			}
		if (processing.keyCode == processing.RIGHT) {
			System.out.println("right pressed");
			x = x + 2;
		}if (processing.keyCode == processing.UP) {
			System.out.println("up pressed");
			y = y - 2;
		}if (processing.keyCode == processing.DOWN) {
			System.out.println("up pressed");
			y = y + 2;
		}
		}
//		// TODO: use initial value
//		if (key == KeyEvent.VK_UP) {
//			velX = 0;
//			velY++;
//		}
	}

//	@Override
//	public void keyReleased(KeyEvent e) {
//		velX = 0;
//		velY = 0;
//
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}

	public int getHeight() {
		return badgerImage.height;
	}

	public int getWidth() {
		return badgerImage.width;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}
}
