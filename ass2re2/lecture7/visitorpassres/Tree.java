package Oop_a2.ass2.ass2re2.lecture7.visitorpassres;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v, R initialResult);

}