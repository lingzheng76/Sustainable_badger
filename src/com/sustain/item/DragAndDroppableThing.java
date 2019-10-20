package com.sustain.item;

public class DragAndDroppableThing extends DraggableThing {

	private VisibleThing target; // object over which this object can be dropped
	private Action action; // action that results from dropping this object over
							// target

	/**
	 * This method is a constructor of DraggableThing and initializes the object
	 * 
	 * @param name   - the name that will be assigned to the object
	 * @param x      - the horizontal position that will be assigned to the
	 *               object
	 * @param y      - the vertical position that will be assigned to the object
	 * @param target - the target of the object
	 * @param action - the action of the object
	 */
	public DragAndDroppableThing(String name, int x, int y, VisibleThing target,
			Action action) {
		super(name, x, y); // call the constructor of DraggableThing
		this.action = action; // assign the action to the object
		this.target = target; // assign the target to the object

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DraggableThing#drop()
	 */
	@Override
	protected Action drop() {
		// if this object is over its target and its target is active
		if (target != null && this != null && target.isActive()
				&& isOver(target)) {
			target.deactivate(); // deactivate the target
			this.deactivate(); // deactivate the object
			return action; // return the action
		}
		return null; // otherwise return null
	}
}
