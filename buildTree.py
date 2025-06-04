# // Time Complexity :O(N)
# // Space Complexity :O(H)
# // Did this code successfully run on Leetcode :no
# // Any problem you faced while coding this :yes
# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


# // Your code here along with comments explaining your approach
# for sure we know root is first element in preorder, all elements left of root in inirder are aprt of left subtree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #root node pre[0]
        if not preorder or not inorder:
            return None
        root=TreeNode(preorder[0])
        mid=inorder.index(preorder[0])
        root.left =self.buildTree(preorder[1:mid+1],inorder[:mid])
        root.right=self.buildTree(preorder[mid+1:],inorder[mid+1:])
        return root

        
