package Oop_a2.gitK.ass2.ass2re2.ass2re1.lecture7.visitorbase;

public class LeavesCountVisitor<T> implements TreeVisitor<T, Integer> {

	public Integer visit(Tree<T> t) {
		return t.accept(this);
	}

	public Integer visit(Leaf<T> l) {
		return 1;
	}

	public Integer visit(Node<T> n) {
		int r = 0;
		for (Tree<T> child : n.getChildren()) {
			r = r + visit(child);
		}
		return r;
	}
}