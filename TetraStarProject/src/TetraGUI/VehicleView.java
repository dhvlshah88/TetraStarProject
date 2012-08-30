package TetraGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Tetra.Inhabitant.Vehicle.Vehicle;

public class VehicleView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2704200614944259478L;
	Image image;
	Vehicle vehicle = null;
	Dimension cellDimension = null;

	public VehicleView(Dimension cellDimension, Vehicle vehicle) {
		this.vehicle = vehicle;
		this.cellDimension = cellDimension;

		try
		{
			image = javax.imageio.ImageIO.read(new java.net.URL(TRoverView.class.getResource(vehicle.getImageFilePath()), ""));
		}
		catch (Exception e) { 
			/*handled in paintComponent()*/ 
		}

		setPreferredSize(cellDimension);
		setLayout(new BorderLayout(0, 0));
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
