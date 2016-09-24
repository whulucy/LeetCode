/* 323. Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to find the number of connected components in an undirected graph.
Example 1:
0          3
|          |
1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
0           4
|           |
1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
You can assume that no duplicate edges will appear in edges.
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

public class Solution {
    //首先用HashMap<Integer, List<Integer>> map  来表示整个graph 结构，然后用dfs的解法
    public int countComponents(int n, int[][] edges) {
        //deal with illegal input
        if (n <= 0){
            return 0;
        }
        if (edges == null || edges.length == 0){
            return n;
        }
        //create the HashMap
        HashMap<Integer, List<Integer>> graph = constructGraph(n, edges);
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }
    private HashMap<Integer, List<Integer>> constructGraph(int n, int[][] edges){
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            addToGraph(a, b, graph);
            addToGraph(b, a, graph);
        }
        return graph;
    }
    // add b to a's neighbor List
    private void addToGraph(int a, int b, HashMap<Integer, List<Integer>> graph){
        List<Integer> neighbors;
        if (graph.containsKey(a)){
            neighbors = graph.get(a);
        } else {
            neighbors = new ArrayList<Integer>();
        }
        neighbors.add(b);
        graph.put(a, neighbors);
    }
    private void dfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        if (graph.containsKey(node)){
            for (int neighbor : graph.get(node)){
                if (!visited[neighbor]){
                    dfs(neighbor, graph, visited);
                }
            }
        }
    }
}
