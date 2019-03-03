package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.ArrayList;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int start;
        int end;
        int sum = 0;
        if (leftBorder <= rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int start;
        int end;
        int sum = 0;
        if (leftBorder <= rightBorder) {
            start = leftBorder;
            end = rightBorder;
        } else {
            start = rightBorder;
            end = leftBorder;
        }
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        if (!arrayList.isEmpty()) {
            for (Integer num : arrayList) {
                sum += num * 3 + 2;
            }
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        arrayList.replaceAll((n) -> {
            if (n % 2 == 1) {
                n = n * 3 + 2;
            }
            return n;
        });
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (Integer n : arrayList) {
            if (n % 2 == 1) {
                sum += n * 3 + 5;
            }
        }
        return sum;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenIndexArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 1) {
                continue;
            }
            evenIndexArray.add(arrayList.get(i));
        }
        double median;
        int index = evenIndexArray.size() / 2;
        if (evenIndexArray.size() % 2 == 1) {
            median = evenIndexArray.get(index);
        } else {
            median = (evenIndexArray.get(index) + evenIndexArray.get(index + 1)) / 2;
        }
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evenIndexArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 1) {
                continue;
            }
            evenIndexArray.add(arrayList.get(i));
        }
        int sum = 0;
        for (Integer n : evenIndexArray) {
            sum += n;
        }

        double average = sum / evenIndexArray.size();

        return average;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenArray = new ArrayList<>();
        for(Integer n : arrayList) {
            if (n % 2 == 0) {
                evenArray.add(n);
            }
        }
        return evenArray.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> repeat = new ArrayList<>();
        for (Integer n : arrayList) {
            if (arrayList.indexOf(n) != arrayList.lastIndexOf(n)) {
                repeat.add(n);
            }
        }
        arrayList.removeAll(repeat);

        return arrayList;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (Integer n : arrayList) {
            if (n % 2 == 0) {
                even.add(n);
            } else {
                odd.add(n);
            }
        }

        even.sort((Integer n1, Integer n2)-> (n1 < n2) ? -1 : ((n1 == n2) ? 0 : 1));
        odd.sort((Integer n1, Integer n2)-> (n1 > n2) ? -1 : ((n1 == n2) ? 0 : 1));
        even.addAll(odd);

        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int processedNum = (arrayList.get(i) + arrayList.get(i + 1) ) * 3;
            result.add(processedNum);
        }
        return result;
    }
}
