package Oop_a2.gitK.ass2.ass2re2.ass2re1.lecture7.visitorbase;

public interface TreeVisitor<T, R> {
	R visit(Tree<T> t);

	R visit(Leaf<T> l);

	R visit(Node<T> n);
}