# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we return false if in the inorder the value is not between left and right boundaries. The left and right boundaries are updated accordingly

class Solution(object):
    
    def isValidBST(self, root):
        def inOrder(root, low, high):
            if not root: return True 
            
            if not(root.val<high and root.val > low):
                return False
            return (inOrder(root.left, low, root.val) and inOrder(root.right, root.val, high))
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        return inOrder(root, float("-inf"), float("inf"))