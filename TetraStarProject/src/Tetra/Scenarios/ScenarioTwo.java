/**
 * 
 */
package Tetra.Scenarios;

import java.awt.event.MouseEvent;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TFace;
import Tetra.Base.MapBase;
import Tetra.Base.River;
import Tetra.Base.THeroBase;
import Tetra.Base.TVaderBase;
import Tetra.Inhabitant.THero;
import Tetra.Inhabitant.TRovers;
import Tetra.Inhabitant.Vehicle.Vehicle;
import TetraGUI.TetraStarGUI;

/**
 * @author Dhaval
 *
 */
public class ScenarioTwo extends Scenario {

	private Position nextPosition;
	private	TFace tface = null;
	private TetraStarGUI gui=null;
	private static int steps = 1;
	private THero  tHero ;


	public ScenarioTwo(TetraStarGUI gui, TFace tface) {
		super(gui, tface);
		this.tface = tface;
		this.gui = gui;
		tHero = super.getTHero();
	}

	public void mouseClicked ( MouseEvent e ) {

		switch(steps)
		{
		case 1:
			nextPosition = tface.getPosition(2,7);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			
			steps++;
			break;

		case 2:
			nextPosition = tface.getPosition(1,7);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 3:
			nextPosition = tface.getPosition(1,6);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 4:
			nextPosition = tface.getPosition(1,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 5:
			nextPosition = tface.getPosition(2,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 6:
			nextPosition = tface.getPosition(3,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 7:
			nextPosition = tface.getPosition(4,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;


		case 8:
			nextPosition = tface.getPosition(5,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;


		case 9:
			nextPosition = tface.getPosition(5,6);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 10:
			nextPosition = tface.getPosition(6,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 11:
			nextPosition = tface.getPosition(7,5);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;

		case 12:
			nextPosition = tface.getPosition(7,4);
			//tHero.moveToPosition(nextPosition);
			moveHero(tHero.validatePosition(nextPosition), nextPosition);
			steps++;
			break;
			
		default:
			gui.setVisible(false);

		}

	}

	public void moveHero(ILocatable locatableObj, Position nextPosition){
		
		if(locatableObj instanceof TRovers || locatableObj instanceof River){
			return;
		}
		
		if(locatableObj == null){
			tHero.moveAStep(nextPosition);
			return;
		}
		
		if(locatableObj instanceof MapBase){
			tHero.moveAStep(nextPosition);
			tHero.enterMapBase(locatableObj);
			return;
		}
		
		if(locatableObj instanceof THeroBase){
			tHero.moveAStep(nextPosition);
			tHero.enterHeroBase(locatableObj);
			return;
		}
		
		if(locatableObj instanceof TVaderBase){
			tHero.moveAStep(nextPosition);
			tHero.enterVaderBase(locatableObj);
			return;
		}
		
		if(locatableObj instanceof Vehicle){
			tHero.moveAStep(nextPosition);
			tHero.setVehicle((Vehicle)locatableObj);
		}
		
		
	}

}
