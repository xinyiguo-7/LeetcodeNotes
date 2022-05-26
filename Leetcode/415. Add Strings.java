// An AC solutoin.
// Time Complexity: O(N) - N is the longer length of the two strings
// Space Complexity: O(N)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int value = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            sum.append(value);
            i--;
            j--;
        }
        if(carry != 0) {
            sum.append(carry);
        }
        return sum.reverse().toString();
    }
}

// A soluton that only works for short strings
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int n = len1 > len2 ? len1 : len2;
        int[] num1Arr = new int[n];
        int[] num2Arr = new int[n];
        int sum = 0;
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < len1; i++) {
            num1Arr[i + n - len1] = num1.charAt(i) - '0';
        }
        for(int j = 0; j < len2; j++) {
            num2Arr[j + n - len2] = num2.charAt(j) - '0';
        }
        // sum may exceed the highest bound of integers in Java
        for(int k = 0; k < n; k++) {
            sum += (num1Arr[k] + num2Arr[k]) * Math.pow(10, n - k - 1);
        }
        if(sum == 0) {
            return "0";
        }
        while(sum > 0) {
            res.insert(0, sum % 10);
            sum /= 10;
        }
        return res.toString();
    }
}