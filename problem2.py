#construct-binary-tree-from-preorder-and-inorder-traversal

# // Time Complexity : O(N)
# // Space Complexity : O(N) because of the hashmap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution(object):
    def buildTree(self, preorder, inorder):
        if(preorder==None or inorder==None or len(preorder)==0 or len(inorder)==0):
            return None
        self.map={}
        self.index=0
        for i in range(len(inorder)):                               #store the inorder values to a hashmap
            self.map[inorder[i]]=i
            
        return self.helper(preorder, 0, len(preorder)-1)
    
    def helper(self, preorder, start, end):
        #base
        if start>end:
            return None
        
        val=preorder[self.index]                                        
        self.index+=1
        root=TreeNode(val)                                      #make a treenode
        val_index=self.map[val]
        root.left = self.helper(preorder, start,val_index-1 )               #for the left side, look at the values from 0 to index-1
        root.right=self.helper(preorder,val_index+1, end )                  #for the right, look at the values from index to the end
        return root
        