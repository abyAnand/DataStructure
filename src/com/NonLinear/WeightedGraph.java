package com.NonLinear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private Map<Integer, List<Edge>> map = new HashMap<>();

    private void addVertex(Integer data){
        map.put(data, new ArrayList<>());
    }

    public void addEdge(Integer vertex1, Integer vertex2, int weight){
        if(!map.containsKey(vertex1)){
            addVertex(vertex1);
        }
        if(!map.containsKey(vertex2)){
            addVertex(vertex2);
        }

        map.get(vertex1).add(new Edge(vertex1, vertex2, weight));
    }

    public void display(){
        for(Integer x : map.keySet()){
            System.out.print(x+ ": ");
            for(Edge edge : map.get(x)){
                System.out.print("(" + edge.vertex1 + "," + edge.vertex2 + "," + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    private class Edge {
        int vertex1;
        int vertex2;
        int weight;

        Edge(int vertex1, int vertex2, int weight){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);
        graph.display();
    }
}
