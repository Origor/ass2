package Oop_a2.ass2.ass2re1.lecture7.visitorpassres;

import java.util.ArrayList;
import java.util.List;

public class TestVisitors {

	@SuppressWarnings("Duplicates")

	public static void main(String[] args) {
		args = new String[] { "one", "two", "three" };
		List<Tree<String>> leaves = new ArrayList<>();

		for (int i = 0; i < args.length; i++) {
			leaves.add(new Leaf<>(args[i]));
		}

		Tree<String> t1 = new Node<>(leaves);
		Tree<String> t2 = new Node<>(leaves);
		Tree<String> t3 = new Node<>(leaves);

		List<Tree<String>> lst = new ArrayList<>();
		lst.add(t1);
		lst.add(t2);
		lst.add(t3);
		lst.add(new Node<>(leaves));

		Tree<String> t = new Node<>(lst);

		TreeVisitor<String,Integer> thv = new TreeHeightVisitor<>();
		TreeVisitor<String,List<String>> llv = new ListLeavesVisitor<>();
		TreeVisitor<String,Integer> lcv = new LeavesCountVisitor<>();
		TreeVisitor<String, String> ppv = new PrettyPrintVisitor<>();

		System.out.println("Tree: " + t);

		System.out.println("Tree height: "+t.accept(thv, 0));

		System.out.println("Leaves: "+t.accept(llv, new ArrayList<>()));

		System.out.println("Leaves count: "+t.accept(lcv, 0));

		System.out.println(System.lineSeparator() + t.accept(ppv, ""));

	}
}
