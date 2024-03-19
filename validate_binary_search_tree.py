# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def __init__(self):
        self.prev = None
        self.flag = False

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.inorder(root)
        return self.flag
    
    def inorder(self, root: Optional[TreeNode]):
        if(root == None or not self.flag): return
        self.inorder(root.left)

        if(self.prev != None and self.prev.val >= root.val):
            self.flag = False
        self.prev = root

        self.inorder(root.right)

        