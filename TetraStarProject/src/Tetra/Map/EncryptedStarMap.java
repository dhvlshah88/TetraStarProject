/**
 * 
 */
package Tetra.Map;

import java.util.ArrayList;

/**
 * @author Dhaval
 *
 */
public class EncryptedStarMap extends Map {

	private final Map map;
	private String tHeroId;
	private String encryptionDate;
	private int restorationCounter;
	private IEncryptionStrategy encryptionStrategy;
	private boolean isEncrypted = true;
	private String symbol;
	
	public EncryptedStarMap(Map map, IEncryptionStrategy encryptionStrategy, String tHeroId, String encryptionDate, int restorationCounter, String symbol){
		this.map = map;
		this.encryptionStrategy = encryptionStrategy;
		this.tHeroId = tHeroId;
		this.encryptionDate = encryptionDate;
		this.restorationCounter = restorationCounter;
		this.symbol = symbol;
		isEncrypted = true;
	}
	
	@Override
	public String getMapId() {
		return map.getMapId();
	}
	
	@Override
	public void setPositionId(String positionId) {
		map.setPositionId(positionId);
	}
	
	@Override
	public String getPositionId() {
		return map.getPositionId();
	}
	
	@Override
	public void setItemCount(int itemCount) {
		map.setItemCount(itemCount);
	}
	
	@Override
	public int getItemCount() {
		return map.getItemCount();
	}
	
	@Override
	public void setDirection(String direction) {
		map.setDirection(direction);
	}
	
	/*
	 * (non-Javadoc)
	 * @see Tetra.Map.Map#getDirection()
	 * 
	 * This method returns encrypted direction based on the encryption strategy used by the THero.
	 */
	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		String encryptedDirection;
		
		//For encryption to happen, an encryption strategy instance must be initialized and star map should be encrypted. 
		if(encryptionStrategy != null && isEncrypted){
			encryptedDirection = encryptionStrategy.encryptDirection(map.getDirection());
			return encryptedDirection;
		}
		
		return map.getDirection();
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "EncryptedStarMap";
	}
	
	@Override
	public Map clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return map.clone();
	}

	/*
	 * (non-Javadoc)
	 * @see Tetra.Map.Map#setTHeroId(java.lang.String)
	 */
	public void setTHeroId(String tHeroId){
		this.tHeroId = tHeroId;
	}
	
	public String getTHeroId(){
		String prevTheroId = map.getTHeroId().trim();
		return (prevTheroId.isEmpty() ? prevTheroId : prevTheroId + ", ") + tHeroId;
	}
	
	public void setEncryptionDate(String encryptionDate){
		this.encryptionDate = encryptionDate;
	}
	
	public String getEncryptionDate(){
		return encryptionDate;
	}
	
	public void setRestorationCounter(int restorationCounter){
		this.restorationCounter = restorationCounter;
	}
	
	public int getRestorationCounter(){
		return restorationCounter;
	}	
	
	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public boolean isEncrypted(){
		return isEncrypted;
	}
	
	public void setEncrypted(boolean encrypted){
		isEncrypted = encrypted;
	}
	
	
	@Override
	public StarSignal showSignal(String mapId) {
		return map.showSignal(mapId);
	}
	
	@Override
	public String getImageFilePath() {
		int endIndex = map.getImageFilePath().indexOf(".jpg");
		return map.getImageFilePath().substring(0, endIndex) + "Encrypted.jpg";
	}

	@Override
	public void setStarMapList(ArrayList<Map> mapList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Map> getStarMapList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStarMap(Map starMap) {
		// TODO Auto-generated method stub
		
	}
}
