package graphs;

import java.util.*;

public class DepthFirstSearchUsingAdjacencyList {

    public static int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];


        Set<Integer> keys = graph.keySet();
        int numConnectedComponents = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                numConnectedComponents++;
                dfs(i, graph, visited);
            }
        }

        return numConnectedComponents;

    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        int result = countComponents(n, edges);
        System.out.println(result);
    }
}
