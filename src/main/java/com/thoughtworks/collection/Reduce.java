package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce implements SingleLink<Integer> {

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
        int index = this.arrayList.size() / 2;
        double median = 0;
//        this.arrayList.sort(Comparator.naturalOrder());
        if (this.arrayList.size() % 2 == 1) {
            median = this.arrayList.get(index);
        }else{
            median = (this.arrayList.get(index) + this.arrayList.get(index - 1)) / 2.0;
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

    @Override
    public Integer getHeaderData() {
        return this.arrayList.get(0);
    }

    @Override
    public Integer getTailData() {
        return this.arrayList.get(this.arrayList.size() - 1);
    }

    @Override
    public int size() {
        return this.arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public boolean deleteFirst() {
        if (this.arrayList.isEmpty()) {
            return false;
        } else {
            this.arrayList.remove(0);
            return true;
        }
    }

    @Override
    public boolean deleteLast() {
        if (this.arrayList.isEmpty()) {
            return false;
        } else {
            this.arrayList.remove(this.arrayList.size() - 1);
            return true;
        }
    }

    @Override
    public void addHeadPointer(Integer item) {
        this.arrayList.add(0, item);
    }

    @Override
    public void addTailPointer(Integer item) {
        this.arrayList.add(item);
    }

    @Override
    public Integer getNode(int index) {
        return this.arrayList.get(index - 1);
    }
}
