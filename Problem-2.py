"""
Approach 1: use the inorder and preorder concepts and build the tree. For preorder the first element is always the root
node. Inorder suggests the elements of left subtree and right subtree to the left anf right of the root node element in
the array.

TC: O(n^2)
SC: O(n^2)
"""

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        root_index = -1

        for i, node in enumerate(inorder):
            if node == root.val:
                root_index = i

        # print(root_index)
        left_inorder = inorder[:root_index]
        right_inorder = inorder[(root_index + 1):]
        left_preorder = preorder[1:len(left_inorder) + 1]
        right_preorder = preorder[root_index + 1:]

        root.left = self.buildTree(left_preorder, left_inorder)
        root.right = self.buildTree(right_preorder, right_inorder)

        return root
"""
Approach 2: use hashmap to reduce the time to find the root node in inorder list everytime. This also elimiantes the 
process of copying the data everytime for each node

TC: O(n)
SC: O(n)
"""

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None

        hash_map = {}
        for i, node_val in enumerate(inorder):
            hash_map[node_val] = i

        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, hash_map)

    def helper(self, preorder, pre_start, pre_end, inorder, in_start, in_end, hash_map):
        if pre_start > pre_end or in_start > in_end:
            return None

        root_val = preorder[pre_start]
        root = TreeNode(root_val)

        root.left = self.helper(preorder, pre_start + 1, pre_start + hash_map[root_val] - in_start, inorder, in_start,
                                hash_map[root_val] - 1, hash_map)
        root.right = self.helper(preorder, pre_start + hash_map[root_val] - in_start + 1, pre_end, inorder,
                                 hash_map[root_val] + 1, in_end, hash_map)

        return root
