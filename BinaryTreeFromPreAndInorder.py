
#TimeComplexity:O(n2)
#SpaceComplexity:O(n2)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
#The statring element of the preorder array gives us the root element.
#Divided the array based on root element and ran a recursive call to get the left and right subtrees




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        
        if preorder == None or len(preorder) == 0 :
            return None
        
        root = preorder[0]
        
        rootindex = -1
        
        rootnode = TreeNode(root)
        
        
        for i in range(0,len(inorder)):
            
            if root == inorder[i]:
                
                rootindex = i
                break
        
        inLeft = inorder[0:rootindex]
        
        preLeft = preorder[1:rootindex+1]
        
        inRight = inorder[rootindex+1:len(inorder)]
        
        preRight = preorder[rootindex+1:len(preorder)]
                
        rootnode.left = self.buildTree(preLeft,inLeft)
        rootnode.right = self.buildTree(preRight,inRight)
        
        return rootnode
        
        
        