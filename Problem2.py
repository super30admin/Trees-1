# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map = {}
        self.index = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.recursion(preorder,0,len(preorder)-1)
    
    def recursion(self,pre,l,r):
        if l > r:
            return None
        x = pre[self.index]
        root = TreeNode(x)
        self.index += 1
        root.left = self.recursion(pre,l,self.map[x]-1)
        root.right = self.recursion(pre,self.map[x]+1,r)
        return root
        

            
            