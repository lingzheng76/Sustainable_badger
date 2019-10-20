package com.sustain.item;

import processing.core.PApplet;
import java.util.ArrayList;

public class Action extends PApplet {
    private Thing thing;

   
    /**
     * This method is a constructor of Action and initializes the object
     * 
     * @param thing the thing that will be assigned to the object
     */
    public Action(Thing thing) {
        this.thing = thing;
    }


    /**
     * This method changes the thing's status and prints the message
     * 
     * @param thingList the ArrayList that will be checked
     */
    public void act(ArrayList<Thing> thingList) {
        if (thingList != null && thing != null && !thing.isActive()) {
            thing.activate(); // active the thing
            thingList.add(thing); // add the thing to the thingList
            thing = null; // set thing to null
        }
    }
}
