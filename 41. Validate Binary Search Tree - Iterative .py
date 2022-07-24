# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        st = []
        prev = None
        while root or len(st) != 0:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            #print(root.val)
            if prev and prev.val >= root.val:
                return False
            prev = root
            root = root.right
        return True


# Time Complexity = O(n).
# Space complexity : O(h) maximum height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
