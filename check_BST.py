# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
I have used a prev pointer that follows the root in bottom up inorder traversal
'''

class Solution:
    
    prev_pointer = None
    def _checkBSThelper(self, root):
        
        if root is None:
            return True
        
        
        
        self._checkBSThelper(root.left)
        #left most leaf popped out as root, and control is midway towards going towards
        #leaf's root
        if self.prev_pointer is not None and self.prev_pointer >= root.val:
            return False
        
        self.prev_pointer = root.val
        self._checkBSThelper(root.right)
        return True
        
                        
    def isValidBST(self, root: TreeNode) -> bool:
        
        return self._checkBSThelper(root)
        