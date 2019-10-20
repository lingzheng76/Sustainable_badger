package com.sustain.main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sustain.panel.MapPanel;
import com.sustain.scene.Dorm;

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

	public MainFrame() {
		super();
		// create card layout
		layout = new CardLayout();
		cards = new JPanel(layout);

		Dorm.parent = this;

		// add cards
		cards.add(new MapPanel(this), "Map");
		cards.add(new JLabel("Nat"), "Nat");
		cards.add(new JLabel("Rheta's"), "Rheta's");
		cards.add(new JLabel("Picnic point"), "Picnic point");
		cards.add(new JLabel("Dorm"), "Dorm");
		setContentPane(cards);

		// locate the window in the middle of the screen
		pack();
		centerAlign();

		// set the behavior of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Which garbage are you???"); // TODO: change
		setVisible(true);

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
			PApplet.main("com.sustain.scene.Dorm");
			setVisible(false);
			break;

		default:
			break;
		}
	}

	private void centerAlign() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		int x = (int) (screenSize.getWidth() - windowSize.getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - windowSize.getHeight()) / 2;
		setLocation(x, y);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
