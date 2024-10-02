#Time Complexity O(n)
#Space Complexity O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        
        # Create a dictionary to store indices of inorder traversal for quick lookup
        self.inorder_index = {}
        for index, value in enumerate(inorder):
            self.inorder_index[value] = index
        
        # Call recursive helper function to build the tree
        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)
    
    def helper(self, preorder, pre_start, pre_end, inorder, in_start, in_end):
        if pre_start > pre_end or in_start > in_end:
            return None
        
        # Root value is the first element in the preorder traversal
        root_val = preorder[pre_start]
        root = TreeNode(root_val)
        
        # Find index of root value in inorder traversal
        in_index = self.inorder_index[root_val]
        
        # Calculate number of nodes in the left subtree
        left_subtree_size = in_index - in_start
        
        # Recursive calls to build left and right subtrees
        root.left = self.helper(preorder, pre_start + 1, pre_start + left_subtree_size, inorder, in_start, in_index - 1)
        root.right = self.helper(preorder, pre_start + left_subtree_size + 1, pre_end, inorder, in_index + 1, in_end)
        
        return root
