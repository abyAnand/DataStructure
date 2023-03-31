package test.NonLinear;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static class Node{

        Map<Character, Node> children = new HashMap<>();

        boolean isWord = false;
    }

    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;

        for(char ch : word.toCharArray()){
            node.children.putIfAbsent(ch, new Node());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    public boolean search(String word){
        Node node = root;

        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isWord;
    }

    public boolean delete(String word){
        return delete(root, word, 0);
    }

    public boolean delete(Node node, String word, int index){
        if(index == word.length()){
            if(!node.isWord){
                return false;
            }

            node.isWord = false;
            return node.children.isEmpty();
        }

        char ch = word.charAt(index);
        Node child = node.children.get(ch);
        if(child== null){
            return false;
        }
        boolean canDelete = delete(child, word, index+1);
        if(canDelete){
            node.children.remove(ch);
            return node.children.isEmpty() && node.isWord;
        }
        return false;
    }
}

