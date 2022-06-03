class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] num = new int[nums.length];
        Arrays.fill(len, 1);
        Arrays.fill(num, 1);
        int max_len = 0, res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[i] == len[j] + 1) {
                        num[i] += num[j];
                    } else if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        num[i] = num[j];
                    }
                }
            }
            if(max_len == len[i])
                res += num[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = num[i];
            }
        }
        return res;
    }
}
