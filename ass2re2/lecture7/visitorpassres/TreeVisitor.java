package Oop_a2.ass2.ass2re2.lecture7.visitorpassres;

public interface TreeVisitor<T, R> {
	R visit(Tree<T> t, R initialResult);

	R visit(Leaf<T> l, R initialResult);

	R visit(Node<T> n, R initialResult);
}