package com.sustain.item;

import java.util.ArrayList;

/**
 * A class that represent the action that a thing can do
 * 
 * @author Zhaoyi
 */
public class Action {
	private String message; // message printed by this action (or null to do nothing)
	private Thing thing; // a Thing object as a result of this action

	/**
	 * Construct an action with only message
	 * 
	 * @param message message printed by this action (or null to do nothing)
	 */
	public Action(String message) { // initialize this new action
		this.message = message;
	}

	/**
	 * Construct an action with only thing
	 * 
	 * @param thing a Thing object as a result of this action
	 */
	public Action(Thing thing) {
		this.thing = thing;
	}

	/**
	 * Construct an action with message and thing
	 * 
	 * @param message message printed by this action (or null to do nothing)
	 * @param thing   a Thing object as a result of this action
	 */
	public Action(String message, Thing thing) {
		this.message = message;
		this.thing = thing;
	}

	/**
	 * Print out the message and add the thing to the things ArrayList, if they are
	 * not null
	 * 
	 * @param things the things that the room has
	 */
	public void act(ArrayList<Thing> things) { // when message is not null, message is printed to
												// System.out
		if (message != null) {
			System.out.println(message);
		}
		if (thing != null) {
			things.add(thing);
			thing.activate(); // activate the thing
			thing = null; // remove the thing so that it is only added to the room once
		}
	}
}
