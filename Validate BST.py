# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        result=[]
        
        return self.inorder(root,result)
    
    def inorder(self,root,result):
        
        if root is None:
            return 
        
        self.inorder(root.left,result)
        result.append(root.val)
        if root.val<=result[-1]:
            return False
        self.inorder(root.right,result)
        
        print(result)
        
        return True

#Time Complexity: O(n)
#Space complexity: O(1)