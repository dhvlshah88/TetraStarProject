package Tetra.Scenarios;

import java.awt.event.MouseEvent;

import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.THero;
import TetraGUI.TetraStarGUI;

public class ScenarioFour extends Scenario {
	private Position nextPosition;
	private	TFace tface = null;
	private TetraStarGUI gui = null;
	private static int steps = 1;
	private THero  tHero ;


	public ScenarioFour(TetraStarGUI gui, TFace tface) {
		super(gui, tface);
		this.gui=gui;
		this.tface = tface;
		tHero = super.getTHero1();
	}

	public void mouseClicked ( MouseEvent e ) {

		switch(steps)
		{
		case 1:
			nextPosition = tface.getPosition(1,0);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 2:
			nextPosition = tface.getPosition(1,1);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 3:
			nextPosition = tface.getPosition(2,1);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 4:
			nextPosition = tface.getPosition(3,1);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 5:
			nextPosition = tface.getPosition(4,1);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 6:
			nextPosition = tface.getPosition(4,2);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 7:
			nextPosition = tface.getPosition(5,2);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 8:
			nextPosition = tface.getPosition(6,2);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;


		case 9:
			nextPosition = tface.getPosition(7,2);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 10:
			nextPosition = tface.getPosition(7,3);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 11:
			nextPosition = tface.getPosition(7,4);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;

		case 12:
			nextPosition = tface.getPosition(6,4);
			tHero.moveToPosition(nextPosition);
			steps++;
			break;
		default:
			gui.setVisible(false);
		}

	}

}
