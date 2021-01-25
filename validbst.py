
# Time Complexity:O(n) (where n = number of nodes)
# Space Complexity:O(h) (where h = height of the tree)
# Did this code successfully run on LeetCode?:Yes
# Problems faced while coding this:None
# Approach:Recursively check if the node is valid i.e. left subtree is less than node value and right subtree is greater than node value


class Solution:
    def isValidBST(self,root:TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root,None,None)
        
    def helper(self,root:TreeNode,min_num,max_num)-> bool:
        
        if not root:
            return True
        if(min_num is not None and root.val<=min_num):
            return False
        if(max_num is not None and root.val>=max_num):
            return False
        
        return self.helper(root.left,min_num,root.val) and self.helper(root.right,root.val,max_num)
        