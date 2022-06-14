// Leetcode solution checked overflow numbers successfully
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int myAtoi(String input) {
        int sign = 1; 
        int result = 0; 
        int index = 0;
        int n = input.length();
        
        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') { 
            index++; 
        }
        
        // sign = +1, if it's positive number, otherwise sign = -1. 
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions. 
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }
        
        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}

// My solution failing to check overflow cases
class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) {
            return 0;
        }
        long integer = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int sign = 1;
        int index = 0;
        int res = 0;
        
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        if(index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            if(s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        while(index < s.length() && index < s.length()) {
            if(Character.isDigit(s.charAt(index))) {
                integer = integer * 10 + s.charAt(index) - '0';
            } else {
                break;
            }
            index++;
        }
        integer *= sign;
        if((integer < 0 && sign == 1)) {
            res = max;
        } else if(integer > 0 && sign == -1){
            res = min;
        } else {
            res = (int)Math.min(max, Math.max(integer, min));
        }
        return res;
    }
}