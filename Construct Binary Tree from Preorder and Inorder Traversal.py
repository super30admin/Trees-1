# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic: preorder dict 1st element is root then left elements & right elements. Inorder dict divides list into parts
# from root element. So, pick 1st element from preorder as root, search its index in inorder & provide index - 1 to
# left of root from the start & index + 1 to end to right of root.

class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder, inorder):
        self.inorder_map = {key: value for value, key in enumerate(inorder)}
        self.p = 0
        self.preorder = preorder
        return self._helper(0, len(inorder)-1)

    def _helper(self, start, end):
        if start > end:
            return None
        root_value = self.preorder[self.p]
        root = Node(root_value)
        self.p += 1
        root.left = self._helper(start, self.inorder_map[root_value] - 1)
        root.right = self._helper(self.inorder_map[root_value] + 1, end)
        return root
