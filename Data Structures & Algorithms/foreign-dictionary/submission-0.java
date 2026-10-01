class Solution {
    public String foreignDictionary(String[] words) {

        // 1. Create graph
        Map<Character, List<Character>> graph = new HashMap<>();

        // 2. Create indegree for every character
        Map<Character, Integer> indegree = new HashMap<>();

        // 3. Add every character to graph and indegree
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // 4. Compare neighboring words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];

            int minLength = Math.min(word1.length(), word2.length());

            boolean foundDifference = false;

            for (int j = 0; j < minLength; j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {

                    // c1 must come before c2
                    graph.get(c1).add(c2);

                    indegree.put(c2, indegree.get(c2) + 1);

                    foundDifference = true;
                    break;
                }
            }

            // Invalid case: longer word comes before its prefix
            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }

        // 5. Put characters with indegree 0 into queue
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // 6. Topological Sort
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();

            result.append(current);

            for (char neighbor : graph.get(current)) {

                indegree.put(
                    neighbor,
                    indegree.get(neighbor) - 1
                );

                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 7. Check for cycle
        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}