// Time Complexity : O(2n^2)   
// Space Complexity : O(depth*2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0:         //O(2n)                   
            return None
        root=TreeNode(preorder[0])    //this will be root node since first element of pre order is always root node 
        
        index=-1
        for i in range(len(inorder)):   //O(n)  //serach for root in inorder then left of inorder will be towards left of root node 
            if inorder[i]==root.val:
                index=i
                break
        
        preLeft=list(preorder[1:index+1])   //create left preoder list
        preRight=list(preorder[index+1:])   //create right preoder list
        
        inLeft=list(inorder[:index])      //create left inorder list
        inRight=list(inorder[index+1:])   //create left inorder list
        
        root.left=self.buildTree(preLeft,inLeft)    //repeat same with preleft and inorderleft list 
        root.right=self.buildTree(preRight,inRight)   //repeat same with preRight and inorderright list 
        
        return root
