# Time Complexity : O(n) - total no of nodes
# Space Complexity : O(h) - height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# TC - O(n)
# SC - O(h)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def valid(node,left,right):
            if not node:
                return True
            if not (node.val < right and node.val > left):
                return False
            
            return (valid(node.left,left,node.val) and
            valid(node.right, node.val,right))
        return valid(root,float("-inf"),float("inf"))