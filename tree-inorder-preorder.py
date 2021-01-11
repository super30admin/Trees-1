# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # inorder L root Right
        # postorder L right Root
        # preorder Root Left Right
        
        # Need to see solution to understand
        
        # root will be first of preorder
        if(len(preorder)==0 or len(inorder)==0):
            return
        root_val = preorder.pop(0)
        # first element will always be root in preorder
        root = TreeNode(root_val)
        
        
        ind = inorder.index(root_val)
        
        root.left = self.buildTree(preorder, inorder[:ind])
        root.right = self.buildTree(preorder, inorder[ind+1:])
        
        return root
