package com.NonLinear;

import java.util.HashMap;
import java.util.Map;

public class SimpleTrie {

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    private Node root;

    public SimpleTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                return false; // word doesn't exist in trie
            }
            node.isWord = false; // unmark the word
            return node.children.isEmpty(); // return true if no other nodes are using this node
        }
        char ch = word.charAt(index);
        Node child = node.children.get(ch);
        if (child == null) {
            return false; // word doesn't exist in trie
        }
        boolean canDelete = delete(child, word, index + 1);
        if (canDelete) {
            node.children.remove(ch);
            return node.children.isEmpty() && !node.isWord; // return true only if no other nodes are using this node and it's not a word node
        }
        return false;
    }
}
