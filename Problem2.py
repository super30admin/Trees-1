# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # inorder_map = {v: i for i, v in enumerate(inorder)}
        # i = 0

        # def build(start, end):
        #     nonlocal i
        #     if start > end: return None

        #     root_val = preorder[i] 
        #     i += 1
        #     root_idx = inorder_map[root_val]
        #     left_tree = build(start, root_idx - 1)
        #     right_tree = build(root_idx + 1, end)

        #     root = TreeNode(root_val)
        #     root.left = left_tree
        #     root.right = right_tree

        #     return root
        
        # return build(0, len(inorder) - 1)

        inorder_map = {v: i for i, v in enumerate(inorder)}

        def build(start, end, i):
            if start > end: return None, i
            if i >= len(preorder): return None, i

            root_val = preorder[i] 
            root_idx = inorder_map[root_val]
            i += 1
            left_tree, i = build(start, root_idx - 1, i)
            right_tree, i = build(root_idx + 1, end, i)

            root = TreeNode(root_val)
            root.left = left_tree
            root.right = right_tree

            return root, i
        
        return build(0, len(inorder) - 1, 0)[0]
