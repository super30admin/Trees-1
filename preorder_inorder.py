# Approach:
# Use preorder to get the current root node.
# Use a hashmap to find the root's index in inorder in O(1) time.
# Recur to build left and right subtrees using sliced boundaries in inorder.

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashMap = {value: index for index, value in enumerate(inorder)}
        p = 0  # Pointer for preorder traversal

        def helper(left, right):
            nonlocal p
            if left > right:
                return None  # No nodes in this range

            value = preorder[p]
            node = TreeNode(value)
            p += 1

            index = hashMap[value]  # Index in inorder

            node.left = helper(left, index - 1)
            node.right = helper(index + 1, right)

            return node

        return helper(0, len(inorder) - 1)

# Time Complexity: O(n)
# Space Complexity: O(n)
