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
	public boolean isOn;
	private int height;
	private int width;
	// private int rotations;
	public String type;

	// initializes the fields of a new bed object positioned in the center of the
	// display
	public Furniture(String type, int height, int width) {
		/** initalize processing */
		this.processing = processing;
		isOn = true;
		/** set up the bed image */

		// /**draw the image at the center of the display*/
		// processing.image(image, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
		this.type = type;
		// /** set up the position of the furniture */
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
		// this.image = processing.loadImage("images/"+type+".png");
		/** draw the image at the center of the display */
		// processing.image(image, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
		this.type = type;
		/** set up the position of the furniture */
		position = new float[] { x, y };
		this.height = height;
		this.width = width;

	}

	// draws this bed at its current position
	public void update() {
		// // /** track the position of the mouse when the furniture is being dragged */
		// if (isMouseOver() && processing.mousePressed) {
		// if (!isOn) {
		// isOn = true;
		//
		// }
		// else {
		// isOn = false;
		// removeFur();
		// }
		// // position[0] = processing.mouseX;
		// // position[1] = processing.mouseY;
		// }

		/** draw the furniture at the current position */
		processing.image(image, position[0], position[1]);

	}

//	private void removeFur() {
//		// TODO Auto-generated method stub
//
//	}

	/**
	 * set the size of the image
	 */
	// public void resize(int x, int y) {
	// height = x;
	// width = y;
	//
	// }

	// // used to start dragging the bed, when the mouse is over this bed when it is
	// // pressed
	// public void mouseDown(Furniture furniture[]) {
	// /** modify is dragging */
	// isOn = true;
	//
	// }
	//
	// // used to indicate that the bed is no longer being dragged
	// public void mouseUp() {
	// /** reset isOn with the mouse up */
	// isOn = false;
	// }

	// helper method to determine whether the mouse is currently over this bed
	public boolean isOver(Badger badger) {
		// /** set up height and width of the furniture */
		// float height = image.height;
		// float width = image.width;
		// /**
		// * check if the furniture has been rotated and modify the height and width if
		// * that is the case
		// */
		// if (image.height > image.width) {
		// height = width;
		// width = image.height;
		// }
		int height = badger.getHeight();
		int width = badger.getWidth();
		int x = badger.getPosX();
		int y = badger.getPosY();
		boolean xNotOverlap = // true if other is next to but not overlapping with this thing
				x >= (position[0] + this.width) || (x + width) <= position[0];
		boolean yNotOverlap = // true if other is above or below but not overlapping with this thing
				position[1] >= (y + height) || (position[1] + this.height) <= y;
		return !(xNotOverlap || yNotOverlap);

		// /**
		// * check if the mouse in the range of the furniture and return T/F
		// respectively
		// */
		// if ((position[0] - width / 2) < processing.mouseX && processing.mouseX <
		// (position[0] + width / 2)
		// && (position[1] - height / 2) < processing.mouseY && (position[1] +
		// this.height / 2) > processing.mouseY) {
		// return true;
		// } else {
		// return false;
		// }
	}

	// //rotate the furniture
	// public void rotate() {
	// /**implement the parameter rotations*/
	// ++rotations;
	// /**draw the bed after rotating it*/
	// processing.image(image, position[0], position[1], position[2]*PApplet.PI/2);
	// }
	//
	// public int getRotation() {
	// return rotations;
	// }
	//
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
