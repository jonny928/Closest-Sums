package se.liu.ida.jonny928.tddc70.closestsums;

/**
 * Created with IntelliJ IDEA.
 * User: Jonathan
 * Date: 2013-09-16
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static BinaryTree tree;

    public static void main(String[] args) {
        tree = new BinaryTree();
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.printTree();
    }

    public Main() {
    }
}
