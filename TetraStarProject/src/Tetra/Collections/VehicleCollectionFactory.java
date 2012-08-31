package Tetra.Collections;

import Tetra.TetraGUIManager;

public class VehicleCollectionFactory {


	private static VehicleCollection instance = null;
	protected VehicleCollectionFactory() {
		// Exists only to defeat instantiation.
	}
	public static VehicleCollection getInstance(TetraGUIManager guiMngr) {
		if(instance == null) {
			instance = new VehicleCollection(guiMngr);
		}
		return instance;
	}

}
