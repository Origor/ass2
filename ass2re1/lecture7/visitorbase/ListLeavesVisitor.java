package Oop_a2.ass2.ass2re1.lecture7.visitorbase;

import java.util.ArrayList;
import java.util.List;

public class ListLeavesVisitor<T> implements TreeVisitor<T, List<T>> {

	private List<T> result = new ArrayList<T>();

	public List<T> visit(Tree<T> t) {
		return t.accept(this);
	}

	public List<T> visit(Leaf<T> l) {
		result.add(l.getValue());
		return result;
	}

	public List<T> visit(Node<T> n) {
		for (Tree<T> child : n.getChildren()) {
			child.accept(this);
		}
		return result;
	}
}