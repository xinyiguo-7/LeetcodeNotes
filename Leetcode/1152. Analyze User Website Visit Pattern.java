
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> userVisitMap = new HashMap<>();
        for(int i = 0; i < username.length; i++) {
            userVisitMap.putIfAbsent(username[i], new ArrayList<>());
            userVisitMap.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }
        
        Pattern maxPattern = null;
        Map<Pattern, Integer> patternCountMap = new HashMap<>();
        for(Map.Entry<String, List<Visit>> userVisitEntry : userVisitMap.entrySet()) {
            Set<Pattern> set = new HashSet<>();
            List<Visit> userVisit = userVisitEntry.getValue();
            Collections.sort(userVisit, (x, y) -> x.time - y.time);
            for(int i = 0; i < userVisit.size(); i++) {
                for(int j = i+1; j < userVisit.size(); j++) {
                    for(int k = j+1; k < userVisit.size(); k++) {
                        Pattern p = new Pattern(userVisit.get(i).site, userVisit.get(j).site, userVisit.get(k).site);
                        if(!set.contains(p)) {
                            patternCountMap.put(p, patternCountMap.getOrDefault(p, 0) + 1);
                            if(maxPattern == null)
                                maxPattern = p;
                            else if(patternCountMap.get(p) > patternCountMap.get(maxPattern) || patternCountMap.get(p) == patternCountMap.get(maxPattern) && p.compareTo(maxPattern) < 0)
                                maxPattern = p;
                        }
                        set.add(p);
                    }
                }
            }
        }
        return Arrays.asList(maxPattern.first, maxPattern.second, maxPattern.third);
    }
}

class Pattern {
    String first, second, third;
    
    public Pattern(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public boolean equals(Object p) {
        if(((Pattern)p).first.equals(first) && ((Pattern)p).second.equals(second) && ((Pattern)p).third.equals(third))
            return true;
        return false;
    }
    
    public int hashCode() {
        return first.hashCode() + second.hashCode() + third.hashCode();
    }
    
    public int compareTo(Pattern p) {
        if(p.first.equals(first) && p.second.equals(second))
            return third.compareTo(p.third);
        else if(p.first.equals(first))
            return second.compareTo(p.second);
        else
            return first.compareTo(p.first);
    }
}

class Visit {
    int time;
    String site;
    
    public Visit(int time, String site) {
        this.time = time;
        this.site = site;
    }
}