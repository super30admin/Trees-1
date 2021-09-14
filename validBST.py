# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def inorder(root):
            if not root:
                return True
            if not inorder(root.left):
                return False
            #return False when current root's value greater than previous
            if self.prev >= root.val:
                return False
            self.prev = root.val
            #traverse right subtree
            return inorder(root.right)
        self.prev = -math.inf
        return inorder(root)
            
