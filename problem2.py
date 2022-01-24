# Definition for a binary tree node.
#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    hashmap = {}
    index = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if(preorder==None or inorder ==None or len(preorder)==0):
            return None
        for i,v in enumerate(inorder):
            self.hashmap[v] =  i
        return self.helper(preorder,0,len(preorder)-1)
    def helper(self,preorder,start,end):
        if(start>end ):
            return None
        rootVal = preorder[self.index]
        self.index+=1
        root = TreeNode(rootVal)
        rootidx= self.hashmap[rootVal]
        root.left = self.helper(preorder,start,rootidx-1)
        root.right = self.helper(preorder, rootidx+1,end)
        return root
        
        
            
        