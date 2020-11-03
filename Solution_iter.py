
"""
Time complexity O(N)
Space complexity for Recursive stack O(Height)-->O(N)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_iter:
    def isValidBST(self, root: TreeNode) -> bool:
        prev= None
        st=[]
        while(root or st):
            while(root):
                st.append(root)
                root=root.left
            root=st.pop()
            if(prev and prev.val>=root.val):
                return False
            prev=root
            root=root.right
        return True