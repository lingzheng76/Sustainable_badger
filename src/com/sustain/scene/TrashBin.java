import java.util.ArrayList;
import java.util.*;
import processing.core.PApplet;
import processing.core.PImage;

public class TrashBin extends PApplet {
	private PImage logo;
	private VisibleThing bin1;
	private VisibleThing bin2;
	private VisibleThing bin3;
	private ArrayList<Thing> allThings; // holds all trash items

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

		DragAndDroppableThing composed1 = new DragAndDroppableThing("compost" + composed[0], 150, 350, bin1, null);
		DragAndDroppableThing composed2 = new DragAndDroppableThing("compost" + composed[1], 300, 350, bin1, null);
		DragAndDroppableThing recylced1 = new DragAndDroppableThing("recyclable" + recycled[0], 450, 350, bin2, null);
		DragAndDroppableThing recylced2 = new DragAndDroppableThing("recyclable" + recycled[1], 150, 500, bin2, null);
		DragAndDroppableThing trash1 = new DragAndDroppableThing("food" + wasted[0], 300, 500, bin3, null);
		DragAndDroppableThing trash2 = new DragAndDroppableThing("food" + wasted[1], 450, 500, bin3, null);

		allThings.add(bin1);
		allThings.add(bin2);
		allThings.add(bin3);
		allThings.add(composed1);
		allThings.add(composed2);
		allThings.add(recylced1);
		allThings.add(recylced2);
		allThings.add(trash1);
		allThings.add(trash2);
	}

	/**
	 * Constantly draw the logo and all the things in the ArrayList
	 */
	@Override
	public void draw() {
		background(201, 233, 246);
		image(logo, 480, 300);
		// iterate the allThings list to update each item
		for (int i = 0; i < allThings.size(); i++) {
			Action actionObj = allThings.get(i).update();
			// act allThings if the actionObj is not null
			// remove the items that are not active
			if (!allThings.get(i).isActive()) {
				allThings.remove(i);
				i--;
			}
		}

	}

	public static void main(String[] args) {
		/** start the application */
		PApplet.main("TrashBin");

		// TODO Auto-generated method stub

	}

}
