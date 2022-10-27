# Time complexity: O(n)
# Space complexity: O(n)
# Does this code run on Leetcode: Yes
# Did you face any difficulty in coding this solution: No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        res = []
        def recur(node):
            if not node:
                return 
            recur(node.left)
            res.append(node.val)
            recur(node.right)
        recur(root)
        for i in range(len(res)):
            if i != len(res)-1 and res[i+1] <=res[i]:
                return False
        return True