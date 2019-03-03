package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
        } else {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }
        result.removeIf((n) -> n % 2 == 1);
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (Integer n : array) {
            if (n % 2 == 0) {
                result.add(n);
            }
        }
        return result;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        first.retainAll(second);
        return first;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> second = new ArrayList<>(Arrays.asList(secondArray));
        second.removeAll(first);
        first.addAll(second);
        return first;
    }
}
