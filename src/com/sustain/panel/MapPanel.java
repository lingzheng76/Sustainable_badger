package com.sustain.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.sustain.main.MainFrame;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = -4727595370439989946L;
	private JLayeredPane layeredPane;
	private ButtonPanel buttonPanel;
	private JButton endDay;

	public MapPanel(MainFrame parent) {
		super();
		ImagePanel imagePanel = new ImagePanel();
		buttonPanel = new ButtonPanel(parent);
		buttonPanel.setBounds(0, 0, imagePanel.getSize().width, imagePanel.getSize().height);

		// overlay two panels
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(imagePanel.getSize());
		endDay = new JButton("End the day");
		endDay.setBounds(0, 0, 120, 25);
		endDay.setVisible(false);
		endDay.addActionListener(parent::reset);
		layeredPane.add(endDay, BorderLayout.EAST);
		layeredPane.add(buttonPanel, BorderLayout.CENTER);
		layeredPane.add(imagePanel, BorderLayout.CENTER);
		add(layeredPane);
	}

	@Override
	public void setEnabled(boolean enabled) {
		buttonPanel.setEnabled(enabled);
		endDay.setVisible(!enabled);
	}
}
