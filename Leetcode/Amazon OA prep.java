// #1
class Solution {
    public void findNumWaysToSplit() {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        int count = 0;
        int res = 0;
        for(int i = 0; i < categories.length(); i++) {
            arr2[categories.charAt(i) - 'a']++;
            }
            for(int j = 0; j < categories.length(); j++) {
                if(arr1[categories.charAt(i) - 'a'] == 0 && arr2[categories.charAt(i) - 'a'] > 1) {
                    count++;
                } else if (arr2[categories.charAt(i) - 'a'] <= 1) {
                    count--;
                }
                if(count > k) {
                    res++;
                }
                arr1[categories.charAt(i) - 'a']++;
                arr2[categories.charAt(i) - 'a']--;
            }
    }
}

// #2
class Solution {
    public int minimumLag(int[] center, int[] destination) {
        int N = center.length;
        Arrays.sort(center);
        Arrays.sort(destination);
        int minLag = 0;
        for(int i = 0; i < N; i++) {
            minLag += Math.abs(center[i], destination[i]);
        }
        return minLag;
    }
}
// #3
class Solution {
    public int[] getSmallestInefficiencies(int[] A, int k) {
        Arrays.sort(A);
        int n = A.length;
        var minheap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < A.length; i++){
            minheap.offer(new int[]{A[i]-A[i-1],i-1,i});
        }
        int[] ans = new int[k];
        while(k > 0){
            int[] top = minheap.poll();
            int val = top[0], L = top[1], R = top[2];
            ans[--k]=val;
            if (R < A.length -1){
                minheap.offer(new int[]{A[R+1]-A[L], L, R+1});
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}

class Solution {
    static int[] getSmallestInefficiencies(int[] A, int k){
        Arrays.sort(A);
        int lo = 0, hi = (int)1e8;
        while(lo < hi){ // find max bound 
            int mid = (lo+hi+1)>>1;
            long cnt = 0;
            for (int i = 0, j = 0; i < A.length; i++){
                while(A[i] - A[j] > mid){
                    ++j;
                }
                cnt += i - j;
            }
            if (cnt <= k){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < A.length && k > 0; i++){ // fill it.
            while(A[i]-A[j]>lo){
                ++j;
            }
            for (int s = j; s < i && k > 0; s++){
                ans[--k]=A[i]-A[s];
            }
        }
        while(k>0) { // fill the remaining with lo+1.
            ans[--k]=lo+1;
        }
    }
}

// #4
class Solution {
    public ListNode getShoppingCart(ListNode head, String[][] oprations) {
        for(String[] op : oprations) {
            if(op[0].equals("PUSH_HEAD")) {
                ListNode newHead = new ListNode(op[1]);
                newHead.next = head;
                head = newHead;
            }
            if(op[0].equals("PUSH_TAIL")) {
                ListNode curr = head;
                while(curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new ListNode(op[1]);
            }
            if(op[0].equals("POP_HEAD")) {
                head = head.next;
            }
        }
        return head;
    }
}

// #5 getMinMoves
// {
//     int n = plates.size();
//     int mn=INT_MAX,mx=INT_MIN;
//     vector arr = plates;
//     int min_idx,max_idx;
//     for(int i=0;imx)
//         {
//             mx = arr[i];
//             max_idx = i;
//         }
//         if(arr[i]min_idx)
//         {
//             ans += min_idx+(n-1-max_idx);
//         }
//         else
//         {
//         ans += min_idx;
//         max_idx++;
//         ans += (n-1-max_idx);
//         }
//     return ans;
// } 

// #6
class Solution {
    public int getpMatchingScore(String username1, String username2, int p) {
        int count = username2.length();
        int start = 0;
        int pScore = 0;
        while(start + (count - 1) * p < username1.length()) {
            StringBuilder sb = new StringBuilder();
            int index1 = start;
            while(count > 0) {
                sb.append(username1.charAt(index1));
                index1 += p;
                count--;
            }
            if(username2.equals(sb.toString())) {
                pScore++;
            }
            count = username2.length();
            start++;
        }
        return pScore;
    }
}

// #7
class Solution {
    public int findMaximumMaximaCount(String s) {
        int[] freq = new int[26];
        int[] maxCountFreq = new int[26];
        int maxCountIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            int curChIndex = s.charAt(i) - 'a';
            freq[curChIndex]++;
            if(freq[curChIndex] > maxCountFreq[maxCountIdx]) {
                maxCountIdx = curChIndex;
                maxCountFreq[curChIndex]++;
            } else if (freq[curChIndex] == maxCountFreq[maxCountIdx]) {
                maxCountFreq[maxCountIdx]++;
                maxCountFreq[curChIndex]++;
            } else {
                maxCountFreq[maxCountIdx]++;
            }
        }

        int res = 0;
        for(int max : maxCountFreq) {
            res = Math.max(max, res);
        }
        return res;
    }
}

// #8
class Solution {
    public int findUniqueValues(int[] experience) {
        int N = experience.length;
        Set<Double> appeared = new HashSet<>();
        for(int i = 0; i < N / 2; i++) {
            double val = (double)(experience[i] + experience[N - i - 1]) / 2;
            if(!appeared.contains(val)) {
                appeared.add(val);
            }
        }
        return appeared.size();
    }
}

// #9
class Solution {
    public String similarPassword(String[] oldPasswords, String[] newPasswords) {
        int N = oldPasswords.length;
        for(int i = 0; i < N; i++) {
            String newPW = newPasswords[i];
            String oldPW = oldPasswords[i];
            int o = 0, n = 0;
            while(n < newPW.length() && o < oldPW.length()) {
                if(newPW.charAt(n) == oldPW.charAt(o) || (char)((int)newPW.charAt(n) + 1) == oldPW.charAt(o)) {
                    o++;
                }
                n++;
            }
            if(o != oldPW.length()) {
                return "NO";
            }
        }
        return "YES";
    }
}

// #10
class Solution {
    public int findMinSegments(String s) {
        int[] appeared = new int[26];
        int res = 0;
        for(char ch : s.toCharArray()) {
            if(appeared[ch - 'a'] > 0) {
                res++;
                appeared = new int[26];
            }
            appeared[ch - 'a']++;
        }
        return res + 1;
    }
}

// #11
class Solution {
    public int[] moveDataLocation(int[] locations, int[] moveFrom, int[] moveTo) {
        for(int i = 0; i < moveFrom; i++) {
            for(int j = 0; j < locations.length; j++) {
                if(locations[j] == moveFrom[i]) {
                    locations[j] = moveTo[i];
                    break;
                }
            }
        }
        return Arrays.sort(locations);
    }
}

// #12
class Solution {
    public SinglyLinkedListNode findLongestList(SinglyLinkedListNode head) {
        SinglyLinkedListNode result = new SinglyLinkedListNode(head.val);
        SinglyLinkedListNode curr = result;
        int maxLen = 0;
        while(head != null) {
            SinglyLinkedListNode newSeg = new SinglyLinkedListNode(head.val);
            int curLen = 1;
            curr = newSeg;
            while(head != null && head.next != null && head.val >= head.next.val) {
                newSeg.next = new SinglyLinkedListNode(head.next.val);
                newSeg = newSeg.next;
                head = head.next;
                curLen++;
            }
            if(curLen > maxLen) {
                result = curr;
                maxLen = curLen;
            }
            head = head.next;
        }
        return result;
    }
}

// Constant extra space
class Solution {
    public SinglyLinkedListNode findLongestList(SinglyLinkedListNode head) {
        SinglyLinkedListNode result = head;
        SinglyLinkedListNode ptr = result;
        int maxLen = 0;
        while(head != null) {
            SinglyLinkedListNode ptr = head;
            int curLen = 1;
            while(head != null && head.next != null && head.val >= head.next.val) {
                head = head.next;
                curLen++;
            }
            if(curLen > maxLen) {
                result = ptr;
                maxLen = curLen;
            }
            head = head.next;
        }
        ptr = result;
        for(int i = 0; i < maxLen - 1; i++) {
            ptr = ptr.next;
        }
        ptr.next = null;
        return result;
    }
}

// #13
class Solution {
    public int minStartingHealth(int[] power, int armor) {
        int minStart = 0;
        int maxPower = 0;
        for(int i = power.length - 1; i >= 0; i--) {
            maxPower = Math.max(maxPower, power[i]);
            minStart += power[i];
        }
        // minStart = minStart - maxPower + maxPower - Math.min(armor, maxPower);
        minStart = minStart - Math.min(armor, maxPower);
    }
}

// #14
class Solution {
    public int minCost(int[] parcels, int k) {
        int remaining = k - parcels.length;
        int costs = 0;
        int curId = 1;
        int pIndex = 0;
        while(remaining > 0) {
            if(currId < parcels[pIndex]) {
                costs += currId;
                remaining--;
            } else {
                while(pIndex < parcels.length && curId >= parcels[pIndex]) {
                    pIndex++;
                }
            }
            currId++;
        }
        return costs;
    }
}

// #15
class Solution {
    public int findMaxStockPricesSum(int[] stock_prices, int k) {
        int left = -1;
        int res = -1, kSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();    // store price and its last appeared index
        
        for(int i = 0; i < stock_prices.length; i++) {
            int price = stock_prices[i];
            if(map.containsKey(price) && map.get(price) > left) {
                left = map.get(price);
            }
            map.put(price, i);
            kSum += price;
            if(i - k >= 0) {
                kSum -= stock_prices[i - k];
            }
            if(i - k >= left) {
                res = Math.max(res, kSum);
            }
        }
        return res;
    }
}
// #16
class Solution {
    public int minKeypadClickCount(String message) {
        // Don't care about what character each frequence # corresponds to
        int[] freq = new int[26];
        for(char ch : message.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int countPos = 0;
        int press = 1;
        int totalPress = 0;
        for(int f : freq) {
            if(f == 0) {
                break;
            }
            if(countPos < 9) {
                totalPress += press * f;
                countPress++;
            } else {
                countPos = 0;
                press++;
            }
        }
        return totalPress;
    }
}

// #17
class Solution {
    public int[][] purchaseBooks(int[] volumes) {
        int[][] result = new int[volumes.length][];
        int newestVer = 0;
        int[] alreadyHave = new int[volumes.length];
        for(int i = 0; i < volumes.length; i++) {
            alreadyHave[volumes[i] - 1] = 1;
            boolean purchase = true;
            for(int j = volumes[i] - 2; j > newestVer - 1; j--) {
                if(alreadyHave[j] == 0) {
                    purchase = false;
                    break;
                }
            }
            if(purchase == true) {
                int count = 0;
                int index = newestVer;
                while(index < alreadyHave.length && alreadyHave[index] != 0) {
                    count++;
                    index++;
                }
                int[] buy = new int[count];
                for(int k = 0; k < count; k++) {
                    buy = ++newestVer;
                }
                result[i] = buy;
            } else {
                result[i] = new int[]{-1};
            }
        }
        return result;
    }
}

// #18
class Solution {
    public int minNumCharstoAdd(String searchWord, String resultWord) {
        int s = 0, r = 0;
        while(s < searchWord.length() && r < resultWord.length()) {
            if(searchWord.charAt(s) == resultWord.charAt(r)) {
                r++;
            }
            s++;
        }
        return resultWord.length() - r;
    }
}
// #19
// LC 424 for reference
// class Solution {
//     public int characterReplacement(String s, int k) {
//         int maxFreq = 0;
//         int[] freq = new int[26];
//         int i = 0;
        
//         int maxLen = 0, start = 0;
//         for(; i < s.length(); i++) {
//             freq[s.charAt(i) - 'A']++;
//             maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);
            
//             while(i - start + 1 - maxFreq > k) {
//                 freq[s.charAt(start) - 'A']--;
//                 maxFreq = Math.max(maxFreq, freq[s.charAt(start) - 'A']);
//                 start++;
//             }
//             maxLen = Math.max(maxLen, i - start + 1);
//         }
//         return maxLen;
//     }
// }

class Solution {
    public int getkConsistency(int[] stock_prices, int k) {
        int maxFreq = 0;
        int maxLen = 0, start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();    // price, frequency

        for(int i = 0; i < stock_prices.length; i++) {
            map.put(stock_prices[i], map.getOrDefault(stock_prices[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(stock_prices[i]));

            while(i - start + 1 - maxFreq > k) {
                map.put(stock_prices[i], map.getOrDefault(stock_prices[i], 0) - 1);
                start++;
            }
        }
        return maxFreq;
    }
}

// #20
class Solution {
    public int getMaxFreqDeviation() {
        // Maintain a map of freq of characters in the string
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        int max = 0;
        // Check for every possible pair of characters in the map with the assumption that the one char is greater than the other
        // In the following piece of code, assuming c2 count is greater than c1
        for(char c1 : map.keySet()){
            for(char c2 : map.keySet()){
                // If both the characters are same then we don't explore any further
                if(c1 == c2)
                    continue;
                int c1Freq=0, c2Freq=0;
                int c1Remaining=map.get(c1); // Keep track of the remaining c1 chars
                
                // Iterate through all the characters in the string
                for(char c : s.toCharArray()){
                    if(c == c1){
                        c1Freq++;
                        c1Remaining--;
                    }
                    if(c == c2)
                        c2Freq++;

                    // If c2-count < c1-count then we reset the counters, only if we know there are more c1 chars to come in the iteration
                    // c1Remaining check is required for the test case "baa" and c1=b && c2=a. We don't reset the counters if there are no more c1 chars left					
                    if(c2Freq < c1Freq && c1Remaining > 0) {
                        c2Freq=0;
                        c1Freq=0;
                    }
                    
                    // Calculate variance of current substring and update max accordingly
                    if(c1Freq > 0 && c2Freq > 0)
                        max = Math.max(max, c2Freq-c1Freq);
                }
            }
        }
        return max;
    }
}

// #21
class Solution {
    public int countMaximumOperations(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxOp = 0;
        for(char ch : t.toCharArray()) {
            maxOp = Math.min(maxOp, map.getOrDefault(ch));
        }
    }
}

// #22
// might TLE
class Solution {
    public int minNumberTrips(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int weight : weights)
            map.put(weight, map.getOrDefault(weight,0)+1);
        Set<Integer> weightsKey = map.keySet();
        int ans = 0;
        for(int w : weightsKey) {
            int cnts = map.get(w);
            if(cnts < 2) 
                return -1;
            if(cnt % 3 == 0) 
                ans += cnts/3;
            else 
                ans += cnts/3 + 1;
        }
        return ans;
    }
}

// Use sorting + math
class Solution {
    public int minNumberTrips(int[] weights) {
        Arrays.sort(weights);
        int ans = 0;
        for(int i = 0; i < weights.length; i++) {
            int count = 1;
            while(i + 1 < weights.length && weights[i] == weights[i + 1]) {
                count++;
                i++;
            }
            if(count < 2) 
                return -1;
            if(count % 3 == 0) 
                ans += count/3;
            else 
                ans += count/3 + 1;
        }
    }
}

// For reference
// def getMinimumTrips(weights):
//     ct = {}
//     for w in weights:
//         ct[w] = ct.get(w, 0) + 1

//     ret = 0
//     # the idea is that we want to deliver 3 packages as many times
//     # as possible, because it's greater than 2, so it'll result
//     # in fewer deliveries
//     for w, c in ct.items():
//         if c == 1:
//             # can never deliver 1 package
//             return -1
//         elif c % 3 == 0:
//             # 3 perfectly divides the count, so just deliver
//             # three packages each time
//             ret += c // 3
//         elif c % 3 == 1:
//             # c == 1 mod 3, so we can deliver 2 packages twice
//             # and then it'll be divisible by 3, so we can deliver
//             # 3 packages for the rest of the count
//             ret += ((c - 4) // 3) + 2
//         else:
//             # c == 2 mod 3, so we can deliver 2 packages once
//             # and then it'll be divisible by 3
//             ret += ((c - 2) // 3) + 1

//     return ret