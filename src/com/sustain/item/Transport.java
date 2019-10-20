package com.sustain.item;

import java.awt.Image;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This file represents different methods of transportation
 * 
 * @author Lingzheng He
 *
 */
public class Transport extends VisibleThing {
	private PApplet processing;
	private PImage image;
	public static int x = 500, y = 500;
	public int totalX, totalY;

	public Transport(String type, PApplet processing) {
		this.processing = processing;
		image = new PImage(processing.loadImage("images/" + type + ".jpg")
				.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	}

	public Action update() {
		keyPressed();
		if (x >= 749) {
			x = 749;
		}
		if (x <= 0) {
			x = 0;
		}
		if (y >= 548) {
			y = 548;
		}
		if (y <= 0) {
			y = 0;
		}
		processing.image(image, x, y);
		return null;
	}

	public void keyPressed() {
		if (processing.keyPressed && processing.key == PApplet.CODED) {
			if (processing.keyCode == PApplet.LEFT) {
				x = x - 2;
				totalX += 2;
			}
			if (processing.keyCode == PApplet.RIGHT) {
				x = x + 2;
				totalX += 2;
			}
			if (processing.keyCode == PApplet.UP) {
				y = y - 2;
				totalY += 2;
			}
			if (processing.keyCode == PApplet.DOWN) {
				y = y + 2;
				totalY += 2;
			}
		}
	}
}
