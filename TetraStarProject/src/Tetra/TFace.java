/**
 * 
 */
package Tetra;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * @author Dhaval
 *
 */
public class TFace {
	
	JFrame tetraFrame = new JFrame();
	Dimension frameDimension;
	Dimension panelDimension;

	
	/**
	 * 
	 */
	public TFace(int rows, int columns) {
		// TODO Auto-generated constructor stub
		
		frameDimension = new Dimension(1000, 700);
		tetraFrame.setPreferredSize(frameDimension);
		tetraFrame.setLayout(new GridLayout(rows, columns));
		panelDimension = new Dimension(frameDimension.width/rows, frameDimension.height/columns);
		JPanel[][] arrPanel = new JPanel[rows][columns];
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
			arrPanel[i][j] = new JPanel();
			arrPanel[i][j].setPreferredSize(panelDimension);
			
			//if ((i + j) % 2 == 0) {
	                arrPanel[i][j].setBackground(Color.white);
	        /* } 
			 else {
				 arrPanel[i][j].setBackground(Color.white);
	         }*/
			
			arrPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black,1));
			tetraFrame.add(arrPanel[i][j]);
			
		  }
		}
		tetraFrame.pack();
		tetraFrame.setVisible(true);
	}

	public TFace(){
	this(6,6);	
	}

}
