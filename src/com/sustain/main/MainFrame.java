package com.sustain.main;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.sustain.item.Badger;
import com.sustain.panel.MapPanel;
import com.sustain.scene.Dorm;
import com.sustain.scene.Nat;
import com.sustain.scene.PlantTree;
import com.sustain.scene.TrashBin;

import processing.core.PApplet;

/**
 * A JFrame as the main window
 * 
 * @author Zhaoyi
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8434228199144892220L;
	private MapPanel mapPanel;
	private int time;

	public MainFrame() {
		super();
		changeToSystemUI();
		initGlobalFont(new FontUIResource("Comic Sans MS", Font.PLAIN, 14));
		// create card layout
		time = 0;

		// initialize classes that use PApplet
		Badger.init();
		Dorm.init(this);
		PlantTree.init(this);
		TrashBin.init(this);
		Nat.init(this);

		setContentPane(mapPanel = new MapPanel(this));

		// locate the window in the middle of the screen
		pack();
		centerAlign();

		// set the behavior of the window
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Sustainable bagder");
		setVisible(true);

		JOptionPane.showMessageDialog(this, "Welcome to UW Madison campus!\n"
				+ "You can go to four places everyday!\n"
				+ "See what you can do to live a more sustainable life!\n"
				+ "Hover your mouse over each pin for more infomation\n"
				+ "and press 'q' to quit the scene!", "Welcome",
				INFORMATION_MESSAGE);

		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_Q:
						enter("Map");
						break;
				}
			}
		});
	}

	public void enter(String name) {
//		layout.show(cards, name);
		switch (name) {
			case "Dorm":
				JOptionPane.showMessageDialog(this, "You are entering Dorm!\n"
						+ "Try to find the electrical applicance that waste energy\n"
						+ "and press 'c' or 'o' to open of close them!", "",
						INFORMATION_MESSAGE);
				PApplet.main("com.sustain.scene.Dorm");
				setVisible(false);
				break;
			case "Picnic point":
				JOptionPane.showMessageDialog(this,
						"You are going to lake shore!\n"
								+ "Plant more trees to protect the nature perserve!",
						"", INFORMATION_MESSAGE);
				PApplet.main("com.sustain.scene.PlantTree");
				setVisible(false);
				break;
			case "Rheta's":
				JOptionPane.showMessageDialog(this,
						"You are going to the Rheta's!\n"
								+ "Let's learn how to sort trashes!",
						"", INFORMATION_MESSAGE);
				PApplet.main("com.sustain.scene.TrashBin");
				setVisible(false);
				break;
			case "Nat":
				JOptionPane.showMessageDialog(this,
						"You are going to the Natatorium!\n"
								+ "Use 'wert' to change your means of transportation\n"
								+ "and use arrow key to move around!",
						"", INFORMATION_MESSAGE);
				PApplet.main("com.sustain.scene.Nat");
				setVisible(false);
				break;
			default:
				break;
		}
		time++;
		mapPanel.updateTime(time);
		if (time > 3) {
			mapPanel.setEnabled(false);
			return;
		}
	}

	public void reset(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
				"Congradulations! You have completed you day!\n"
						+ Nat.getReuslt() + TrashBin.getResult()
						+ PlantTree.getResult() + Dorm.getResult(),
				"", INFORMATION_MESSAGE);
		time = 0;
		mapPanel.setEnabled(true);
		mapPanel.updateTime(0);
	}

	private void centerAlign() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		int x = (int) (screenSize.getWidth() - windowSize.getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - windowSize.getHeight()) / 2;
		setLocation(x, y);
	}

	private void changeToSystemUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initGlobalFont(FontUIResource font) {
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys
				.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, font);
			}
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
