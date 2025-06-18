# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# For all solutions
# Time Complexity:O(n) - n is the number of nodes
# Space Complexity:O(h) - h is the height of the tree.

# #Approach1: uses a global flag to carry the result
# class Solution:
#     def __init__(self):
#         self.prev = None  # To store the previously visited node in inorder traversal
#         self.flag = True  # Will be set to False if a BST violation is found
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         # Start the inorder traversal
#         self.inorder(root)
#         # After traversal, return the flag indicating whether the tree is a valid BST
#         return self.flag
#     def inorder(self, root: TreeNode):
#         # Base case: if node is None or flag already False, return early
#         if root is None or not self.flag:
#             return
#         # Traverse left subtree
#         self.inorder(root.left)
#         # Check BST property: current node's value must be greater than previous node's value
#         if self.prev is not None and self.prev.val >= root.val:
#             self.flag = False  # Violation found, mark as invalid
#         # Update previous node to current
#         self.prev = root
#         # Traverse right subtree
#         self.inorder(root.right)

#approach2: no flgs. Returns False immediately upon detecting the BST property violation. Only goes right if left is valid.
class Solution:
    def __init__(self):
        self.prev = None  # To store the previously visited node in inorder traversal    
    def isValidBST(self, root: TreeNode) -> bool:
        # Start the inorder traversal and return the result directly
        return self.inorder(root)
    def inorder(self, root: TreeNode) -> bool:
        # Base case: empty subtree is always valid
        if root is None:
            return True
        # Recursively validate left subtree
        if not self.inorder(root.left):
            return False  # If left subtree is invalid, no need to continue
        # Check BST property: node values must increase in inorder traversal
        if self.prev is not None and self.prev.val >= root.val:
            return False  # Violation of BST property
        # Print current node value for debugging (optional)
        print(root.val)
        # Update previous node to current
        self.prev = root
        # Recursively validate right subtree
        return self.inorder(root.right)

# #approach3:Iterative using stack
# # Iterative in-order traversal using a stack to visit nodes in sorted order.
# # At each step, compare the current node with the previous one to ensure increasing order.
# # If any node violates the rule, return false.
# class Solution:
#     def isValidBST(self, root):
#         stack = []
#         prev = None
#         while stack or root:
#             while root:
#                 stack.append(root)
#                 root = root.left
#             root = stack.pop()
#             if prev is not None and prev.val >= root.val:
#                 return False
#             prev = root
#             root = root.right
#         return True