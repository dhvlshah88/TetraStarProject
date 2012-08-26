package TetraGUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;

import Tetra.Location;
import Tetra.Position;

public class TetraStarGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2316960806450516275L;
	private JPanel contentPane;
	private Location[][] cellPanel = null;
	JTextArea taDisplaySteps = null;
	private final int ROWS = 8;
	private final int COLUMNS = 8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TetraStarGUI frame = new TetraStarGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TetraStarGUI() {
		setResizable(false);
		setMaximumSize(new Dimension(1000, 700));
		setTitle("Tetra Star Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		gridPanel.setPreferredSize(new Dimension(994, 518));
		gridPanel.setBackground(Color.GRAY);
		
		JSeparator separator = new JSeparator();
		
		JPanel stepDisplayPanel = new JPanel();
		stepDisplayPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel functionalityPanel = new JPanel();
		functionalityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(stepDisplayPanel, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(functionalityPanel, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
				.addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 994, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(stepDisplayPanel, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
						.addComponent(functionalityPanel, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
		);
		
		JLabel lblSteps = new JLabel("Display Steps");
		lblSteps.setFont(new Font("Dialog", Font.BOLD, 12));
		
		taDisplaySteps = new JTextArea();
		GroupLayout gl_stepDisplayPanel = new GroupLayout(stepDisplayPanel);
		gl_stepDisplayPanel.setHorizontalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSteps)
						.addComponent(taDisplaySteps, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_stepDisplayPanel.setVerticalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSteps, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taDisplaySteps, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
					.addContainerGap())
		);
		stepDisplayPanel.setLayout(gl_stepDisplayPanel);
		gridPanel.setLayout(new GridLayout(8, 8, 0, 0));
		contentPane.setLayout(gl_contentPane);
		
		generateCell(gridPanel, ROWS, COLUMNS);
		pack();
	}
	
	
	private void generateCell(JPanel gridPanel, int rows, int columns){
		cellPanel = new Location[rows][columns];
		int width = gridPanel.getWidth();
		int height = gridPanel.getHeight();
		
		Dimension cellDimension = new Dimension(width/rows, height/columns);
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				cellPanel[i][j] = new Location(new Position(i, j));
				gridPanel.add(cellPanel[i][j]);
				cellPanel[i][j].setVisible(true);
				cellPanel[i][j].setPreferredSize(cellDimension);
				cellPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				cellPanel[i][j].setBackground(new Color(150, 93, 82)); //Brown Color.
				
				cellPanel[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						taDisplaySteps.setText(((Location) e.getSource()).getPosition().toString());
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});

			}
		}
		
		//cellPanel[0][0].add(new TInhabitantView(cellDimension));
	}
}
