# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.li=[]
        self.dict={}
        self.idx=0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        start=0
        end=len(inorder)-1
        
        for i in range(len(preorder)):
            self.dict[inorder[i]]=i
        print(self.dict)       #On 
        root=self.tree(preorder,inorder,start,end)
        return root
    def tree(self,preorder,inorder,start,end):
        if start>end:
            return None
       
        rootidx=self.dict[preorder[self.idx]]
        
        root=TreeNode(preorder[self.idx])
        self.idx=self.idx+1
        
        root.left=self.tree(preorder,inorder,start,(rootidx-1))
        
        root.right=self.tree(preorder,inorder,rootidx+1,end)
        return root
       
        
        
        
        
        
        
        
         
       
            
   
        
        