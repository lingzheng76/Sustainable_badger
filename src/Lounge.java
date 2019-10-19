import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 */

/**
 * @author Xiaoqi
 *
 */
public class Lounge extends PApplet {
	/** initialize variables */
	private PImage backgroundImage;// the background image of the room
	private ArrayList<Furniture> furnitures; // holds all furnitures in the room

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
		
		
		if (!furnitures.isEmpty()) {
			for (Furniture fur : furnitures) {
				fur.update();
			}
		}
		mousePress();
		badger.update();
	}

	public void mousePress() {
		if (keyPressed) {
			if (fire.isOver(badger) && key == ' ') {
				if (!fire.isOn) {
					fire.isOn = true;
					furnitures.add(fire);
				} else {
					fire.isOn = false;
					furnitures.remove(fire);
				}
			}

			else if (tv.isOver(badger) && key == ' ') {
				if (!tv.isOn) {
					tv.isOn = true;
					furnitures.add(tv);
				} else {
					tv.isOn = false;
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
		// /** add a new bed when the key is pressed */
		// /** initialize counter */
		// int j;
		// /** loop through furniture */
		// for (j = 0; j < furnitures.size(); j++) {
		// /** check if the key "d" is being pressed */
		// if (processing.key == 'd' || processing.key == 'D') {
		// if (furnitures.get(j).isMouseOver()) {
		// /** delete the furniture if that is the case */
		// furnitures.remove(j);
		// /** break to prevent multiple furniture to be deleted simultaneously */
		// break;
		// }
		// }
	}

	// }

	// /**
	// * This method creates a new Furniture[] for the old mouseDown() methods to
	// make
	// * use of. It does so by copying all Furniture references from this.furnitures
	// * into a temporary array of size MAX_LOAD_FURNITURE.
	// *
	// * @return that array of Furniture references.
	// */
	// private Furniture[] extractFurnitureFromGUIObjects() {
	// Furniture[] furniture = new Furniture[MAX_LOAD_FURNITURE];
	// int nextFreeIndex = 0;
	// for (int i = 0; i < furnitures.size() && nextFreeIndex < furniture.length;
	// i++)
	// if (furnitures.get(i) instanceof Furniture)
	// furniture[nextFreeIndex++] = (Furniture) furnitures.get(i);
	// return furniture;
	// }

	// /**
	// * This method first removes all Furniture references from this.furnitures,
	// and
	// * then adds back in all of the non-null references from it's parameter.
	// *
	// * @param furniture
	// * contains the only furniture that will be left in this.furnitures
	// * after this method is invoked (null references ignored).
	// */
	// private void removeFur(Furniture[] furniture) {
	// for (int i = 0; i < furnitures.size(); i++)
	// if (furnitures.get(i) instanceof Furniture)
	// furnitures.remove(i--);
	// for (int i = 0; i < furniture.length; i++)
	// if (furniture[i] != null)
	// furnitures.add(furniture[i]);
	// }
	// // start reading file contents
	// Scanner fin = null;
	// int lineNumber = 1; // report first line in file as lineNumber 1
	// try {
	// fin = new Scanner(new File(filename));
	//
	// // read and store background image
	// String backgroundImageFilename = fin.nextLine().trim();
	// backgroundImageFilename = "images" + File.separator + backgroundImageFilename
	// + ".png";
	// backgroundImage = loadImage(backgroundImageFilename);
	// lineNumber++;
	//
	// // read and print out introductory text
	// String introductoryText = fin.nextLine().trim();
	// System.out.println(introductoryText);
	// lineNumber++;
	//
	//
	//
	// // catch and report warnings related to any problems experienced loading this
	// file
	// } catch (FileNotFoundException e) {
	// System.out.println("WARNING: Unable to find or load file: " + filename);
	// } catch (RuntimeException e) {
	// System.out.println("WARNING: Problem loading file: " + filename + " line: " +
	// lineNumber);
	// e.printStackTrace();
	// } finally {
	// if (fin != null)
	// fin.close();
	// }
	// }
	// public Main(PApplet processing) {
	// /**initialize processing*/
	// this.processing = processing;
	// /** set up the background color*/
	// processing.background(95, 158, 160);
	// /**set up the background image*/
	// backgroundImage = processing.loadImage("images/background.jpeg");
	// /**draw the background image */
	// processing.image(backgroundImage, processing.width / 2, processing.height /
	// 2);
	//
	//
	// }

	protected Badger getbadger() {
		return badger;
	}
	// private boolean isOver() {
	// // TODO Auto-generated method stub
	//
	// if ()
	// return false;
	// }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** start the application */
		PApplet.main("Lounge");
	}

}
