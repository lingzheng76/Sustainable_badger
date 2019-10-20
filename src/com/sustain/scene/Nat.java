package com.sustain.scene;

import java.awt.Image;
import java.util.ArrayList;

import com.sustain.item.Transport;
import com.sustain.main.MainFrame;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

/**
 * This file makes the user play the transportsation game
 * 
 * @author Lingzheng He
 *
 */
public class Nat extends PApplet {
	public static double emission;
	private static MainFrame parent;
	private static PImage mapImage;// the background image of the room
	private ArrayList<Transport> transports; // holds all transportsation
												// methods
	private Transport transport;
	private boolean arrived;

	public static void init(MainFrame parent) {
		Nat.parent = parent;
	}

	@Override
	public void settings() {
		super.settings();
		mapImage = new PImage(loadImage("images/nat.png").get().getImage()
				.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
		transports = new ArrayList<Transport>(4);
		transports.add(new Transport("walk", this));
		transports.add(new Transport("bike", this));
		transports.add(new Transport("bus", this));
		transports.add(new Transport("car", this));
		transport = transports.get(0);
		Transport.x = 500;
		Transport.y = 500;
		size(800, 600);
	}

	@Override
	public void setup() {
		textSize(50);
	}

	@Override
	public void keyPressed() {
		if (keyPressed && !arrived) {
			switch (key) {
				case 'w':
					transport = transports.get(0);
					break;
				case 'e':
					transport = transports.get(1);
					break;
				case 'r':
					transport = transports.get(2);
					break;
				case 't':
					transport = transports.get(3);
					break;
			}
		}
	}

	public void checkArrive() {
		int x = Transport.x;
		int y = Transport.y;
		if (110 < x && x < 130 && 150 < y && y < 160) {
			text("You arrived Natatorium!", 150, 150);
			arrived = true;
			Transport trans = transports.get(2);
			double bus = (trans.totalX + trans.totalY) * 0.4;
			trans = transports.get(3);
			double car = (trans.totalX + trans.totalY) * 0.9;
			emission = bus + car;
		}
	}

	@Override
	public void draw() {
		image(mapImage, 0, 0); // draw the background
		keyPressed();
		if (!arrived)
			transport.update();
		checkArrive();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKey() == 'q') {
			parent.setVisible(true);
			surface.setVisible(false);
			stop();
		}
	}

	public static String getReuslt() {
		String str =  String.format(
				"You produced %.2f gram carbon emission when going to the Nat!\n",
				emission);
		emission = 0;
		return str;
	}
}
