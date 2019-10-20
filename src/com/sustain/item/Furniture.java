package com.sustain.item;

import processing.core.PApplet;
import processing.core.PImage;

public class Furniture {
	/** declare variables needed in the class Furniture */
	private static PApplet processing = null;
	private PImage image;
	private float[] position;
	// public boolean isOn;
	private int height;
	private int width;
	// private int rotations;
	public String type;

	// initializes the fields of a new bed object positioned in the center of
	// the
	// display
	public Furniture(String type, int height, int width) {
		this.type = type;

		/** set up the position of the furniture */
		position = new float[] { processing.width / 2, processing.height / 2 };

		this.height = height;
		this.width = width;
	}

	public Furniture(String type, float x, float y, int height, int width) {

		/** set up the bed image */
		this.image = processing.loadImage("images/" + type + ".jpeg");
		image.resize(height, width);

		this.type = type;

		/** set up the position of the furniture */
		position = new float[] { x, y };

		this.height = height;
		this.width = width;

	}

	// draws this bed at its current position
	public void update() {
		/** draw the furniture at the current position */
		processing.image(image, position[0], position[1]);

	}

	// helper method to determine whether the mouse is currently over this bed
	public boolean isOver(Badger badger) {

		int height = badger.getHeight();
		int width = badger.getWidth();
		int x = badger.getPosX();
		int y = badger.getPosY();

		boolean leftof = ((x + (0.5 * width)) < (position[0]
				- (0.5 * this.width)));
		boolean rightof = ((x - (0.5 * width)) > (position[0]
				+ (0.5 * this.width)));
		boolean above = ((y - (0.5 * height)) > (position[1]
				+ (0.5 * this.height)));
		boolean below = ((y + (0.5 * height)) < (position[1]
				- (0.5 * this.height)));
		return !(leftof == true || rightof == true || above == true
				|| below == true);
	}

	/**
	 * Set the processing field of the thing
	 * 
	 * @param processing the reference to the processing of the escape room
	 */
	public static void setProcessing(PApplet processing) { // initializes
															// processing field
		Furniture.processing = processing;
	}

	/**
	 * Return the reference to the processing of the escape room
	 * 
	 * @return the reference to the processing of the escape room
	 */
	protected static PApplet getProcessing() { // accessor method to retrieve
												// this static field
		return Furniture.processing;
	}

	public float[] getPosition() {
		return position;
	}
}
