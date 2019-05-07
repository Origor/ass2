package Oop_a2.ass2.ass2re1.lecture7.visitorbase;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v);
}