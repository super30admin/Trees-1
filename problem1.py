# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        maxvalue=float("inf")
        minvalue=float("-inf")
        def validBST(maxvalue,minvalue,root):
            if root:
                if not (minvalue<root.val<maxvalue):
                    return False
                left=validBST(root.val,minvalue,root.left)
                right=validBST(maxvalue,root.val,root.right)
                return left and right
            return True
        return validBST(maxvalue,minvalue,root)
        #Time O(logn)
        #Space O(n)
        #https://leetcode.com/problems/validate-binary-search-tree/
