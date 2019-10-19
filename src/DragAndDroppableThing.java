//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DragAndDroppableThing
// Files: DragAndDroppableThing.java
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
/**
 * This method extends DraggableThing and allows users to specify a target for this kind of thing to
 * be dropped on along with an action that is produced when this happens.
 * 
 * @author Carrie Chen
 * @author Yiping He
 *
 */
public class DragAndDroppableThing extends DraggableThing {

    private VisibleThing target; // object over which this object can be dropped
    private Action action; // action that results from dropping this object over target

    /**
     * This method is a constructor of DraggableThing and initializes the object
     * 
     * @param name - the name that will be assigned to the object
     * @param x - the horizontal position that will be assigned to the object
     * @param y - the vertical position that will be assigned to the object
     * @param target - the target of the object
     * @param action - the action of the object
     */
    public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
        super(name, x, y); // call the constructor of DraggableThing
        this.action = action; // assign the action to the object
        this.target = target; // assign the target to the object

    }

    /* (non-Javadoc)
     * @see DraggableThing#drop()
     */
    @Override
    protected Action drop() {
        // if this object is over its target and its target is active
        if (target != null && this != null && target.isActive() && isOver(target)) {
            target.deactivate(); // deactivate the target
            this.deactivate(); // deactivate the object
            return action; // return the action
        }
        return null; // otherwise return null
    } 
}
