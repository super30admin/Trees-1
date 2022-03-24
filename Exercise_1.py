# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# 98. Validate Binary Search Tree
# https://leetcode.com/problems/validate-binary-search-tree/

# Recursive
# Time Complexity = O(n)
# Space Complexity = O(n)

class Solution(object):
    prev = None
    isValid = True
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return
        self.isValidBST(root.left)
        if self.prev and root.val<=self.prev.val:
            
            self.isValid = False
            return 

        self.prev=root
        self.isValidBST(root.right)
        
        return self.isValid

# Iterative
# Time Complexity = O(n)
# Space Complexity = O(h) Height of the tree
class Solution(object):
    prev = None
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = []
        prev = None
        while(root or len(stack)>0):
            while(root):
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and root.val<=prev.val:
                return False
            prev = root
            root = root.right
        return True


# Calculating Max and Min
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root, curr_min, curr_max):
            if root == None:
                return True
            if root.val <= curr_min or root.val >= curr_max:
                return False
            
            return helper(root.left, curr_min, root.val) and helper(root.right, root.val, curr_max)
        
        return helper(root, float('-inf'), float('inf'))