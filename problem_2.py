# Time O(n)
# Space O(n)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return None 
        slow = head 
        fast = head
        while fast and fast.next:
            slow = slow.next 
            fast = fast.next.next 
        new_p = self.resverse_l(slow)
        while new_p:
            if head.val != new_p.val:
                return False 
            head = head.next 
            new_p = new_p.next 
        return True 
                
        
    def resverse_l(self, head):
        cur = head 
        prev = None
        tmp = None 
        while cur:
            tmp = cur.next 
            cur.next = prev 
            prev = cur 
            cur = tmp 

        return prev 
            


