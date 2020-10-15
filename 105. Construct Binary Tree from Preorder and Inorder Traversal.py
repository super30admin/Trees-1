"""
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """This class constructs Binary tree from inorder and preorder traversal"""
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        """The first element in preorder is a root.
        The root splits the inorder list into left subtree and right subtree.
         and repeat the procedure for left and right subtree
        """
        # Run Time Complexity: O(N)
        # Space Complexity: O(N)
        def helper(left = 0, right = len(inorder)):
            nonlocal  pre_idx           
            if left == right:
                return 
            
#             root is created
            root_val = preorder[pre_idx]
            root = TreeNode(root_val)
            idx = idx_map[root_val]
            pre_idx += 1
#             creating left and right subtree by recurssion
            root.left = helper(left, idx)
            root.right = helper(idx+1, right)
            return root
        pre_idx = 0
        idx_map = {val:idx for idx, val in enumerate(inorder)}
        return helper()
            
            