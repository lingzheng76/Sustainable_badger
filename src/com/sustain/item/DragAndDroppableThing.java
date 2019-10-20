//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DragAndDroppableThing
// Files:           DragAndDroppableThing.java
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

/**
 * A class that represents draggable and droppable things
 * 
 * @author Zhaoyi
 */
public class DragAndDroppableThing extends DraggableThing {
  private VisibleThing target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object over target

  /**
   * Construct a draggable and droppable thing at specified position and with specified action
   * 
   * @param name   name of this thing
   * @param x      x coordinate
   * @param y      y coordinate
   * @param target target thing to drop onto
   * @param action action to perform when dropped
   */
  public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) { // initialize
                                                                                                // new
                                                                                                // object
    super(name, x, y);
    this.target = target;
    this.action = action;
  }

  /**
   * Determine if this thing is on its target and if so deactivate both this thing and the target
   * 
   * @return an action to perform when this thing is dropped
   */
   @Override
  protected Action drop() { // returns action and deactivates objects in response to successful drop
                            // When this object is over its target and its target is active:
                            // deactivate both this object and the target object, and return action,
                            // otherwise return null
    // if this thing is over the target and the target is active
    if (isOver(target) && this.isActive()) {
      // deactivate both of them
      this.deactivate();
//      target.deactivate();
      return action;
    } else {
      return null;
    }
  }
}
