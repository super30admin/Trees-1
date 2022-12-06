# Time Complexity: O(N)
# Space Complexity: O(h) height of tree (recursive stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        isBST = self.checkBST(-sys.maxsize-1,root,sys.maxsize)
        return isBST

    def checkBST(self,mini,root,maxi):
        if root==None:
            return True
        if root.val<=mini or root.val>=maxi:
            return False
        left = self.checkBST(mini,root.left,root.val)
        right = self.checkBST(root.val,root.right,maxi)
        return (left and right)



#     def __init__(self):
#         self.isBST = True
#         self.prev = None

#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         if root==None:
#             return True
#         self.inorder(root)
#         return self.isBST

#     def inorder(self,root):
#         if root==None:
#             return
#         self.inorder(root.left)
#         if self.prev!=None and self.prev.val>=root.val:
#             self.isBST = False
#             return
#         self.prev = root
#         self.inorder(root.right)