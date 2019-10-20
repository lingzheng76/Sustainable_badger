//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Action
// Files:           Action.java
// Course:        CS300, 2019 Spring
//
// Author:        Zhaoyi Zhang
// Email:           zzhang825@wisc.edu
// Lecturer's Name: Gary
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
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
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;

/**
 * A class that represent the action that a thing can do
 * 
 * @author  Zhaoyi
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
   * Print out the message and add the thing to the things ArrayList, if they are not null
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
