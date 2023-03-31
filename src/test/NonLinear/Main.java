package test.NonLinear;

import com.NonLinear.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insertIntoTree(55);
        tree.insertIntoTree(45);
        tree.insertIntoTree(67);
        tree.insertIntoTree(49);
        tree.insertIntoTree(34);
        tree.postOrderTraversal();



    }
}
