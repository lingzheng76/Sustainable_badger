import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * A JFrame as the main window
 * 
 * @author Zhaoyi
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8434228199144892220L;
	ImagePanel imagePanel;

	public MainFrame() {
		super();

		// initialize the image panel and resize the window
		add(imagePanel = new ImagePanel());
		setSize(imagePanel.getSize());

		// locate the window in the middle of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		int x = (int) (screenSize.getWidth() - windowSize.getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - windowSize.getHeight()) / 2;
		setLocation(x, y);

		// set the behavior of the window
		setTitle("Which garbage are you???"); // TODO: change
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
