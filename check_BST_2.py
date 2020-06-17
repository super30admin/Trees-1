# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
I have used a permisisible min max range based on root at every node. If the condition violates
we know for sure that it is not a BST
'''

import sys
class Solution:
    def _checkBSThelper(self, root, min_val, max_val):
        
        if root is None:
            return True

        
        if (root.val > min_val and root.val < max_val) and self._checkBSThelper(root.left, min_val, root.val) and self._checkBSThelper(root.right, root.val, max_val):
            return True
        
        return False
                
        
    def isValidBST(self, root: TreeNode) -> bool:
        
        return self._checkBSThelper(root,-sys.maxsize, sys.maxsize)
        