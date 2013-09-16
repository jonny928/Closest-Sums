package se.liu.ida.jonny928.tddc70.closestsums;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jonathan
 * Date: 2013-09-16
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree {
    private ArrayList tree;
    private final Object EMPTY = null;
    private final int LEFT = 0;
    private final int MIDDLE = 1;
    private final int RIGHT = 2;

    public BinaryTree() {
        tree = new ArrayList(3);
        tree.add(RIGHT, new BinaryTree());
        tree.add(LEFT, new BinaryTree());
    }

    public boolean isEmpty() {
        return tree.get(MIDDLE) == EMPTY;
    }

    public void add(int newNum) {
        if (this.isEmpty()) {
            tree.add(MIDDLE, new BinaryBranch(newNum));
        } else {
            int value = ((BinaryBranch)tree.get(MIDDLE)).getValue();
            if (value == newNum) {
                return;
            } else if (value < newNum) {
                ((BinaryTree)tree.get(RIGHT)).add(newNum);  //Add to right
            } else if (value > newNum) {
                ((BinaryTree)tree.get(LEFT)).add(newNum);   //Add to left
            }
        }
    }

    private Object get(int index) {
        return tree.get(index);
    }

    private void add (int index, Object obj) {
        tree.add(index, obj);
    }

    public void printTree() {
        System.out.println("Middle: " + ((BinaryBranch)tree.get(MIDDLE)).getValue());
        System.out.println("Left: " + ((BinaryBranch)((BinaryTree)tree.get(LEFT)).get(MIDDLE)).getValue());
        System.out.println("Right: " + ((BinaryBranch)((BinaryTree)tree.get(RIGHT)).get(MIDDLE)).getValue());
    }


}
