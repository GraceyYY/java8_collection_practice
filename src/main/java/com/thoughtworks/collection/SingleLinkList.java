package com.thoughtworks.collection;

import java.util.LinkedList;
import java.util.List;

public class SingleLinkList implements SingleLink<Integer> {
    private LinkedList<Integer> list;

    public SingleLinkList() {
        this.list = new LinkedList<>();
    }

    @Override
    public Integer getHeaderData() {
        return this.list.getFirst();
    }

    @Override
    public Integer getTailData() {
        return this.list.getLast();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean deleteFirst() {
        return this.list.remove(getTailData());
    }

    @Override
    public boolean deleteLast() {
        return this.list.remove(getHeaderData());
    }

    @Override
    public void addHeadPointer(Integer item) {
        this.list.addFirst(item);
    }

    @Override
    public void addTailPointer(Integer item) {
        this.list.addLast(item);
    }

    @Override
    public Integer getNode(int index) {
        return this.list.get(index);
    }
}
