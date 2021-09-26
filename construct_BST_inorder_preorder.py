# // Time Complexity : O(n) where n stand for length of the list
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: return None
        
        node = preorder[0]
        idx = -1
        for i in range(len(inorder)):
            if inorder[i] == node:
                idx = i
        preorder_left = preorder[1:idx+1]
        preorder_right = preorder[idx+1:]
        inorder_left = inorder[:idx]
        inorder_right = inorder[idx+1:]
        
        root = TreeNode(node)
        
        root.left = self.buildTree(preorder_left,inorder_left)
        root.right = self.buildTree(preorder_right,inorder_right)
        
        return root
        