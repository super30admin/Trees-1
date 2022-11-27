from typing import List, Optional
# Time Complexity : O(n*n), Where n is number of nodes in the Binary Tree
# Space Complexity : O(n), Where n is number of nodes in the Binary Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def constructUniqueBinaryTree(self,preo: List[int],ino: List[int]):
        if(len(ino)==0 and len(preo)==0):
            return None
        #Clearly rootvalue is present in the first of the preorder(preo)
        rootval=preo[0]
        root=TreeNode(rootval)
        #Let us find the rootval in the inorder
        index=0
        for i in range(len(ino)):
            if(ino[i]==rootval):
                break
        #llength=i
        #rlength=(len(ino)-1)-i
        #print(llength,rlength)
        root.left=self.constructUniqueBinaryTree(preo[1:i+1],ino[0:i])
        root.right=self.constructUniqueBinaryTree(preo[i+1:],ino[i+1:])
        return root
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #This is an edge case
        if(len(inorder)==0 and len(preorder)==0):
            return None
        else:
            return self.constructUniqueBinaryTree(preorder,inorder)
        