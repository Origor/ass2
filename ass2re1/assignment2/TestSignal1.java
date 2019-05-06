package Oop_a2.gitK.ass2.ass2re2.ass2re1.assignment2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSignal1 {
	static JFrame frame = new JFrame();
	static JButton Button = new JButton("Switch mode");
	static boolean state = false;
	
	public static void main(String[] args) {
		Signal theSignal = new Signal();
		theSignal.addObserver(new StarObserver());
		theSignal.addObserver(new SignalWindow());
		theSignal.addObserver(new SignalWindow());
		
		frame.add(Button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.pack();
		frame.setVisible(true);

		Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(state) {
					theSignal.setSignalState(new DefaultSampler());
					state = !state;
				}	
				else {
					theSignal.setSignalState(new Sinus(0, 0.5));
					state = !state;
				}
			}
		});
	}
	
	private static void printStars(int x) {
		for (int i = 0; i < x; i++)
			System.out.print("*");
		System.out.println();		
	}

}