# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {val: idx for idx, val in enumerate(inorder)}
        pre_idx = 0

        def array_to_tree(left: int, right: int) -> Optional[TreeNode]:
            nonlocal pre_idx
            
            if left > right:
                return None
            root_val = preorder[pre_idx]
            root = TreeNode(root_val)
            pre_idx += 1

            mid = inorder_map[root_val]
            root.left = array_to_tree(left, mid - 1)
            root.right = array_to_tree(mid + 1, right)
            
            return root
        return array_to_tree(0, len(inorder) - 1)
