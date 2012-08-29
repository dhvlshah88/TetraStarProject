package Tetra;

import TetraGUI.TetraStarGUI;

public class ScenarioFactory {

	Scenario testcase = null;
	
	public Scenario createScenario(int testCaseNo, TetraStarGUI gui, TFace tface){
		switch (testCaseNo) {
		case 1:
			testcase = new Scenario(gui, tface);
			break;

		default:
			break;
		}
		
		return testcase;
	}
}
