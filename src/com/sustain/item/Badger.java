package com.sustain.item;

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
//	private int velX = 0, velY = 0;
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
		if (processing.keyPressed && processing.key == PApplet.CODED) {
			if (processing.keyCode == PApplet.LEFT) {
				x = x - 2;
			}
			if (processing.keyCode == PApplet.RIGHT) {
				x = x + 2;
			}
			if (processing.keyCode == PApplet.UP) {
				y = y - 2;
			}
			if (processing.keyCode == PApplet.DOWN) {
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
