/**
 * 
 */
package Tetra.Scenarios;

import java.awt.event.MouseAdapter;

import Tetra.TFace;
import Tetra.TetraGUIManager;
import Tetra.Base.Base;
import Tetra.Base.BaseFactory;
import Tetra.Base.MapBase;
import Tetra.Collections.TBaseCollection;
import Tetra.Collections.TInhabitantCollection;
import Tetra.Collections.VehicleCollection;
import Tetra.Inhabitant.THero;
import Tetra.Inhabitant.TRoverFactory;
import Tetra.Inhabitant.TRovers;
import Tetra.Inhabitant.TVader;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.EncryptionStrategyOne;
import Tetra.Map.EncryptionStrategyTwo;
import Tetra.Map.Map;
import Tetra.Map.MapFactory;
import TetraGUI.BaseView;
import TetraGUI.TRoverView;
import TetraGUI.TetraStarGUI;

/**
 * @author Dhaval
 *
 */
public class Scenario extends MouseAdapter {

	private TetraStarGUI gui = null;
	private TFace tface = null;

	private TRovers trover1 = null;
	private TRovers trover2 = null;
	private TVader tvader = null; 
	private THero thero = null;
	private THero thero1 = null;
	private Map map1 = null;
	private Map map2 = null;
	private Map map3 = null;
	private Map map4 = null;
	private Map emap1 = null;
	private Map emap2 = null;
	private MapBase mapbase1 = null;
	private MapBase mapbase2 = null;
	private MapBase mapbase3 = null;
	private Base herobase = null;
	private Base firstriver = null;
	private Base secondriver = null;
	Base thirdriver = null;
	Base fourthriver = null;
	
	Base vaderbase = null;

	private TInhabitantCollection inhabitantColl = null;
	private TBaseCollection baseColl = null;
	private VehicleCollection vehicleColl = null;

	private TetraGUIManager guiMngr = null;

	private TRoverFactory roverFactory = null;
	private MapFactory mapFactory = null;

	public Scenario(TetraStarGUI gui, TFace tface){
		this.gui = gui;
		this.tface = tface;


		roverFactory = new TRoverFactory();
		mapFactory = new MapFactory();
		guiMngr = new TetraGUIManager(gui, tface);

		//add factory
		inhabitantColl = new TInhabitantCollection(guiMngr);
		baseColl = new TBaseCollection(guiMngr);
		vehicleColl = new VehicleCollection(guiMngr);

		gui.addMouseListener(this);


		addVader();
		
		addTRovers();
		
		addHero();
		
		addMapBase();

		addVaderBase();

		addRiver();

		addHeroBase();

		addToCollection();

	}



	private void addRiver(){
		firstriver = BaseFactory.createBase("River", tface.getPosition(2,3));
		//firstriverView = new BaseView(gui.getCellDimension(), firstriver);
		
		secondriver = BaseFactory.createBase("River", tface.getPosition(3,2));
		//secondriverView = new BaseView(gui.getCellDimension(), secondriver);
		
		thirdriver = BaseFactory.createBase("River", tface.getPosition(4,3));
		//thirdriverView = new BaseView(gui.getCellDimension(), thirdriver);
		
		fourthriver = BaseFactory.createBase("River", tface.getPosition(3,4));
		//fourthriverView = new BaseView(gui.getCellDimension(), fourthriver);
	}


	private void addVaderBase(){
		vaderbase = BaseFactory.createBase("TVaderBase", tface.getPosition(3,3));
		//vaderBaseView = new BaseView(guiMngr.getCellDimension(), vaderbase);	
	}


	private void addHeroBase(){
		herobase = BaseFactory.createBase("THeroBase", tface.getPosition(0,0));
		//heroBaseView = new BaseView(gui.getCellDimension(), herobase);
	}



