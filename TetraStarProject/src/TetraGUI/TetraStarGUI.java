package TetraGUI;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import Tetra.Position;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;


public class TetraStarGUI extends JFrame {

	private static final long serialVersionUID = 2316960806450516275L;
	private JPanel contentPane;
	private JPanel[][] cellPanel = null;
	static JTextArea taDisplaySteps = null;
	private int rows;
	private int columns;
	Dimension cellDimension = null;
	JPanel gridPanel = null;
	Border cellBorder = null;
	Border selectedCellBorder = null;
	Border occupiedCellBorder = null;

	/**
	 * Create the frame.
	 */
	public TetraStarGUI(int rows, int columns) {
		this.setRows(rows);
		this.setColumns(columns);
		setResizable(false);
		setMaximumSize(new Dimension(1000, 600));
		setTitle("Tetra Star Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		gridPanel = new JPanel();
		gridPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gridPanel.setSize(new Dimension(994, 518));
		gridPanel.setBackground(Color.GRAY);

		JSeparator separator = new JSeparator();

		JPanel stepDisplayPanel = new JPanel();
		stepDisplayPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
				.addComponent(stepDisplayPanel, GroupLayout.PREFERRED_SIZE, 1006, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stepDisplayPanel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_stepDisplayPanel = new GroupLayout(stepDisplayPanel);
		gl_stepDisplayPanel.setHorizontalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1007, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_stepDisplayPanel.setVerticalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);

		JLabel lblSteps = new JLabel("Display Steps");
		scrollPane.setColumnHeaderView(lblSteps);
		lblSteps.setFont(new Font("Dialog", Font.BOLD, 12));

		taDisplaySteps = new JTextArea();
		taDisplaySteps.setEditable(false);
		scrollPane.setViewportView(taDisplaySteps);
		stepDisplayPanel.setLayout(gl_stepDisplayPanel);
		gridPanel.setLayout(new GridLayout(8, 8, 0, 0));
		contentPane.setLayout(gl_contentPane);

		cellBorder = BorderFactory.createLineBorder(Color.black, 1);
		selectedCellBorder = BorderFactory.createLineBorder(Color.green, 3);
		occupiedCellBorder = BorderFactory.createLineBorder(Color.red, 3);
		
		generateCell(gridPanel, rows, columns);
		setVisible(true);
		pack();
	}

	public static void DisplaySteps(String message) {
		taDisplaySteps.append(message + "\n");
		taDisplaySteps.repaint();
	} 

	private void generateCell(JPanel gridPanel, int rows, int columns){
		cellPanel = new JPanel[rows][columns];
		int width = gridPanel.getWidth();
		int height = gridPanel.getHeight();

		cellDimension = new Dimension(width/rows, height/columns);

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){

				cellPanel[i][j] = new JPanel();
				gridPanel.add(cellPanel[i][j]);
				cellPanel[i][j].setLayout(new GridLayout());
				cellPanel[i][j].setVisible(true);
				cellPanel[i][j].setPreferredSize(cellDimension);
				cellPanel[i][j].setBorder(cellBorder);
				cellPanel[i][j].setBackground(new Color(150, 93, 82)); //Brown Color.
				//cellPanel[i][j].setToolTipText("(" + i +", " + j + ")");
			}
		}
	}


	public void redrawGrid(Position prevPosition, Position currentPosition){
		JPanel view = null;
		if(cellPanel[prevPosition.getRowNo()][prevPosition.getColumnNo()].getComponentCount() != 1){
			view = (JPanel) cellPanel[prevPosition.getRowNo()][prevPosition.getColumnNo()].getComponent(1);	
		}else{
			view = (JPanel) cellPanel[prevPosition.getRowNo()][prevPosition.getColumnNo()].getComponent(0);
		}
		cellPanel[currentPosition.getRowNo()][currentPosition.getColumnNo()].add(view);
		cellPanel[currentPosition.getRowNo()][currentPosition.getColumnNo()].setBorder(selectedCellBorder);
		cellPanel[prevPosition.getRowNo()][prevPosition.getColumnNo()].setBorder(cellBorder);
		cellPanel[prevPosition.getRowNo()][prevPosition.getColumnNo()].remove(view);
		gridPanel.revalidate();
		gridPanel.repaint();
	}

	public void initializeGrid(Position position, JPanel locatableViews){
		cellPanel[position.getRowNo()][position.getColumnNo()].add(locatableViews);
		gridPanel.revalidate();
		gridPanel.repaint();
	}

	public Dimension getCellDimension(){
		return cellDimension;
	}
	
	public void highlightCell(Position position, boolean troverPresent){
		if(troverPresent){
			cellPanel[position.getRowNo()][position.getColumnNo()].setBorder(occupiedCellBorder);
		}
		gridPanel.revalidate();
		gridPanel.repaint();
	}

	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

}
