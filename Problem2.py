"""105. Construct Binary Tree from Preorder and Inorder Traversal
Time Complexity - O(2(n^2))
Space Complexity - O(depth of tree * n)
As we know Pre-order stores elements as Root-Left- Right hence first element will always be root also here we are provided with inorder array hence i.e. Left - root - right therefore from preorder we get root and search root index in in order hence this provides us subarray for right and left of subtree."""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or preorder == None:
            return None
        root = TreeNode(preorder[0])
        for i in range (len(inorder)):
            if root.val == inorder[i]:
                index = i
                break
        preorder_left = preorder[1:index+1]
        preorder_right = preorder[index+1: ]
        
        inorder_left = inorder[0:index]
        inorder_right = inorder[index+1:]
        
        root.left = self.buildTree(preorder_left,inorder_left)
        root.right = self.buildTree(preorder_right,inorder_right)
        
        return root