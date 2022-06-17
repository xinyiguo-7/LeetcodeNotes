// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int[] plusOne(int[] digits) {
        int N = digits.length;
        int value = (digits[N - 1] + 1) % 10;
        int carry = (digits[N - 1] + 1) / 10;
        digits[N - 1] = value;
        int i = N - 2;
        
        while(carry > 0 && i >= 0) {
            value = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = value;
            i--;
        }
        if(carry > 0) {
            int[] newDigits = new int[N + 1];
            // A nice function to remember for copying arrays
            System.arraycopy(digits, 0, newDigits, 1, N);
            newDigits[0] = carry;
            return newDigits;
        }
        return digits;
    }
}