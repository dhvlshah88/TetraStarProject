package TetraGUI;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Tetra.ILocatable;
import Tetra.Position;
import Tetra.TFace;
import Tetra.Inhabitant.TRovers;


public class TetraGUIManager implements Observer {

	private TFace tfaceObj = null;
	private TetraStarGUI gui = null;
	private ILocatable locatableObj = null;
	private TetraViewFactory viewFactory = null;

	public TetraGUIManager(TetraStarGUI gui, TFace tfaceObj, Observable observableObj){
		this.gui = gui;
		this.tfaceObj = tfaceObj;
		observableObj.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object arg) {

		locatableObj = (ILocatable) arg;
		if(locatableObj instanceof TRovers){
			TRovers trover = ((TRovers)locatableObj);
			if(trover.getPrevPosition() == null){

			}
			else{
				redrawGrid(trover.getPrevPosition(), trover.getPosition());
			}
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
	
}
