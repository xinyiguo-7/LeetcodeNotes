// #1
class Solution {
    public void solution() {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < categories.length(); i++) {
        arr2[categories.charAt(i) - 'a']++;
        }
        Int count = 0;
        Int res = 0;
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

// #3
class Solution {
    public int[] solution(int[] A, int k) {
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
    static int[] solve(int[] A, int k){
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
    public ListNode solution(ListNode head, String[][] oprations) {
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
    }
}

// #7
class Solution {
    public int maximumCount(String s) {
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
    public int findUniqueValue(int[] experience) {
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
    public String isSimilar(String[] oldPasswords, String[] newPasswords) {
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
    public int minSegments(String s) {
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
    public int[] afterLocations(int[] locations, int[] moveFrom, int[] moveTo) {
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
        SinglyLinkedListNode result = new SinglyLinkedListNode(heal.val);
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
        }
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

// #16
class Solution {
    public int minPresses(String message) {
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
    public int maxKScore(int[] stock_prices, int k) {
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

