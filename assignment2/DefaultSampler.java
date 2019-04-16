package assignment2;

public class DefaultSampler implements Sampler {
	public double read() {
		return Math.random() * 100;
	}
}