package com.sustain.item;

/**
 * A class that represents draggable and droppable things
 * 
 * @author Zhaoyi
 */
public class DragAndDroppableThing extends DraggableThing {
	private VisibleThing target; // object over which this object can be dropped
	private Action action; // action that results from dropping this object over
							// target

	/**
	 * Construct a draggable and droppable thing at specified position and with
	 * specified action
	 * 
	 * @param name   name of this thing
	 * @param x      x coordinate
	 * @param y      y coordinate
	 * @param target target thing to drop onto
	 * @param action action to perform when dropped
	 */
	public DragAndDroppableThing(String name, int x, int y, VisibleThing target,
			Action action, int width, int height) { // initialize
		// new
		// object
		super(name, x, y, width, height);
		this.target = target;
		this.action = action;
	}

	/**
	 * Determine if this thing is on its target and if so deactivate both this
	 * thing and the target
	 * 
	 * @return an action to perform when this thing is dropped
	 */
	@Override
	protected Action drop(int i) { // returns action and deactivates objects in
									// response to successful drop
									// When this object is over its target and
									// its
									// target is active:
									// deactivate both this object and the
									// target
									// object, and return action,
									// otherwise return null
		// if this thing is over the target and the target is active
		if (isOver(target)) {
			// deactivate both of them
			if (i == 0 && this.isActive()) {
				this.deactivate();
				return action;
			} else if (i == 1 && target.isActive()) {
				target.deactivate();
				return action;
			}
		}
		return null;
	}
}
