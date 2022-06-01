// Time Complexity: O(N * M)
// Space Complexity: O(N + M)
// Approach: Inmitate the process of multiplying two numbers, store the product
// of each digit multiplication in an array, add them, then convert the array
// into string and return.
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        int[] product = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            int value1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--) {
                int value2 = num2.charAt(j) - '0';
                int idx = i + j + 1;
                int curr = product[idx];
                product[idx] = (value1 * value2 + curr) % 10;
                product[idx - 1] += (value1 * value2 + curr) / 10;
            }
        }
        int start = 0;
        while(start < product.length && product[start] == 0) {
            start++;
        }
        for(int k = start; k < product.length; k++) {
            res.append(product[k]);
        }
        return res.toString();
    }
}