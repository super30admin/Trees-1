using min-max method :

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None



// Your code here along with comments explaining your approach

Given Inorder and preorder traversal we have to construct a binary tree.In pre traversal the first element is the root element when found the index of the same element in inorder list we get the  left and right subtrees at that element.use recursion to build all the sub trees.In the end return the root.

class Solution(object):
    def __init__(self):
        self.index=0
        self.d=dict()
    def helper(self,preorder,inorder,start,end):
        if start>end :
            return None
        print(self.index,start,end)
        value=preorder[self.index]
        root=TreeNode(value)
        index=self.d[value]
        self.index=self.index+1
        root.left=self.helper(preorder,inorder,start,index-1)
        root.right=self.helper(preorder,inorder,index+1,end)
        return root
        
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if preorder==None or len(preorder)==0:
            return None
        start=0
        end=len(preorder)-1
        for i in range(len(inorder)):
            self.d[inorder[i]]=i
        return self.helper(preorder,inorder,start,end)
        
        