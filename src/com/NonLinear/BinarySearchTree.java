package com.NonLinear;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private class TreeNode{

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }


    public TreeNode insert(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root. right= insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int data){
        if(root == null || root.data == data){
            return root;
        }

        if(data < root.data){
            return search(root.left, data);
        }
        return search(root.right , data);
      }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    public TreeNode getMinimum(TreeNode root){
        if(root.left != null){
            return getMinimum(root.left);
        }
        return root;
    }

    public int getMaximum(TreeNode root){
        if(root.right != null){
            return getMaximum(root.right);
        }
        return root.data;
    }

    void printLevelOrder() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null)
                queue.offer(currentNode.left);

            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }


    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int closestValue(TreeNode root, int target) {
        int closest = root.data;
        while (root != null) {
            if (Math.abs(root.data - target) < Math.abs(closest - target)) {
                closest = root.data;
            }
            root = target < root.data ? root.left : root.right;
        }
        return closest;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }



    public TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        }
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        else {
            // Case 1: Node has no child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                root = root.right;

            }
            else if (root.right == null) {
                root = root.left;
            }
            // Case 3: Node has two children
            else {
                // Find the minimum value in the right subtree
                TreeNode minValueNode = getMinimum(root.right);
                // Replace the node's data with the minimum value in the right subtree
                root.data = minValueNode.data;
                // Delete the minimum value node in the right subtree
                root.right = delete(root.right, minValueNode.data);
            }
        }

        return root;
    }

    public void insertIntoTree(int data){

        root = insert(root, data);
    }

    public TreeNode searchTree(int data){
        return search(root, data);
    }

    public void inOrderTraversal(){
        inOrder(root);
    }

    public void preOrderTraversal(){
        preOrder(root);
    }

    public void postOrderTraversal(){
        postOrder(root);
    }


}
