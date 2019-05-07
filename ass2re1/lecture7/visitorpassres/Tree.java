package Oop_a2.ass2.ass2re1.lecture7.visitorpassres;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v, R initialResult);

}