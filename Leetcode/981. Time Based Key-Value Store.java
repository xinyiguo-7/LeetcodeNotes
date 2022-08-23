// Time Complexity: O(N)
// Space Complexity: O(N)
// Learned how to use a TreeMap where sorting of keys are implemented
// So we can traverse through elements via sorted keys.
class TimeMap {
    
    HashMap<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> timeMap = new TreeMap<>();
            timeMap.put(timestamp, value);
            map.put(key, timeMap);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = map.get(key);
        // remember to check whether this map is null
        if(timeMap != null) {
            if(timeMap.containsKey(timestamp)) {
                return timeMap.get(timestamp);
                //  lowerKey() returns a key stricly lower than given key, or null
            } else if(timeMap.lowerKey(timestamp) != null) {
                int lowerKey = timeMap.lowerKey(timestamp);
                return timeMap.get(lowerKey);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */