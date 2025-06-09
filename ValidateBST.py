# Time Complexity: O(N), N is the number of nodes in the tree
# Space Complexity: O(H), where H is the number of recursive function calls in the stack
# O (log N) in best case where the tree is balanced and O(N) in the worst case where the tree is skewed
# Did this code successfully run on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True

    def isValidBST(self, root) -> bool:
        self.helper(root)
        return self.flag
    
    def helper(self, root):
        if root is None or not self.flag:
            return

        self.helper(root.left)

        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
            return
        
        self.prev = root

        self.helper(root.right)