# Time complexity: O(n)
# Space Complexity: O(H)   H is the height of the BST
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.inorder(root)
        return self.flag
    def inorder(self, root: Optional[TreeNode]) -> bool:
#         base
        if not root:
            return False
        self.inorder(root.left)  
#         stack.pop()
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
        if self.flag:
            self.inorder(root.right)
#         stack.pop()
        
