#TimeComplexity:O(N*N)since for each element we are traversing all the elements 
#SpaceComplexity: O(N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        rootVal=preorder[0]
        root=TreeNode(rootVal)
        
        leftInorder=inorder[0:inorder.index(rootVal)]
        rightInorder=inorder[inorder.index(rootVal)+1:]
        leftPreorder=preorder[1:1+inorder.index(rootVal)]
        rightPreorder=preorder[1+inorder.index(rootVal):]
        
        root.left=self.buildTree(leftPreorder,leftInorder)
        root.right=self.buildTree(rightPreorder,rightInorder)
        
        return root
            
        