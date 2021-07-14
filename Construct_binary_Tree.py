# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Spacee_Complexity:O(N)
#Time:O(N)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        
        val = preorder.pop(0)
        
        index_root = inorder.index(val)
        
        root = TreeNode(val)
        
        root.left = self.buildTree(preorder, inorder[:index_root])
        root.right = self.buildTree(preorder, inorder[index_root+1:])
        return root