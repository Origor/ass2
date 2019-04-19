package Oop_a2.gitK.ass2.ass2re2.assignment2_3;

import java.util.Arrays;

public class abstractFilterTester extends abstractFilter {

    boolean accept(String string){
        return string.length() <= 3;
    }


    public static void main(String[] args){
        String[] testArray = {"a", "bbb", "cccc", "dd"};
        String[] result = new abstractFilterTester().filter(testArray);
        System.out.println(Arrays.toString(result));

    }

}