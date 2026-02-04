''' 
Time Complexity : O(2) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        rootVal = preorder[0]
        rootIdx = -1
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
                break
        
        root = TreeNode(rootVal)
        inleft = inorder[:rootIdx]
        inRight = inorder[rootIdx+1:]

        preleft = preorder[1:len(inleft)+1]
        preRight = preorder[len(inleft)+1:]

        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preRight, inRight)

        return root

        