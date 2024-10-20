# Approach 2: time O(n), space:O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Create a local hashmap to store the index of each value in inorder
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        self.idx = 0  # Use a class attribute to track the preorder index

        def helper(start, end):
            # Base case: no subtree to construct
            if start > end:
                return None
            
            # Root value is the current element in preorder at self.idx
            root_val = preorder[self.idx]
            root = TreeNode(root_val)
            
            # Increment the preorder index
            self.idx += 1

            # Find the root's index in inorder list using the local hashmap
            rootIdx = inorder_map[root_val]

            # Recursively build the left and right subtrees
            root.left = helper(start, rootIdx - 1)
            root.right = helper(rootIdx + 1, end)

            return root

        # Call the helper function with the initial boundaries
        return helper(0, len(inorder) - 1)