	private void addMapBase(){
		mapbase1 =(MapBase) BaseFactory.createBase("MapBase", tface.getPosition(1,6));
		mapbase1.setTface(tface);
		//mapBaseView1 = new BaseView(guiMngr.getCellDimension(), mapbase1);
		
		map1 = mapFactory.createMap("StarAtlas", mapbase1.getPosition(), "M1");
		map1.setItemCount(0);

		map3 = mapFactory.createMap("StarMap", mapbase1.getPosition(), "M3");
		map3.setDirection("Inside StarAtlas.");
		map3.setItemCount(0);
		map1.addStarMap(map3);
		mapbase1.setMap(map1);

		mapbase2 = (MapBase) BaseFactory.createBase("MapBase", tface.getPosition(7,4));
		
		map2 = mapFactory.createMap("StarMap", mapbase2.getPosition(), "M2");
		map2.setDirection("Rovers displayed map!!");
		map2.setItemCount(0);
		
		emap1 = new EncryptedStarMap(map2, getTHero().getEncryptionStrategy(), getTHero().getTetId(), "Jan 30 2020" , 0, getTHero().getSymbol());
		mapbase2.setMap(emap1);
		
		mapbase3 = (MapBase) BaseFactory.createBase("MapBase", tface.getPosition(3, 0));
	
		map4 = mapFactory.createMap("StarMap", mapbase3.getPosition(), "M4");
		map4.setDirection("Go 2,000 light year straight.");
		map4.setItemCount(0);
		
		emap2= new EncryptedStarMap(map4, getTHero1().getEncryptionStrategy(), getTHero1().getTetId(), "Aug 30 2012" , 0, getTHero1().getSymbol());
		mapbase3.setMap(emap2);
		


	}


	private void addTRovers(){
		trover1 = roverFactory.createTRover("TRover", tface.getPosition(5,6));
		//firstroverView = (TRoverView) guiMngr.generateViews(trover1); 
		trover1.setName("BumbleBee1");
		trover1.setTetId("TR1");
		trover1.setGender("M");

		trover2 = roverFactory.createTRover("TRover", tface.getPosition(7,0));
		//secondroverView = (TRoverView) guiMngr.generateViews(trover2);
		trover1.setName("BumbleBee2");
		trover1.setTetId("TR2");
		trover1.setGender("M");

	}

	private void addVader(){
		tvader = (TVader) roverFactory.createTRover("TVader", tface.getPosition(3,3));
		tvader.setName("Megatron");
		tvader.setTetId("V1");
		tvader.setGender("M");
		
	}

	private void addHero(){
		thero = (THero) roverFactory.createTRover("THero", tface.getPosition(3,7));
		thero.setName("OptimusPrime");
		thero.setTetId("TH1");
		thero.setGender("M");
		thero.setSymbol("@");
		thero.setEncryptionStrategy(new EncryptionStrategyOne());
	
		thero1 = (THero) roverFactory.createTRover("THero", tface.getPosition(0,0));
		thero1.setName("OptimusPrime1");
		thero1.setTetId("TH2");
		thero1.setGender("M");
		thero1.setSymbol("$");
		thero1.setEncryptionStrategy(new EncryptionStrategyTwo());
		
	}

	private void addToCollection(){
		
		baseColl.addLocatableObject(herobase);
		
		baseColl.addLocatableObject(vaderbase);
		
		baseColl.addLocatableObject(firstriver);
		baseColl.addLocatableObject(secondriver);
		baseColl.addLocatableObject(thirdriver);
		baseColl.addLocatableObject(fourthriver);

		baseColl.addLocatableObject(mapbase1);
		baseColl.addLocatableObject(mapbase2);
		baseColl.addLocatableObject(mapbase3);

		inhabitantColl.addLocatableObject(tvader);
		tvader.setInhabitantColl(inhabitantColl);
		tvader.setBaseColl(baseColl);
		tvader.setVehicleColl(vehicleColl);

		inhabitantColl.addLocatableObject(thero);
		inhabitantColl.addLocatableObject(thero1);
		thero.setInhabitantColl(inhabitantColl);
		thero.setBaseColl(baseColl);
		thero.setVehicleColl(vehicleColl);
		thero1.setInhabitantColl(inhabitantColl);
		thero1.setBaseColl(baseColl);
		thero1.setVehicleColl(vehicleColl);

		inhabitantColl.addLocatableObject(trover1);
		inhabitantColl.addLocatableObject(trover2);
		trover1.setInhabitantColl(inhabitantColl);
		trover1.setBaseColl(baseColl);
		trover1.setVehicleColl(vehicleColl);
		trover2.setInhabitantColl(inhabitantColl);
		trover2.setBaseColl(baseColl);
		trover2.setVehicleColl(vehicleColl);

	}

	public TRovers getTrover1(){
		return trover1;
	}

	public TRovers getTrover2(){
		return trover2;
	}

	public TVader getTvader() {
		return tvader;
	}
	
	public THero getTHero(){
		return thero;
	}
	
	public THero getTHero1(){
		return thero1;
	}
}
