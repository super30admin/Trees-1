# Time complexity : O(N) since we visit each node exactly once.
# Space complexity : O(N) since we keep up to the entire tree.
# Yes, It ran on leetcode
# Did this problem earlier also, so didn't faced any problems.

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root):
        if not root:
            return True
        return self.isValidNode(root,float('-inf'), float('inf'))
    
    def isValidNode(self, root, l, r):
        if not root:
            return True
        return l<root.val<r and self.isValidNode(root.left, l, root.val) and self.isValidNode(root.right, root.val, r)