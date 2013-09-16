package se.liu.ida.jonny928.tddc70.closestsums;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jonathan
 * Date: 2013-09-16
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class SortedList {
    private ArrayList<Integer> sortedList;
    private int size;

    public SortedList() {
        sortedList = new ArrayList<Integer>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int newValue) {
        if (isEmpty()) {
            sortedList.add(newValue);
            size++;
            return;
        }
        int min = 0;
        int max = size-1;
        int middle;
        int currentValue;
        middle = (max + min)/2;
        while (true) {
            currentValue = sortedList.get(middle);
            if (newValue == currentValue) {
                return;
            } else if (newValue < currentValue) {
                if (middle == min) {
                    sortedList.add(min, newValue);
                    size++;
                    return;
                } else if (middle == max) {
                    sortedList.add(max, newValue);
                    size++;
                    return;
                }
                min = middle;
                middle = (max + min)/2;
            } else if (newValue > currentValue) {
                if (middle == (max-1)) {
                    middle = max;
                    min = max;
                } else if (middle == max) {
                    sortedList.add(newValue);
                    size++;
                    return;
                }
                min = middle;
                middle = (max + min)/2;
            }
        }
    }

    public void printList() {
        System.out.println("Sorted list:");
        for (Integer integer : sortedList) {
            System.out.println(integer);
        }
    }
}
