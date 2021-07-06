# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recurse(self, left, right):
        
        if left > right:
            return None
        
        root_val = self.preorder[self.preorder_index]
        self.preorder_index += 1
        
        node = TreeNode(root_val)
        
        head_index = self.inorder_map[root_val]
        node.left = self.recurse(left, head_index - 1)
        node.right = self.recurse(head_index + 1, right)
        
        return node
        
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        self.preorder_index = 0
        self.inorder_map = {}
        self.preorder = preorder
        self.inorder = inorder
        
        for i in range(len(inorder)):
            
            self.inorder_map[inorder[i]] = i
        
        return self.recurse(0, len(preorder) - 1)
        