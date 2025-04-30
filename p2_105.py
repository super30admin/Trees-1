# 105. Construct Binary Tree from Preorder and Inorder Traversal

# TC: O(n) where n is the number of nodes in the tree
# SC: O(n) for the recursion stack and the output tree
# Did this code successfully run on Leetcode: Yes

# Approach : Base Case: If the inorder traversal is empty, return None (no tree to build).
# Root Identification: The first element of the preorder traversal is always the root of the current tree/subtree.
# Split Inorder Traversal: Find the position of the root value in the inorder traversal. This splits the inorder traversal into left subtree elements (before the root) and right subtree elements (after the root).
# Split Preorder Traversal: Based on the number of elements in the left subtree (determined from the inorder traversal), split the preorder traversal into left and right subtree portions.
# Recursive Construction: Recursively apply the same process to build the left and right subtrees.
# Return: Connect the subtrees to the root and return the root node.
# The time complexity is O(n) because we visit each node once, and the space complexity is O(n) for the recursion stack in the worst case of a skewed tree, plus the space for the output tree.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:  ## Approach 1
    def buildTree(self, preorder, inorder):
        # Edge case
        if not inorder:
            return None
        
        # The first element in preorder is the root of the tree
        root_val = preorder[0]
        
        # Find the index of the root in inorder traversal
        root_idx = -1
        for i in range(len(inorder)):
            if inorder[i] == root_val:
                root_idx = i
                break
        
        # Create the root node
        root = TreeNode(root_val)
        
        # Elements before root_idx in inorder form the left subtree
        left_inorder = inorder[:root_idx]
        
        # Elements after root_idx in inorder form the right subtree
        right_inorder = inorder[root_idx+1:]
        
        # Elements in preorder corresponding to left subtree (after the root)
        left_preorder = preorder[1:1+len(left_inorder)]
        
        # Elements in preorder corresponding to right subtree (after left subtree)
        right_preorder = preorder[1+len(left_inorder):]
        
        # Recursively build left and right subtrees
        root.left = self.buildTree(left_preorder, left_inorder)
        root.right = self.buildTree(right_preorder, right_inorder)
        
        return root
        
# ========================================================================================================================================================================================================================

# TC: O(n) where n is the number of nodes in the tree
# SC: O(n) for the hashmap, recursion stack, and output tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

# Approach : Preprocessing: Create a hashmap that maps each value in the inorder traversal to its index. This allows O(1) lookup of a value's position instead of linear search.
# Global Index: Keep track of the current index in the preorder array as a class variable (self.idx).
# Recursive Helper Function: The helper function takes a range in the inorder array (start to end) that represents the current subtree.
# Root Identification: The current element in preorder (at self.idx) is the root of the current subtree.
# Partition: Using the hashmap, quickly find the position of the root value in the inorder traversal, which divides elements into left and right subtrees.
# Recursive Construction: Build the left subtree with elements before the root in inorder, and the right subtree with elements after the root.
# Return: Connect subtrees to the root and return the root node.
# The time complexity is O(n) because we process each node exactly once. The space complexity is O(n) for the hashmap, recursion stack, and the tree we're building.


class Solution:  ## Approach 2
    def buildTree(self, preorder, inorder):
        # Create a hashmap to store value -> index mapping for inorder array
        # This allows O(1) lookup of a value's position in inorder traversal
        inorder_map = {}
        for i, val in enumerate(inorder):
            inorder_map[val] = i
        
        # Initialize preorder index tracker
        self.idx = 0
        
        # Helper function to recursively build the tree
        def helper(start, end):
            # Base case: invalid range
            if start > end:
                return None
            
            # Get the root value from preorder traversal at current index
            root_val = preorder[self.idx]
            self.idx += 1
            
            # Create the current node
            root = TreeNode(root_val)
            
            # Find position of current root in inorder traversal
            root_idx = inorder_map[root_val]
            
            # Recursively build left subtree (elements before root in inorder)
            root.left = helper(start, root_idx - 1)
            
            # Recursively build right subtree (elements after root in inorder)
            root.right = helper(root_idx + 1, end)
            
            return root
        
        # Start the recursive tree building process
        return helper(0, len(inorder) - 1)