# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC: O(N) N is the total nodes in the tree 
# SC: O(H) H is the height of the tree
# LeetCode: Y(https://leetcode.com/problems/validate-binary-search-tree/)
# Approach: Inorder traversal of a valid BST prints the elements of the tree in an increasing order.
#           So previous element must always be less than the next element
#           So use a stack and do a preorder traversal checking if previous is less than current

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        stack = []
        previous = None
        
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            
            # check for BST property
            if previous and previous.val >= root.val:
                return False
            
            # update previous
            previous = root
            
            # update root
            root = root.right
            
        return True
            
        
