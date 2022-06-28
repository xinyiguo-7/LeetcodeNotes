// Leetcode solution: long division
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        // Consider fraction as a string
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        // If dividend can be divided, then just return fraction
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        // Store remainder and current index of fraction
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}

// Wrong Answer
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        // nums.add(numerator);
        if(numerator / denominator == 0) {
            sb.append("0.");
            numerator *= 10;
        } else if(numerator % denominator == 0){
            sb.append(String.valueOf(numerator / denominator));
        } else {
            sb.append(String.valueOf(numerator / denominator));
            sb.append(".");
            numerator %= denominator;
            numerator *= 10;
        }
        StringBuilder recur = new StringBuilder();
        while(!nums.contains(numerator)) {
            nums.add(numerator);
            int quotient = numerator / denominator;
            if(numerator % denominator == 0) {
                sb.append(String.valueOf(quotient));
                break;
            } else if(quotient == 0){
                recur.append(String.valueOf(quotient));
                numerator *= 10;
            } else {
                recur.append(String.valueOf(quotient));
                numerator %= denominator;
                numerator *= 10;
            }
        }
        if(!recur.isEmpty()) {
            sb.append("(" + recur.toString() + ")");
        }
        
        return sb.toString();
    }
}