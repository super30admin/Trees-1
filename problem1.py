# Time Complexity : O(n)
# Space Complexity : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    result = True
    prevmin = float('-inf')
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inordertraversal(root)
        return self.result
    def inordertraversal(self,root):
        if root is None or self.result == False:
            return
        self.inordertraversal(root.left)
        #comparing staement
        if root.val <= self.prevmin:
            self.result = False
            return
        self.prevmin = root.val 
        self.inordertraversal(root.right)