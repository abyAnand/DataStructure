package com.NonLinear;

import sun.java2d.pipe.SpanShapeRenderer;

public class Main {
    public static void main(String[] args) {

        SimpleTrie trie = new SimpleTrie();


        trie.insert("hello");
        trie.insert("helloo");

        trie.insert("he");
        System.out.println(trie.search("hel"));
        System.out.println(trie.delete("helloo"));
        System.out.println(trie.search("hello"));



    }
}
