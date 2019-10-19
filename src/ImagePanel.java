import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 5564818820574092960L;
	private BufferedImage image;

	public ImagePanel() {
		super();
		try {
			image = ImageIO.read(new File("wallhaven-0qo2r4.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Dimension getSize() {
		return new Dimension(image.getWidth() / 5, image.getHeight() / 4);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth() / 5, image.getHeight() / 5, this);
	}
}