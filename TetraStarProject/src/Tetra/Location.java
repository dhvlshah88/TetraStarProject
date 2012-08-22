/**
 * 
 */
package Tetra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.Position;

import Tetra.Inhabitant.TRovers;

/**
 * @author Dhaval
 *
 */
public class Location extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7155070533311395293L;
	private Position currentPosition = null;
	private TRovers tetraInhabitant = null;
	private String locationType;
	private JLabel picLabel = null;
	private BufferedImage locImage = null;
	
	
	private boolean tetraInhabitantPresent = false;
	private boolean isEmptyLocation = false;
	
	/*
	 * Initializes Position object that stores row and column number.
	 */
	public Location(Position currentPosition){
		this.currentPosition = currentPosition;
		this.locationType = "EmptyLocation";
	}
   
	public Position getPosition(){
		return currentPosition;
	}
	
	public void setUpBase(String baseType){
		
	}
	
	/*public void enterBase(TRovers tetraInhabitant){
		if(this.tetraInhabitant == null){
			this.tetraInhabitant = tetraInhabitant;
			setLocationType(this.tetraInhabitant.getType());
			tetraInhabitantPresent = true;
		}
	}*/

	public boolean isInhabitantPresent(){
		return tetraInhabitantPresent;
	}
	
	
	public void setEmptyLocation(boolean isEmpty){
		this.isEmptyLocation = isEmpty;
	}
	
	public boolean isEmpty(){
		return isEmptyLocation;
	}
	
	private void setLocationType(String locationType){
		this.locationType = locationType;
	}
	
	public String locationType() {
		return locationType;
	}
	
	/*public void setImage(String filePath){
		try {
			this.locImage = ImageIO.read(new File(filePath));
			picLabel = new JLabel(new ImageIcon(this.locImage));
			picLabel.setPreferredSize(getSize());
			this.add(picLabel);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Image problems!");
			e.printStackTrace();
		}
	}*/
	
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(bg);
	}
	
	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub
		super.setSize(width, height);
	}
	
	
	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}
	
	@Override
	public Color getBackground() {
		// TODO Auto-generated method stub
		return super.getBackground();
	}
}
