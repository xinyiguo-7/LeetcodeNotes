// A good practice of writing comparator
// Time Complexity: O(M * N * logN) -- N is the length of array, M is number of elems in each log
// Space Complexity: O(M * logN)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> newComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // if both logs are letter-logs
                if(!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmpContent = split1[1].compareTo(split2[1]);
                    if(cmpContent != 0) {
                        return cmpContent;
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                }
                // if one or no log is digit log
                if(!isDigit1 && isDigit2) {
                    return -1;
                } else if(isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, newComp);
        return logs;
    }
}