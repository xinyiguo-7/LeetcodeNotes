# Iterative reverse list
# Time Complexity: O(N)
# Space Complexity: O(1)

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return None
        prevNode = None
        nextNode = head.next
        
        while head != None and head.next != None:
            head.next = prevNode
            prevNode = head
            head = nextNode
            nextNode = head.next
        head.next = prevNode
        return head


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return None
        prev = None
        curr = head
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp 
        return prev