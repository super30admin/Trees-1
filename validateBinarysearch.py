# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         O(n)--TC
# O(1)--SC
#         base case
        if root is None: 
            return True
        
        return self.BST(root, float('-inf'), float('inf'))
        
    def BST(self, root, min_v, max_v):
        if root is None: return True
        
        if min_v < root.val < max_v:
            return self.BST(root.left, min_v, root.val) and self.BST(root.right, root.val, max_v)
        
        return False