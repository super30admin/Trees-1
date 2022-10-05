"""
105. Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 is the inorder traversal of the same tree, construct and return the binary tree.

TC - O(n)
SC - O(n)
"""
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # index element of 1st element of preorder
        preorder_index = 0

        # create a hashmap to store inorder values
        inorder_index_map = {}

        for idx, val in enumerate(inorder):
            inorder_index_map[val] = idx

        def array_to_tree(left, right):
            nonlocal preorder_index

            if left > right:
                return None

            # root value
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)

            preorder_index += 1

            # create subtrees
            root.left = array_to_tree(left, inorder_index_map[root_value] - 1)
            root.right = array_to_tree(inorder_index_map[root_value] + 1, right)

            return root

        return array_to_tree(0, len(preorder) - 1)