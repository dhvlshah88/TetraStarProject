package TetraGUI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

import Tetra.Map.Map;
import Tetra.Map.StarAtlas;
import java.awt.GridLayout;


public class StarAtlasView extends JFrame {

	private JPanel contentPane;
	private JLabel lblStar;
	private JPanel panel_StarMapContainer;
	private JLabel lblStarAtlasID;
	private JLabel lblStarAtlasId;
	private JLabel lblCount;
	private JLabel lblLocation;
	private JLabel lblNoOfItems;
	private JLabel lblPositionid;
	Map map=null;
	StarAtlas starAtlas = null;
	
	/**
	 * Create the frame.
	 */
	public StarAtlasView(StarAtlas atlas) {
		starAtlas=atlas;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		atlas.getMapId();
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.select"));
		
		panel_StarMapContainer = new JPanel();
		panel_StarMapContainer.setBackground(SystemColor.window);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_StarMapContainer, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addGap(12))
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_StarMapContainer, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		panel_StarMapContainer.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblStarAtlasID = new JLabel("starAtlasMessage");
		
		lblStarAtlasId = new JLabel("Star Atlas ID : ");
		
		lblCount = new JLabel("count");
		lblLocation = new JLabel("location");
		
		lblNoOfItems = new JLabel("No. of Items");
		
		lblPositionid = new JLabel("LocationID:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(lblStarAtlasId)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStarAtlasID)
					.addGap(50)
					.addComponent(lblPositionid)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLocation)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(lblNoOfItems)
					.addGap(18)
					.addComponent(lblCount, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStarAtlasID)
						.addComponent(lblStarAtlasId)
						.addComponent(lblCount, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNoOfItems)
						.addComponent(lblPositionid)
						.addComponent(lblLocation))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		setValues(atlas);
		}

	private void setValues(StarAtlas atlas){
	
		lblStarAtlasID.setText(atlas.getMapId()+"");
		lblCount.setText( atlas.getItemCount() + "" );
		lblLocation.setText(atlas.getPositionId());

		for(final Map map : atlas.getStarMapList()){
			JPanel star = new JPanel();

			lblStar = new JLabel( (new ImageIcon("src/images/starImage.jpg") ));
			star.add(lblStar);
			
			star.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						StarMapView dialog = new StarMapView(map);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
		
				}
			});
		
			panel_StarMapContainer.add(star);
		}

	}

}
