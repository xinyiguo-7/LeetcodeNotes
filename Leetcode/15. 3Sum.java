// Approach1: Two Pointers
// Time complexity: O(N^2)
// Space complexity: O(logN) to O(N)

// Remember the twoSumII method. It's important.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            // Use an if statement to skip the array elements that may cause duplicate
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                // use a while loop to skip the lower elements that may cause duplicate
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}

// I think this work but Leet Code failed me on [0,0,0,0] case.
// Time complexity: O(N^2)
// Space complexity: O(logN) to O(N)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3 || nums[0] > 0) {
            return new ArrayList<>();
        }
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                left = i + 1;
                int sum = nums[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                for(int j = 0; j < 2; j++) {
                    if(sum <= 0) {
                        sum += nums[right];
                        temp.add(nums[right]);
                        right--;
                    } else {
                        sum += nums[left];
                        temp.add(nums[left]);
                        left++;
                    }
                }
                if(sum == 0) {
                    res.add(temp);
                } else if(sum > 0) {
                    break;
                }
            }
        }
        return res;
    }
}

// Updated on 05/17/2022. This trial passed the small test cases, but exceeded time limit on large ones.
// P.S.: Only the first solution in this file passed the time limit.
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int mid = i + 1, high = nums.length - 1;
            while(mid < high){
                int tempSum = nums[i] + nums[mid] + nums[high];
                if(tempSum == 0) {
                    if(!res.contains(Arrays.asList(nums[i], nums[mid], nums[high]))){
                        res.add(Arrays.asList(nums[i], nums[mid], nums[high]));
                    }
                    mid++;
                } else if(tempSum > 0) {
                    high--;
                } else{
                    mid++;
                }
            }
        }
        return res;
    }
    
}

// Updated 5/19/2022
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while(low < high) {
                    if(nums[i] + nums[low] + nums[high] == 0) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    } else if(nums[i] + nums[low] + nums[high] > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}