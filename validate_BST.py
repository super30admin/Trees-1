# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev=TreeNode(None)
    def isValidBST(self, root: TreeNode) -> bool:
        #defining inorder function
        def inorder(self,node:TreeNode) -> bool:
            if node==None:
                return True
            #left side tree is not BST
            if inorder(self,node.left)==False:
                return False
            #inorder traversal should be ascendind for BST
            if self.prev.val!=None and self.prev.val>=node.val:
                return False
            self.prev=node
            #recursive call for right node
            return inorder(self,node.right)
        #making prev global variable         
        global prev
        if root==None:
            return True
        return inorder(self,root)
        return True
    
#Time-Complexity: O(N)
#Space-Complexity: O(N)
        
                   
        
    
        