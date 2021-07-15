# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root:TreeNode,min1:int,max1:int):
            if root==None:
                return 
            helper(root.left,min1,root.val)
            if root.val>=max1 or root.val<=min1:
                self.result=False
                return
            helper(root.right,root.val,max1)
        self.result=True
        helper(root,-math.inf,math.inf)
        print(-math.inf)
        print(type(root.right))
        return self.result
    
        