package com.NonLinear;

import java.util.Scanner;

public class BSTmain {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int n, num;

        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers you want to input: ");
        n = sc.nextInt();
        System.out.println("Enter the "+n +" numbers: ");
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            bst.insertIntoTree(num);
        }
        System.out.println("Tree Insertion Done!!!");

        System.out.println("Enter the Number to Search: ");
        int numToSearch = sc.nextInt();
        if(bst.searchTree(numToSearch) != null){
            System.out.println("Number Found");
        }
        else{
            System.out.println("Number Not Found!!");
        }
        System.out.println("Inorder Traversal of this Binary Search Tree: ");
        bst.inOrderTraversal();
        System.out.println("Preorder Traversal of this Binary Search Tree: ");
        bst.preOrderTraversal();
        System.out.println("PostOrder Traversal of this Binary Search Tree: ");
        bst.postOrderTraversal();

        int depth = bst.getDepth(bst.root);
        System.out.println("Depth of the tree: " + depth);
    }
}
