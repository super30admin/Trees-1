# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# #Brute Force
# #Takes the root from the first element of preorder, then finds its index in inorder by linear search.Slices preorder and inorder arrays to recursively build left and right subtrees.
# #Time Complexity = O(n^2), nefficient due to repeated slicing and O(n) search
# #Space Complexity = O(n^2)
# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         # Base case: if preorder is empty, return None
#         if len(preorder) == 0:
#             return None
#         # The first element in preorder is always the root
#         root = TreeNode(preorder[0])
#         rootidx = -1
#         # Find the root's index in inorder (linear search)
#         for index, val in enumerate(inorder):
#             if val == root.val:
#                 rootidx = index
#         # Split inorder and preorder arrays into left and right subtrees
#         inleft = inorder[:rootidx]
#         preleft = preorder[1:rootidx + 1]
#         inright = inorder[rootidx + 1:]
#         preright = preorder[rootidx + 1:]
#         # Recursively build left and right subtrees
#         root.left = self.buildTree(preleft, inleft)
#         root.right = self.buildTree(preright, inright)
#         return root

# Hashmap
# Use preorder to get the root and a map to find its position in the inorder array. Everything before that index in inorder goes to the left subtree, rest to the right. Recurse left first (because preorder is root-left-right), then build the right subtree.
#Time Complexity = O(n)
#Space Complexity = O(n)

class Solution:
    def buildTree(self, preorder, inorder):
        # Initialize a global index to track the current node in preorder traversal
        self.idx = 0

        # Create a hashmap to store the index of each value in inorder traversal for O(1) access
        inorder_map = {val: i for i, val in enumerate(inorder)}

        # Begin recursive tree construction
        return self.helper(preorder, 0, len(inorder) - 1, inorder_map)

    def helper(self, preorder, start, end, inorder_map):
        # Base case: if start exceeds end, there's no subtree to build
        if start > end:
            return None

        # The current root value is at the current index in preorder
        root_val = preorder[self.idx]
        self.idx += 1  # Move to the next root value for future recursive calls

        # Create the root node
        root = TreeNode(root_val)

        # Get the index of root value in inorder traversal
        root_idx = inorder_map[root_val]

        # Recursively build the left subtree with the left segment of inorder
        root.left = self.helper(preorder, start, root_idx - 1, inorder_map)

        # Recursively build the right subtree with the right segment of inorder
        root.right = self.helper(preorder, root_idx + 1, end, inorder_map)

        # Return the constructed subtree rooted at `root`
        return root

