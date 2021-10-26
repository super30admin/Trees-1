#Time Complexity : O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def recursiveFunc(node, left, right):
            if not node:
                return True
            if not(node.val<right and node.val>left):
                return False
            
            return(recursiveFunc(node.left,left,node.val) and recursiveFunc(node.right,node.val, right))
        return  recursiveFunc(root, float("-inf"), float("inf"))
