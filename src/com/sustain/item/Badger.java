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
	private PImage badger_right;
	private PImage badger_left;
	private PImage badger;
	private PApplet processing;

	public Badger(PApplet processing) {
		this.processing = processing;
		badger_right = processing.loadImage(
				"C:\\Users\\mic\\eclipse-workspace\\Hackthon\\src\\images\\badger_right.png");
		badger_left = processing.loadImage(
				"C:\\Users\\mic\\eclipse-workspace\\Hackthon\\src\\images\\badger_left.png");
		badger = badger_right;
	}

	public void update() {
		String direction = keyPressed();
		if (x >= 652) {
			x = 652;
		}
		if (x <= 0) {
			x = 0;
		}
		if (y >= 350) {
			y = 350;
		}
		if (y <= 0) {
			y = 0;
		}

		if (direction == null) {
			processing.image(badger, x, y);
		} else if (direction.equals("right")) {
			badger = badger_right;
			processing.image(badger, x, y);
		} else if (direction.equals("left")) {
			badger = badger_left;
			processing.image(badger, x, y);
		}

	}

	public String keyPressed() {
		if (processing.keyPressed && processing.key == PApplet.CODED) {
			if (processing.keyCode == PApplet.LEFT) {
				x = x - 3;
				return "left";
			}
			if (processing.keyCode == PApplet.RIGHT) {
				x = x + 3;
				return "right";
			}
			if (processing.keyCode == PApplet.UP) {
				y = y - 3;
				return null;
			}
			if (processing.keyCode == PApplet.DOWN) {
				y = y + 3;
				return null;
			}
		}
		return null;
	}

	public int getHeight() {
		return badger.height;
	}

	public int getWidth() {
		return badger.width;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}
}
