# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        return self.helper(root, None, None)

    def helper(self, root, minimum, maximum):
        if root is None:
            return True
        if maximum is not None and maximum <= root.val:
            return False
        if minimum is not None and minimum >= root.val:
            return False

        # case1 = self.helper(root.left, minimum, root.val)
        # #print("Up", root.val, maximum, minimum)
        # case2 = self.helper(root.right, root.val, maximum)
        # print("Down", root.val, maximum, minimum)
        # return case1 and case2

        return self.helper(root.left, minimum, root.val) and self.helper(root.right, root.val, maximum)

# TC =O(n).
# Space complexity : O(1). Height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
