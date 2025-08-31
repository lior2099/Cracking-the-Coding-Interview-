package fromWeb;

import java.util.*;


public class PrintPaths {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        System.out.println("All paths from 2 to 3:");
        g.printAllPaths(0, 3);
    }

}


class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int vertices) {
        this.V = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printAllPaths(int s, int d) {
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(s, d, visited, path);
    }

    private void dfs(int node, int d, boolean[] visited, List<Integer> path) {
        path.add(node);
        visited[node] = true;

        if (node == d) {
            System.out.println(path);
        } else {
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, d, visited, path);
                }
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
        visited[node] = false;
    }
}
