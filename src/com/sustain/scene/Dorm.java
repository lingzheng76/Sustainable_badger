package com.sustain.scene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.sustain.item.Badger;
import com.sustain.item.Furniture;
import com.sustain.main.MainFrame;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

/**
 * @author Xiaoqi
 *
 */
public class Dorm extends PApplet {
	private static MainFrame parent;
	/** initialize variables */
	private ArrayList<Furniture> furnitures; // holds all furniture in the room

	private static PImage backgroundImage;// the background image of the room
	private static PImage on;
	private static PImage off;
	private Furniture tv;
	private Furniture fire;
	private static boolean save;

	protected Badger badger;

	public static String getResult() {
		String str = String.format("You %s the energy for the dorm!\n",
				save ? "saved" : "did not save");
		save = false;
		return str;
	}

	/**
	 * Sets the window
	 */
	@Override
	public void settings() {
		size(800, 600);
	}

	private static void initImage() {
		try {
			on = new PImage(ImageIO.read(new File("images/dorm.jpeg")));
			off = new PImage(ImageIO.read(new File("images/light.jpeg")));
			backgroundImage = on;
		} catch (IOException e) {
			System.err.println("Cannot load dorm.jpeg or light.jpeg");
			System.exit(-1);
		}
	}

	public static void init(MainFrame parent) {
		initImage();
		on.resize(800, 600);
		off.resize(800, 600);
		Dorm.parent = parent;
		backgroundImage = on;
	}

	/**
	 * Called once as long as the program starts
	 */
	@Override
	public void setup() {
		furnitures = new ArrayList<Furniture>();
		Furniture.setProcessing(this);
		badger = new Badger(this);

		// light.resize();
		tv = new Furniture("tv", 325, 220, 140, 80);
		furnitures.add(tv);
		// tv.resize(100, 50);
		fire = new Furniture("fire", 300, 370, 190, 150);
		furnitures.add(fire);
		// fire.resize(200, 150);
	}

	/**
	 * Constantly draw the background and all the things in the ArrayList
	 */
	@Override
	public void draw() {
		image(backgroundImage, 0, 0); // draw the background

		mousePress();
		if (!furnitures.isEmpty()) {
			for (Furniture fur : furnitures) {
				fur.update();
			}
		}

		badger.update();
	}

	public void mousePress() {
		if (keyPressed) {
			if (fire.isOver(badger)) {
				if (!furnitures.contains(fire) && key == 'o') {
					// fire.isOn = true;
					furnitures.add(fire);
				} else if (key == 'c') {
					// fire.isOn = false;
					furnitures.remove(fire);
				}
			}

			else if (tv.isOver(badger)) {
				if (!furnitures.contains(tv) && key == 'o') {
					furnitures.add(tv);
				} else if (key == 'c') {
					furnitures.remove(tv);
				}
			}

			else if (key == 'c') {
				backgroundImage = off;
			} else if (key == 'o') {
				backgroundImage = on;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKey() == 'q') {
			parent.setVisible(true);
			save = !furnitures.contains(fire) || !furnitures.contains(tv)
					|| backgroundImage == off;
			surface.setVisible(false);
			backgroundImage = on;
			stop();
		}
	}
}
