#TIME COMPLEXITY : O(N)
#SPACE COMPLEIXTY : HEIGHT OF THE TREEE OR O(N).
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root,None, None)
        return self.flag
    
    def helper(self,root, mini,maxi):
        
        if root == None:
            return
        if(mini != None and root.val <= mini):
            self.flag = False
        if(maxi != None and root.val >= maxi):
            self.flag = False
        self.helper(root.left,mini,root.val)
        self.helper(root.right,root.val,maxi) 
        
        # left = self.helper(root.left, mini, root.val)
        # right = self.helper(root.right,root.val,maxi)
