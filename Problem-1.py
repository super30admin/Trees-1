#Time Complexity :O(n) 
#Space Complexity :o(h) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    prev=None
    res=None
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root == None):
            return True
        self.res=True
        self.prev=None
        self.helper(root)
        return self.res
    
    
    def helper(self,root):
        #base
        if(root==None):
            return
        if(not self.res):
            return 
        #logic
        self.helper(root.left)
        if(self.prev!=None and root.val<=self.prev.val):
            self.res=False
        self.prev=root
        self.helper(root.right)
    
