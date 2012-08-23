/**
 * 
 */
package Tetra;



import java.util.ArrayList;
import Tetra.Inhabitant.Vehicle.Vehicle;

/**
 * @author Dhaval
 *
 */
public class Location {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7155070533311395293L;

	//
	private Position currentPosition = null;

	//
	private String locationType;

	//
	//private ArrayList<Vehicle> vehicleList = null;

	//
	private boolean tetraInhabitantPresent = false;

	//
	private boolean isEmptyLocation = false;

	//
	private Vehicle vehicle=null;

	//
	private boolean isVehiclePresent = true;

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

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String locationType() {
		return locationType;
	}

	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		vehicle.setCurrentPosition(this.currentPosition);
	}

	public Vehicle getVehicle(){
		if(!isVehiclePresent){
			return null;
		}
		isVehiclePresent = false;
		return vehicle;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isVehiclePresent(){
		return isVehiclePresent;
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



}
