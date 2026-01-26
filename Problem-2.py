#105. Construct Binary Tree from Preorder and Inorder Traversal
# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

# Your code here along with comments explaining your approach
#from preorder identify the root element
# fint the root element index in the inorder array
# Inorder array, everything on left of root is left subtree of root and everything on right is right subtree of root
#make recusive calls to implement the above logic
#time - O(n)
#space - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.idx=0#index of preorder list
        d=dict()#map for maintaining index of values in inorder
        for i in range(0,len(inorder)):
            d[inorder[i]] = i
        return self.helper(preorder, d, 0, len(inorder)-1)
    def helper(self, preorder, d, start, end):
        if(start>end):
            return None

        curr=preorder[self.idx]
        root = TreeNode(curr)
        self.idx+=1
        root.left = self.helper(preorder, d, start, d[curr]-1)#leftsubtree of current node
        root.right = self.helper(preorder, d, d[curr]+1, end)#right subtree of current node
        return root
        