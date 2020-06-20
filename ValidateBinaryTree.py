# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev=None
    
    def isValidBST(self, root: TreeNode) -> bool:
        return self.inorder(root)
    
    def inorder(self,root):
        if root==None:
            return True
        if self.inorder(root.left)== False:
            return False
        if self.prev!=None and self.prev.val>=root.val:
            return False
        self.prev=root
        return self.inorder(root.right)
        
        
 #Time complexity is O(n), as it runs for all the nodes of tree
 #space complexity is O(h), h is the height of the tree
