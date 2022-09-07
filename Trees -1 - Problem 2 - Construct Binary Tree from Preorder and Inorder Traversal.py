"""
S30 FAANMG Problem #48 {Medium}


105. Construct Binary Tree from Preorder and Inorder Traversal

Time Complexity : O(N^2)
As we do n iterations for each node


Space Complexity :  O(N^2)
As we are making copy of each node
Recursion

Did this code successfully run on Leetcode : Yes
  





@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        #Null Case
        
        if len(preorder) == 0:
            return None 
        
        # making the root as first value in preorder list
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        
        idx =-1
        
        #find root in Inorder
        
        for i in range (len(inorder)):
            if(inorder[i] == rootVal):
                idx =i
                break
        
        # breaking up the list into 2 each, one for left sub-tree and other for right-subtree, according to the index that we have found
        inLeft  = inorder[0 : idx]
        preLeft = preorder[1 : idx +1 ]
        
        preRight = preorder[ idx +1 : len(preorder) ]
        inRight = inorder[idx+1 : len(inorder)]
        
        
        # recursively call the buildTree function on those sub-trees and store it as root.left and root.right
        root.left = self.buildTree(preLeft, inLeft)
         
        root.right = self.buildTree(preRight, inRight)
        
        return root