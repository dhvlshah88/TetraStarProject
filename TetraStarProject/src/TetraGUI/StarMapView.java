package TetraGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Tetra.Map.Map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class StarMapView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	Map map = null;
	private JLabel lblId;
	private JLabel lblStarmapid;
	private JLabel lblItems;
	private JLabel lblItemsCount;
	private JLabel lblLocationid;
	private JLabel lblLocid;
	private JLabel lblDate;
	private JLabel lblSymbol_1;
	private JLabel lblMessage_1;
	private JLabel lblSymbols;
	private JPanel mapBody;
	private JLabel lblSymbols_1;
	private JLabel lblTheroid;
	private JLabel lblTheroid_1;
	private JLabel lblSymbol;

	private JLabel lblDate_;

	/**
	 * Create the dialog.
	 */
	public StarMapView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StarMapView.class.getResource("/images/StarMap.jpg")));
		setTitle("StarMap");


		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setVisible(false);

			}
		});
		setBounds(100, 100, 515, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel header = new JPanel();
		header.setBackground(Color.lightGray);
		mapBody = new JPanel();
		mapBody.setBackground(Color.WHITE);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(header, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
				.addComponent(mapBody, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(header, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mapBody, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		);

		lblTheroid = new JLabel("THeroID:");
		lblTheroid.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblTheroid.setVisible(false);
		lblTheroid_1 = new JLabel();
		lblTheroid_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblTheroid_1.setVisible(false);

		lblDate_ = new JLabel("Date:");
		lblDate_.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDate_.setVisible(false);
		lblDate_.setBackground(new Color(255, 0, 0));
		lblDate = new JLabel();
		lblDate.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDate.setVisible(false);

		lblSymbol = new JLabel("Symbol:");
		lblSymbol.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblSymbol.setVisible(false);
		lblSymbol.setBackground(new Color(255, 0, 0));
		lblSymbol_1 = new JLabel();
		lblSymbol_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
	
		lblMessage_1 = new JLabel();
		lblMessage_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
	
		lblSymbols = new JLabel();
		lblSymbols.setVisible(false);
		lblSymbols_1 = new JLabel();
		lblSymbols_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblSymbols_1.setVisible(false);
		
		JLabel lblMessage = new JLabel("Directions:");
		lblMessage.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));


		GroupLayout gl_body = new GroupLayout(mapBody);
		gl_body.setHorizontalGroup(
			gl_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_body.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_body.createSequentialGroup()
							.addComponent(lblMessage)
							.addGap(13)
							.addComponent(lblMessage_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
						.addGroup(gl_body.createSequentialGroup()
							.addComponent(lblTheroid)
							.addGap(13)
							.addGroup(gl_body.createSequentialGroup()
								.addComponent(lblTheroid_1)
								.addGap(39)
								.addComponent(lblDate_)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblDate)
								.addGap(49)
								.addComponent(lblSymbol)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblSymbol_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblSymbols, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
						.addComponent(lblSymbols_1, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_body.setVerticalGroup(
			gl_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_body.createSequentialGroup()
					.addGap(8)
					.addComponent(lblSymbols, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_body.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTheroid)
							.addComponent(lblSymbol_1)
							.addComponent(lblSymbol))
						.addGroup(gl_body.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTheroid_1)
							.addComponent(lblDate_)
							.addComponent(lblDate)))
					.addGap(18)
					.addGroup(gl_body.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMessage_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(lblSymbols_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		mapBody.setLayout(gl_body);

		lblId = new JLabel("MapID:");
		lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblId.setBackground(new Color(255, 0, 0));
		lblStarmapid = new JLabel();
		lblStarmapid.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		lblItems = new JLabel("Items:");
		lblItems.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblItems.setBackground(new Color(255, 0, 0));
		lblItemsCount = new JLabel();
		lblItemsCount.setFont(new Font("Trebuchet MS", Font.BOLD, 12));

		lblLocationid = new JLabel("LocationID:");
		lblLocationid.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblLocid = new JLabel();
		lblLocid.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(15)
					.addComponent(lblId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStarmapid, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblLocationid)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLocid, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblItems)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblItemsCount, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblItemsCount, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItems)
						.addComponent(lblLocid, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStarmapid, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblId)
							.addComponent(lblLocationid)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	private void setValues(Map map){
		
		lblStarmapid.setText(map.getMapId());
		lblItemsCount.setText(map.getItemCount()+"");
		lblLocid.setText(map.getPositionId());
		lblMessage_1.setText(map.getDirection());
		
		if(map.isEncrypted()){
			lblDate.setText(map.getEncryptionDate());
			lblSymbol_1.setText(map.getSymbol());
			lblTheroid_1.setText(map.getTHeroId());
			
			String symbol_="";
			for (int i = 0; i < 60 ; i++ ) {
				symbol_=symbol_ + map.getSymbol(); 
			}
			lblSymbols_1.setText(symbol_);
			lblSymbols.setText(symbol_);
			setTitle("Encrypted StarMap");

			lblTheroid.setVisible(true);
			lblTheroid_1.setVisible(true);
			lblSymbols_1.setVisible(true);
			lblSymbols.setVisible(true);
			lblSymbol.setVisible(true);
			lblDate.setVisible(true);
			lblDate_.setVisible(true);
			lblSymbol_1.setVisible(true);
		}
	}

	public void setStarMap(Map mapInstance){
		this.map = mapInstance;
		setValues(map);
	}
	
	public Map getStarMap(){
		return map;
	}
}
