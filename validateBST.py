# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root) -> bool:
        if root == None:
            return True
        
        def recursion(root):
            if root == None:
                return True
            case1 = recursion(root.left)
            if self.prev != None  and self.prev.val >= root.val:
                return False
            self.prev = root
            case2 = recursion(root.right)
            return case1 and case2

        self.prev = None
        return recursion(root)
    
# TC: O(n)
# SC: O(h)