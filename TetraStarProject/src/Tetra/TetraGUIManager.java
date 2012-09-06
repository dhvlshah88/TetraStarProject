package Tetra;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import Tetra.Inhabitant.TRovers;
import Tetra.Scenarios.Scenario;
import TetraGUI.TetraStarGUI;
import TetraGUI.TetraViewFactory;


public class TetraGUIManager implements Observer{

	private TetraStarGUI gui = null;
	private ILocatable locatableObj = null;
	private TetraViewFactory viewFactory = null;

	public TetraGUIManager() {
		
	}

	public TetraGUIManager(int rows, int columns, Scenario scenario){
		this.gui = new TetraStarGUI(rows, columns);
		gui.addMouseListener(scenario);
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(arg instanceof ILocatable){
			locatableObj = (ILocatable) arg;
			if(locatableObj instanceof TRovers){
				TRovers trover = ((TRovers)locatableObj);
				if(trover.getPrevPosition() == null){
					drawGrid(trover.getPosition(), this.generateViews(trover));
				}
				else{
					redrawGrid(trover.getPrevPosition(), trover.getPosition());
				}
			}else{
				drawGrid(locatableObj.getPosition(), this.generateViews(locatableObj));
			}
		}
		
		if(arg instanceof Position){
			gui.highlightCell((Position)arg, true);
		}
	}

	public void redrawGrid(Position prevPosition, Position currentPosition){
		gui.redrawGrid(prevPosition, currentPosition);
	}

	public void drawGrid(Position currentPosition, JPanel locatableViews){
		gui.initializeGrid(currentPosition, locatableViews);
	}

	public Dimension getCellDimension(){
		return gui.getCellDimension();
	}

	public JPanel generateViews(ILocatable locatableObj){
		viewFactory = new TetraViewFactory(this.getCellDimension());
		return viewFactory.generateViews(locatableObj);
	}
	
	/**
	 * This static method calls <code>DisplaySteps()</code> method of <code>TetraStarGUI</code> class to print steps
	 * executed on GUI's text area component.
	 * @param steps 
	 */
	public static void DisplaySteps(String steps){
		TetraStarGUI.DisplaySteps(steps);
	}

}
