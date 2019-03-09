package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(element -> element * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(element -> this.letterList.get(element - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return this.array.stream().map(element -> {
            if (element <= 26) {
                return this.letterList.get(element - 1);
            } else {
                int firstLetterIndex = (element - 1) / 26;
                int secondLetterIndex = element - 26 * firstLetterIndex;
                return this.letterList.get(firstLetterIndex - 1) + this.letterList.get(secondLetterIndex - 1);
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
