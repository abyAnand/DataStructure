package com.NonLinear;


import java.util.*;

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
        System.out.print(root.data + " ");
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
    public boolean isValidBSTRec(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) {
            return false;
        }
        return isValidBSTHelper(node.left, min, node.data) && isValidBSTHelper(node.right, node.data, max);
    }


    public void delete(int val){
        delete(root,val );
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





    //pictorial representation of BST
    public void printTree() {
        int maxLevel = maxLevel(root);
        printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printTreeNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newTreeNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newTreeNodes.add(node.left);
                newTreeNodes.add(node.right);
            } else {
                newTreeNodes.add(null);
                newTreeNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (TreeNode node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node.right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    private int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null)
                return false;
        }

        return true;
    }

}
