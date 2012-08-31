/**
 * 
 */
package Tetra.Scenarios;

import java.awt.event.MouseEvent;

import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.THero;
import Tetra.Inhabitant.TVader;
import TetraGUI.TetraStarGUI;

/**
 * @author Dhaval
 *
 */
public class ScenarioFive extends Scenario{


	private Position nextPosition;
	private	TFace tface = null;
	private TetraStarGUI gui = null;
	private static int steps = 1;
	private TVader tVader ;
	private THero tHero1;


	public ScenarioFive(TetraStarGUI gui, TFace tface) {
		super(gui, tface);
		this.tface = tface;
		this.gui = gui;
		tVader = super.getTvader();
		tHero1 = super.getTHero1();
	}

	public void mouseClicked ( MouseEvent e ) {

		switch(steps)
		{
		case 1:
			nextPosition = tface.getPosition(3,0);
			tVader.moveToPosition(nextPosition);
			steps++;
			break;

		case 2:
			tVader.retracePosition();
			steps++;
			break;

		case 3:
			nextPosition = tface.getPosition(1,0);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;

		case 4:
			nextPosition = tface.getPosition(2,0);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;

		case 5:
			nextPosition = tface.getPosition(3,0);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 6:
			nextPosition = tface.getPosition(3,1);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 7:
			nextPosition = tface.getPosition(3,2);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 8:
			nextPosition = tface.getPosition(4,2);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 9:
			nextPosition = tface.getPosition(1,3);
			tVader.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 10:
			nextPosition = tface.getPosition(3,3);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
		case 11:
			nextPosition = tface.getPosition(3,0);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;	

		case 12:
			nextPosition = tface.getPosition(0,0);
			tHero1.moveToPosition(nextPosition);
			steps++;
			break;
			
			
		default:
			gui.setVisible(false);
		
		}

	}
}
