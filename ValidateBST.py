# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Iterative Approach and inorder traversal. Push the nodes into stack and if visited pop it into the res array
# If not visited check the left and right child of that node and push it to stack
# Once all the nodes are processed, the output will be a sorted array for BST
# If it is not a sorted array then it is not a valid BST


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def inorder(root):
            stack = [(root, False)]
            res = []
            while stack:
                node, visited = stack.pop()
                if node:
                    if visited:
                        res.append((node.val))
                    else:
                        stack.append((node.right, False))
                        stack.append((node, True))
                        stack.append((node.left, False))
            return res

        output = inorder(root)
        for i in range(1, len(output)):
            if output[i - 1] >= output[i]:
                return False
        return True