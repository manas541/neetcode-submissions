class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // 1. Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(
                from, x -> new PriorityQueue<>()
            ).offer(to);
        }

        // 2. Start DFS from JFK
        dfs("JFK");

        // 3. Reverse the postorder result
        Collections.reverse(result);

        return result;
    }

    private void dfs(String airport) {

        PriorityQueue<String> destinations = graph.get(airport);

        // Keep using tickets while available
        while (destinations != null && !destinations.isEmpty()) {

            String next = destinations.poll();

            dfs(next);
        }

        // Add airport only after all outgoing tickets are used
        result.add(airport);
    }
}