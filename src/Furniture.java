import processing.core.PApplet;
import processing.core.PImage;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           furniture class
// Files:           DormGUI
// Course:          CS 300, Summer 2018
//
// Author:          Xiaoqi Li
// Email:           xli778@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Effy Chu
// Partner Email:   xchu6@wisc.edu
// Partner Lecturer's Name: 	Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
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

	// initializes the fields of a new bed object positioned in the center of the
	// display
	public Furniture(String type, int height, int width) {
		/** initalize processing */
		this.processing = processing;

		this.type = type;

		/** set up the position of the furniture */
		position = new float[] { processing.width / 2, processing.height / 2 };

		this.height = height;
		this.width = width;
	}

	public Furniture(String type, float x, float y, int height, int width) {
		/** initalize processing */
		this.processing = processing;

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

		boolean leftof = ((x + (0.5 * width)) < (position[0] - (0.5 * this.width)));
		boolean rightof = ((x - (0.5 * width)) > (position[0] + (0.5 * this.width)));
		boolean above = ((y - (0.5 * height)) > (position[1] + (0.5 * this.height)));
		boolean below = ((y + (0.5 * height)) < (position[1] - (0.5 * this.height)));
		return !(leftof == true || rightof == true || above == true || below == true);
	}

	/**
	 * Set the processing field of the thing
	 * 
	 * @param processing
	 *            the reference to the processing of the escape room
	 */
	public static void setProcessing(PApplet processing) { // initializes processing field
		Furniture.processing = processing;
	}

	/**
	 * Return the reference to the processing of the escape room
	 * 
	 * @return the reference to the processing of the escape room
	 */
	protected static PApplet getProcessing() { // accessor method to retrieve this static field
		return Furniture.processing;
	}

	public float[] getPosition() {
		return position;
	}
}
