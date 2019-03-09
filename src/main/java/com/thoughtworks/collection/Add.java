package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start;
        int end;
        if (leftBorder <= rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        return IntStream.rangeClosed(start, end).filter(element -> element % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start;
        int end;
        if (leftBorder <= rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        return IntStream.rangeClosed(start, end).filter(element -> element % 2 == 1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(element -> element * 3 + 2).reduce(0, (a, b) -> a + b);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(element ->
                element % 2 == 1 ? element * 3 + 2 : element
        ).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(element -> element % 2 == 1).map(element -> element * 3 + 5).collect(Collectors.summingInt(e -> e));
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenIndexArray = arrayList.stream().filter(element -> arrayList.indexOf(element) % 2 == 0).collect(Collectors.toList());
        double median;
        int index = evenIndexArray.size() / 2;
        if (evenIndexArray.size() % 2 == 1) {
            median = evenIndexArray.get(index);
        } else {
            median = (evenIndexArray.get(index) + evenIndexArray.get(index - 1)) / 2;
        }
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(element -> arrayList.indexOf(element) % 2 == 0).collect(Collectors.averagingInt(Integer::intValue));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(element -> element % 2 == 0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().distinct().filter(element -> element % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(element -> element % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(element -> element % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int processedNum = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            result.add(processedNum);
        }
        return result;
    }
}
