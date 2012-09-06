package Tetra.Scenarios;

import java.awt.event.MouseEvent;

import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.TVader;
import TetraGUI.TetraStarGUI;

public class ScenarioThree extends Scenario {

	private Position nextPosition;
	private	TFace tface = null;
	private TetraStarGUI gui = null;
	private static int steps = 1;
	private TVader tVader ;


	public ScenarioThree(TetraStarGUI gui, TFace tface) {
		super(gui, tface);
		this.tface = tface;
		this.gui = gui;
		tVader = super.getTvader();
	}

	public void mouseClicked ( MouseEvent e ) {

		switch(steps)
		{
		case 1:
			nextPosition = tface.getPosition(3,6);
			tVader.moveToPosition(nextPosition);
			steps++;
			break;

		case 2:
			nextPosition = tface.getPosition(5,0);
			tVader.moveToPosition(nextPosition);
			steps++;
			break;

		case 3:
			nextPosition = tface.getPosition(1,6);
			tVader.moveToPosition(nextPosition);
			steps++;
			break;

		case 4:
			tVader.retracePosition();
			steps++;
			break;

		case 5:
			tVader.retracePosition();
			steps++;
			break;
			
		case 6:
			tVader.retracePosition();
			steps++;
			break;
			
		default:
			gui.setVisible(false);
		
		}

	}
}
