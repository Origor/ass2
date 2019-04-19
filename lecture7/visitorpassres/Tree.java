package Oop_a2.gitK.ass2.lecture7.visitorpassres;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v, R initialResult);

}