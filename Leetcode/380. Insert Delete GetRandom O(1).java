// Approach: ArrayList + HashMap
// HashMap's find & remove: O(1)
// ArrayList's get at index & remove at index & swap: O(1)
class RandomizedSet {
    List<Integer> vals; // values
    HashMap<Integer, Integer> map;  // value - index
    // Learn how to use Random object
    Random rand = new Random();
    
    public RandomizedSet() {
        vals = new ArrayList<>();
        map = new HashMap<>();
    }
    
    // put value and its index in the map, and append value to the end of ArrayList
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    // Swap target value with last value in ArrayList(so that indexes are not largely affected), then remove the last value
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int idx = map.get(val);
            int lastElem = vals.get(vals.size() - 1);
            
            vals.set(idx, lastElem);
            // change the index of last elem in map
            map.put(lastElem, idx);
            vals.remove(vals.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    // Since ArrayList contains all the values, randomly return one of them using Random object
    public int getRandom() {
        // Learn how to use Random object
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */