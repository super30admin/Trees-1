'''

Did it run on Leetcode: Yes
Problems faced: None (because I solved it previously)

Time complexity: 0(N)
Space Complexity: 0(N)

Algorithm:
- In a BST, all the values on left side should be less than root and values on the right
should be greater than the right.

- Recursively visited each node in BST where we check whether the node value is in the specified range.
If its in the range, then its a valid BST, if at any point in the recursion it returns False, then 
its an invalid BST.

'''



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        if not root:
            return True
        
        return self.isValidBSTUtil(root.left,-float("inf"),root.val) and self.isValidBSTUtil(root.right,root.val,float("inf"))
        
    def isValidBSTUtil(self,node,low,high):
        
        if not node:
            return True
        elif low<node.val<high:
            return self.isValidBSTUtil(node.left,low,node.val) and self.isValidBSTUtil(node.right,node.val,high)
        
        else:
            return False
        
        