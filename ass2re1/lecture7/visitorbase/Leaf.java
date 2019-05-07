package Oop_a2.ass2.ass2re1.lecture7.visitorbase;

public class Leaf<T> implements Tree<T> {

	private T value;

	public Leaf(T v) {
		value = v;
	}

	public String toString() {
		return getClass().getName() + "[value = " + value + "]";
	}

	public <R> R accept(TreeVisitor<T, R> v) {
		return v.visit(this);
	}
	
	public T getValue() {
		return value;
	}
}