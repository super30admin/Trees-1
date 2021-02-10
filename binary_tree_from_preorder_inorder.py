'''
Time complexity: O(2n*n)
Space complexity: O(max_depth)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        
        root = TreeNode(preorder[0]) # root will always be first element of preorder
        index = -1
        
        # find index of root in inorder
        for x in range(0, len(inorder)):
            if inorder[x] == root.val:
                index = x
                break
        
        preLeft = preorder[1: index + 1] #preoder(1, index+1) => 1 inlcusive, index + 1 exclusive
        preRight = preorder[index + 1: len(preorder)]
        inLeft = inorder[0: index + 1]
        inRight = inorder[index + 1: len(inorder)]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root
        