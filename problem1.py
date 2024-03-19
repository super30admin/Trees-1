# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


## Time complexity is O(N) and space complexity is O(N)
class Solution(object):
    def isValidBST(self, root):
        return self.dfs(root, float('inf'), float('-inf'))
        
    
    
    def dfs(self, root, right, left):
        if not root:
            return True
        
        if not(root.val> left and root.val<right):
            return False
        
        return self.dfs(root.left, root.val, left) and self.dfs(root.right, right, root.val)
    