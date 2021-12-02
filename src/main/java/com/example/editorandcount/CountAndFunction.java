package com.example.editorandcount;

public class CountAndFunction {

    public int countAnds (String sentence) {
        int count = 0;
        // Split sentence on whitespace
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            // remove all non-alphabetic characters
            word = word.replaceAll("[^a-zA-Z]+", "");

            // put all words to lower case and check for ands
            if (word.equalsIgnoreCase("and")){
               count++ ;
            }
        }

        return count;
    }
}
