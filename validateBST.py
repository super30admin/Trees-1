'''
Time complexity: O(N) since every node has to be visited
Space complexity: O(H) where H is the height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValid = True 
    prev = None 
    stackk = []
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        while root is not None or self.stackk:
            while root is not None:
                self.stackk.append(root)
                root = root.left
            root = self.stackk.pop()
            if self.prev is not None and self.prev.val >= root.val:
                return False
            self.prev = root
            root = root.right
        return self.isValid





        

        