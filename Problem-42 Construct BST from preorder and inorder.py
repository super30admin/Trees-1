# 105. Construct Binary Tree from Preorder and Inorder Traversal
# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Logic: 1st element in the preorder will give us the root of the table. 
# We then check the same element in the inorder list and elements before 
# this index will be left subtree and elements after it is right subtree.

# Time complexiety: O(n)
# Space complexiety: O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.p = 0
        
    def _helper(self,preorder, start,end,inorder_map):
        if start > end or self.p == len(preorder):
            return
        
        inorderIndex = inorder_map[preorder[self.p]]
        root = TreeNode(preorder[self.p])
        self.p += 1
        
        root.left = self._helper(preorder,start, inorderIndex - 1,inorder_map)
        root.right = self._helper(preorder,inorderIndex + 1, end,inorder_map)
        
        return root
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = dict()
        
        for idx, i in enumerate(inorder):
            inorder_map[i] = idx
        
        return self._helper(preorder,0,len(preorder)-1,inorder_map)