package Oop_a2.gitK.ass2.ass2re2.ass2re1.lecture7.visitorbase;

public class TreeHeightVisitor<T> implements TreeVisitor<T, Integer> {

	public Integer visit(Tree<T> t) {
		return t.accept(this);
	}

	public Integer visit(Leaf<T> l) {
		return 0;
	}

	public Integer visit(Node<T> n) {
		Integer result = 0;
		Integer max = result;
		for (Tree<T> child : n.getChildren()) {
			result = visit(child);
			if (result > max)
				max = result;
		}
		return max + 1;
	}

}