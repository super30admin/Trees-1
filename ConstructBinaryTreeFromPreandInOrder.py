// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes 
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0:
            return None
        root=TreeNode(preorder[0])
        for i in range(len(inorder)):
            if inorder[i]==root.val: #find the index of root
                break
        index=i
        inLeft=inorder[:index] #left side of index
        preLeft=preorder[1:index+1]  # left side array in preorder
        
        inRight=inorder[index+1:]  #right side of index
        preRight=preorder[index+1:] # right side array in preorder
        
        root.left=self.buildTree(preLeft,inLeft) #go to left
        root.right=self.buildTree(preRight,inRight) #go to right
        
        
        return root #tree is built