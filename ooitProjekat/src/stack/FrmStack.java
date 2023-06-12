package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
		setTitle("Matkovic Bojana, IM116/2019");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(197, 251, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlStack = new JPanel();
		pnlStack.setBorder(new LineBorder(new Color(45, 165, 10), 2));
		pnlStack.setForeground(new Color(0, 0, 0));
		pnlStack.setBackground(new Color(255, 255, 255));
		pnlStack.setBounds(10, 11, 369, 314);
		contentPane.add(pnlStack);
		GridBagLayout gbl_pnlStack = new GridBagLayout();
		gbl_pnlStack.columnWidths = new int[]{0, 0};
		gbl_pnlStack.rowHeights = new int[]{0, 0};
		gbl_pnlStack.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlStack.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlStack.setLayout(gbl_pnlStack);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlStack.add(scrollPane, gbc_scrollPane);
		
		JList listStack = new JList();
		scrollPane.setViewportView(listStack);
		listStack.setModel(dlm);
		
		JPanel toolbar = new JPanel();
		toolbar.setBackground(new Color(197, 251, 181));
		toolbar.setBounds(10, 336, 369, 51);
		contentPane.add(toolbar);
		GridBagLayout gbl_toolbar = new GridBagLayout();
		gbl_toolbar.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_toolbar.rowHeights = new int[]{0, 0};
		gbl_toolbar.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_toolbar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		toolbar.setLayout(gbl_toolbar);
		
		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack rect = new DlgStack();
				rect.setVisible(true);
				if(rect.commited) {
					String element = ("Upper left point: ( " + rect.getTxtX().getText() + " " + "," + " " + rect.getTxtY().getText() + " " + ") , width: " + rect.getTxtWidth().getText() + " , height: " + rect.getTxtHeight().getText());
					dlm.add(0, element);
				}
			}
		});
		btnAdd.setBackground(new Color(45, 165, 10));
		btnAdd.setForeground(new Color(4, 4, 3));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		toolbar.add(btnAdd, gbc_btnAdd);
		
		JButton btnDelete = new JButton("Delete Rectangle");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					DlgStack dlgDelete = new DlgStack();
					String[] split= dlm.getElementAt(0).toString().split(" ");
					int index = 0;
					dlgDelete.getTxtX().setText(split[4]);
					dlgDelete.getTxtY().setText(split[6]);
					dlgDelete.getTxtWidth().setText(split[10]);
					dlgDelete.getTxtHeight().setText(split[13]);
					dlgDelete.getTxtX().setEditable(false);
					dlgDelete.getTxtY().setEditable(false);
					dlgDelete.getTxtWidth().setEditable(false);
					dlgDelete.getTxtHeight().setEditable(false);
					dlgDelete.setVisible(true);
					
					if(dlgDelete.commited) {
						dlm.remove(index);
					}
				}
			}
		});
		btnDelete.setBackground(new Color(45, 165, 10));
		btnDelete.setForeground(new Color(4, 4, 3));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 0;
		toolbar.add(btnDelete, gbc_btnDelete);
		
	}
}
