package com.NonLinear;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
    }

    Node root = new Node();
    char endSymbol = '*';

    public Trie(String str){
        populateSuffixTrie(str);
    }

    public void populateSuffixTrie(String str){
        for (int i = 0; i < str.length(); i++) {
            insertSubStringStartingAt(i, str);
        }
    }

    public void insertSubStringStartingAt(int index, String str){
        Node node = root;
        for (int j = index; j < str.length(); j++) {
            char letter = str.charAt(j);
            if(!node.children.containsKey(letter)){
                Node newNode = new Node();
                node.children.put(letter, newNode);
            }
            node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);
    }

    public boolean contains(String str){
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                return false;
            }
            node = node.children.get(letter);
        }
        return node.children.containsKey(endSymbol);
    }

    public static void main(String[] args) {
        Trie trie = new Trie("mannan");
        System.out.println(trie.contains("mannan"));
    }
    public void delete(String str) {
        deleteSubStringStartingAt(0, str, root);
    }

    public boolean deleteSubStringStartingAt(int index, String str, Node node) {
        if (index == str.length()) {
            if (!node.children.containsKey(endSymbol)) {
                return false; // The substring doesn't exist in the trie
            }
            node.children.remove(endSymbol);
            return node.children.isEmpty(); // Return whether the node has no children after deletion
        }
        char letter = str.charAt(index);
        if (!node.children.containsKey(letter)) {
            return false; // The substring doesn't exist in the trie
        }
        boolean shouldDeleteCurrentNode = deleteSubStringStartingAt(index + 1, str, node.children.get(letter));
        if (shouldDeleteCurrentNode) {
            node.children.remove(letter);
            return node.children.isEmpty(); // Return whether the node has no children after deletion
        }
        return false;
    }
}
