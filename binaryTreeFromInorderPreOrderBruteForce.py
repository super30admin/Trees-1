# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if not preorder:
            return None
        
        idx = -1
        rootValue = preorder[0]
        
        print(rootValue)
        root = TreeNode(rootValue)
        
        for index,num in enumerate(inorder):
            if num == rootValue:
                idx = index
                break
        
        inLeft = inorder[0:idx+1]
        inRight = inorder[idx+1:len(inorder)]
        preLeft = preorder[1:idx+1]
        preRight =  preorder[idx+1:len(preorder)]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        
        return root
    
    
#  this is brute force, time complexity is O(n) and space complexity is O(n2)
                
