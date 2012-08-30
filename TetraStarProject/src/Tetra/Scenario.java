/**
 * 
 */
package Tetra;

import java.awt.event.MouseAdapter;

import Tetra.Base.Base;
import Tetra.Base.BaseFactory;
import Tetra.Base.MapBase;
import Tetra.Inhabitant.THero;
import Tetra.Inhabitant.TRoverFactory;
import Tetra.Inhabitant.TRovers;
import Tetra.Inhabitant.TVader;
import Tetra.Map.Map;
import Tetra.Map.MapFactory;
import TetraGUI.BaseView;
import TetraGUI.TRoverView;
import TetraGUI.TetraGUIManager;
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
	private Map map1 = null;
	private Map map2 = null;
	private Map map3 = null;
	private MapBase mapbase1 = null;
	private MapBase mapbase2 = null;
	
	private TInhabitantCollection inhabitantColl = null;
	private TBaseCollection baseColl = null;
	private VehicleCollection vehicleColl = null;
	
	private TetraGUIManager guiMngr = null;
	
	private TRoverFactory roverFactory = null;
	private MapFactory mapFactory = null;
	private TRoverView firstroverView = null;
	private TRoverView secondroverView = null;
	
	public Scenario(TetraStarGUI gui, TFace tface){
		this.gui = gui;
		this.tface = tface;
		
		
		roverFactory = new TRoverFactory();
		mapFactory = new MapFactory();
		
		inhabitantColl = new TInhabitantCollection();
		baseColl = new TBaseCollection();
		vehicleColl = new VehicleCollection();
		
		
		guiMngr = new TetraGUIManager(gui, tface, inhabitantColl);
		

		gui.addMouseListener(this);
		

		addMapBase();

		addVaderBase();

		addRiver();

		addHeroBase();

		addVader();

		addTRovers();

		addHero();
		
		
	}


	
	private void addRiver(){
		Base firstriver = BaseFactory.createBase("River", tface.getPosition(2,3));
		BaseView firstriverView = new BaseView(gui.getCellDimension(), firstriver);
		guiMngr.drawGrid(firstriver.getPosition(), firstriverView);

		Base secondriver = BaseFactory.createBase("River", tface.getPosition(3,2));
		BaseView secondriverView = new BaseView(gui.getCellDimension(), secondriver);
		guiMngr.drawGrid(secondriver.getPosition(), secondriverView);

		Base thirdriver = BaseFactory.createBase("River", tface.getPosition(4,3));
		BaseView thirdriverView = new BaseView(gui.getCellDimension(), thirdriver);
		guiMngr.drawGrid(thirdriver.getPosition(), thirdriverView);

		Base fourthriver = BaseFactory.createBase("River", tface.getPosition(3,4));
		BaseView fourthriverView = new BaseView(gui.getCellDimension(), fourthriver);
		guiMngr.drawGrid(fourthriver.getPosition(), fourthriverView);
		
		baseColl.addLocatableObject(firstriver);
		baseColl.addLocatableObject(secondriver);
		baseColl.addLocatableObject(thirdriver);
		baseColl.addLocatableObject(fourthriver);
		
	}

	
	private void addVaderBase(){
		Base vaderbase = BaseFactory.createBase("TVaderBase", tface.getPosition(3,3));
		BaseView vaderBaseView = new BaseView(gui.getCellDimension(), vaderbase);
		guiMngr.drawGrid(vaderbase.getPosition(), vaderBaseView);
		
		baseColl.addLocatableObject(vaderbase);
	}

	
	private void addHeroBase(){
		Base herobase = BaseFactory.createBase("THeroBase", tface.getPosition(0,0));
		BaseView heroBaseView = new BaseView(gui.getCellDimension(), herobase);
		guiMngr.drawGrid(herobase.getPosition(), heroBaseView);
		
		baseColl.addLocatableObject(herobase);
		}

	
	
	private void addMapBase(){
		mapbase1 =(MapBase) BaseFactory.createBase("MapBase", tface.getPosition(1,6));
		mapbase1.setTface(tface);
		BaseView mapBaseView1 = new BaseView(gui.getCellDimension(), mapbase1);
		guiMngr.drawGrid(mapbase1.getPosition(), mapBaseView1);

		map1 = mapFactory.createMap("StarAtlas", mapbase1.getPosition(), "M1");
		map1.setItemCount(0);
		
		map3 = mapFactory.createMap("StarMap", mapbase1.getPosition(), "M3");
		map3.setDirection("Inside StarAtlas.");
		map3.setItemCount(0);
		map1.addStarMap(map3);
		mapbase1.setMap(map1);
		
		mapbase2 = (MapBase) BaseFactory.createBase("MapBase", tface.getPosition(7,4));
		BaseView mapBaseView2 = new BaseView(gui.getCellDimension(), mapbase2);
		guiMngr.drawGrid(mapbase2.getPosition(), mapBaseView2);
		
		map2 = mapFactory.createMap("StarMap", mapbase2.getPosition(), "M2");
		map2.setDirection("Rovers displayed map!!");
		map2.setItemCount(0);
		mapbase2.setMap(map2);
		
		baseColl.addLocatableObject(mapbase1);
		baseColl.addLocatableObject(mapbase2);
		
	}

	
	private void addTRovers(){
		trover1 = roverFactory.createTRover("TRover", tface.getPosition(5,6));
		firstroverView = (TRoverView) guiMngr.generateViews(trover1); 
		trover1.setName("BumbleBee1");
		trover1.setTetId("TR1");
		trover1.setGender("M");
		guiMngr.drawGrid(trover1.getPosition(), firstroverView);
	
		trover2 = roverFactory.createTRover("TRover", tface.getPosition(7,0));
		secondroverView = (TRoverView) guiMngr.generateViews(trover2);
		trover1.setName("BumbleBee2");
		trover1.setTetId("TR2");
		trover1.setGender("M");
		guiMngr.drawGrid(trover2.getPosition(), secondroverView);

		inhabitantColl.addLocatableObject(trover1);
		inhabitantColl.addLocatableObject(trover2);
		trover1.setInhabitantColl(inhabitantColl);
		trover1.setBaseColl(baseColl);
		trover1.setVehicleColl(vehicleColl);
		trover2.setInhabitantColl(inhabitantColl);
		trover2.setBaseColl(baseColl);
		trover2.setVehicleColl(vehicleColl);
	}

	private void addVader(){
		tvader = (TVader) roverFactory.createTRover("TVader", tface.getPosition(3,3));
		TRoverView vaderView = new TRoverView(gui.getCellDimension(), tvader);
		gui.initializeGrid(tvader.getPosition(), vaderView);
		
		inhabitantColl.addLocatableObject(tvader);
		tvader.setInhabitantColl(inhabitantColl);
		tvader.setBaseColl(baseColl);
		tvader.setVehicleColl(vehicleColl);
	}

	private void addHero(){
		thero = (THero) roverFactory.createTRover("THero", tface.getPosition(3,7));
		TRoverView heroView = new TRoverView(gui.getCellDimension(), thero);
		gui.initializeGrid(thero.getPosition(), heroView);
		
		inhabitantColl.addLocatableObject(thero);
		thero.setInhabitantColl(inhabitantColl);
		thero.setBaseColl(baseColl);
		thero.setVehicleColl(vehicleColl);
	}
	
	private void addVehicle(){
		
	}
	
	private void addMap(){
		
	}

	public TRovers getTrover1(){
		return trover1;
	}

	public TRovers getTrover2(){
		return trover2;
	}
}
