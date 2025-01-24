# Time Complexity = O(n^2)
# Space Complexity = O(h)
# Approach = pick the root from preorder[0] and finds its index in inorder to split left and right subtrees.
#  then we recursively build the left subtree using elements before the root index and the right subtree using elements after it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder and not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:]) 
        return root 

        