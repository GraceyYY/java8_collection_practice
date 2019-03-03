package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        int randomNum = this.random.nextInt(3);
        while ((number - randomNum) > 0) {
            result.add(number - randomNum);
            number -= randomNum;
        }
        return result;
    }
}
