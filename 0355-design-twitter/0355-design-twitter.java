class Twitter {

    Map<Integer, List<int[]>> tweet;
    Map<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweet = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.putIfAbsent(userId, new ArrayList<>());
        tweet.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        if(tweet.containsKey(userId)){
            for(int[] id : tweet.get(userId)){
                pq.add(id);
                if(pq.size() > 10){
                    pq.poll();
                }
            }
        }

        if(following.containsKey(userId)){
            for(int followee : following.get(userId)){
                if(tweet.containsKey(followee)){
                    for(int[] id : tweet.get(followee)){
                        pq.add(id);
                        if(pq.size() > 10){
                            pq.poll();
                        }
                    }
                }
            }
        }

        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll()[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
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