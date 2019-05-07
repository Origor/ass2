package Oop_a2.ass2.ass2re2.unx;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * A class that implements an Observer object that displays a barchart view of a
 * data model.
 */
public class BarFrame extends JFrame implements ChangeListener {

	private ArrayList<Double> a;
	private DataModel dataModel;

	private static final int ICON_WIDTH = 200;
	private static final int ICON_HEIGHT = 200;

	/**
	 * Constructs a BarFrame object
	 * @param dataModel the data that is displayed in the barchart
	 */
	public BarFrame(DataModel dataModel) {
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
						int location = (int) (e.getY()/barHeight -1 * 0.5);
						double value = e.getX();
						//System.out.println("getY(): " + e.getY() + "  getX(): " + e.getX() + " barHeight: " + (int) ((e.getY()/barHeight) - 1));
						if (e.getY() < ICON_HEIGHT + barHeight/2) {
							dataModel.update(location, value);
						}
					}
				});
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
		DataModel b = (DataModel) e.getSource();

		System.out.println("stateChanged()");
		repaint();
	}

}