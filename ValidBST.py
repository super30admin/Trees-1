#Time Complexity-o(n)
#space complexity-o(n)
#Run on leetcode-Yes

##Recursive Solution::
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root,None,None)
        
        
    def helper(self,node,minc,maxc):
        #base
        if not node:
            return True
        if (minc!=None and node.val<=minc):
            return False
        if (maxc!=None and node.val>=maxc):
            return False
        
        
        #logic
        case1=self.helper(node.left,minc,node.val)
        case2=self.helper(node.right,node.val,maxc)
        if case1 and case2:
            return True
           
         
