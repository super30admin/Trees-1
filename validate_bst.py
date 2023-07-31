# Time Complexity :O(N)
# Space Complexity :O(H)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
    # started copying values backwards, using slow and fast pointer, fast is always one step ahead


class Solution:
    def helper_prev_methode(self, root, p):
        #base
        if(root==None):
            return True
        #logic
        if(p!=None and p.left!=None and p.left.val==root.val and p.val<=root.val):
            return False
        if(p!=None and p.right!=None and p.right.val==root.val and  p.val>=root.val):
            return False
        return self.helper_prev_methode(root.left,root) and self.helper_prev_methode(root.right,root)

        pass
    def helper_range_methode(self, root, low, high):
        #base
        if(root==None):
            return True
        #logic
        if(root.val>=high):
            return False
        if(root.val<=low):
            return False
        
        return self.helper_range_methode(root.left, low, root.val) and self.helper_range_methode(root.right, root.val, high)



    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # return self.helper_range_methode(root,float('inf')*-1, float('inf'))
        return self.helper_prev_methode(root,None)