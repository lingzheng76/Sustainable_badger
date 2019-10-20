package com.sustain.panel;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sustain.main.MainFrame;

public class ButtonPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8726704462364227154L;
	private static final int BUTTON_WIDTH = 30;
	private static final int BUTTON_HEIGHT = 30;
	private MainFrame parent;

	public ButtonPanel(MainFrame parent) {
		super();
		this.parent = parent;

		// remove layout
		setLayout(null);

		// load icon
		Image image = null;
		try {
			image = ImageIO.read(new File("images/pin.png")).getScaledInstance(
					BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.err.println("Cannot load pin.png");
			System.exit(-1);
		}
		ImageIcon icon = new ImageIcon(image);

		// create buttons with magic coordinates
		addButton(icon, "Nat", 172, 190);
		addButton(icon, "Rheta's", 200, 300);
		addButton(icon, "Dorm", 590, 530);
		addButton(icon, "Picnic point", 700, 70);

		setOpaque(false);
	}

	private void addButton(ImageIcon icon, String name, int x, int y) {
		JButton jb = new JButton(icon);
		jb.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		jb.setToolTipText(name);
		jb.setActionCommand(name);
		jb.addActionListener(this);
		add(jb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.enter(e.getActionCommand());
	}

	@Override
	public void setEnabled(boolean enabled) {
		for (Component comp : getComponents()) {
			comp.setEnabled(enabled);
		}
	}
}
