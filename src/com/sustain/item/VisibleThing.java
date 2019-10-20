package com.sustain.item;

import java.io.File;
import processing.core.PImage;

/**
 * This class extends Thing and represents a visible object with a graphical
 * representation in the game
 *
 * @author Carrie Chen
 * @author Yiping He
 * 
 */
public class VisibleThing extends Thing {
	private PImage image; // the graphical representation of this thing
	private int x; // the horizontal position (in pixels of this thing's left
					// side)
	private int y; // the vertical position (in pixels of this thing's top side)

	public VisibleThing(String name, int x, int y) {
		super(name); // call the constructor of Thing
		this.image = getProcessing()
				.loadImage("images" + File.separator + name + ".png");
		this.x = x;
		this.y = y;
	}

	/**
	 * This method is a constructor of VisibleThing and initializes the object
	 * 
	 * @param name the name that will be assigned to the object
	 * @param x    the horizontal position that will be assigned to the object
	 * @param y    the vertical position that will be assigned to the object
	 */
	public VisibleThing(String name, int x, int y, int width, int height) {
		super(name); // call the constructor of Thing
		this.image = getProcessing()
				.loadImage("images" + File.separator + name + ".png");
		image.resize(width, height);
		this.x = x;
		this.y = y;
		this.image.width = width;
		this.image.height = height;
	}

	/**
	 * This method is the default constructor of VisibleThing
	 * 
	 */
	public VisibleThing() {
		image = null;
		x = 0;
		y = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Thing#update()
	 */
	@Override
	public Action update(int i) {
		getProcessing().image(this.image, x, y);// draws image at its position
												// before returning null
		return null;
	}

	/**
	 * This method changes the position of the object
	 * 
	 * @param dx
	 * @param dy
	 */
	public void move(int dx, int dy) {
		x += dx; // changes x by adding dx to it
		y += dy; // changes y by adding dy to it
	}

	/**
	 * This method checks whether a point is over the image
	 * 
	 * @param x the horizontal position of the point
	 * @param y the vertical position of the point
	 * @return the result
	 */
	public boolean isOver(int x, int y) {
		if (x >= this.x && x <= (this.x + image.width) && y >= this.y
				&& y <= (this.y + image.height)) {
			return true; // return true only when point x,y is over image
		}
		return false;
	}

	/**
	 * This method checks whether an image is over another image
	 * 
	 * @param other the another image
	 * @return the result
	 */
	public boolean isOver(VisibleThing other) {
		int otherHeight = other.image.height;
		int otherWidth = other.image.width;
		int thisHeight = this.image.height;
		int thisWidth = this.image.width;
		if (other.x >= this.x - otherWidth && other.x <= this.x + thisWidth
				&& other.y <= this.y + thisHeight
				&& other.y >= this.y - otherHeight) {
			return true; // return true only when other's image overlaps this
							// one's
		}
		return false;
	}
}
