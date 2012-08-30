package TetraGUI;

import java.awt.Dimension;

import javax.swing.JPanel;

import Tetra.ILocatable;
import Tetra.Base.Base;
import Tetra.Inhabitant.TRovers;
import Tetra.Inhabitant.Vehicle.Vehicle;

public class TetraViewFactory {

	private JPanel tetraViews = null;
	private Dimension cellDimension = null; 

	public TetraViewFactory(Dimension cellDimension){
		this.cellDimension = cellDimension;
	}

	public JPanel generateViews(ILocatable locatableObj) {

		if(locatableObj instanceof TRovers){
			tetraViews = new TRoverView(cellDimension, ((TRovers)locatableObj));
		}

		if(locatableObj instanceof Base){
			tetraViews = new BaseView(cellDimension, ((Base)locatableObj));
		}

		if(locatableObj instanceof Vehicle){
			tetraViews = new VehicleView(cellDimension, ((Vehicle)locatableObj));
		}
		return tetraViews;
	}

}
