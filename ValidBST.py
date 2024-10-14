# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity : O(h), where h is the height of the tree, due to the recursive call stack in a depth-first traversal. In the worst case (for a skewed tree), h could be O(n).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree

# Your code here along with comments explaining your approach 
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None
        self.flag = True
        self.helper(root)
        return self.flag
    def helper(self, root):
        if(root==None):
            return
        self.helper(root.left)
        if(self.prev!=None and self.prev.val>=root.val):
            self.flag = False
        self.prev = root
        self.helper(root.right)