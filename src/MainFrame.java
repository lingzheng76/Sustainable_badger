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
		
		// set the behavior of the window
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
