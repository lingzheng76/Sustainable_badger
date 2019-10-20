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
	private int x = 400; // x-axis
	private int y = 350; // y-axis
	private int velX = 0, velY = 0;
	private PImage badgerImage;
	private PApplet processing;

	public Badger(PApplet processing) {
		this.processing = processing;
		badgerImage = processing.loadImage("images/badger.png");

	}

	public void update() {
		keyPressed();
		processing.image(badgerImage, x, y);
	}

	public void keyPressed() {
		if (processing.keyPressed && processing.key == processing.CODED) {
			if (processing.keyCode == processing.LEFT) {
				x = x - 2;
			}
			if (processing.keyCode == processing.RIGHT) {
				x = x + 2;
			}
			if (processing.keyCode == processing.UP) {
				y = y - 2;
			}
			if (processing.keyCode == processing.DOWN) {
				y = y + 2;
			}
		}
	}

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
