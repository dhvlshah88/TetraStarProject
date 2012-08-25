package Tetra.Map;

import Tetra.Position;
import Tetra.StarSignal;

public class StarMap extends Map {

	private String direction;
	
	public StarMap(Position currentPosition){
		super(currentPosition);
	}

	public void setDirection(String direction){
		this.direction = direction;
	}
	
	public String getDirection(){
		return this.direction;
	}
	
	public String getType(){
		return "StarMap";
	}
	
	@Override
	public StarSignal showSignal(int mapId, Position heroPosition) {
		if(super.getMapId() == mapId && super.getPosition().equals(heroPosition)){
			
		}
		return null;
	}
	
	
	//Given below are the empty method stub which are implemented in EncryptedStarMap, i.e. Decorator
	
	@Override
	public void setTHeroId(String tHeroId) {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public String getTHeroId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setEncryptionDate(String encryptionDate) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getEncryptionDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setRestorationCounter(int restorationCounter) {
		// TODO Auto-generated method stub
		
	}
	
     @Override
    public int getRestorationCounter() {
    	// TODO Auto-generated method stub
    	return 0;
    }

	@Override
	public void setSymbol(String symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEncrypted(boolean encrypted) {
		// TODO Auto-generated method stub
		
	}
     
     
     
}
