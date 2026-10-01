class Solution {
    public boolean validTree(int n, int[][] edges) {

    // A tree with n nodes must have n - 1 edges
    if (edges.length != n - 1) {
        return false;
    }

    List<List<Integer>> graph = new ArrayList<>();

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

    // Check for cycle
    if (hasCycle(0, -1, graph, visited)) {
        return false;
    }

    // Check if every node was visited
    for (boolean nodeVisited : visited) {
        if (!nodeVisited) {
            return false;
        }
    }

    return true;
}
private boolean hasCycle(
    int node,
    int parent,
    List<List<Integer>> graph,
    boolean[] visited
) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        // Ignore the edge we came from
        if (neighbor == parent) {
            continue;
        }

        // Found a previously visited node
        // that isn't our parent → cycle
        if (visited[neighbor]) {
            return true;
        }

        if (hasCycle(neighbor, node, graph, visited)) {
            return true;
        }
    }

    return false;
}
}
