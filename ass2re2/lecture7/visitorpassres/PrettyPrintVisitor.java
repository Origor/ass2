package Oop_a2.gitK.ass2.ass2re2.lecture7.visitorpassres;

public class PrettyPrintVisitor<T> implements TreeVisitor<T, String> {
       String result;


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
        String result;
<<<<<<< HEAD:ass2re2/lecture7/visitorpassres/PrettyPrintVisitor.java
        result = "Child" + System.lineSeparator();
=======
        if(!(n.accept(new TreeHeightVisitor<>(), 0) == 1)) result = "Root" + System.lineSeparator();
        else result = "Child" + System.lineSeparator();
>>>>>>> master:lecture7/visitorpassres/PrettyPrintVisitor.java

        for (Tree<T> child : n.getChildren()){
            result += "\t"+child.accept(this, result);
        }
        return  result;
    }
}
