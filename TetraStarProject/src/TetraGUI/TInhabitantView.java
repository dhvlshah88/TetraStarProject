package TetraGUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TInhabitantView extends JPanel {


	JLabel lblLblheroimage = null;


	/**
	 * Create the panel.
	 */
	public TInhabitantView(Dimension cellDimension) {
		setBackground(new Color(150, 93, 82));
		
		lblLblheroimage = new JLabel("");
		lblLblheroimage.setIcon(new ImageIcon(TInhabitantView.class.getResource("/images/Optimus.jpg")));
		lblLblheroimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblheroimage.setVerticalAlignment(SwingConstants.CENTER);
		setPreferredSize(cellDimension);
		setLayout(new GridLayout(0, 1, 0, 0));
		add(lblLblheroimage);
	}
	
}
