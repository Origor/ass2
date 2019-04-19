package Oop_a2.gitK.ass2.lecture7.visitorbase;

public interface TreeVisitor<T, R> {
	R visit(Tree<T> t);

	R visit(Leaf<T> l);

	R visit(Node<T> n);
}