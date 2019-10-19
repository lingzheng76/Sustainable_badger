//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Escape Room
// Files: Thing.java
// Course: CS 300, 2019 Spring
//
// Author: Carrie Chen
// Email: ychen792@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Partner Name: Yiping He
// Partner Email: yhe262@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
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

/**
 * This class organizes the capabilities that are common to all interactive things in our game.
 * 
 * @author Carrie Chen
 * @author Yiping He
 *
 */

public class Thing {
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with
  private static PApplet processing = null;

  /**
   * initialize name, and set isActive to true
   * 
   * @param name name of the thing
   */
  public Thing(String name) {
    NAME = name;
    isActive = true;
  }

  /**
   * default constructor
   */
  public Thing() {
    NAME = "";
    isActive = true;
  }

  /**
   * returns true only when contents of name equal NAME
   * 
   * @param name the name used to compare
   * @return true/false if contents of name equal/don't equal NAME
   */
  public boolean hasName(String name) {
    if (name.equals(NAME)) {// if the NAME of this Thing matches the name parameter
      return true;
    }
    return false;// if it doesn't return false
  }

  /**
   * returns true only when isActive is true
   * 
   * @return if the Thing is active
   */
  public boolean isActive() {
    if (isActive) {
      return true; // returns true only when isActive is true
    }
    return false;
  }

  /**
   * changes isActive to true
   */
  public void activate() {
    isActive = true;// change isActive to true
  }

  /**
   * changes isActive to false
   */
  public void deactivate() {
    isActive = false;// changes isActive to false
  }

  /**
   * this method returns null, subclass types will override this update() method to do more
   * interesting things
   * 
   * @return null
   */
  public Action update() {
    return null;
  }

  /** initializes processing field
   * @param processing
   */
  public static void setProcessing(PApplet processing) {
    Thing.processing = processing;
  } 

  /** accessor method to retrieve this static field
   * @return processing this static fild
   */
  protected static PApplet getProcessing() {
    return processing;
  } 
}
