"""
Time Complexity :   isValidBST_recursive - O(n)
                    isValidBST_iterative - O(n)
Space Complexity :  isValidBST_recursive - O(h)
                    isValidBST_iterative - O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST_recursive(self, root):
        return self.helper(root, None, None)
        
    def helper(self, root, min_val, max_val):
        if root == None:    # base case when encountering a leaf node
            return True
        if max_val != None and root.val >= max_val:     # base case when right child >= max_val
            return False
        if min_val != None and root.val <= min_val:     # base case when left child <= min_val
            return False
        
        # logic
        return self.helper(root.left, min_val, root.val) and self.helper(root.right, root.val, max_val)
    
    def isValidBST_inorder_iterative(self, root):
        if not root:
            return True
        st = []
        prev = None
        
        while root or st:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            if prev != None and root.val <= prev.val: return False
            prev = root
            root = root.right 
            
        return True