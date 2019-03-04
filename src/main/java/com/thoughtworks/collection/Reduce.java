package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        arrayList.sort(Comparator.reverseOrder());
        return arrayList.get(0);
    }

    public double getMinimum() {
        arrayList.sort(Comparator.naturalOrder());
        return arrayList.get(0);
    }

    public double getAverage() {
        double sum = 0;
        for (Integer n : this.arrayList) {
            sum += n;
        }
        double average = sum / this.arrayList.size();
        return average;
    }

    public double getOrderedMedian() {
        this.arrayList.sort(Comparator.naturalOrder());
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
        for (int i = 0; i < this.arrayList.size(); i++) {
            if (this.arrayList.get(i) % 2 == 0) {
                return this.arrayList.get(i);
            }
        }
        return -1;
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
            median = (list.getNode(index - 1) + list.getNode(index))/2.0;
        }
        return median;
    }

    public int getLastOdd() {
        for (int i = this.arrayList.size() - 1; i >= 0; i--) {
            if (this.arrayList.get(i) % 2 == 1) {
                return this.arrayList.get(i);
            }
        }
        return -1;
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
