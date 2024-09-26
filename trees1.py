# problem 1 : 98. Validate Binary Search Tree : https://leetcode.com/problems/validate-binary-search-tree/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
            
        stack = [(root, float('-inf'), float('inf')), ] 
        while stack:
            root, lower, upper = stack.pop()
            if not root:
                continue
            val = root.val
            if val <= lower or val >= upper:
                return False
            stack.append((root.right, val, upper))
            stack.append((root.left, lower, val))
        return True  


# problem 2 : 105. Construct Binary Tree from Preorder and Inorder Traversal : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.idx = 0
        self.in_index = {}
        for i in range(len(inorder)):
            self.in_index[inorder[i]] = i
        
        return self.helper(preorder, inorder, 0, len(inorder)-1)
        
    def helper(self, preorder, inorder, start, end):
        if start > end:
            return None
        ## logic
        index = self.in_index[preorder[self.idx]]
        root = TreeNode(preorder[self.idx])
        self.idx += 1
        root.left = self.helper(preorder, inorder, start, index-1)
        root.right = self.helper(preorder, inorder, index+1, end)
        return root