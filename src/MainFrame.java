import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8434228199144892220L;
	ImagePanel imagePanel;

	public MainFrame() {
		super();
		add(imagePanel = new ImagePanel());
		setSize(imagePanel.getSize());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
