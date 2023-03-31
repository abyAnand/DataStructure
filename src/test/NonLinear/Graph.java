package test.NonLinear;

import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    private void addVortex(Integer data){
        map.put(data, new ArrayList<>());
    }

    public void insert(Integer vertex, Integer edge, boolean isBidirectional){
        if(!map.containsKey(vertex)){
            addVortex(vertex);
        }
        if(!map.containsKey(edge)){
            addVortex(edge);
        }

        map.get(vertex).add(edge);
        if(isBidirectional){
            map.get(edge).add(vertex);
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

    public void dfs(int start){
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    public void dfsHelper(int current, Set<Integer> visited){
        visited.add(current);
        System.out.print(current+ " ");

        for(int neighbor : map.get(current)){
            if(!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current+ " ");

            for(int neighbor : map.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println();
    }
}
