package TetraGUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

import Tetra.Location;
import Tetra.Position;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TetraStarGUI extends JFrame {

	private static final long serialVersionUID = 2316960806450516275L;
	private JPanel contentPane;
	private JPanel[][] cellPanel = null;
	static JTextArea taDisplaySteps = null;
	private final int rows;
	private final int columns;
	Dimension cellDimension = null;
	private int value;

	/**
	 * Create the frame.
	 */
	public TetraStarGUI(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		setResizable(false);
		setMaximumSize(new Dimension(1000, 600));
		setTitle("Tetra Star Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gridPanel.setSize(new Dimension(994, 518));
		gridPanel.setBackground(Color.GRAY);

		JSeparator separator = new JSeparator();

		JPanel stepDisplayPanel = new JPanel();
		stepDisplayPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

		JPanel functionalityPanel = new JPanel();
		functionalityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(stepDisplayPanel, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(functionalityPanel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
				.addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(stepDisplayPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(functionalityPanel, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
					.addGap(39))
		);
		
		JRadioButton rdbtnScenario = new JRadioButton("Scenario 1");
		rdbtnScenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				value = 1;
			}
		});
		
		functionalityPanel.add(rdbtnScenario);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_stepDisplayPanel = new GroupLayout(stepDisplayPanel);
		gl_stepDisplayPanel.setHorizontalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_stepDisplayPanel.setVerticalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.CENTER, gl_stepDisplayPanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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

		cellDimension = new Dimension(width/rows - 10, height/columns - 10);

		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){

				cellPanel[i][j] = new JPanel();
				gridPanel.add(cellPanel[i][j]);
				cellPanel[i][j].setVisible(true);
				cellPanel[i][j].setPreferredSize(cellDimension);
				cellPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				cellPanel[i][j].setBackground(new Color(150, 93, 82)); //Brown Color.
			}
		}
	}


	public void redrawGrid(){
		repaint();
	}
	
	public void drawLocatableObj(Position position, JPanel locatableViews){
		cellPanel[position.getRowNo()][position.getColumnNo()].add(locatableViews);
		cellPanel[position.getRowNo()][position.getColumnNo()].revalidate();
		cellPanel[position.getRowNo()][position.getColumnNo()].repaint();
	}
	
	public Dimension getCellDimension(){
		return cellDimension;
	}
}
