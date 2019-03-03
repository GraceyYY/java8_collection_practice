package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] arr : this.array) {
            result.addAll(Arrays.asList(arr));
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> flaten = new ArrayList<>();
        for (Integer[] arr : this.array) {
            flaten.addAll(Arrays.asList(arr));
        }
        LinkedHashSet<Integer> tempSet = new LinkedHashSet<>(flaten);
        List<Integer> result = new ArrayList<>(tempSet);
        return result;
    }
}
