# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.inorder_dict = {}
        self.preorder = None
        self.inorder = None
        self.pre_len = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.pre_len = len(preorder) - 1
        if preorder is None:
            return None
        for i, val in enumerate(inorder):
            self.inorder_dict[val] = i
        self.preorder = preorder
        self.inorder = inorder
        return self.tree_builder(0, self.pre_len, 0, self.pre_len)

    def tree_builder(self, pre_start: int, pre_end: int, in_start: int, in_end: int) -> Optional[TreeNode]:
        if pre_start > pre_end or in_start > in_end:
            return None
        root_val = self.preorder[pre_start]
        _index = self.inorder_dict[root_val]
        root = TreeNode(root_val)
        len_left = _index - in_start
        root.left = self.tree_builder(pre_start + 1, pre_start + len_left, in_start, _index - 1)
        root.right = self.tree_builder(pre_start + len_left + 1, pre_end, _index + 1, in_end)
        return root
