package TetraGUI;

import javax.swing.JPanel;
import Tetra.Inhabitant.TRovers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Image;

public class TRoverView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9154998090722585010L;
	Image image;
	TRovers tRovers = null;
	Dimension cellDimension = null;

	public TRoverView(Dimension cellDimension , TRovers tRovers) {
		this.tRovers = tRovers;
		this.cellDimension = cellDimension;

		try
		{
			image = javax.imageio.ImageIO.read(new java.net.URL(TRoverView.class.getResource(tRovers.getImageFilePath()), ""));
		}
		catch (Exception e) { 
			/*handled in paintComponent()*/ 
		}

		setPreferredSize(cellDimension);
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.black);
		setOpaque(false);
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		if (image != null){
			g.drawImage(image, 0, 0, (int)cellDimension.getWidth(), (int)cellDimension.getHeight(), this);
		}
	}

}
