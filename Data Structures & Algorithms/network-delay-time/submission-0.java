class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // 1. Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.computeIfAbsent(u, x -> new ArrayList<>())
                 .add(new int[]{v, w});
        }

        // 2. Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Starting node
        dist[k] = 0;

        // 3. Min heap: {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, k});

        // 4. Dijkstra
        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int node = current[1];

            // Ignore outdated information
            if (currentDist > dist[node]) {
                continue;
            }

            for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {

                int neighbor = edge[0];
                int weight = edge[1];

                int newDist = currentDist + weight;

                // Found a shorter path
                if (newDist < dist[neighbor]) {

                    dist[neighbor] = newDist;

                    pq.offer(new int[]{newDist, neighbor});
                }
            }
        }

        // 5. Find maximum shortest distance
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}