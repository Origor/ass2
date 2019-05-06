package Oop_a2.gitK.ass2.ass2re2.ass2re1.assignment2;

import javax.swing.*;

public class SignalWindow extends JFrame implements SignalObserver {
	private JTextArea jta;
	
	public SignalWindow() {
		jta = new JTextArea(100, 20);
		jta.append("The signal amplitude.\n");
		add(jta);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public void updateSignal(double x) {
		jta.append("" + String.format("%.6f", x) + "\n");
	}

}