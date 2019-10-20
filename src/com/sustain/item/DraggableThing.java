package com.sustain.item;

/**
 * This class extends VisibleThing and allows the user to drag the items around
 * the screen.
 * 
 */
public class DraggableThing extends VisibleThing {
	private boolean mouseWasPressed; // tracks whether the mouse was pressed
										// during the last
										// update()
	private boolean isDragging; // true when this object is being dragged by the
								// user
	private int oldMouseX; // horizontal position of mouse during last update
	private int oldMouseY; // vertical position of mouse during last update

	/**
	 * This method is a constructor of DraggableThing and initializes the object
	 * 
	 * @param name the name that will be assigned to the object
	 * @param x    the horizontal position that will be assigned to the object
	 * @param y    the vertical position that will be assigned to the object
	 */
	public DraggableThing(String name, int x, int y, int width, int height) {
		super(name, x, y, width, height); // calls the constructor of VisibleThing
		mouseWasPressed = false; // sets mouseWasPressed to false
		isDragging = false; // sets isDragging to false
		oldMouseX = x; // sets oldMouseX to x
		oldMouseY = y; // sets oldMouseY to y
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see VisibleThing#update()
	 */
	public Action update(int i) {
		Action actionUpdate = super.update(i); // calls VisibleThing update()
		if (getProcessing().mousePressed && !mouseWasPressed
				&& isOver(getProcessing().mouseX, getProcessing().mouseY)) {
			isDragging = true;
		} // sets isDragging to true if the mouse has been pressed
		if (isDragging) {
			this.move(getProcessing().mouseX - oldMouseX,
					getProcessing().mouseY - oldMouseY);
		} // moves the item if isDragging is true
		if (!getProcessing().mousePressed && mouseWasPressed) {
			isDragging = false;
			actionUpdate = this.drop(i);
		} // sets isDragging to false and drops the item if the mouse has been
			// released
		mouseWasPressed = getProcessing().mousePressed; // updates the
														// mouseWasPressed
		oldMouseX = getProcessing().mouseX; // updates the oldMouseX
		oldMouseY = getProcessing().mouseY; // updates the oldMouseY
		return actionUpdate;
	}

	/**
	 * This method returns null. Subclass types will override this drop() method
	 * to do more interesting things
	 * 
	 * @return
	 */
	protected Action drop(int i) {
		return null;
	} // this method returns null
		// subclass types will override this drop() method to do more
		// interesting things
}
