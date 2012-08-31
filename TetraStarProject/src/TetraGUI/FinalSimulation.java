package TetraGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Tetra.TFace;
import Tetra.Scenarios.Scenario;
import Tetra.Scenarios.ScenarioFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalSimulation extends JFrame {

	private JPanel contentPane;
	private TFace tface = null;
	Scenario scenario = null; 
	ScenarioFactory scenarioFactory = null;
	TetraStarGUI gui = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalSimulation frame = new FinalSimulation();
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
	public FinalSimulation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tface = new TFace(8, 8);
		JButton btnScenarioOne = new JButton("Scenario One");

		btnScenarioOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui = new TetraStarGUI(8,8);
				scenarioFactory = new ScenarioFactory();
				scenario = scenarioFactory.createScenario(1, gui, tface);

			}
		});

		JButton btnScenarioTwo = new JButton("Scenario Two");
		btnScenarioTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFace tface = new TFace(8, 8);
				gui = new TetraStarGUI(8,8);
				scenarioFactory = new ScenarioFactory();
				scenario = scenarioFactory.createScenario(2, gui, tface);

			}
		});

		JButton btnScenarioThree = new JButton("Scenario Three");
		btnScenarioThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TFace tface = new TFace(8, 8);
				gui = new TetraStarGUI(8,8);
				scenarioFactory = new ScenarioFactory();
				scenario = scenarioFactory.createScenario(3, gui, tface);

			}
		});

		JButton btnScenarioFour = new JButton("Scenario Four");
		btnScenarioFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFace tface = new TFace(8, 8);
				gui = new TetraStarGUI(8,8);
				scenarioFactory = new ScenarioFactory();
				scenario = scenarioFactory.createScenario(4, gui, tface);
				
			}
		});

		JButton btnScenarioFive = new JButton("Scenario Five");
		btnScenarioFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFace tface = new TFace(8, 8);
				gui = new TetraStarGUI(8,8);
				scenarioFactory = new ScenarioFactory();
				scenario = scenarioFactory.createScenario(5, gui, tface);				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(70)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnScenarioFive, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnScenarioFour, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnScenarioThree, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnScenarioOne, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnScenarioTwo, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(425, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(52)
						.addComponent(btnScenarioOne, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addComponent(btnScenarioTwo, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addComponent(btnScenarioThree, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(34)
						.addComponent(btnScenarioFour, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addComponent(btnScenarioFive, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(143, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
