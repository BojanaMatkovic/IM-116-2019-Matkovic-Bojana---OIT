package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtRadius;
	private Circle circle;
	protected boolean commited;
	private JButton btnInnerColor;
	private JButton btnOutlieColor;
	private Color innerColor = Color.WHITE;
	private Color outlineColor = Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("Create/Modify Circle");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 268);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 197, 182));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCoordinateXCenter = new JLabel("Coordinate X:");
			lblCoordinateXCenter.setForeground(new Color(252, 255, 246));
			lblCoordinateXCenter.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblCoordinateXCenter = new GridBagConstraints();
			gbc_lblCoordinateXCenter.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateXCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateXCenter.gridx = 1;
			gbc_lblCoordinateXCenter.gridy = 2;
			contentPanel.add(lblCoordinateXCenter, gbc_lblCoordinateXCenter);
		}
		{
			txtXCoordinate = new JTextField();
			GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
			gbc_txtXCoordinate.gridwidth = 2;
			gbc_txtXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXCoordinate.gridx = 2;
			gbc_txtXCoordinate.gridy = 2;
			contentPanel.add(txtXCoordinate, gbc_txtXCoordinate);
			txtXCoordinate.setColumns(10);
		}
		{
			JButton btnInnerColor1 = new JButton("Inner Color");
			btnInnerColor1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor1.getBackground());
					if(innerColor != null) {
						btnInnerColor1.setBackground(innerColor);
					}
				}
			});
			btnInnerColor1.setBackground(new Color(255, 255, 255));
			btnInnerColor1.setForeground(new Color(9, 9, 9));
			GridBagConstraints gbc_btnInnerColor1 = new GridBagConstraints();
			gbc_btnInnerColor1.insets = new Insets(0, 0, 5, 5);
			gbc_btnInnerColor1.gridx = 4;
			gbc_btnInnerColor1.gridy = 2;
			contentPanel.add(btnInnerColor1, gbc_btnInnerColor1);
		}
		{
			JLabel lblCoordinateYCenter = new JLabel("Coordinate Y:");
			lblCoordinateYCenter.setForeground(new Color(252, 255, 246));
			lblCoordinateYCenter.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblCoordinateYCenter = new GridBagConstraints();
			gbc_lblCoordinateYCenter.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateYCenter.gridx = 1;
			gbc_lblCoordinateYCenter.gridy = 3;
			contentPanel.add(lblCoordinateYCenter, gbc_lblCoordinateYCenter);
		}
		{
			txtYCoordinate = new JTextField();
			GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
			gbc_txtYCoordinate.gridwidth = 2;
			gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYCoordinate.gridx = 2;
			gbc_txtYCoordinate.gridy = 3;
			contentPanel.add(txtYCoordinate, gbc_txtYCoordinate);
			txtYCoordinate.setColumns(10);
		}
		{
			JButton btnOutlineColor = new JButton("Outline Color");
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outlineColor = JColorChooser.showDialog(null, "Choose outline color", btnOutlineColor.getBackground());
					if(outlineColor != null) {
						btnOutlineColor.setBackground(outlineColor);
					}
				}
			});
			btnOutlineColor.setBackground(new Color(255, 255, 255));
			btnOutlineColor.setForeground(new Color(9, 9, 9));
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnOutlineColor.gridx = 4;
			gbc_btnOutlineColor.gridy = 3;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setForeground(new Color(252, 255, 246));
			lblRadius.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 5;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.gridwidth = 2;
			gbc_txtRadius.insets = new Insets(0, 0, 5, 5);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 2;
			gbc_txtRadius.gridy = 5;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(252, 248, 243));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(txtXCoordinate.getText().isEmpty() || txtYCoordinate.getText().isEmpty() || txtRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "All field are required!", "ERROR", JOptionPane.ERROR_MESSAGE);
							} else if(Integer.parseInt(txtRadius.getText().toString()) < 0 ||
										Integer.parseInt(txtXCoordinate.getText().toString())<0 || Integer.parseInt(txtYCoordinate.getText().toString())<0){
								JOptionPane.showMessageDialog(null, "Insert values greather than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
							} else {
								circle = new Circle (new Point(Integer.parseInt(txtXCoordinate.getText().toString()), Integer.parseInt(txtYCoordinate.getText().toString())),
										Integer.parseInt(txtRadius.getText().toString()), false, outlineColor, innerColor);
								commited = true;
								setVisible(false);
							}
						} catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Enter numbers only!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(221, 99, 89));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(254, 127, 119));
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.setActionCommand("Cancel");
			}
		}
		
	}

	public JTextField getTxtXCenter() {
		return txtXCoordinate;
	}

	public void setTxtXCenter(JTextField txtXCenter) {
		this.txtXCoordinate = txtXCenter;
	}

	public JTextField getTxtYCenter() {
		return txtYCoordinate;
	}

	public void setTxtYCenter(JTextField txtYCenter) {
		this.txtYCoordinate = txtYCenter;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlieColor() {
		return btnOutlieColor;
	}

	public void setBtnOutlieColor(JButton btnOutlieColor) {
		this.btnOutlieColor = btnOutlieColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

}
