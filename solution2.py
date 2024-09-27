# // Time Complexity : o(n*n) ; total of n nodes, each node calculates o(n)
# // Space Complexity : o(n*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : space and time complexity was confusing here
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0 or len(inorder)==0:
            return None
        root=TreeNode(preorder[0])
        i=inorder.index(root.val)
        root.left = self.buildTree(preorder[1:i+1],inorder[:i])
        root.right = self.buildTree(preorder[i+1:],inorder[i+1:])
        return root