#Time Complexity: O(n^2)
# Space Complexity: O(H) 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder and inorder:
            return None
        
        root = TreeNode(val = preorder[0])                                  # taking root for preorder
        mid = inorder.index(preorder[0])                                    # Taking root from inorder                    
        
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])        # Left subtree
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])      # Right subtree
        
        return root
        