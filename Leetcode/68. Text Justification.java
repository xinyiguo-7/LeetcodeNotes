class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> result = new ArrayList<>();
        
        while(i < words.length) {
            StringBuilder line = new StringBuilder();
            line.append(words[i]);
            
            int curLen = words[i].length();
            int totalLen = curLen;
            int toIdx = ++i;
            while(toIdx < words.length && curLen + 1 + words[toIdx].length() <= maxWidth) {
                curLen += 1 + words[toIdx].length();
                totalLen += words[toIdx].length();
                toIdx++;
            }
            
            int numSpaces = maxWidth - totalLen;
            if(toIdx != words.length) {
                for(int j = i; j < toIdx; j++) {
                    int addSpace = numSpaces / (toIdx - j);
                    if(numSpaces % (toIdx - j) != 0)
                        addSpace += 1;
                    for(int k = 0; k < addSpace; k++) {
                        line.append(' ');
                    }
                    line.append(words[j]);
                    numSpaces -= addSpace;
                }
            } else {
                for(int j = i; j < toIdx; j++) {
                    line.append(' ');
                    line.append(words[j]);
                    numSpaces--;
                }
            }
            
            if(numSpaces != 0) {
                for(int k = 0; k < numSpaces; k++) {
                    line.append(' ');
                }
            }
            
            result.add(line.toString());
            i = toIdx;
        }
        return result;
    }
}