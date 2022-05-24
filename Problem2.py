#Time Complexity - O(N)
#Space Complexity - O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.helper(preorder,inorder)
        
        
    def helper(self,preorder,inorder):
        #base
        if not preorder or not inorder:
            return None
        
        #logic
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.helper(preorder[1:mid+1],inorder[:mid])
        root.right = self.helper(preorder[mid+1:],inorder[mid+1:])
        
        return root 