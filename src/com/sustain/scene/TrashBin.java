package com.sustain.scene;

import java.util.ArrayList;
import java.util.Random;

import com.sustain.item.DragAndDroppableThing;
import com.sustain.item.Thing;
import com.sustain.item.VisibleThing;
import com.sustain.main.MainFrame;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class TrashBin extends PApplet {
	private static MainFrame parent;
	private PImage logo;
	private VisibleThing bin1;
	private VisibleThing bin2;
	private VisibleThing bin3;
	private ArrayList<Thing> allThings; // holds all trash items
	public static int score;

	public static void init(MainFrame parent) {
		TrashBin.parent = parent;
	}

	public static String getResult() {
		String str = String
				.format("You correctly sort %d trashes in Rheta's!\n", score);
		score = 0;
		return str;
	}

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
		this.allThings = new ArrayList<Thing>();
		Thing.setProcessing(this);

		logo = loadImage("images/rheta.png");
		logo.resize(320, 300);
		bin1 = new VisibleThing("bin1", 100, 50, 130, 250);
		bin2 = new VisibleThing("bin2", 300, 50, 130, 250);
		bin3 = new VisibleThing("bin3", 500, 50, 130, 250);
		;

		Random rand = new Random();

		int[] composed = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };
		int[] recycled = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };
		int[] wasted = { rand.nextInt(2) + 1, rand.nextInt(2) + 3 };

		DragAndDroppableThing composed1 = new DragAndDroppableThing(
				"compost" + composed[0], 150, 350, bin1, null, 120, 120);
		DragAndDroppableThing composed2 = new DragAndDroppableThing(
				"compost" + composed[1], 300, 350, bin1, null, 120, 120);
		DragAndDroppableThing recylced1 = new DragAndDroppableThing(
				"recyclable" + recycled[0], 450, 350, bin3, null, 120, 120);
		DragAndDroppableThing recylced2 = new DragAndDroppableThing(
				"recyclable" + recycled[1], 150, 500, bin3, null, 120, 120);
		DragAndDroppableThing trash1 = new DragAndDroppableThing(
				"food" + wasted[0], 300, 500, bin2, null, 120, 120);
		DragAndDroppableThing trash2 = new DragAndDroppableThing(
				"food" + wasted[1], 450, 500, bin2, null, 120, 120);

		allThings.add(bin1);
		allThings.add(bin2);
		allThings.add(bin3);
		allThings.add(composed1);
		allThings.add(composed2);
		allThings.add(recylced1);
		allThings.add(recylced2);
		allThings.add(trash1);
		allThings.add(trash2);
		textSize(50);
	}

	/**
	 * Constantly draw the logo and all the things in the ArrayList
	 */
	@Override
	public void draw() {
		background(201, 233, 246);
		image(logo, 480, 300);
		// iterate the allThings list to update each item
		if (allThings.size() == 3) {
			text("All Done!\nCongrats!!", 200, 350);
		}
		for (int i = 0; i < allThings.size(); i++) {
			allThings.get(i).update(0);
			// act allThings if the actionObj is not null
			// remove the items that are not active
			text(score, 700, 60);
			if (!allThings.get(i).isActive()) {
				allThings.remove(i);
				i--;
				score++;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKey() == 'q') {
			parent.setVisible(true);
			surface.setVisible(false);
			stop();
		}
	}
}
