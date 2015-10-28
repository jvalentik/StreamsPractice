package org.jvk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Apple> myApples = new ArrayList<>();
        for (int i=0; i<=1000; i++) {
            myApples.add(new Apple());
        }
        Random randomGenerator = new Random();
        myApples.forEach(apple -> apple.setWeight(randomGenerator.nextInt(1000)));
        List<Apple> heavyApples = myApples.parallelStream()
                                          .filter(apple -> apple.getWeight() >= 500 && apple.getWeight() <= 600)
                                          .sorted(Comparator.comparing(Apple::getWeight))
                                          .collect(Collectors.toList());
        heavyApples.stream().forEach(System.out::println);
    }
}

class Apple {
    private int weight;
    private int size;
    String sort;

    public Apple(String sort, int size, int weight) {
        this.size = size;
        this.sort = sort;
        this.weight = weight;
    }

    public Apple() {
        this("Generic", 1, 1);
    }

    @Override
    public String toString() {
        return sort +" " + size + " " + weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
