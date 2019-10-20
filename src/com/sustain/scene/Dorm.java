package com.sustain.scene;

import java.util.ArrayList;

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
	public static MainFrame parent;
	/** initialize variables */
	private PImage backgroundImage;// the background image of the room
	private ArrayList<Furniture> furnitures; // holds all furniture in the room

	private PImage on;
	private PImage off;
	private boolean lightOff;
	private Furniture tv;
	private Furniture fire;

	protected Badger badger;

	/**
	 * Sets the window
	 */
	@Override
	public void settings() {
		size(800, 600);
	}

	/**
	 * Called once as long as the program starts
	 */
	@Override
	public void setup() {
		on = loadImage("images/background.jpeg");
		on.resize(800, 600);
		backgroundImage = on;
		furnitures = new ArrayList<Furniture>();
		Furniture.setProcessing(this);
		badger = new Badger(this);

		off = loadImage("images/light.jpeg");
		off.resize(800, 600);
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
//		System.out.println(furnitures.size());
		if (!furnitures.isEmpty()) {
			for (Furniture fur : furnitures) {
//				System.out.println(fur.type);
				fur.update();
			}
		}

		badger.update();
	}

	public void mousePress() {
		if (keyPressed) {
			if (fire.isOver(badger) && key == ' ') {
				if (!furnitures.contains(fire)) {
//					fire.isOn = true;
					furnitures.add(fire);
				} else {
					System.out.println("fire off");
//					fire.isOn = false;
					furnitures.remove(fire);
				}
			}

			else if (tv.isOver(badger) && key == ' ') {
				if (!furnitures.contains(tv)) {
					furnitures.add(tv);
				} else {
					furnitures.remove(tv);
				}
			}

			else if (key == ' ') {
				if (!lightOff) {
					lightOff = true;
					backgroundImage = off;
				} else {
					lightOff = false;
					backgroundImage = on;
				}
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKey() == 'q') {
			parent.setVisible(true);
			surface.setVisible(false);
		}
	}

	protected Badger getbadger() {
		return badger;
	}
}
