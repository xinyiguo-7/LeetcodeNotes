// Time Complexity: O(N)
// Space Complexity: O(N)
// Approach: Monotonic Stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[N];
        answer[N - 1] = 0;
        s.push(N - 1);
        for(int i = N - 2; i >= 0; i--) {
            if(temperatures[i] < temperatures[i + 1]) {
                answer[i] = 1;
                s.push(i);
            } else {
                while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    answer[i] = 0;
                } else {
                    answer[i] = s.peek() - i;
                }
                s.push(i);
            }
        }
        return answer;
    }
}

// A cleaner solution using the same approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        
        return answer;
    }
}

// Array, Optimized space
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                // Use information from answer to search for the next warmer day
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        
        return answer;
    }
}