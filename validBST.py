# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root == None:
            return True
        
        stack = []

        #create a prev counter and initially assign it None as we want to come to the leftmost element(that's in-order traversal)
        prev = None
        #create a current variable to store current value 
        curr = None
        
        #in-order traversal
        while stack or root != None:
            #get to the leftmost element
            while root != None:
                stack.append(root)
                #keep moving left
                root = root.left
            
            #Now pop the stack element to get current element
            curr = stack.pop()
            
            #if prev is greater than current, its not sorted...hence its not a valid BST
            if prev!=None and prev.val >= curr.val:
                return False
            
            #update previous value
            prev = curr
            #change your root to current.right
            root = curr.right
        
        return True
        
        