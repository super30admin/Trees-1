# Author: Naveen US
# Titile: Validate binary tree.

# Time complexity: O(n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root,float("-inf"),float("inf"))
    def helper(self,root,Min,Max):
        if not root:
            return True 
        if not Min<root.val<Max:
            return False
        return self.helper(root.left,Min,root.val) and self.helper(root.right,root.val,Max)
