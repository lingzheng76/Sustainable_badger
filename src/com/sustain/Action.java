//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Action
// Files: Action.java
// Course: CS 300, 2019 Spring
//
// Author: Yiping He
// Email: yhe262@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Partner Name: Carrie Chen
// Partner Email: ychen792@wisc.edu
// Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import processing.core.PApplet;
import java.util.ArrayList;

/**
 * This class extends PApplet and represents the response to an object being clicked or dragged onto
 * another.
 * 
 * @author Carrie Chen
 * @author Yiping He
 *
 */
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
