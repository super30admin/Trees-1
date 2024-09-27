#105. Construct Binary Tree from Preorder and Inorder Traversal
#Time Complexity : O(n) 
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
class Solution:
    mapp = {}
    index = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        for i in range(len(inorder)):
            self.mapp[inorder[i]] = i
        return self.helper(preorder,inorder,0,len(inorder)-1)
    def helper(self, preorder, inorder,start,end):
        if start > end or self.index > len(preorder):
            return None
        
        root = TreeNode(preorder[self.index])
        indx = self.mapp[root.val]
        self.index += 1
        root.left = self.helper(preorder,inorder,start,indx-1)
        root.right = self.helper(preorder,inorder,indx+1,end)
        return root
