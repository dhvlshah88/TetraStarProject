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

import Tetra.Map.EncryptionStrategyOne;
import Tetra.Map.IEncrytionStrategy;
import Tetra.Map.Map;
import Tetra.Map.StarMap;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class StarMapView extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	Map map=null;// = new StarMap() ;
	private JLabel lblStarmapid;
	private JLabel lblDate;
	private JLabel lblItemsCount;
	private JLabel lblSymbol_1;
	private JLabel lblMessage;
	private JLabel lblSymbols;
	private JLabel lblLocid;
	private JPanel body;
	private JLabel lblSymbols_1;
	private JLabel lblTheroid;
	private JLabel lblTheroid_1;

	private JLabel lblSymbol;

	private JLabel lblDate_;

	/**
	 * Create the dialog.
	 */
	public StarMapView(Map map) {
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
		body = new JPanel();
		body.setBackground(UIManager.getColor("Button.focus"));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(header, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 622, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(body, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(header, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		);
		
		lblMessage = new JLabel("Default Message");
		lblMessage.setText(map.getDirection());
		
		lblSymbol = new JLabel("Symbol:");
		lblSymbol.setVisible(false);
		lblSymbol.setBackground(new Color(255, 0, 0));
		
		lblSymbol_1 = new JLabel("symbol");
		lblSymbol_1.setText(map.getSymbol());
		
		lblDate = new JLabel("date");
		lblDate.setVisible(false);
		
		lblDate_ = new JLabel("Date:");
		lblDate_.setVisible(false);
		lblDate_.setBackground(new Color(255, 0, 0));
		
		lblSymbols = new JLabel("symbols");
		lblSymbols.setVisible(false);
		
		lblSymbols_1 = new JLabel("symbols");
		lblSymbols_1.setVisible(false);
		
		lblTheroid = new JLabel("THeroID:");
		lblTheroid.setVisible(false);
		
		lblTheroid_1 = new JLabel("theroid");
		lblTheroid_1.setVisible(false);
		GroupLayout gl_body = new GroupLayout(body);
		gl_body.setHorizontalGroup(
			gl_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_body.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_body.createSequentialGroup()
							.addComponent(lblTheroid)
							.addGap(20)
							.addComponent(lblTheroid_1)
							.addGap(39)
							.addComponent(lblDate_)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDate)
							.addGap(49)
							.addComponent(lblSymbol)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblSymbol_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(25, Short.MAX_VALUE))
						.addGroup(gl_body.createSequentialGroup()
							.addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
							.addGap(384))
						.addGroup(gl_body.createSequentialGroup()
							.addGroup(gl_body.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSymbols_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
								.addComponent(lblSymbols, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
							.addContainerGap())))
		);
		gl_body.setVerticalGroup(
			gl_body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_body.createSequentialGroup()
					.addComponent(lblSymbols)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_body.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_body.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTheroid)
							.addComponent(lblSymbol_1)
							.addComponent(lblSymbol))
						.addGroup(gl_body.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTheroid_1)
							.addComponent(lblDate_)
							.addComponent(lblDate)))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(lblMessage)
					.addGap(36)
					.addComponent(lblSymbols_1)
					.addGap(20))
		);
		body.setLayout(gl_body);
		
		JLabel lblId = new JLabel("MapID: ");
		lblId.setBackground(new Color(255, 0, 0));
		
		lblStarmapid = new JLabel("StarMapID");
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBackground(new Color(255, 0, 0));
		
		lblItemsCount = new JLabel("items");
		
		JLabel lblLocationid = new JLabel("LocationID :");
		
		lblLocid = new JLabel("locId");
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(15)
					.addComponent(lblId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStarmapid)
					.addGap(53)
					.addComponent(lblItems)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblItemsCount, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLocationid)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLocid, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStarmapid)
						.addComponent(lblId)
						.addComponent(lblItemsCount)
						.addComponent(lblItems)
						.addComponent(lblLocationid)
						.addComponent(lblLocid))
					.addContainerGap(42, Short.MAX_VALUE))
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
		setValues(map);
	}

	private void setValues(Map map){
		lblStarmapid.setText(map.getMapId());
		lblItemsCount.setText(map.getItemCount()+"");
		lblLocid.setText(map.getPositionId());
		if(map.isEncrypted()){
			lblDate.setText(map.getEncryptionDate());
			lblMessage.setText(map.getDirection());
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

}
