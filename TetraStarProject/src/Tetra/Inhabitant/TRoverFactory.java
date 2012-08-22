/**
 * 
 */
package Tetra.Inhabitant;



/**
 * @author Dhaval
 *
 */
public class TRoverFactory {
	private TVader tVader=null;


	public TRovers createTRover(String type){

		TRovers tRover=null;
		if (type.equals("TRover")) {
			tRover = new TRovers("TRover", "", "");
		} else if (type.equals("THero")) {
			tRover = new THero("THero", "", "");
		} else if (type.equals("TVader")) {
			tRover = createTVaderIfNotPresent();
		}
		return tRover;
	}

	private TVader createTVaderIfNotPresent(){
		if(tVader==null){
			tVader=new TVader("Megatron", "", "");
		}

		return tVader;
	}
}
