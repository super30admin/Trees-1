# Approach:
# We use preorder to identify the root of each subtree and find the root's position in the inorder list to separate left and right subtrees.
# Recursively build the left and right subtrees by splitting preorder and inorder lists according to the identified root position.
# This approach allows us to construct the binary tree with correct structure using recursive division.

# Time Complexity: O(n), where n is the number of nodes, as we visit each node once.
# Space Complexity: O(n), due to the recursive stack and additional storage for the hash map of inorder indices.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Hash map to store the index of each value in inorder for quick lookup
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        
        # Recursive helper function to construct the tree
        def array_to_tree(pre_left, pre_right, in_left, in_right):
            # Base case: If there are no elements to construct the tree
            if pre_left > pre_right:
                return None
            
            # The first element in preorder is the root for this subtree
            root_val = preorder[pre_left]
            root = TreeNode(root_val)
            
            # Get the index of the root from inorder to divide the tree
            in_root_index = inorder_index_map[root_val]
            
            # Calculate the size of the left subtree
            left_tree_size = in_root_index - in_left
            
            # Recursively construct the left subtree
            root.left = array_to_tree(pre_left + 1, pre_left + left_tree_size, in_left, in_root_index - 1)
            
            # Recursively construct the right subtree
            root.right = array_to_tree(pre_left + left_tree_size + 1, pre_right, in_root_index + 1, in_right)
            
            return root
        
        # Build the tree using the helper function
        return array_to_tree(0, len(preorder) - 1, 0, len(inorder) - 1)
