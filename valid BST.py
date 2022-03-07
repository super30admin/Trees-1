# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

import math
class Solution:
    def isValidBST(self, root) -> bool:
        
        stack , prev = [], -math.inf
        
        while root or stack:
            while root:
                
                # add the nodes to the stack
                stack.append(root)
                root = root.left
            
            # assign root from stack
            root = stack.pop()
            
            # check for BST condition
            if root.val<=prev:
                return False
            prev = root.val # logic to check parent node
            root = root.right # assign root to the node's right
            
        return True