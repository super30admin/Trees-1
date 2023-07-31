# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        Time complexity - O(n)
        Space complexity - (n), n --> number of nodes in the binary tree.
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # Helper function to recursively build the binary tree
        def helper(pre_start, pre_end, in_start, in_end):
            # Base case: If the start index is greater than the end index, there are no elements to construct the tree.
            if pre_start > pre_end or in_start > in_end:
                return None

            # The first element in the preorder list is the root node value.
            root_val = preorder[pre_start]
            root = TreeNode(root_val)

            # Find the index of the root node in the inorder list using the hashmap.
            root_idx_inorder = inorder_map[root_val]
            # Calculate the size of the left subtree (number of elements on the left side of the root in inorder list).
            left_size = root_idx_inorder - in_start

            # Recursively build the left and right subtrees.
            # For the left subtree, the preorder range is [pre_start + 1, pre_start + left_size].
            # For the inorder range, the indices are [in_start, root_idx_inorder - 1].
            root.left = helper(pre_start + 1, pre_start +
                               left_size, in_start, root_idx_inorder - 1)

            # For the right subtree, the preorder range is [pre_start + left_size + 1, pre_end].
            # For the inorder range, the indices are [root_idx_inorder + 1, in_end].
            root.right = helper(pre_start + left_size + 1,
                                pre_end, root_idx_inorder + 1, in_end)

            return root

        # Create a hashmap to store the indices of elements in the inorder array.
        inorder_map = {val: idx for idx, val in enumerate(inorder)}

        # Call the helper function to build the binary tree using the entire range of preorder and inorder lists.
        return helper(0, len(preorder) - 1, 0, len(inorder) - 1)
