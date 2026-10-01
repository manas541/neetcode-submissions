class Solution {
    public int[] findRedundantConnection(int[][] edges) {

    int n = edges.length;

    int[] parent = new int[n + 1];

    // Initially, every node is its own parent
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }

    for (int[] edge : edges) {

        int a = edge[0];
        int b = edge[1];

        if (find(a, parent) == find(b, parent)) {
            return new int[]{a, b};
        }

        union(a, b, parent);
    }

    return new int[0];
}

private int find(int node, int[] parent) {

    if (parent[node] == node) {
        return node;
    }

    return parent[node] = find(parent[node], parent);
}


private void union(int a, int b, int[] parent) {

    int rootA = find(a, parent);
    int rootB = find(b, parent);

    parent[rootA] = rootB;
}
}