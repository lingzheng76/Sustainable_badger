package com.sustain.scene;

import java.util.ArrayList;
import java.util.Random;

import com.sustain.item.Trash;

import processing.core.PApplet;
import processing.core.PImage;

public class TrashBin extends PApplet {
	private PImage logo;
	private PImage bin1;
	private PImage bin2;
	private PImage bin3;
	private ArrayList<Trash> trash; // holds all trash items

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
		logo = loadImage("images/rheta.png");
		logo.resize(320, 300);
		bin1 = loadImage("images/bin1.png");
		bin1.resize(100, 200);
		bin2 = loadImage("images/bin2.png");
		bin2.resize(100, 200);
		bin3 = loadImage("images/bin3.png");
		bin3.resize(100, 200);

		this.trash = new ArrayList<Trash>();
		Trash.setProcessing(this);

		Random rand = new Random();

		int[] composed = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };
		int[] recycled = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };
		int[] wasted = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };

		Trash composed1 = new Trash("compost", composed[0], 150, 350, 100, 100);
		Trash composed2 = new Trash("compost", composed[1], 300, 350, 100, 100);
		Trash recylced1 = new Trash("recyclable", recycled[0], 450, 350, 100,
				100);
		Trash recylced2 = new Trash("recyclable", recycled[1], 150, 500, 100,
				100);
		Trash trash1 = new Trash("food", wasted[0], 300, 500, 100, 100);
		Trash trash2 = new Trash("food", wasted[1], 450, 500, 100, 100);

		trash.add(composed1);
		trash.add(composed2);
		trash.add(recylced1);
		trash.add(recylced2);
		trash.add(trash1);
		trash.add(trash2);
	}

	/**
	 * Constantly draw the logo and all the things in the ArrayList
	 */
	@Override
	public void draw() {
		background(201, 233, 246);
		image(logo, 480, 300);

		image(bin1, 150, 50);
		image(bin2, 300, 50);
		image(bin3, 450, 50);

		for (Trash t : trash) {
			t.update();
		}

	}

	public static void main(String[] args) {
		/** start the application */
		PApplet.main("TrashBin");

		// TODO Auto-generated method stub

	}

}
