package Oop_a2.ass2.ass2re1.assignment2;

public class Sinus implements Sampler {
	private double arg;
	private double delta;

	public Sinus(double start, double delta) {
		arg = start;
		this.delta = delta;
	}

	public double read() {
		double x = arg;
		arg = arg + delta;
		return 60 + Math.sin(x) * 30;
	}
}