package Tetra.Scenarios;

import Tetra.TFace;
import TetraGUI.TetraStarGUI;

public class ScenarioFactory {

	Scenario testcase = null;
	
	public Scenario createScenario(int testCaseNo, TetraStarGUI gui, TFace tface){
		
		if(testcase != null){
			return testcase;
		}
		
		switch (testCaseNo) {
		case 1:
			testcase = new ScenarioOne(gui, tface);
			break;
		case 2:
			testcase = new ScenarioTwo(gui, tface);
			break;
		case 3:
			testcase = new ScenarioThree(gui, tface);
			break;
		case 4:
			testcase = new ScenarioFour(gui, tface);
			break;
		case 5:
			testcase = new ScenarioFive(gui, tface);
			break;
		default:
			break;
		}
		
		return testcase;
	}
}
