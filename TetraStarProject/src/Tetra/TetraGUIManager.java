package Tetra;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Tetra.Inhabitant.TRovers;
import TetraGUI.TetraStarGUI;
import TetraGUI.TetraViewFactory;


public class TetraGUIManager implements Observer{

	private TFace tfaceObj = null;
	private TetraStarGUI gui = null;
	private ILocatable locatableObj = null;
	private TetraViewFactory viewFactory = null;

	public TetraGUIManager() {
		// TODO Auto-generated constructor stub
	}

	public TetraGUIManager(TetraStarGUI gui, TFace tfaceObj){
		this.gui = gui;
		this.tfaceObj = tfaceObj;
		//observableObj.addObserver(this);
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

}
