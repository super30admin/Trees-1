# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not preorder or not inorder:
            return None
        rootValue = preorder[0]
        root = TreeNode(rootValue)
        inorder_index = inorder.index(rootValue)
        root.left = self.buildTree(preorder[1:inorder_index+1], inorder[:inorder_index])
        root.right = self.buildTree(preorder[inorder_index+1:], inorder[inorder_index+1:])
        
        return root