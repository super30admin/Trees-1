#O(n) time and o(d) space where n is no.of nodes in BST and d is max_depth of BST

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validateBST(root,float("-inf"),float("inf"))
    
    def validateBST(self,node,minimum,maximum):
        if node is None:
            return True
        if node.val <= minimum or node.val >= maximum:
            return False
        
        return self.validateBST(node.left,minimum,node.val) and self.validateBST(node.right,node.val,maximum)
