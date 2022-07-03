// Approach: Sort
// Time Complexity: O(NlogN)
// Space Complexity: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
}

// Approach: Heap
// Time Complexity: O(Nlogk)
// Space Complexity: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Priority Queue is min element first by default
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int num : nums) {
            heap.add(num);
            // If heap elements have larger than k, then remove the first one
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}