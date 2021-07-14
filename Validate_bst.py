# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time:O(n)
#Space:O(n)
class Solution:
    def __init__(self):
        self.old = float("-inf")
    def isValidBST(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        
        ans_left = self.isValidBST(root.left)
        print(root.val)
        if root.val<=self.old:
            print("False")
            return False
        self.old = root.val
        ans_right = self.isValidBST(root.right)
        return ans_left and ans_right