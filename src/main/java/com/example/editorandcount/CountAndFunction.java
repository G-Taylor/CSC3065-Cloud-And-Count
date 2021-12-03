package com.example.editorandcount;

public class CountAndFunction {

    public int countAnds (String sentence) {
        int count = 0;
        // Split sentence on whitespace
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            // remove all non-alphabetic characters
            System.out.println("Word from sentence after split, but before second regex: " + word);
            word = word.replaceAll("[^a-zA-Z]+", "");

            System.out.println("Word from sentence after second regex: " + word);
            // put all words to lower case and check for ands
            if (word.equalsIgnoreCase("and")){
               count++ ;
               System.out.println("Count: " + count);
            }
        }

        return count;
    }
}
