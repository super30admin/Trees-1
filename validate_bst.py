/ Time Complexity: O(nlogn)
//Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        if(root==None):
            return(True)
        
        res=[]
        stack=[]
        cur=root
        while(True):
            
            
            if(cur!=None):
                stack.append(cur)
                cur=cur.left
            
            elif(stack!=[]):
                current=stack.pop()
                res.append(current.val)
                cur=current.right
            else:
                break
        
        if(sorted(res) == res and len(set(res))==len(res)):
            return(True)
        else:
            return(False)
                
                
            
                
            
        
        