package Tetra.Map;

import java.util.ArrayList;
import java.util.Iterator;

import Tetra.Position;
import Tetra.StarSignal;


public class StarAtlas extends Map {

	private ArrayList<Map> mapList = null;
	private int mapCount = 0;

	public StarAtlas(Position currentPosition){
		super(currentPosition);
	}

	/*
	 * This methods add the StarMap instance in the StarAtlas instance but before adding, it checks whether 
	 * this StarMap instance is already present in the StarAtlas instance or not. If not, it will add the 
	 * StarMap instance.
	 */
	public void addStarMap(Map starMap){
		int counter = 0;
		/*if(!(starMap instanceof StarMap)){
			return;
		}*/

		Iterator<Map> iterator = mapList.iterator();
		while(iterator.hasNext()){
			Map map = iterator.next(); 
			if(map.getMapId() == starMap.getMapId()){
				counter++;	
			}
		}

		if(counter != 0){
			return;
		}

		starMap.setPosition(super.getPosition());
		mapList.add(starMap);
		mapCount = super.getItemCount() + 1;
		super.setItemCount(mapCount);


	}

	public ArrayList<Map> getStarMapList(){
		return mapList;
	}

	public String getType(){
		return "StarAtlas";
	}


	@Override
	public void setDirection(String direction) {

	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StarSignal showSignal(int mapId, Position heroPosition) {

		return null;
	}


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
