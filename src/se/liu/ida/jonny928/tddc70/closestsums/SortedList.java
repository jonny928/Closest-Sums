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

    public int findClosestMember(int query) {
        int currentSum;
        int leftSum;
        int rightSum;
        int min = 0;
        int max = size;
        int middle = (min + max)/2;
        while (true) {
            currentSum = sortedList.get(middle);
            if (middle != 0) {
                leftSum = sortedList.get(middle-1);
            } else {
                leftSum = currentSum;
            }
            if (middle != size-1) {
                rightSum = sortedList.get(middle+1);
                } else {
                rightSum = currentSum;
            }

            if (query == currentSum) {
                return query;

            } else if (query < currentSum) {
                if (query == leftSum) {
                    return query;
                } else if (query > leftSum) {
                    if (query-leftSum > currentSum-query) {
                        return currentSum;
                    } else {
                        return leftSum;
                    }
                } else {
                    max = middle;
                    middle = (max + min)/2;
                }

            } else if (query > currentSum) {
                if (query == rightSum) {
                    return query;
                } else if (query < rightSum) {
                    if (rightSum-query > query-currentSum) {
                        return currentSum;
                    } else {
                        return rightSum;
                    }
                } else {
                    min = middle;
                    middle = (max + min)/2;
                }
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
