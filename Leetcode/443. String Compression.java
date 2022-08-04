// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int compress(char[] chars) {
        // answer array and chars array use two different index
        int index = 0, i = 0;
        while(i < chars.length) {
            int count = 0;
            char currCh = chars[i];
            // Will enter this while loop everytime encountered a new char
            while(i < chars.length && chars[i] == currCh) {
                i++;
                count++;
            }
            chars[index++] = currCh;
            // write count to array if it is greater than 1
            if(count > 1) {
                for(char ch : Integer.toString(count).toCharArray())
                    chars[index++] = ch;
            }
        }
        return index;
    }
}