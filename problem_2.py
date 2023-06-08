
# Time Complexity - O(n)
# Space Complexity - O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preIndex = 0
        self.dictionary = {}
        for i in range(len(inorder)):
            self.dictionary[inorder[i]] = i 
        return self.helper(inorder,preorder,0,len(inorder)-1)
        
    def helper(self,inorder,preorder,start,end):
        if start > end : 
            return None     
        rootVal = preorder[self.preIndex]
        self.preIndex += 1 
        root = TreeNode(rootVal)
        rootIndx = self.dictionary[rootVal] 

        root.left = self.helper(inorder,preorder,start,rootIndx-1)
        root.right = self.helper(inorder,preorder,rootIndx+1,end) 

        return root
