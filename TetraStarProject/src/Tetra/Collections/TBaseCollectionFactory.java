package Tetra.Collections;

import Tetra.TetraGUIManager;

public class TBaseCollectionFactory {


	private static TBaseCollection instance = null;
	protected TBaseCollectionFactory() {
		// Exists only to defeat instantiation.
	}
	public static TBaseCollection getInstance(TetraGUIManager guiMngr) {
		if(instance == null) {
			instance = new TBaseCollection(guiMngr);
		}
		return instance;
	}

}
