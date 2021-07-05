# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        result = []
        self.bst(root, result)
        
        for i in range(len(result)-1):
            if result[i] >= result[i+1]:
                return False
        
        return True
    
    def bst(self, node, result):
        if not node:
            return
        
        self.bst(node.left,result)
        result.append(node.val)
        self.bst(node.right,result)