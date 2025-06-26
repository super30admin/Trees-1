# Time Complexity :
- O(n), where n is the number of nodes in the tree (each node is visited once)

# Space Complexity :
- O(n), for the hashmap and recursion stack in the worst case (skewed tree)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index_map = {val: idx for idx, val in enumerate(inorder)}
        preorder_index = 0

        def build(left, right):
            nonlocal preorder_index
            if left > right:
                return None

            root_val = preorder[preorder_index]
            root = TreeNode(root_val)
            preorder_index += 1

            index = inorder_index_map[root_val]

            root.left = build(left, index - 1)
            root.right = build(index + 1, right)

            return root

        return build(0, len(inorder) - 1)
