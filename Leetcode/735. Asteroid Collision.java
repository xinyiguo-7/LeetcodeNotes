// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> remaining = new LinkedList<>();
        int rightCount = 0;
        
        for(int a : asteroids) {
            if(a > 0) {
                remaining.add(a);
                rightCount++;
            }
            if(a < 0) {
                if(rightCount == 0) {
                    remaining.add(a);
                    continue;
                }
                int current = a;
                while(current < 0 && rightCount > 0) {
                    int metAsteroid = remaining.removeLast();
                    if(Math.abs(current) < Math.abs(metAsteroid)) {
                        current = metAsteroid;
                    } else if (current == -metAsteroid) {
                        current = 0;
                    }
                    if(current <= 0) {
                        rightCount--;
                    }
                    
                }
                if(current != 0) {
                    remaining.add(current);
                }
            }
        }
        
        int[] res = remaining.stream().mapToInt(i -> i).toArray();
        return res;
    }
}