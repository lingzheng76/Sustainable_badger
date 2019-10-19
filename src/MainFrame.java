import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * A JFrame as the main window
 * 
 * @author Zhaoyi
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8434228199144892220L;
	private JLayeredPane layeredPane;

	public MainFrame() {
		super();
		// initialize the content panel
		ImagePanel imagePanel = new ImagePanel();

		ButtonPanel buttonPanel = new ButtonPanel();
		buttonPanel.setBounds(0, 0, imagePanel.getSize().width, imagePanel.getSize().height);

		JPanel jp = new JPanel();
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(imagePanel.getSize());
		layeredPane.add(buttonPanel, BorderLayout.CENTER);
		layeredPane.add(imagePanel, BorderLayout.CENTER);
		jp.add(layeredPane);
		setContentPane(jp);

		// locate the window in the middle of the screen
		pack();
		centerAlign();

		// set the behavior of the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Which garbage are you???"); // TODO: change
		setVisible(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println(getMousePosition());
			}
		});
	}

	private void centerAlign() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		int x = (int) (screenSize.getWidth() - windowSize.getWidth()) / 2;
		int y = (int) (screenSize.getHeight() - windowSize.getHeight()) / 2;
		setLocation(x, y);
	}
}
