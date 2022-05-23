#Time Complexity : O(n)
#Space Complexity: O(n) where n -> height of tree
#Did your code run on leetcode : yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #isvalid = False
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = -math.inf
        #global isvalid
        #isvalid = True
        
        return self.inorder(root)
    
    
    def inorder(self, root: Optional[TreeNode])->bool:
        if root == None : return True
        
        if (self.inorder(root.left) == False): return False
       



        if(self.prev!= -math.inf and self.prev >= root.val):
            return False
        
        self.prev = root.val
        return self.inorder(root.right)
