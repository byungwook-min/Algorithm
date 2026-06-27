class Twitter {

    private static class User {
        Set<Integer> followees = new HashSet();

    }

    private static class Tweet {
        private final int userId;
        private final int tweetId;

        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    private final Map<Integer, User> users;
    private final List<Tweet> tweets;

    public Twitter() {
        this.users = new HashMap<>();
        this.tweets = new ArrayList();
    }

    public void postTweet(int userId, int tweetId) {
        User user = users.computeIfAbsent(userId, id -> new User());
        tweets.addFirst(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);

        if (user == null) {
            return new ArrayList<>();
        }

        Set<Integer> followees = user.followees;
        return tweets.stream()
            .filter(t -> (followees.contains(t.userId) || userId == t.userId))
            .limit(10)
            .map(t -> t.tweetId)
            .toList();
    }

    public void follow(int followerId, int followeeId) {
        User user = users.computeIfAbsent(
                followerId,
                id -> new User()
        );
        user.followees.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User user = users.get(followerId);

        if (user != null) {
            user.followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
