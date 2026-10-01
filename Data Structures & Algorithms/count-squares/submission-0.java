

    class CountSquares {

    Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = map.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int answer = 0;

        // Look at points having the same x-coordinate
        if (!map.containsKey(x)) {
            return 0;
        }

        for (int y2 : map.get(x).keySet()) {

            if (y2 == y) {
                continue;
            }

            int side = Math.abs(y - y2);

            // Square extending to the left
            int x1 = x - side;

            if (map.containsKey(x1)) {
                int count1 = map.get(x1).getOrDefault(y, 0);
                int count2 = map.get(x1).getOrDefault(y2, 0);

                answer += count1 * count2 * map.get(x).get(y2);
            }

            // Square extending to the right
            int x2 = x + side;

            if (map.containsKey(x2)) {
                int count1 = map.get(x2).getOrDefault(y, 0);
                int count2 = map.get(x2).getOrDefault(y2, 0);

                answer += count1 * count2 * map.get(x).get(y2);
            }
        }

        return answer;
    }
}