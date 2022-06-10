// Time Complexity: O(N)
// Space Complexity: O(M)  M == k
// Approach: My approach using queue to reverse linked list iteratively
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Queue<ListNode> Q = new LinkedList<>();
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode prev = sentinel;
        
        while(head != null) {
            for(int i = 0; head != null && i < k; i++) {
                Q.add(head);
                head = head.next;
            }
            if(Q.size() == k) {
                ListNode curr = head;
                ListNode nextPrev = Q.peek();
                while(Q.size() > 0) {
                    ListNode lastNode = Q.poll();
                    lastNode.next = curr;
                    curr = lastNode;
                }
                prev.next = curr;
                prev = nextPrev;
            }
        }
        return sentinel.next;
    }
}

// LeetCode solutions
// Approach 1: Recursion
// Time Complexity: O(N)
// Space Complexity: O(N/k)
class Solution {
    // Get familiarize with this reverse linked list function
    public ListNode reverseLinkedList(ListNode head, int k) {
        
        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains 
        // atleast k nodes.
        ListNode new_head = null;
        ListNode ptr = head;
        
        while (k > 0) {
            
            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;
            
            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;
            
            // Move on to the next node
            ptr = next_node;
            
            // Decrement the count of nodes to be reversed by 1
            k--;
        }
            
            
        // Return the head of the reversed list
        return new_head;
    
    }
            
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int count = 0;
        ListNode ptr = head;
        
        // First, see if there are atleast k nodes
        // left in the linked list.
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
        
        // If we have k nodes, then we reverse them
        if (count == k) {
            
            // Reverse the first k nodes of the list and
            // get the reversed list's head.
            ListNode reversedHead = this.reverseLinkedList(head, k);
            
            // Now recurse on the remaining linked list. Since
            // our recursion returns the head of the overall processed
            // list, we use that and the "original" head of the "k" nodes
            // to re-wire the connections.
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }
            
        return head;
    }
}

// Approach 2: Iteration
// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    
    public ListNode reverseLinkedList(ListNode head, int k) {
        
        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains 
        // atleast k nodes.
        ListNode new_head = null;
        ListNode ptr = head;
        
        while (k > 0) {
            
            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;
            
            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;
            
            // Move on to the next node
            ptr = next_node;
            
            // Decrement the count of nodes to be reversed by 1
            k--;
        }
            
            
        // Return the head of the reversed list
        return new_head;
    
    }
            
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode ptr = head;
        ListNode ktail = null;
        
        // Head of the final, moified linked list
        ListNode new_head = null;
        
        // Keep going until there are nodes in the list
        while (ptr != null) {
            
            int count = 0;
            
            // Start counting nodes from the head
            ptr = head;
            
            // Find the head of the next k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            // If we counted k nodes, reverse them        
            if (count == k) {
                
                // Reverse k nodes and get the new head
                ListNode revHead = this.reverseLinkedList(head, k);
                
                // new_head is the head of the final linked list
                if (new_head == null)
                    new_head = revHead;
                
                // ktail is the tail of the previous block of 
                // reversed k nodes
                if (ktail != null)
                    ktail.next = revHead;
                    
                ktail = head; 
                head = ptr;
            }
        }
            
         // attach the final, possibly un-reversed portion
        if (ktail != null)
            ktail.next = head;
        
        return new_head == null ? head : new_head;
    }
}