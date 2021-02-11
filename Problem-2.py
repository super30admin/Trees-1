#Time Complexity :O(n)
#Space Complexity :O(n) hashhmap  
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
lass Solution(object):
    hmap=None
    idx=None
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.hmap={}
        self.idx=0
        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i
        
        return self.helper(preorder,inorder,0,len(inorder)-1)
    
    def helper(self,preorder,inorder,start,end):
        #base
        if(start>end):
            return None
        #logic
        rootVal=preorder[self.idx]
        self.idx+=1
        root=TreeNode(rootVal)
        inIdx=self.hmap[rootVal]
        root.left=self.helper(preorder,inorder,start,inIdx-1)
        root.right=self.helper(preorder,inorder,inIdx+1,end)
        return root
        
        