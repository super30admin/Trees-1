# T: O(n) S: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, None, None)

    def helper(self, root, mini, maxi):
        if (root == None):
            return True
        if (mini != None and mini >= root.val):
            return False
        if (maxi != None and maxi <= root.val):
            return False
        return ((self.helper(root.left, mini, root.val) and (self.helper(root.right, root.val, maxi))))


