#LC 105 - Construct Binary Tree from Preorder and Inorder Traversal
#Time Complexity - O(n)
#Space Complexity - O(n)
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
        
        self.d = {}
        self.index = 0
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        def helper(inorder,preorder,start,end):
            if self.index >= len(preorder) or start > end:
                return None
        
            root = TreeNode(preorder[self.index])
            self.index = self.index + 1
            inIdx = self.d[root.val]
            root.left = helper(inorder,preorder,start,inIdx-1)
            root.right = helper(inorder,preorder,inIdx+1,end)
            return root
        return helper(inorder,preorder,0,len(inorder)-1)