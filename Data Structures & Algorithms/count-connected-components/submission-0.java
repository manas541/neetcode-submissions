class Solution {
    public int countComponents(int n, int[][] edges) {

    List<List<Integer>> graph = new ArrayList<>();

    // Create adjacency list
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    // Build undirected graph
    for (int[] edge : edges) {
        int a = edge[0];
        int b = edge[1];

        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    boolean[] visited = new boolean[n];

    int components = 0;

    // Find every separate component
    for (int i = 0; i < n; i++) {

        if (!visited[i]) {

            // Found a new component
            components++;

            dfs(i, graph, visited);
        }
    }

    return components;
}

private void dfs(
    int node,
    List<List<Integer>> graph,
    boolean[] visited
) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}

}
