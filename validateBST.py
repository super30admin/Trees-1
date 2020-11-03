'''
Time Complexity : O(n) 
Space Complexity : O(h)
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if not root:
            return True
        prev = float('-inf')
        st = []
        while root or  st:
            while root :
                st.append(root)
                root = root.left
            
            root = st.pop()
            
            if root.val <= prev:
                return False
            prev = root.val
            root  = root.right
            
        return True