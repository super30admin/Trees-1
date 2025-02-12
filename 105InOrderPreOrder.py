
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {val: idx for idx, val in enumerate(inorder)}  # O(N) hashmap for quick lookup
        preorder_index = 0  # Keeps track of root index in preorder list

        def helper(left, right):
            nonlocal preorder_index
            if left > right:
                return None  # Base case: no elements in this subtree
            
            root_val = preorder[preorder_index]  # Pick current root
            preorder_index += 1  # Move to the next root
            root = TreeNode(root_val)

            # Find root index in inorder array
            root_index = inorder_map[root_val]

            # Build left subtree first, then right subtree
            root.left = helper(left, root_index - 1)
            root.right = helper(root_index + 1, right)

            return root

        return helper(0, len(inorder) - 1)
