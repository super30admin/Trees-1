#Space: O(n)
#Time: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.is_valid = True
        # self.prev= None

        self.inorder(root,float('-inf'), float('inf'))
        return self.is_valid

    def inorder(self, root, minm, maxm):
        if(root == None):
            return
        self.inorder(root.left ,minm, root.val)
        print(root.val, minm, maxm)
        if((minm != None and root.val <= minm) or (maxm != None and root.val >= maxm)):
            self.is_valid = False
            return 
        
        self.inorder(root.right,root.val, maxm)
        return 

    
