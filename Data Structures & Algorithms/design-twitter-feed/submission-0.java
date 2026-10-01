class Twitter {

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(
            new Tweet(tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(b.time, a.time)
            );

        Set<Integer> users = new HashSet<>();

        users.add(userId);

        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        for (int user : users) {

            List<Tweet> list = tweetMap.get(user);

            if (list != null) {
                for (Tweet tweet : list) {
                    pq.offer(tweet);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}