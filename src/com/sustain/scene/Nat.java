package com.sustain.scene;

import java.awt.Image;
import java.util.ArrayList;

import com.sustain.item.Transport;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This file makes the user play the transportsation game
 * 
 * @author Lingzheng He
 *
 */

public class Nat extends PApplet {
	private static PImage mapImage;// the background image of the room
	private ArrayList<Transport> transports; // holds all transportsation
												// methods
	private Transport transport;

	@Override
	public void settings() {
		super.settings();
		mapImage = new PImage(loadImage("./src/images/nat.png").get().getImage()
				.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
		transports = new ArrayList<Transport>(4);
		transports.add(new Transport("walk", this));
		transports.add(new Transport("bike", this));
		transports.add(new Transport("bus", this));
		transports.add(new Transport("car", this));
		transport = transports.get(0);
		size(800, 600);
	}

	@Override
	public void setup() {
		textSize(50);
		// fill(0xffffff);
	}

	@Override
	public void keyPressed() {
		if (keyPressed) {
			System.out.println(key);
			switch (key) {
				case 'q':
					transport = transports.get(0);
					break;
				case 'w':
					transport = transports.get(1);
					break;
				case 'e':
					transport = transports.get(2);
					break;
				case 'r':
					transport = transports.get(3);
					break;
			}
		}
	}

	public void checkArrive() {
		int x = transport.x;
		int y = transport.y;
		if (110 < x && x < 130 && 150 < y && y < 160) {
			text("Boom!", 200F, 200F);
			System.out.println("arrive");
		}
	}

	@Override
	public void draw() {
		image(mapImage, 0, 0); // draw the background
		keyPressed();
		transport.update();
		checkArrive();
	}

	public static void main(String[] args) {
		PApplet.main("Nat");
	}

}
