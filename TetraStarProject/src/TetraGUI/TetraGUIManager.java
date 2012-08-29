package TetraGUI;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import Tetra.ILocatable;
import Tetra.LocatableCollection;
import Tetra.Position;
import Tetra.Inhabitant.TRovers;

public class TetraGUIManager implements Observer {

	//private LocatableCollection locatableColl = null;
	private HashMap<Position, ILocatable> locatableHashMap = null;
	private Collection<ILocatable> locatableColl = null;

	public TetraGUIManager(Observable observableObj){
		observableObj.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object arg) {
		
		if(arg == null){
			locatableHashMap = ((LocatableCollection) observable).getLocatable();
			locatableColl = locatableHashMap.values();
			
			
		}else{
			if(arg instanceof TRovers){
				
			}
			
			
		}
		
	}
}
