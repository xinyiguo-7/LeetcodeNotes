class Solution {
    public int minSwaps(String s) {
        // Possible alternating strings:
        // only 1s on odd, 0s on even/0s on odd, 1s on even
        // zeros == ones: 101010, 010101, doesn't matter starting with 0s or 1s
        // zeros == one + 1: 0101010, has to start with 0
        // ones == zero + 1: 1010101, has to start with 1
        // else: impossible
        int zeros = 0, ones = 0;
        int shouldStartWith0 = 0, shouldStartWith1 = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')
                zeros++;
            else
                ones++;
            
            if(i % 2 == 0 && s.charAt(i) == '0' || i % 2 == 1 && s.charAt(i) == '1')
                shouldStartWith1++;
            else
                shouldStartWith0++;
        }
        
        if(Math.abs(zeros - ones) > 1) 
            return -1;
        if(ones == zeros)   // Doesn't matter to start with 1 or 0
            return Math.min(shouldStartWith1, shouldStartWith0) / 2;
        if(ones > zeros)    // Has to start with 1
            return shouldStartWith1 / 2 + shouldStartWith1 % 2;
        else
            return shouldStartWith0 / 2 + shouldStartWith0 % 2;
    }
}