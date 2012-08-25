/**
 * 
 */
package Tetra;

import Tetra.Base.Base;
import Tetra.Base.BaseFactory;
import Tetra.Inhabitant.Vehicle.Vehicle;

/**
 * @author Dhaval
 *
 */
public class Location {

	//
	private Position currentPosition = null;
	
	//
	private Base base = null;
	
	//
	private Vehicle vehicle=null;

	//
	private String locationType;

	//
	private boolean tetraInhabitantPresent = false;
	
	//
	private boolean basePresent = false;

	//
	private boolean emptyLocation = false;

	//
	private boolean vehiclePresent = true;

	/**
	 * Initializes Position object that stores row and column number.
	 */
	public Location(Position currentPosition){
		this.currentPosition = currentPosition;
		this.locationType = "EmptyLocation";
	}

	/**
	 * 
	 * @return
	 */
	public Position getPosition(){
		return currentPosition;
	}

	/**
	 * 
	 * @param baseType
	 */
	public void setUpBase(String baseType){
		if(basePresent){
			return;
		}
		
		base = BaseFactory.createBase(baseType, currentPosition);
		setBasePresent(true);
	}

	/**
	 * 
	 * @return
	 */
	public Base getBase(){
		return base;
	}
	
	/**
	 * 
	 * @param tetraInhabitantPresent
	 */
	public void setInhabitantPresent(boolean tetraInhabitantPresent){
		this.tetraInhabitantPresent = tetraInhabitantPresent;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isInhabitantPresent(){
		return tetraInhabitantPresent;
	}

	/**
	 * 
	 * @param basePresent
	 */
	public void setBasePresent(boolean basePresent){
		this.basePresent = basePresent;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBasePresent(){
		return basePresent;
	}

	/**
	 * 
	 * @param emptyLocation
	 */
	public void setEmptyLocation(boolean emptyLocation){
		this.emptyLocation = emptyLocation;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		return emptyLocation;
	}

	/**
	 * 
	 * @param locationType
	 */
	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	/**
	 * 
	 * @return
	 */
	public String locationType() {
		return locationType;
	}
	
	/**
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		vehicle.setCurrentPosition(this.currentPosition);
	}

	/**
	 * 
	 * @return
	 */
	public Vehicle getVehicle(){
		if(!vehiclePresent){
			return null;
		}
		vehiclePresent = false;
		return vehicle;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isVehiclePresent(){
		return vehiclePresent;
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
