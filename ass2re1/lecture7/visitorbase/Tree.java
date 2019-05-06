package Oop_a2.gitK.ass2.ass2re2.ass2re1.lecture7.visitorbase;

public interface Tree<T> {
	<R> R accept(TreeVisitor<T, R> v);
}