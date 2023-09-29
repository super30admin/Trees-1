# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No



# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        return self.helper1(root)
    def helper1(self, root):
        #base
        if root == None:
            return True

        # Left tree
        res = self.helper1(root.left)
        if res == False:
            return False
        
        # root action
        if self.prev != None and root.val <= self.prev:
            return False
        self.prev = root.val

        #right tree
        return self.helper1(root.right)
    #     return self.helper(root, None, None)
    # def helper(self, root, min, max):
    #     if root == None:
    #         return True
    #     if (min != None and root.val <= min):
    #         return False
    #     if (max != None and root.val >= max):
    #         return False
    #     return self.helper(root.left, min, root.val) and self.helper(root.right, root.val, max)
