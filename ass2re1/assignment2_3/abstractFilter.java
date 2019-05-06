package Oop_a2.gitK.ass2.ass2re2.ass2re1.assignment2_3;


public abstract class abstractFilter {

    abstract boolean accept(String x);

    @SuppressWarnings("Duplicates")
    public static String[] filter(String[] a, abstractFilter f){
        String[] temp = new String[a.length];
        int n = -1;
        for (String s : a) {                                 //go through given String[]
            if (f.accept(s)) {                               // and add elements to temp[] according
                temp[++n] = s;                               // to Filter f specification
            }
        }

        String[] result = new String[n+1];                      //
        n = -1;                                                 // Remove null spaces
        for (String s : temp) if (s != null) result[++n] = s;   //
        return result;
    }

}
