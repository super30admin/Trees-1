#98. Validate Binary Search Tree
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    flag = True
    def isValidBST(self, root): #T.C-> O(N) , S.C-> O(H)
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.helper(root,None,None)
        return self.flag
    
    def helper(self,root,min_val,max_val):

        if(root == None): return 

        self.helper(root.left,min_val,root.val)

        self.helper(root.right,root.val,max_val)

        if(min_val!=None and root.val <= min_val):
            self.flag = False
        if(max_val!=None and root.val >= max_val):
            self.flag = False