// Leetcode solution using Queue
class HitCounter {
    private Queue<Integer> hits; 

    /** Initialize your data structure here. */
    public HitCounter() {
        this.hits = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if (diff >= 300) this.hits.remove();
            else break;
        }
        return this.hits.size();
    }
}

// My solution that exceeds time limit
class HitCounter {
    private int hitNum = 0;
    private int timeElapsed = 0;
    private int minTime = 0;
    private HashMap<Integer, Integer> map;
    
    public HitCounter() {
        map = new HashMap<>();
        hitNum = 0;
        timeElapsed = 0;
        minTime = 0;
    }
    
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        hitNum++;
        updateTime(timestamp);
    }
    
    public int getHits(int timestamp) {
        updateTime(timestamp);
        return hitNum;
    }
    
    public void updateTime(int timestamp) {
        timeElapsed = timestamp - minTime;
        if(timeElapsed > 300) {
            int newMin = timestamp - 300;
            for(int t = minTime + 1; t <= newMin; t++) {
                hitNum -= map.getOrDefault(t, 0);
            }
            minTime = newMin;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */