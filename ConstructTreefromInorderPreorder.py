#https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
#time :O(n)
#space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return 

        root = TreeNode(preorder[0])
        #we know that root will be at middle in inorder 
        mid = inorder.index(preorder[0])

        #constructing left tree 
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])

        #constructing right sub tree
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])

        return root

