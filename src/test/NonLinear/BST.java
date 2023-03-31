package test.NonLinear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    private class Node {
        int data;
        Node left, right;


        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node root;

    public BST(){
        root = null;
    }

    public Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public Node search(Node root, int data){
        if(root == null  || root.data == data){
            return root;
        }

        if(data < root.data){
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    public int getMinimum(Node root){
        if(root.left != null){
            return getMinimum(root.left);
        }
        return root.data;
    }

    public int getMaximum(Node root){
        if(root.right != null){
            return getMaximum(root.right);
        }
        return root.data;
    }

    public Node delete(Node root, int data){
        if(root == null){
            return root;
        }
        if(data < root.data){
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        else{
            //node has no child
            if(root.left == null && root.right == null){
                root = null;
            }
            // root has right child;
            else if (root.left == null) {
                root = root.right;
            }
            //root has left child;
            else if (root.right == null) {
                root = root.left;
            }
            else{
                int minValue = getMinimum(root.right);
                root.data = minValue;
                root.right = delete(root.right, minValue);
            }
        }
        return root;
    }

    void printLevelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+ " ");

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

    }
}
