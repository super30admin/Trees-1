#98. Validate Binary Search Tree
# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#set a prev value to None, prev should track the prev node of each node check if prev is not None and prev is less than current root value, else flag is set to false (conditional recursion)
# time - O(n)
#space - O(h)
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    #global vaariables
    def __init__(self):
        self.flag = True
        self.prev = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag
    #inorder
    def helper(self, root):
        if root is None:
            return
        #conditional recursion
        if not self.flag:
            return
        self.helper(root.left)
        #check prev is less than current value
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
        self.prev=root
        self.helper(root.right)
