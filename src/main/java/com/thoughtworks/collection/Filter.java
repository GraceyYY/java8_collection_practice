package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Filter {

    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> result = new ArrayList<>(this.array);
        result.removeIf((n) -> n % 2 == 1);
        return result;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> result = new ArrayList<>(this.array);
        result.removeIf((n) -> n % 3 != 0);
        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> first = new ArrayList<>(firstList);
        first.retainAll(secondList);
        return first;
    }

    public List<Integer> getDifferentElements() {
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>(new ArrayList<>(this.array));
        List<Integer> result = new ArrayList<>(tempSet);
        return result;
    }
}