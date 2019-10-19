import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A JPanel that displays a image
 * 
 * @author Zhaoyi
 */
public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 5564818820574092960L;
	private BufferedImage image;

	public ImagePanel() {
		super();
		// load the image
		try {
			image = ImageIO.read(new File("images/map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Dimension getSize() {
		return new Dimension(image.getWidth() + 5, image.getHeight() + 35);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// paint the component
		super.paintComponent(g);
		// paint the image 
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
	}
}