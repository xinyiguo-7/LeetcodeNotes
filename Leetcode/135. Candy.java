// Brute Force: Fill a candies array with number 1
// Scan ratings from left to right and see if an update on candies 
// distribution is necessary. (Update when 2nd condition is not met)
// Time Complexity: O(N^2)
// Space Complexity: O(N)
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        
        while(hasChanged) {
            hasChanged = false;
            for(int i = 0; i < ratings.length; i++) {
                if(i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
                if(i < ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
            }
        }
        
        int sum = 0;
        for(int n : candies) {
            sum += n;
        }
        return sum;
    }
}

// Optimized approach: scanning from left to right and right to left
// Increase # when number increases, back to 1 otherwise
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // Scan from left to right
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Scan from right to left
        for(int j = ratings.length - 2; j >= 0; j--) {
            if(ratings[j] > ratings[j + 1]) {
                candies[j] = Math.max(candies[j], candies[j + 1] + 1);
            }
        }
        
        int sum = 0;
        for(int n : candies) {
            sum += n;
        }
        return sum;
    }
}

// Finest approach: Single Pass Approach with Constant Space
// Time Complexity: O(N)
// Space Complexity: O(1)
public class Solution {
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1 
                : (ratings[i] < ratings[i - 1] ? -1 
                : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}