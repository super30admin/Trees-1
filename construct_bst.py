# The code defines a buildTree method to construct a binary tree from preorder and inorder traversal lists.
# The approach uses recursive depth-first search (dfs) to build the tree by maintaining the correct order of nodes based on traversal properties.

# Initial Setup:
#   - 'preIdx' is the index for the current root node in the preorder traversal.
#   - 'inIdx' is the index for the current node in the inorder traversal.
#   - The helper function 'dfs' takes a 'limit' value that helps in managing the position of nodes within the tree structure.

# Recursive Depth-First Search (dfs):
#   - If 'preIdx' exceeds the length of preorder, return None as there are no more nodes to add.
#   - If the current inorder node matches 'limit', increment 'inIdx' and return None, signaling that we've completed constructing a subtree up to that limit.
#   
#   - Create a new 'TreeNode' with the value at preorder[preIdx], representing the root of the current subtree.
#       - Increment 'preIdx' to move to the next root for upcoming recursive calls.
#       - Recursively call 'dfs' to build the left subtree, using the current root value as the new limit.
#       - Recursively call 'dfs' to build the right subtree, maintaining the existing limit.
#   - Return 'root' once both left and right subtrees are constructed for this node.

# Main Execution:
#   - The buildTree method initiates the tree construction by calling dfs with an infinite limit, allowing all values initially.
#   - It returns the root of the fully constructed tree.

# TC: O(n) - Each node is processed once, making the time complexity linear with the number of nodes.
# SC: O(n) - The space complexity is linear, primarily due to the recursion stack, which could go up to n levels deep in the worst case.

from typing import List, Optional


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        preIdx = inIdx = 0
        def dfs(limit):
            nonlocal preIdx, inIdx
            if preIdx >= len(preorder):
                return None
            if inorder[inIdx] == limit:
                inIdx += 1
                return None
            
            root = TreeNode(preorder[preIdx])
            preIdx += 1
            root.left = dfs(root.val)
            root.right = dfs(limit)
            return root
        return dfs(float('inf'))