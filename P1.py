
# ## Problem 1
# TC : O(n)
# SC : O(1)
# https://leetcode.com/problems/validate-binary-search-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(root, low = -math.inf, high = math.inf):
            if not root:
                return True
            print(root.val, low, high)
            if root.val <= low or root.val >= high:
                return False
            return (validate(root.right, root.val, high) and validate(root.left, low, root.val))
        return validate(root)
            # if root.left!=None and root.right!=None:
            #     if root.left.val >= root.val or root.right.val <= root.val:
            #         return False
            #     self.isValidBST(root.left)
            #     self.isValidBST(root.right)
            # elif root.left==None and root.right==None:
            #     return True
            # elif root.left==None and root.right!=None:
            #     if root.right.val <= root.val:
            #         return False
            # else:
            #     if root.left.val >= root.val:
            #         return False
            # return True
        