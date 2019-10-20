package com.sustain.scene;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.sustain.item.Action;
import com.sustain.item.DragAndDroppableThing;
import com.sustain.item.Thing;
import com.sustain.item.VisibleThing;
import com.sustain.main.MainFrame;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

public class PlantTree extends PApplet {
	private static MainFrame parent;
	public static int planted;
	private PImage backgroundImage; // The background image of the game
	private ArrayList<Thing> allThings; // Create an ArrayList to store all
										// items that will be
										// displayed in the game

	public static void init(MainFrame parent) {
		PlantTree.parent = parent;
	}

	public static String getResult() {
		String str = String.format(
				"You have planted %d trees to protect the nature perserve!\n",
				planted);
		planted = 0;
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see processing.core.PApplet#settings()
	 */
	@Override
	public void settings() {
		size(800, 600); // Set the size of the game window
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see processing.core.PApplet#setup()
	 */
	@Override
	public void setup() {
		Thing.setProcessing(this);
		allThings = new ArrayList<>();
		loadPicnicPoint("PicnicPoint.txt");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see processing.core.PApplet#draw()
	 */
	@Override
	public void draw() {
		this.image(backgroundImage, 0, 0);
		// iterate the allThings list to update each item
		for (int i = 0; i < allThings.size(); i++) {
			Action actionObj = allThings.get(i).update(1);
			// act allThings if the actionObj is not null
			if (actionObj != null) {
				actionObj.act(allThings);
			}
			// remove the items that are not active
			if (!allThings.get(i).isActive()) {
				allThings.remove(i);
				i--;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKey() == 'q') {
			parent.setVisible(true);
			for (int i = 0; i < allThings.size(); i++) {
				Thing t = allThings.get(i);
				if (Pattern.matches("4Tree[1-3]", t.NAME) && t.isActive()) {
					planted++;
				}
			}
			surface.setVisible(false);
			stop();
		}
	}

	/**
	 * This method loads a background image, prints out some introductory text,
	 * and then reads in a set of thing descriptions from a text file with the
	 * provided name. The image is stored in this.backgroundImage, and the
	 * activated things are added to the this.allThings list.
	 * 
	 * @param filename - relative path of file to load, relative to current
	 *                 working directory
	 */
	private void loadPicnicPoint(String filename) {
		// start reading file contents
		Scanner fin = null;
		int lineNumber = 1; // report first line in file as lineNumber 1
		try {
			fin = new Scanner(new File(filename));

			// read and store background image
			String backgroundImageFilename = fin.nextLine().trim();
			backgroundImageFilename = "images" + File.separator
					+ backgroundImageFilename + ".png";
			backgroundImage = loadImage(backgroundImageFilename);
			lineNumber++;

			// then read and create new things, one line per thing
			while (fin.hasNextLine()) {
				String line = fin.nextLine().trim();
				if (line.length() < 1)
					continue;
				String[] parts = line.split(":");
				Thing newThing = null;
				if (line.charAt(0) == 'D') {
					newThing = loadNewDragAndDroppableThing(parts);
				}
				if (Character.toUpperCase(line.charAt(0)) == 'V') {
					newThing = loadVisibleThing(parts);
				}
				allThings.add(newThing);
				if (line.charAt(0) == 'v') {
					newThing.deactivate();
				}
				lineNumber++;
			}
			// catch and report warnings related to any problems experienced
			// loading this
			// file
		} catch (FileNotFoundException e) { // catch FileNotFoundException
			System.out.println(
					"WARNING: Unable to find or load file: " + filename);
		} catch (RuntimeException e) { // catch RuntimeException
			System.out.println("WARNING: Problem loading file: " + filename
					+ " line: " + lineNumber);
			e.printStackTrace();
		} finally {
			if (fin != null)
				fin.close(); // close the scanner
		}
	}

	private Thing loadVisibleThing(String[] parts) {
		// V:hole:600:500
		String name = parts[1].trim();
		int x = Integer.parseInt(parts[2].trim());
		int y = Integer.parseInt(parts[3].trim());
		VisibleThing newThing;
		if (parts.length > 4) {
			int width = Integer.parseInt(parts[4].trim());
			int length = Integer.parseInt(parts[5].trim());
			newThing = new VisibleThing(name, x, y, width, length);
		} else {
			newThing = new VisibleThing(name, x, y, 100, 100);
		}
		return newThing;
	}

	/**
	 * Helper method to retrieve thing references from allThings, based on their
	 * names. If multiple things have that name, this method will return the
	 * first (lowest-index) reference found.
	 * 
	 * @param name is the name of the object that is being found
	 * @return a reference to a thing with the specified name, or null when none
	 *         is found
	 */
	private Thing findThingByName(String name) {
		for (int i = 0; i < allThings.size(); i++)
			if (allThings.get(i).hasName(name)) {
				return allThings.get(i);
			}
		System.out.println("WARNING: Failed to find thing with name: " + name);
		return null;
	}

	/**
	 * This method creates and returns a new DragAndDroppableThing based on the
	 * properties specified as strings within the provided parts array.
	 * 
	 * @param parts contains the following strings in this order: - D: indicates
	 *              that a DragAndDroppableThing is being created - name: the
	 *              name of the newly created thing - x: the starting x position
	 *              (as an int) for this thing - y: the starting y position (as
	 *              an int) for this thing - message: a string of text to
	 *              display when this thing is dropped on target - name of thing
	 *              to activate (optional): activates this thing when dropped on
	 *              target
	 * @return the newly created object
	 */
	private DragAndDroppableThing loadNewDragAndDroppableThing(String[] parts) {
		// y: name: x: y: target: name of object to activate (optional)
		String name = parts[1].trim();
		int x = Integer.parseInt(parts[2].trim());
		int y = Integer.parseInt(parts[3].trim());
		Thing dropTarget = findThingByName(parts[4].trim());
		if (!(dropTarget instanceof VisibleThing))
			dropTarget = null;
		Thing activate = null;
		activate = findThingByName(parts[5].trim());
		// create new thing
		DragAndDroppableThing newThing = new DragAndDroppableThing(name, x, y,
				(VisibleThing) dropTarget, new Action(activate), 60, 60);
		return newThing;
	}
}
