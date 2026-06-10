class Twitter {
    java.util.HashMap<Integer, Set<Integer>> following = new java.util.HashMap<>();
    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    private int timestamp = 0; 

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        if(tweets.containsKey(userId)){
            tweets.get(userId).add(newTweet);
        }
        else{
            java.util.ArrayList<Tweet> nl = new java.util.ArrayList<>();
            nl.add(newTweet);
            tweets.put(userId, nl);
        }
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        java.util.ArrayList<Integer> ans = new java.util.ArrayList<>();
        java.util.PriorityQueue<Tweet> newpq = new java.util.PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        Set<Integer> foll = following.get(userId);
        if (foll != null){
            for (int i : foll){
            List<Tweet> twts = tweets.get(i);
            if (twts == null){
                continue;
            }
            for(Tweet t :twts){
                newpq.add(t);           }
        }

        }
        if (foll == null || !foll.contains(userId)) {
            List<Tweet> twts = tweets.get(userId);
            if (twts != null){
                for(Tweet t: twts){
                    newpq.add(t);
                }
            }
        
        }
        
        
        while(newpq.size() > 0 && ans.size() < 10){
            ans.add(newpq.poll().tweetId);
        }
        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if (following.containsKey(followerId)){
            following.get(followerId).add(followeeId); 
        }
        else{
            Set<Integer> newSet = new HashSet<>();
            newSet.add(followeeId); 
            following.put(followerId, newSet);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)){
            following.get(followerId).remove(followeeId); 
        }
        
        
    }
}
class Tweet{
    int tweetId;
    int timestamp; 

    public Tweet(int tweetId, int timestamp){
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}
