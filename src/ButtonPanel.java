import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = -8726704462364227154L;
	private static final int BUTTON_WIDTH = 30;
	private static final int BUTTON_HEIGHT = 30;

	public ButtonPanel() {
		super();

		Image image = null;
		try {
			image = ImageIO.read(new File("images/pin.png")).getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT,
					Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.err.println("Cannot load pin.png");
			System.exit(-1);
		}
		ImageIcon icon = new ImageIcon(image);
		setLayout(null);

		JButton nat = new JButton(icon);
		add(nat);
		nat.setBounds(172, 190, BUTTON_WIDTH, BUTTON_HEIGHT);
		nat.setToolTipText("Nat");

		JButton rheta = new JButton(icon);
		add(rheta);
		rheta.setBounds(200, 300, BUTTON_WIDTH, BUTTON_HEIGHT);
		rheta.setToolTipText("Rheta's");

		JButton dorm = new JButton(icon);
		add(dorm);
		dorm.setBounds(590, 530, BUTTON_WIDTH, BUTTON_HEIGHT);
		dorm.setToolTipText("Dorm");

		JButton pic = new JButton(icon);
		add(pic);
		pic.setBounds(700, 70, BUTTON_WIDTH, BUTTON_HEIGHT);
		pic.setToolTipText("Picnic point");

		setOpaque(false);
		setVisible(true);
	}

	public void addListeners(JButton... buttons) {
		
	}
}
