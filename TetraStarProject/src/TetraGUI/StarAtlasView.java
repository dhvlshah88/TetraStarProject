package TetraGUI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

import Tetra.Map.Map;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.Iterator;


public class StarAtlasView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4118310718783060784L;
	private JPanel contentPane;
	private JLabel lblStar;
	private JPanel panel_StarMapContainer;
	private JLabel lblStarAtlasId_1;
	private JLabel lblStarAtlasId;
	private JLabel lblNoOfItems_1;
	private JLabel lblLocationId_1;
	private JLabel lblNoOfItems;
	private JLabel lblLocationId;
	private Map map = null;


	/**
	 * Create the frame.
	 */
	public StarAtlasView() {
		setTitle("Star Atlas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StarAtlasView.class.getResource("/images/StarAtlas.png")));
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);

		panel_StarMapContainer = new JPanel();
		panel_StarMapContainer.setBackground(SystemColor.window);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panel_StarMapContainer, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_StarMapContainer, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
						.addContainerGap())
				);


		panel_StarMapContainer.setLayout(new GridLayout(1, 0, 0, 0));

		lblStarAtlasId = new JLabel("Star Atlas ID: ");
		lblStarAtlasId.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblStarAtlasId_1 = new JLabel();
		lblStarAtlasId_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));


		lblNoOfItems = new JLabel("No. of Items");
		lblNoOfItems.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNoOfItems_1 = new JLabel();
		lblNoOfItems_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		lblLocationId = new JLabel("LocationID:");
		lblLocationId.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblLocationId_1 = new JLabel();
		lblLocationId_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(9)
						.addComponent(lblStarAtlasId, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblStarAtlasId_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGap(22)
						.addComponent(lblLocationId)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblLocationId_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addComponent(lblNoOfItems)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNoOfItems_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGap(36))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblStarAtlasId_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNoOfItems_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblStarAtlasId)
										.addComponent(lblNoOfItems)
										.addComponent(lblLocationId)
										.addComponent(lblLocationId_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(47, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void setStarAtlas(Map starAtlas){
		lblStarAtlasId_1.setText(starAtlas.getMapId()+"");
		lblNoOfItems_1.setText( starAtlas.getItemCount() + "" );
		lblLocationId_1.setText(starAtlas.getPositionId());
		
		Iterator<Map> starMapIterator =  starAtlas.getStarMapList().iterator();
		while(starMapIterator.hasNext()){
			map = starMapIterator.next();
			
			JPanel star = new JPanel();
			lblStar = new JLabel( (new ImageIcon(map.getImageFilePath())));
			star.add(lblStar);
			
			star.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						StarMapView starMapViewDialog = new StarMapView();
						starMapViewDialog.setStarMap(map);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
					
				}
			});
			
			panel_StarMapContainer.add(star);
		}
	}
}
