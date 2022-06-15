# Time complexity: O(n)
# Space Complexity: O(h)
  
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None
        
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        #         st.pop()
        # root = 
        print("up", root.val)
        if self.prev is not None and self.prev.val >= root.val:
            self.flag = False
            
        self.prev = root
        
        if self.flag:
            self.inorder(root.right)
        #         st.pop()
        # root = 
        print("down", root.val)
        
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag
