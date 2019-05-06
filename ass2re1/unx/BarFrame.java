package Oop_a2.gitK.ass2re1.unx;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * A class that implements an Observer object that displays a barchart view of a
 * data model.
 */
public class BarFrame extends JFrame implements ChangeListener {
	/**
	 * Constructs a BarFrame object
	 * @param dataModel the data that is displayed in the barchart
	 */
	public BarFrame(DataModel dataModel, TextFrame textFrame) {
		this.dataModel = dataModel;
		a = dataModel.getData();

		setLocation(0, 200);
		setLayout(new BorderLayout());

		Icon barIcon = new Icon() {
			public int getIconWidth() {
				return ICON_WIDTH;
			}

			public int getIconHeight() {
				return ICON_HEIGHT;
			}

			double barHeight = (getIconHeight())/ a.size();

			public void paintIcon(Component c, Graphics g, int x, int y) {
				addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						int mousePressedX = e.getX();
						int mousePressedY = e.getY();
						//System.out.println("X: "+ mousePressedX);
						//System.out.println("Y: "+ mousePressedY);
						
						double max = (a.get(0)).doubleValue();
						for (Double v : a) {
							double val = v.doubleValue();
							if (val > max)
								max = val;
						}
						double x = ((double)mousePressedX / getIconWidth())*max;
						
						double barHeight = (getIconHeight())/ a.size();
						int y = (int)((mousePressedY / barHeight-1*0.5));
						
						dataModel.update(y, x);
						System.out.println("Meine exe: "+x);
						int location = (int) (e.getY()/barHeight -1 * 0.5);
						double value = e.getX();
						//System.out.println("getY(): " + e.getY() + "  getX(): " + e.getX() + " barHeight: " + (int) ((e.getY()/barHeight) - 1));
						 if (e.getY() < ICON_HEIGHT + barHeight/2) {
							dataModel.update(location, value);
							//textFrame.getDataModel().update(location, value);
							textFrame.getJTextFieldArr()[location].setText(String.valueOf(value)); //= new JTextField(value + "", 11);
						 }
						//	System.out.println("aa: " + a);
					}
				});
				//System.out.println("a: " + a);
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(Color.darkGray);

				int i = 0;
				for (Double v : a) {
					double value = v;
					//	System.out.println("v = " +  v);
					double barLength = getIconWidth() * value / ICON_WIDTH;

					Rectangle2D.Double rectangle = new Rectangle2D.Double(0, (barHeight * i), barLength, barHeight-1);
					i++;
					g2.fill(rectangle);
				}
			}
		};

		add(new JLabel(barIcon));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);


	}

	/**
	 * Called when the data in the model is changed.
	 *
	 * @param e the event representing the change
	 */
	public void stateChanged(ChangeEvent e) {
		a = dataModel.getData();
		repaint();
	}

	private ArrayList<Double> a;
	private DataModel dataModel;

	private static final int ICON_WIDTH = 200;
	private static final int ICON_HEIGHT = 200;
}
