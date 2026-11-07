import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window {

	private WindowDisplay windowDisplay;

	public Window(String title) {
		windowDisplay = new WindowDisplay(title);
	}

	public Window(String title, int x, int y) {
		windowDisplay = new WindowDisplay(title);
		windowDisplay.setWindowLocation(x, y);
	}
	
	// --
	
	public Window(String title, ColorImage img) {
		this(title, ImageUtil.toBufferedImage(img));
	}
	
	public Window(String title, BinaryImage img) {
		this(title, ImageUtil.toBufferedImage(img));
	}
	
	private Window(String title, BufferedImage img) {
		windowDisplay = new WindowDisplay(title);
		show(img);
	}
	
	// --
	
	public Window(String title, int x, int y, ColorImage img) {
		this(title, x, y, ImageUtil.toBufferedImage(img));
	}
	
	public Window(String title, int x, int y, BinaryImage img) {
		this(title, x, y, ImageUtil.toBufferedImage(img));
	}
	
	private Window(String title, int x, int y, BufferedImage img) {
		windowDisplay = new WindowDisplay(title);
		windowDisplay.setWindowLocation(x, y);
		show(img);
	}
	
	
	public void setTitle(String title) {
		windowDisplay.setTitle(title);
	}

	public void show(ColorImage img) {
		show(ImageUtil.toBufferedImage(img));
	}

	public void show(BinaryImage img) {
		show(ImageUtil.toBufferedImage(img));
	}
	
	private void show(BufferedImage img) {
		windowDisplay.setImage(img);
	}

	private class WindowDisplay extends JComponent {

		private static final long serialVersionUID = -8255319694373975038L;
		private JFrame frame;
		private BufferedImage img;

		public WindowDisplay(String title) {
			frame = new JFrame();
			frame.setTitle(title);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().add(this);
			frame.setVisible(false);

		}
		public void setWindowLocation(int x, int y) {
			frame.setLocation(x, y);
		}

		public void setTitle(String title) {
			frame.setTitle(title);
		}

		public void setImage(BufferedImage img) {
			this.img = img;
			refresh();
		}

		public void refresh() {
			if(!frame.isVisible()) 
				frame.setVisible(true);
			
			Dimension dimension = new Dimension(img.getWidth(), img.getHeight());
			
			frame.setSize(dimension);
			this.setPreferredSize(dimension);

			frame.pack();
			this.repaint();
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if(img != null)
				g.drawImage(img, 0, 0, null);
		}
	}

}
