package Oop_a2.gitK.ass2.lecture7.visitorpassres;

public class PrettyPrintVisitor<T> implements TreeVisitor<T, String> {


    @Override
    public String visit(Tree<T> t, String initialResult) {
        return t.accept(this, initialResult);
    }

    @Override
    public String visit(Leaf<T> l, String initialResult) {
        initialResult = "\t"+l.getValue() + System.lineSeparator();
        return initialResult;
    }

    @Override
    public String visit(Node<T> n, String initialResult) {
        //final String temp = initialResult;
        String result = "Child" + System.lineSeparator();
        for (Tree<T> child : n.getChildren()){
            result += "\t"+child.accept(this, result);
        }
        return "Root"  + System.lineSeparator() + "\t" + result;
    }
}
