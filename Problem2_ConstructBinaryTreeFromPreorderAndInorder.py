# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(n) for the hashmap and recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use hashmap to store inorder indices for O(1) lookup, then recursively build tree.
# First element in preorder is root, find its position in inorder to split into left and right subtrees.
# Recursively construct left subtree from left portion and right subtree from right portion of inorder.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Create hashmap for O(1) lookup of inorder indices
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        pre_idx = 0  # Pointer for preorder array
        
        def build(in_start, in_end):
            nonlocal pre_idx
            
            # Base case: no more nodes to process
            if in_start > in_end:
                return None
            
            # Get root value from preorder
            root_val = preorder[pre_idx]
            pre_idx += 1
            
            # Create root node
            root = TreeNode(root_val)
            
            # Find root position in inorder
            root_pos = inorder_map[root_val]
            
            # Recursively build left and right subtrees
            # Left subtree: inorder[in_start : root_pos]
            # Right subtree: inorder[root_pos + 1 : in_end + 1]
            root.left = build(in_start, root_pos - 1)
            root.right = build(root_pos + 1, in_end)
            
            return root
        
        return build(0, len(inorder) - 1)
