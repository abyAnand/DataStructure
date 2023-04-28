package com.NonLinear;

import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    private void addVertex(Integer data){

        map.put(data, new ArrayList<>());
    }

    public void insert(Integer vertex, Integer edge, boolean isBidirectional){
        if(!map.containsKey(vertex)){
            addVertex(vertex);
        }
        if(!map.containsKey(edge)){
            addVertex(edge);
        }

        map.get(vertex).add(edge);
        if(isBidirectional){
            map.get(edge).add(vertex);
        }
    }

    public void display(){
        for(Integer x : map.keySet()){
            System.out.print(x+ ": ");
            for(Integer y : map.get(x)){
                System.out.print(y+ " ");
            }
            System.out.println();
        }
    }

    public void removeEdge(Integer vertex, Integer edge, boolean isBidirectional){
        if(map.containsKey(vertex) && map.containsKey(edge)){
            map.get(vertex).remove(edge);
            if(isBidirectional){
                map.get(edge).remove(vertex);
            }
        }
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : map.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth First Search
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : map.get(current)) {
            if (!visited.   contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.insert(3,5,true);
        graph.insert(3,4,true);
        graph.insert(5,6,false);
        graph.display();
        graph.bfs(3);
        graph.dfs(3);
    }
}
