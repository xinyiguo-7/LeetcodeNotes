class Solution {
    public int getMaxLen(int[] nums) {
        int positiveLen = 0, negativeLen = 0;
        int result = positiveLen;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                // no sign changing, positive length increase
                // negative length keeps zero if is zero, or increase if not
                positiveLen++;
                negativeLen = negativeLen == 0 ? 0 : negativeLen + 1;
            } else if(nums[i] < 0) {
                // changing sign, switch positive and negative number's length
                int temp = positiveLen;
                positiveLen = negativeLen == 0 ? 0 : negativeLen + 1;
                negativeLen = temp + 1;
            } else {
                // encounter a zero number, clear the lengths
                positiveLen = 0;
                negativeLen = 0;
            }
            result = Math.max(result, positiveLen);
        }
        return result;
    }
}