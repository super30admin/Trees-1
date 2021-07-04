"""
Given preorder and inorder traversal of a tree, construct the binary tree.

Time = O(n), n = number of nodes in a tree
Space = O(n), n = number of nodes in a tree
Successfully excecuted on leetcode

Approach ---
1. Iterative solution with stack
2. Create a stack to store root, preorder and inorder for each sub tree step
3. Extract index of root from inorder list; append left side of index for left subtree and right side of the index to retrieve right subtree
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class ConstructBST:
    def buildTree(self, preorder: List[int], inorder: List[int]):
        
        if not preorder or len(preorder) == 0:
            return None
        
        root = TreeNode(preorder[0])
        stack = [(root, preorder, inorder)]
        while stack:
            head = stack.pop()
            node, preorder, inorder = head[0], head[1], head[2]
            if len(preorder) == 0:
                continue
                
            root_idx = inorder.index(preorder[0])
            
            if root_idx > 0: # left subtree
                node.left = TreeNode(preorder[1])
                stack.append((node.left, preorder[1:root_idx+1], inorder[:root_idx]))
                
            if root_idx < len(inorder) - 1: # Right subtree
                node.right = TreeNode(preorder[root_idx+1])
                stack.append((node.right, preorder[root_idx+1:], inorder[root_idx+1:])