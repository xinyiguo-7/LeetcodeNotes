// Time Complexity: O(logN)
// Space Complexity: O(logN)
class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        List<Integer> nums = new ArrayList<>();
        
        while(n != 1) {
            int temp = n;
            while(temp != 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            nums.add(n);
            n = sum;
            if(nums.contains(n)) {
                return false;
            }
            sum = 0;
        }
        return true;
    }
}