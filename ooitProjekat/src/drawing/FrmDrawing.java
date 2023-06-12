package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;

import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing;
	private int brojac = 0;
	private boolean selected;
	private Point startPoint, endPoint, upperLeft;
	private Color outlineColor, innerColor;
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Shape lastSelectedShape;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmDrawing() {
		setBackground(new Color(231, 238, 239));
		setTitle("Matkovic Bojana, IM116/2019");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 252, 126));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBackground(new Color(255, 255, 255));
		pnlDrawing.setBounds(118, 6, 529, 407);
		pnlDrawing.setBorder(new LineBorder(new Color(126, 189, 245), 2));
		contentPane.setLayout(null);
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnPoint.setBounds(6, 38, 100, 23);
		contentPane.add(btnPoint);
		btnPoint.setFont(new Font("Arial", Font.BOLD, 11));
		btnPoint.setForeground(new Color(0, 0, 0));
		btnPoint.setBackground(new Color(180, 254, 254));
		buttonGroup.add(btnPoint);
		
		JToggleButton btnLine = new JToggleButton("Line");
		btnLine.setBounds(6, 112, 100, 23);
		contentPane.add(btnLine);
		btnLine.setFont(new Font("Arial", Font.BOLD, 11));
		btnLine.setForeground(new Color(0, 0, 0));
		btnLine.setBackground(new Color(126, 189, 245));
		buttonGroup.add(btnLine);
		
		JToggleButton btnRectangle = new JToggleButton("Rectangle");
		btnRectangle.setBounds(6, 191, 100, 23);
		contentPane.add(btnRectangle);
		btnRectangle.setFont(new Font("Arial", Font.BOLD, 11));
		btnRectangle.setForeground(new Color(0, 0, 0));
		btnRectangle.setBackground(new Color(126, 189, 245));
		buttonGroup.add(btnRectangle);
		
		JToggleButton btnCircle = new JToggleButton("Circle");
		btnCircle.setBounds(6, 264, 100, 23);
		contentPane.add(btnCircle);
		btnCircle.setFont(new Font("Arial", Font.BOLD, 11));
		btnCircle.setForeground(new Color(0, 0, 0));
		btnCircle.setBackground(new Color(126, 189, 245));
		buttonGroup.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		btnDonut.setBounds(6, 339, 100, 23);
		contentPane.add(btnDonut);
		btnDonut.setFont(new Font("Arial", Font.BOLD, 11));
		btnDonut.setForeground(new Color(0, 0, 0));
		btnDonut.setBackground(new Color(126, 189, 245));
		buttonGroup.add(btnDonut);
		JToggleButton btnSelect = new JToggleButton("Select");
		btnSelect.setBounds(659, 112, 100, 37);
		contentPane.add(btnSelect);
		btnSelect.setFont(new Font("Arial", Font.BOLD, 11));
		btnSelect.setForeground(new Color(0, 0, 0));
		btnSelect.setBackground(new Color(126, 189, 245));
		buttonGroup.add(btnSelect);
		JToggleButton btnModify = new JToggleButton("Modify");
		btnModify.setBounds(659, 203, 100, 37);
		contentPane.add(btnModify);
		btnModify.setFont(new Font("Arial", Font.BOLD, 11));
		btnModify.setForeground(new Color(0, 0, 0));
		btnModify.setBackground(new Color(126, 189, 245));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnModify.isSelected()) {
					if(pnlDrawing.getShapes().isEmpty()) {
						JOptionPane.showMessageDialog(null, "The field is empty! To perform this operation, please create a shape first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(selectedShapes.isEmpty()) {
						JOptionPane.showMessageDialog(null, "To modify an object, please select it first.", "ERROR", JOptionPane.ERROR_MESSAGE);
					
					}else {
						try {
							for(Shape s : pnlDrawing.getShapes()) {
								if(s instanceof Point) {
									if(s.isSelected()) {
										Point temp = (Point) s;
										Point p = new Point();
										
										DlgPoint point = new DlgPoint();
										point.getTxtX().setText(Integer.toString(temp.getX()));
										point.getTxtY().setText(Integer.toString(temp.getY()));
										point.setOutlineColor(temp.getColor());
										point.setVisible(true);
										
										if(point.isCommited()) {
											p = point.getP();
											p.setSelected(false);
											p.moveTo(Integer.parseInt(point.getTxtX().getText()), Integer.parseInt(point.getTxtY().getText()));
											pnlDrawing.getShapes().set(pnlDrawing.getShapes().indexOf(temp), p);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Line) {
									if(s.isSelected()) {
										Line temp = (Line) s;
										Line l = new Line();
										
										DlgLine line = new DlgLine();
										line.getTxtStartX().setText(Integer.toString(temp.getStartPoint().getX()));
										line.getTxtStartY().setText(Integer.toString(temp.getStartPoint().getY()));
										line.getTxtEndX().setText(Integer.toString(temp.getEndPoint().getX()));
										line.getTxtEndY().setText(Integer.toString(temp.getEndPoint().getY()));
										line.setOutlineColor(temp.getColor());
										line.setVisible(true);
										
										if(line.isCommited()) {
											l = line.getLine();
											l.setSelected(false);
											pnlDrawing.getShapes().add(l);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Rectangle) {
									if(s.isSelected()) {
										Rectangle temp = (Rectangle) s;
										Rectangle r = new Rectangle();
										
										DlgRectangle rect = new DlgRectangle();
										rect.getTxtUpperX().setText(Integer.toString(temp.getUpperLeft().getX()));
										rect.getTxtUpperY().setText(Integer.toString(temp.getUpperLeft().getY()));
										rect.getTxtWidth().setText(Integer.toString(temp.getWidth()));
										rect.getTxtHeight().setText(Integer.toString(temp.getHeight()));
										rect.setInnerColor(temp.getInnerColor());
										rect.setOutlineColor(temp.getColor());
										rect.setVisible(true);
										
										if(rect.isCommited()) {
											r = rect.getRectangle();
											r.setSelected(false);
											pnlDrawing.getShapes().add(r);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Circle && (s instanceof Donut)==false) {
									if(s.isSelected()) {
										Circle temp = (Circle) s;
										Circle c = new Circle();
										
										DlgCircle circle = new DlgCircle();
										circle.getTxtXCenter().setText(Integer.toString(temp.getCenter().getX()));
										circle.getTxtYCenter().setText(Integer.toString(temp.getCenter().getY()));
										circle.getTxtRadius().setText(Integer.toString(temp.getRadius()));
										circle.setInnerColor(temp.getInnerColor());
										circle.setOutlineColor(temp.getColor());
										circle.setVisible(true);
										
										if(circle.isCommited()) {
											c = circle.getCircle();
											c.setSelected(false);
											pnlDrawing.getShapes().add(c);
											pnlDrawing.getShapes().remove(s);
											repaint();
											selectedShapes.clear();
										}
									}
								}else if(s instanceof Donut) {
									if(s.isSelected()) {
									Donut temp = (Donut) s;
									Donut d = new Donut();
									
									DlgDonut donut = new DlgDonut();
									donut.getTxtX().setText(Integer.toString(temp.getCenter().getX()));
									donut.getTxtY().setText(Integer.toString(temp.getCenter().getY()));
									donut.getTxtOuterRadius().setText(Integer.toString(temp.getRadius()));
									donut.getTxtInnerRadius().setText(Integer.toString(temp.getInnerRadius()));
									donut.setInnerColor(temp.getInnerColor());
									donut.setOutlineColor(temp.getColor());
									donut.setVisible(true);
									
									if(donut.isCommited()) {
										d = donut.getDonut();
										d.setSelected(false);
										pnlDrawing.getShapes().add(d);
										pnlDrawing.getShapes().remove(s);
										repaint();
										selectedShapes.clear();
										}
									}
								}
							}
						}catch(Exception cme) {	
						}
					}
				}
			}
		});
		buttonGroup.add(btnModify);
		
		JToggleButton btnDelete = new JToggleButton("Delete");
		btnDelete.setBounds(659, 303, 100, 37);
		contentPane.add(btnDelete);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 11));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setBackground(new Color(126, 189, 245));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getShapes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "The field is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(selectedShapes.size() == 0) {
					JOptionPane.showMessageDialog(null, "No shapes are currently selected. Please select a shape before proceeding with this operation.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					int selectedOption = JOptionPane.showConfirmDialog(null, "You have selected shapes to be deleted. Are you sure you want to proceed?", "Warning message", JOptionPane.YES_NO_OPTION);
					if (selectedOption == JOptionPane.YES_OPTION) {
						pnlDrawing.getShapes().removeAll(selectedShapes);
						selectedShapes.clear();
						repaint();
					}
				}
			}
		});
		
		
		buttonGroup.add(btnDelete);
		
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnSelect.isSelected()) {
					
					for(Shape s : pnlDrawing.getShapes()) {
					    if(s.contains(e.getX(), e.getY())) {
					        if(s instanceof Point || s instanceof Line || s instanceof Rectangle || s.getClass() == Circle.class) {
					            if(lastSelectedShape != null && lastSelectedShape != s) {
					                lastSelectedShape.setSelected(false);
					                selectedShapes.remove(lastSelectedShape);
					            }
					            if(!s.isSelected()) {
					                s.setSelected(true);
					                selectedShapes.add(s);
					                lastSelectedShape = s;
					                repaint();
					            } else {
					                s.setSelected(false);
					                selectedShapes.remove(s);
					                lastSelectedShape = null;
					                repaint();
					            }
					        } else if(s instanceof Donut) {
					            if(lastSelectedShape != null && lastSelectedShape != s && lastSelectedShape.getClass() == Donut.class) {
					                lastSelectedShape.setSelected(false);
					                selectedShapes.remove(lastSelectedShape);
					            }
					            if(!s.isSelected()) {
					                s.setSelected(true);
					                selectedShapes.add(s);
					                lastSelectedShape = s;
					                repaint();
					            } else {
					                s.setSelected(false);
					                selectedShapes.remove(s);
					                lastSelectedShape = null;
					                repaint();
					            }
					        }
					    }
					}
				}else if(btnPoint.isSelected()) {
					Point p = new Point(e.getX(),e.getY());
					p.setColor(Color.BLACK);
					pnlDrawing.getShapes().add(p);
					repaint();
				}else if(btnLine.isSelected()){
					brojac++;
					if(brojac == 1) {
						startPoint = new Point(e.getX(),e.getY());
						startPoint.setColor(Color.BLACK);
						repaint();
					}else if(brojac == 2){
						endPoint = new Point(e.getX(),e.getY());
						Line l = new Line(startPoint, endPoint);
						l.setColor(Color.BLACK);
						pnlDrawing.getShapes().add(l);
						repaint();
						brojac = 0;
					}
				}else if(btnRectangle.isSelected()) {
					upperLeft = new Point(e.getX(),e.getY());
					DlgRectangle rect = new DlgRectangle();
					rect.getTxtUpperX().setText(Integer.toString(upperLeft.getX()));
					rect.getTxtUpperX().setEditable(false);
					rect.getTxtUpperY().setText(Integer.toString(upperLeft.getY()));
					rect.getTxtUpperY().setEditable(false);
					rect.setVisible(true);
					repaint();
					
					if(rect.isCommited()) {
						Rectangle r = rect.getRectangle();
						pnlDrawing.getShapes().add(r);
						repaint();
					}		
				}else if(btnCircle.isSelected()) {
					Point center = new Point (e.getX(), e.getY());
					DlgCircle circle = new DlgCircle();
					circle.getTxtXCenter().setText(Integer.toString(center.getX()));
					circle.getTxtXCenter().setEditable(false);
					circle.getTxtYCenter().setText(Integer.toString(center.getY()));
					circle.getTxtYCenter().setEditable(false);
					circle.setVisible(true);
					repaint();
					
					if(circle.isCommited()) {
						Circle c = circle.getCircle();
						pnlDrawing.getShapes().add(c);
						repaint();
					}
				}else if(btnDonut.isSelected()) {
					Point center = new Point(e.getX(), e.getY());
					DlgDonut donut = new DlgDonut();
					donut.getTxtX().setText(Integer.toString(center.getX()));
					donut.getTxtX().setEditable(false);
					donut.getTxtY().setText(Integer.toString(center.getY()));
					donut.getTxtY().setEditable(false);
					donut.setVisible(true);
					repaint();
					
					if(donut.isCommited()) {
						Donut d = donut.getDonut();
						pnlDrawing.getShapes().add(d);
						repaint();
					}
				}
			}
		});
		
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
