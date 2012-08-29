/**
 * 
 */
package Tetra;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Tetra.Base.Base;
import Tetra.Base.BaseFactory;
import Tetra.Inhabitant.TRoverFactory;
import Tetra.Inhabitant.TRovers;
import TetraGUI.BaseView;
import TetraGUI.TRoverView;

/**
 * @author Dhaval
 *
 */
public class Scenario extends MouseAdapter {

	private TetraStarGUI gui = null;
	private TFace tface = null;

	public Scenario(TetraStarGUI gui, TFace tface){
		this.gui = gui;
		this.tface = tface;

		gui.addMouseListener(this);
		
		addTRovers(gui, tface);

		addMapBase(gui, tface);

		addVaderBase(gui, tface);

		addVader(gui, tface);

		addRiver(gui, tface);

		addHeroBase(gui, tface);

		addHero(gui, tface);
	}


	private static void addRiver(TetraStarGUI gui, TFace tface){
		Base firstriver = BaseFactory.createBase("River", tface.getPosition(2,3));
		BaseView firstriverView = new BaseView(gui.getCellDimension(), firstriver);
		gui.drawLocatableObj(firstriver.getPosition(), firstriverView);

		Base secondriver = BaseFactory.createBase("River", tface.getPosition(3,2));
		BaseView secondriverView = new BaseView(gui.getCellDimension(), secondriver);
		gui.drawLocatableObj(secondriver.getPosition(), secondriverView);

		Base thirdriver = BaseFactory.createBase("River", tface.getPosition(4,3));
		BaseView thirdriverView = new BaseView(gui.getCellDimension(), thirdriver);
		gui.drawLocatableObj(thirdriver.getPosition(), thirdriverView);

		Base fourthriver = BaseFactory.createBase("River", tface.getPosition(3,4));
		BaseView fourthriverView = new BaseView(gui.getCellDimension(), fourthriver);
		gui.drawLocatableObj(fourthriver.getPosition(), fourthriverView);
	}

	private static void addVaderBase(TetraStarGUI gui, TFace tface){
		Base vaderbase = BaseFactory.createBase("TVaderBase", tface.getPosition(3,3));
		BaseView vaderBaseView = new BaseView(gui.getCellDimension(), vaderbase);
		gui.drawLocatableObj(vaderbase.getPosition(), vaderBaseView);
	}

	private static void addHeroBase(TetraStarGUI gui, TFace tface){
		Base herobase = BaseFactory.createBase("THeroBase", tface.getPosition(0,0));
		BaseView heroBaseView = new BaseView(gui.getCellDimension(), herobase);
		gui.drawLocatableObj(herobase.getPosition(), heroBaseView);
	}

	private static void addMapBase(TetraStarGUI gui, TFace tface){
		Base mapbase1 = BaseFactory.createBase("MapBase", tface.getPosition(1,6));
		BaseView mapBaseView1 = new BaseView(gui.getCellDimension(), mapbase1);
		gui.drawLocatableObj(mapbase1.getPosition(), mapBaseView1);

		Base mapbase2 = BaseFactory.createBase("MapBase", tface.getPosition(7,4));
		BaseView mapBaseView2 = new BaseView(gui.getCellDimension(), mapbase2);
		gui.drawLocatableObj(mapbase2.getPosition(), mapBaseView2);
	}

	private static void addTRovers(TetraStarGUI gui, TFace tface){
		TRoverFactory roverFactory = new TRoverFactory();

		TRovers trover1 = roverFactory.createTRover("TRover", tface.getPosition(5,6));
		TRoverView firstroverView = new TRoverView(gui.getCellDimension(), trover1);
		gui.drawLocatableObj(trover1.getPosition(), firstroverView);

		TRovers trover2 = roverFactory.createTRover("TRover", tface.getPosition(7,0));
		TRoverView secondroverView = new TRoverView(gui.getCellDimension(), trover2);
		gui.drawLocatableObj(trover2.getPosition(), secondroverView);

	}

	private static void addVader(TetraStarGUI gui, TFace tface){
		TRoverFactory roverFactory = new TRoverFactory();
		TRovers tvader = roverFactory.createTRover("TVader", tface.getPosition(3,3));
		TRoverView vaderView = new TRoverView(gui.getCellDimension(), tvader);
		gui.drawLocatableObj(tvader.getPosition(), vaderView);
	}

	private static void addHero(TetraStarGUI gui, TFace tface){
		TRoverFactory roverFactory = new TRoverFactory();
		TRovers thero = roverFactory.createTRover("THero", tface.getPosition(3,7));
		TRoverView heroView = new TRoverView(gui.getCellDimension(), thero);
		gui.drawLocatableObj(thero.getPosition(), heroView);
	}


}
