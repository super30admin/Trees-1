
#Time Compelxity O(N)
#Space Compelxity O(N)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        def check_tree(left, right):
            nonlocal preorder_index
            if left > right: return None
            root_value = preorder[preorder_index]
            root = TreeNode(root_value)
            preorder_index += 1

            root.left = check_tree(left, inorder_index_map[root_value] - 1)
            root.right = check_tree(inorder_index_map[root_value] + 1, right)

            return root

        preorder_index = 0
        inorder_index_map = {}
        for index, value in enumerate(inorder):
            inorder_index_map[value] = index

        return check_tree(0, len(preorder) - 1)
