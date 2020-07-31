# APPROACH 1: Iterative Solution
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do inorder traversal
# 2. Store previous value in memory, st it can be compared against the current value
# 3. If current < previous value -> Invalid tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        stack, prev, isFirst = [], float('-inf'), True
        
        while root is not None or (len(stack) > 0 or isFirst):
            isFirst = False
            while root is not None:
                stack.append(root)
                root = root.left
                
            root = stack.pop(-1)
            if prev != float('inf') and prev >= root.val:
                return False
            prev = root.val
            root = root.right
            
        return True
        
        
        

# APPROACH 2: Recursive Solution
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as approach 1 but in recursive way

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.prev = None
        
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        return self.helper(root)

    
    def helper(self, root):
        if root is None:
            return True
        
        if self.helper(root.left) is False:
            return False
        
        if self.prev is not None and self.prev >= root.val:
            return False
        self.prev = root.val
        return self.helper(root.right)
        
        
        
        
        
# APPROACH 3: Using range
# Time Complexity : O(n), n: number of nodes 
# Space Complexity : O(h), h: height of the tree (max and min stored at each node is of constant space)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1 For each node, store the min and max value that it can have
# 2. For root's left child -> min: same as the parent's, max: bounded by the parent - 1
#               right child -> min: same as parent + 1, max: same as max of parent's
# 3. if the current value violates the range, INVALID TREE


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        return self.helper(root, float('-inf'), float('inf'))

    
    def helper(self, root, min_val, max_val):
        if root is None:
            return True
        
        if root.val <= min_val or root.val >= max_val:
            return False
        
        return self.helper(root.left, min_val, root.val) and self.helper(root.right, root.val, max_val)
        
