// Approach 1: Brute Force
// Time Complexity: O(NlogN) - sorting costs NlogN time
// Space Complexity: O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();
        // Add all values in all lists to an array list
        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }
        // sort the array list
        Collections.sort(l);
        // put all elements in the array into a list
        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }
}

// Approach 2: Compare one by one
// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode();
        ListNode head = res;
        boolean end = false;
        
        while(!end) {
            // keep track of the min index and value each time looping through the head of the list
            // if not all heads are null, set end to false
            int minIndex = 0;
            int minVal = Integer.MAX_VALUE;
            end = true;
            // find min value in k heads
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(lists[i].val < minVal) {
                        minVal = lists[i].val;
                        minIndex = i;
                    }
                    end = false;
                }   
            }
            // add the element to resulting list
            if(end == false) {
                head.next = new ListNode(minVal);
                head = head.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return res.next;
    }
}