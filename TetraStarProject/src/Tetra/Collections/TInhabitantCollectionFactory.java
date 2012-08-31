package Tetra.Collections;

import Tetra.TetraGUIManager;

public class TInhabitantCollectionFactory {

	private static TInhabitantCollection instance = null;
	protected TInhabitantCollectionFactory() {
		// Exists only to defeat instantiation.
	}
	public static TInhabitantCollection getInstance(TetraGUIManager guiMngr) {
		if(instance == null) {
			instance = new TInhabitantCollection(guiMngr);
		}
		return instance;
	}

}
