package Tetra;

import java.awt.event.MouseAdapter;

import Tetra.Base.*;
import Tetra.Inhabitant.TRoverFactory;
import Tetra.Inhabitant.TRovers;
import TetraGUI.BaseView;
import TetraGUI.TRoverView;
import TetraGUI.TetraStarGUI;

public class Simulation extends MouseAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		TFace tface = new TFace(8, 8);
		
		TetraStarGUI gui = new TetraStarGUI(8,8);
			
		ScenarioFactory factory = new ScenarioFactory();
		
		Scenario scenario = factory.createScenario(1, gui, tface);
		
		
	}
	
	
	
}
