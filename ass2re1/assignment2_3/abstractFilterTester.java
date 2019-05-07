package Oop_a2.ass2.ass2re1.assignment2_3;

import java.util.Arrays;

public class abstractFilterTester extends abstractFilter {

    boolean accept(String string){
        return string.length() <= 3;
    }


    public static void main(String[] args){
        String[] testArray = {"a", "bbb", "cccc", "dd"};
       String[] result = filter(testArray, new abstractFilterTester());
        System.out.println(Arrays.toString(result));

    }

}