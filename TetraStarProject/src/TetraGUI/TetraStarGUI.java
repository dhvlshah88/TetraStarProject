package TetraGUI;

import java.awt.EventQueue;

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
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TetraStarGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2316960806450516275L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		gridPanel.setBackground(Color.GRAY);
		
		JSeparator separator = new JSeparator();
		
		JPanel stepDisplayPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
				.addComponent(stepDisplayPanel, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(gridPanel, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stepDisplayPanel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
		);
		
		JLabel lblSteps = new JLabel("Steps");
		lblSteps.setFont(new Font("Dialog", Font.BOLD, 12));
		GroupLayout gl_stepDisplayPanel = new GroupLayout(stepDisplayPanel);
		gl_stepDisplayPanel.setHorizontalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSteps)
					.addContainerGap(941, Short.MAX_VALUE))
		);
		gl_stepDisplayPanel.setVerticalGroup(
			gl_stepDisplayPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_stepDisplayPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSteps)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		stepDisplayPanel.setLayout(gl_stepDisplayPanel);
		gridPanel.setLayout(new GridLayout(8, 8, 0, 0));
		contentPane.setLayout(gl_contentPane);
	}
}
