/**
 * 
 */
package Tetra.Scenarios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import Tetra.Inhabitant.Movement.AllDirectionMovement;
import Tetra.Inhabitant.Movement.CardinalDirectionMovement;
import Tetra.Inhabitant.Movement.OrdinalDirectionMovement;
import Tetra.Inhabitant.Movement.TFlierMovement;
import Tetra.Map.EncryptedStarMap;
import Tetra.Map.EncryptionStrategyOne;
import Tetra.Map.EncryptionStrategyTwo;
import Tetra.Map.Map;
import Tetra.Map.MapFactory;
import TetraGUI.TetraStarGUI;

/**
 * @author Dhaval
 *
 */
public class Scenario extends MouseAdapter {

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
	private Base vaderbase = null;
	private Base firstriver = null;
	private Base secondriver = null;
	private Base thirdriver = null;
	private Base fourthriver = null;

	private TInhabitantCollection inhabitantColl = null;
	private TBaseCollection baseColl = null;
	private VehicleCollection vehicleColl = null;

	private TetraGUIManager guiMngr = null;

	private TRoverFactory roverFactory = null;
	private MapFactory mapFactory = null;

	public Scenario(TetraStarGUI gui, TFace tface){
		this.tface = tface;

		roverFactory = new TRoverFactory();
		mapFactory = new MapFactory();
		guiMngr = new TetraGUIManager(tface.getTotalRows(), tface.getTotalColumns(), this);

		inhabitantColl = TInhabitantCollection.getInstance(guiMngr);
		baseColl = TBaseCollection.getInstance(guiMngr);
		vehicleColl = VehicleCollection.getInstance(guiMngr);

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
		secondriver = BaseFactory.createBase("River", tface.getPosition(3,2));
		thirdriver = BaseFactory.createBase("River", tface.getPosition(4,3));
		fourthriver = BaseFactory.createBase("River", tface.getPosition(3,4));
	}


	private void addVaderBase(){
		vaderbase = BaseFactory.createBase("TVaderBase", tface.getPosition(3,3));
	}


	private void addHeroBase(){
		herobase = BaseFactory.createBase("THeroBase", tface.getPosition(0,0));
	}



	private void addMapBase(){
		mapbase1 =(MapBase) BaseFactory.createBase("MapBase", tface.getPosition(1,6));
		//mapbase1.setTface(tface);

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
		trover1.setName("BumbleBee1");
		trover1.setTetId("TR1");
		trover1.setGender("M");
		trover1.setMovementStrategy(new OrdinalDirectionMovement(tface));

		trover2 = roverFactory.createTRover("TRover", tface.getPosition(7,0));
		trover2.setName("BumbleBee2");
		trover2.setTetId("TR2");
		trover2.setGender("M");
		trover2.setMovementStrategy(new CardinalDirectionMovement(tface));
	}

	private void addVader(){
		tvader = (TVader) roverFactory.createTRover("TVader", tface.getPosition(3,3));
		tvader.setName("Megatron");
		tvader.setTetId("V1");
		tvader.setGender("M");
		tvader.setMovementStrategy(new TFlierMovement(tface));
	}

	private void addHero(){
		thero = (THero) roverFactory.createTRover("THero", tface.getPosition(3,7));
		thero.setName("OptimusPrime");
		thero.setTetId("TH1");
		thero.setGender("M");
		thero.setSymbol("@");
		thero.setEncryptionStrategy(new EncryptionStrategyOne());
		thero.setMovementStrategy(new AllDirectionMovement(tface));

		thero1 = (THero) roverFactory.createTRover("THero", tface.getPosition(0,0));
		thero1.setName("OptimusPrime1");
		thero1.setTetId("TH2");
		thero1.setGender("M");
		thero1.setSymbol("$");
		thero1.setEncryptionStrategy(new EncryptionStrategyTwo());
		thero.setMovementStrategy(new CardinalDirectionMovement(tface));
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
