package Tetra.Base;

import Tetra.Position;

public class NullBase extends Base {

	/*
	 * Default Constructor.
	 */
	public NullBase() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Do nothing constructor.
	 */
	public NullBase(Position basePosition) {
	
	}

	/*
	 * Do nothing method which returns null base type.
	 * @see Tetra.Base.Base#baseType()
	 */
	@Override
	public String baseType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see Tetra.Base.Base#getImageFilePath()
	 */
	@Override
	public String getImageFilePath() {
		return null;
	}

}
