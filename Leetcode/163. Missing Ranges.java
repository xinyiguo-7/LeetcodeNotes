// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if(nums.length == 0) {
            if(lower == upper) {
                ranges.add(String.valueOf(lower));
            } else {
                ranges.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return ranges;
        }
        if(lower < nums[0] - 1) {
            ranges.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
        } else if(lower == nums[0] - 1) {
            ranges.add(String.valueOf(lower));
        }
        int left = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(left < nums[i] - 2) {
                ranges.add(String.valueOf(left + 1) + "->" + String.valueOf(nums[i] - 1));
            } else if(left == nums[i] - 2) {
                ranges.add(String.valueOf(left + 1));
            }
            left = nums[i];
        }
        if(left < upper - 1) {
            ranges.add(String.valueOf(left + 1) + "->" + String.valueOf(upper));
        } else if(left == upper - 1) {
            ranges.add(String.valueOf(upper));
        }
        return ranges;
    }
}

// Solution can be made cleaner if expand the range to be [lower - 1, upper + 1]
// And conclude string formatting in one function
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}
