# Time Complexity: O(n^2) 
# Space Complexity: O(n)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Base case: if there are no nodes to construct, return None
        if not inorder:
            return None

        # First element of preorder is always the root
        root = TreeNode(preorder[0])

        # Find the index of the root in inorder to split left/right subtrees
        idx = inorder.index(root.val)

        # Recursively build left and right subtrees:
        # Left subtree uses next 'idx' preorder elements and left part of inorder
        root.left = self.buildTree(preorder[1:1+idx], inorder[:idx])

        # Right subtree uses the remaining preorder elements and right part of inorder
        root.right = self.buildTree(preorder[1+idx:], inorder[idx+1:])

        # Return the constructed root
        return root
