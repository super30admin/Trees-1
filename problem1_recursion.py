# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None
        self.result = True
        def inorder(root):
            if root == None:
                return
            
            inorder(root.left)
            
            if self.prev !=None and self.prev >= root.val:
                self.result = False
            
            self.prev = root.val
            print(root.val)
            inorder(root.right)
        
        
        inorder(root)
        return self.result
    
# Time complexity is O(n) where n is number of nodes
# Space complexity is O(h) where h is height of the tree
# recursion is used to compare the node value with previous value
            
        
        
