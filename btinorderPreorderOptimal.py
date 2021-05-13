# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    dataStore = dict()
    idx = -1
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        
        if not preorder:
            return None
        
        for i in range(len(inorder)):
                self.dataStore[inorder[i]] = i
                
        self.idx = 0
        
        return self.helper(preorder, inorder, 0, len(preorder)-1)
            
    
    def helper(self, preorder, inorder, start, end):
        
        if start>end:
            return None
        
        rootIdx = self.dataStore.get(preorder[self.idx])
        
        print(rootIdx)
        root = TreeNode(preorder[self.idx])
        print(root)
        self.idx += 1
        
        root.left = self.helper(preorder, inorder, start, rootIdx-1)
        root.right = self.helper(preorder, inorder, rootIdx+1, end)
        
        return root

#  better time and space complexity as we are using hashmap instead of 4 arrays and 2 pointers.
        
