package Oop_a2.gitK.ass2.assignment2;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Signal {
	private double amplitude;
	private final int SAMPLING = 1000;
	private ArrayList<SignalObserver> myObservers;
	private Sampler sample;
	
	public void addObserver(SignalObserver s) {
		myObservers.add(s);
	}

	public Signal() {
		myObservers = new ArrayList<SignalObserver>();
		sample = new DefaultSampler();
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(sample.read());
			}
		});
		t.start();
	}
	
	public void setSignalState(Sampler s) {
		sample = s;
	}
	
	private void nextValue(double x) {
		amplitude = x;
		for (SignalObserver so : myObservers) {
			so.updateSignal(amplitude);
		}		
	}
}