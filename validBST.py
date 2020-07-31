# Leetcode 98. Validate Binary Search Tree

# Time Complexity :  O(n) where n is the number of the nodes in tree

# Space Complexity : O(n) where n is the number of the nodes in tree thath can be in the stack in worst case

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: start at the root and traverse down the tree on the left child. Append the root to stack at
# every level of the tree. Once we reach the leaf, we check for its children and we exit out of the inner
# while i.e. we reached the left leaf. Now pop the stack and use the element as root. Check if there is a
# previous node and if its val is greater than root. If its greater than return false as that is not possible
# in a valid BST. Now traverse the right child. Once all the nodes are travsersed and stack is empty, return
# True

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        prev = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if(prev and prev.val >= root.val):
                return False
            prev = root
            root = root.right
        return True
