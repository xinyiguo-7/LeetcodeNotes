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

