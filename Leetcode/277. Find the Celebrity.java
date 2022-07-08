// Idea1: call knows on each person to another person
// If they knows someone, then is not celebrity
// But will cause O(n^2) time and n^2 times calling knows()
    

// Approach 2: Logical Deduction
// Time Complexity: O(N)
// Space Complexity: O(1)
// Calling knows <= 3*N times
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
    
            int celebrity = 0;
            
            for(int i = 0; i < n; i++) {
                if(i != celebrity && knows(celebrity, i)) {
                    celebrity = i;
                }
            }
            // check if this celebrity knows any person
            for(int j = 0; j < n; j++) {
                if(j != celebrity && knows(celebrity, j)) {
                    return -1;
                }
            }
            // check if all other people know celebrity
            for(int k = 0; k < n; k++) {
                if(k != celebrity && !knows(k, celebrity)) {
                    return -1;
                }
            }
            
            return celebrity;
        }
    }

// Another implementation by LC solution
    public class Solution extends Relation {
    
        private int numberOfPeople;
        
        public int findCelebrity(int n) {
            numberOfPeople = n;
            int celebrityCandidate = 0;
            for (int i = 0; i < n; i++) {
                if (knows(celebrityCandidate, i)) {
                    celebrityCandidate = i;
                }
            }
            if (isCelebrity(celebrityCandidate)) {
                return celebrityCandidate;
            }
            return -1;
        }
        
        private boolean isCelebrity(int i) {
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == j) continue; // Don't ask if they know themselves.
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
            return true;
        }
    }