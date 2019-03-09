package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        Stream<Integer> result;
        if (left <= right) {
            result = IntStream.rangeClosed(left, right).boxed();
        } else {
            result = IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder());
        }
        return result.collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        Stream<Integer> result;
        if (left <= right) {
            result = IntStream.rangeClosed(left, right).boxed();
        } else {
            result = IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder());
        }
        return result.filter(element -> element % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(element -> element % 2 == 0).boxed().collect(Collectors.toList());
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
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).collect(Collectors.toList());
        second.removeAll(first);
        first.addAll(second);
        return first;
    }
}
