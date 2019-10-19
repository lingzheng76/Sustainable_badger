import java.awt.BorderLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = -4727595370439989946L;
	private JLayeredPane layeredPane;

	public MapPanel(MainFrame parent) {
		super();
		ImagePanel imagePanel = new ImagePanel();
		ButtonPanel buttonPanel = new ButtonPanel(parent);
		buttonPanel.setBounds(0, 0, imagePanel.getSize().width, imagePanel.getSize().height);

		// overlay two panels
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(imagePanel.getSize());
		layeredPane.add(buttonPanel, BorderLayout.CENTER);
		layeredPane.add(imagePanel, BorderLayout.CENTER);
		add(layeredPane);
	}
}
