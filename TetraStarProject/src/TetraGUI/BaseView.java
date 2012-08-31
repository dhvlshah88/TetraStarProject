package TetraGUI;

import javax.swing.JPanel;

import Tetra.Base.*;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

public class BaseView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7328384810065237203L;
	Image image;
	Dimension cellDimension = null;
	Base base = null;

	/**
	 * Create the panel.
	 */
	public BaseView(Dimension cellDimension , Base base) {
		this.base  = base;
		this.cellDimension = cellDimension;

		try
		{
			image = javax.imageio.ImageIO.read(new java.net.URL(BaseView.class.getResource(base.getImageFilePath()), ""));
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		setPreferredSize(cellDimension);
		setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setOpaque(false);
		setBackground(new Color(150, 93, 82));
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		if (image != null){
			g.drawImage(image, 0, 0, (int) cellDimension.getWidth(), (int)cellDimension.getHeight(),this);
		}
	}
}
