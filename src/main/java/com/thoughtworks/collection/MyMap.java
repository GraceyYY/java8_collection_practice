package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> result = new ArrayList<>(this.array);
        result.replaceAll((n) -> n * 3);
        return result;
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        for (Integer n : this.array) {
            result.add(this.letterList.get(n - 1));
        }
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        for (Integer n : this.array) {
            if (n <= 26) {
                result.add(this.letterList.get(n - 1));
            } else {
                int firstLetterIndex = (n - 1) / 26;
                int secondLetterIndex = n - 26 * firstLetterIndex;
                String letters = this.letterList.get(firstLetterIndex - 1) + this.letterList.get(secondLetterIndex - 1);
                result.add(letters);
            }
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        List<Integer> result = new ArrayList<>(this.array);
        result.sort(Comparator.reverseOrder());
        return result;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> result = new ArrayList<>(this.array);
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
