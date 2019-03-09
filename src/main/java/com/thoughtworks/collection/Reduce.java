package com.thoughtworks.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().max(Integer::compareTo).get();
    }

    public double getMinimum() {
        return this.arrayList.stream().min(Integer::compareTo).get();
    }

    public double getAverage() {
        return this.arrayList.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
    }

    public double getOrderedMedian() {
        this.arrayList.sort(Integer::compareTo);
        int index = this.arrayList.size() / 2;
        double median;
        if (this.arrayList.size() % 2 == 1) {
            median = this.arrayList.get(index);
        } else {
            median = (this.arrayList.get(index - 1) + this.arrayList.get(index)) / 2.0;
        }
        return median;
    }

    public int getFirstEven() {
        return this.arrayList.stream().filter(element -> element % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (this.arrayList.get(i) != arrayList.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        SingleLink<Integer> list = new SingleLinkList();
        for (Integer n : this.arrayList) {
            singleLink.addTailPointer(n);
            list.addTailPointer(n);
        }
        double median;
        int index = list.size() / 2;
        if (list.size() % 2 == 1) {
            median = list.getNode(index);
        } else {
            median = (list.getNode(index - 1) + list.getNode(index)) / 2.0;
        }
        return median;
    }

    public int getLastOdd() {
        LinkedList<Integer> temp = new LinkedList<>(this.arrayList.stream().filter(element -> element % 2 == 1).collect(Collectors.toList()));
        return temp.getLast();
    }

    public int getIndexOfLastOdd() {
        for (int i = this.arrayList.size() - 1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 == 1) {
                return i;
            }
        }
        return -1;

    }

}
