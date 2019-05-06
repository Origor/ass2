package Oop_a2.gitK.ass2re2.lecture7.visitorpassres;

public class PrettyPrintVisitor<T> implements TreeVisitor<T, String> {

    private int traceDepth = 0;

    public String visit(Tree<T> t, String initialResult ) {
        return t.accept(this, initialResult);
    }

    public String visit(Leaf<T> l, String initialResult ) {
        StringBuilder initialResultBuilder = new StringBuilder(initialResult);
        for (int i = 0; i < traceDepth; i++) { initialResultBuilder.append("\t"); }
        return initialResultBuilder.toString() + l.getValue() + System.lineSeparator();
    }

    public String visit(Node<T> n, String initialResult ) {
        StringBuilder result = new StringBuilder(initialResult);
        for (int i = 0; i < traceDepth; i++) {
            result.append("\t");
        }
        result.append("Child\n");
        traceDepth++;
        for (Tree<T> child : n.getChildren()){
            result.append(child.accept(this, initialResult));
        }
        traceDepth--;
        return result.toString();
    }
}
