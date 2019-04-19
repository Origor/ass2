package Oop_a2.gitK.ass2.lecture7.visitorpassres;

import java.util.*;

public class Node<T> implements Tree<T> {

	private List<Tree<T>> children;

	public Node(List<Tree<T>> trees) {
		children = trees;
	}

	public <R> R accept(TreeVisitor<T, R> v, R initialResult) {
		return v.visit(this, initialResult);
	}

	public String toString() {
		return getClass().getName() + "[children = " + children + "]";
	}

	public List<Tree<T>> getChildren() {
		return children;
	}
}