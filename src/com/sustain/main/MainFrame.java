package com.sustain.main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.sustain.panel.MapPanel;
import com.sustain.scene.Dorm;
import com.sustain.scene.PlantTree;

import processing.core.PApplet;

/**
 * A JFrame as the main window
 * 
 * @author Zhaoyi
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8434228199144892220L;
	private CardLayout layout;
	private JPanel cards;
	private MapPanel mapPanel;
	private int time;

	public MainFrame() {
		super();
		changeToSystemUI();
		initGlobalFont(new FontUIResource("Comic Sans MS", Font.PLAIN, 14));
		// create card layout
		layout = new CardLayout();
		cards = new JPanel(layout);
		time = 0;

		// initialize classes that use PApplet
		Dorm.init(this);
		PlantTree.init(this);

		// add cards
		cards.add(mapPanel = new MapPanel(this), "Map");
		cards.add(new JLabel("Nat"), "Nat");
		cards.add(new JLabel("Rheta's"), "Rheta's");
		cards.add(new JLabel("Picnic point"), "Picnic point");
		cards.add(new JLabel("Dorm"), "Dorm");
		setContentPane(cards);

		// locate the window in the middle of the screen
		pack();
		centerAlign();

		// set the behavior of the window
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Which garbage are you???"); // TODO: change
		setVisible(true);

		JOptionPane.showMessageDialog(this, "Welcome to UW Madison campus!\n"
				+ "You can go to four places everyday!\n"
				+ "See what you can do to live a more sustainable life!\n"
				+ "Hover your mouse over each pin for more infomation!",
				"Welcome", JOptionPane.INFORMATION_MESSAGE);

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
		time++;
		mapPanel.updateTime(time);
		if (time >= 4) {
			mapPanel.setEnabled(false);
			return;
		}
		switch (name) {
			case "Dorm":
				PApplet.main("com.sustain.scene.Dorm");
				setVisible(false);
				break;
			case "Picnic point":
				PApplet.main("com.sustain.scene.PlantTree");
				setVisible(false);
			default:
				break;
		}
	}

	public void reset(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
				"Congradulations! You have completed you day!");
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
