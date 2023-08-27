# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev =  None
        st = []

        while(root is not None or len(st) != 0):
            while(root != None):
                st.append(root)
                root = root.left

            root = st.pop()

            if prev != None and prev.val >= root.val:
                return False

            prev = root
            root = root.right

        return True
        