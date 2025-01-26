# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.previous = None
    
    def inorder_isValidBST(self,root):
        # Base Case
        if root == None:
            return True
        
        # Leaf Node Case
        elif root.left == None and root.right == None:
            if self.previous != None and self.previous.val >= root.val:
                # Invalid Case
                return False
            else:
                self.previous = root
                return
        
        # Inorder BST Traversal on LHS
        lftTrav = self.inorder_isValidBST(root.left)
        
        if lftTrav == False:
            return lftTrav
        
        if self.previous != None and self.previous.val >= root.val:
            # Invalid Case
            return False
        
        self.previous = root
        
        # Inorder BST Traversal on RHS
        rtTrav = self.inorder_isValidBST(root.right)
        
        if rtTrav == False:
            return rtTrav
        
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        if self.inorder_isValidBST(root) != False:
            return True
        else:
            return False
        