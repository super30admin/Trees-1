"""

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Time Complexity: O(N^2) in the worst case due to the `index()` lookup in `inorder`, but can be optimized to O(N) using a hashmap for indexing.
Space Complexity: O(N) due to the recursive call stack in the worst case (skewed tree) and the storage of sliced lists.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach follows a recursive strategy where the first element in the preorder list is the root, and its position in the inorder list determines the left and right subtrees.  
# The left subtree is constructed from elements before the root in inorder and the corresponding elements in preorder, while the right subtree follows similarly.  
# This process is repeated recursively until the entire tree is built.  


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if not preorder or not inorder:
            return None

        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])
        
        return root
