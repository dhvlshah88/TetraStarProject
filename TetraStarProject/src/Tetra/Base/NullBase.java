package Tetra.Base;

import Tetra.Position;

public class NullBase extends Base {

	public NullBase() {
		// TODO Auto-generated constructor stub
	}

	public NullBase(Position basePosition) {
	
	}

	@Override
	public String baseType() {
		return null;
	}

	@Override
	public String getImageFilePath() {
		return null;
	}

}
