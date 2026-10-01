class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

    // Create graph
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
        graph.add(new ArrayList<>());
    }

    // Indegree of every course
    int[] indegree = new int[numCourses];

    // Build graph and indegree
    for (int[] prerequisite : prerequisites) {

        int course = prerequisite[0];
        int pre = prerequisite[1];

        graph.get(pre).add(course);

        indegree[course]++;
    }

    // Courses with no prerequisites
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }

    // Store answer
    int[] result = new int[numCourses];
    int index = 0;

    // BFS
    while (!queue.isEmpty()) {

        int course = queue.poll();

        result[index] = course;
        index++;

        for (int next : graph.get(course)) {

            indegree[next]--;

            if (indegree[next] == 0) {
                queue.offer(next);
            }
        }
    }

    // If we couldn't take every course,
    // there must be a cycle.
    if (index != numCourses) {
        return new int[0];
    }

    return result;
}
}