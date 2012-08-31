/**
 * 
 */
package Tetra.Scenarios;

import java.awt.event.MouseEvent;

import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.TRovers;
import TetraGUI.TetraStarGUI;

/**
 * @author Dhaval
 *
 */
public class ScenarioOne extends Scenario {

	private Position nextPosition;
	private	TFace tface = null;
	private TetraStarGUI gui = null;
	private static int steps = 1;
	TRovers tRover ;

	/**
	 * @param gui
	 * @param tface
	 */
	public ScenarioOne(TetraStarGUI gui, TFace tface) {
		super(gui, tface);
		this.tface = tface;
		this.gui = gui;
		tRover = super.getTrover1();
	}

	public void mouseClicked(MouseEvent e) {

		switch(steps){

		case 1:
			nextPosition = tface.getPosition(5,5);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 2:
			nextPosition = tface.getPosition(5,4);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 3:
			nextPosition = tface.getPosition(5,3);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 4:
			nextPosition = tface.getPosition(5,2);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 5:
			nextPosition = tface.getPosition(6,2);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 6:
			nextPosition = tface.getPosition(7,2);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 7:
			nextPosition = tface.getPosition(7,3);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 8:
			nextPosition = tface.getPosition(7,4);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		case 9:
			nextPosition = tface.getPosition(7,5);
			tRover.moveToPosition(nextPosition);
			steps++;
			break;
		default:
			gui.setVisible(false);
		}
	}




}
