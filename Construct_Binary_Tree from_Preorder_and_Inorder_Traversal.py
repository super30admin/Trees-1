# Time Complexity : O(N)
# Space Complexity : O(H) We are storing entire tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Please verify my time and space complexity I am kind of confuse(weather O(H) or O(N). Thanks 

#After the initial prechecking statements (line #1 and #2), we pop first element of preorder, add that value to node. 
Then we do two recursions, one for left and one for right subtrees. Note that in this problem, left subtree will be used first. 
This is done due to the relation between inorder and preorder.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(inorder) == 0: #1
            return None
        
        if len(preorder) == 1: #2
            return TreeNode(preorder[0])
        
        ind = inorder.index(preorder.pop(0)) #3
        node = TreeNode(inorder[ind])
        
        node.left = self.buildTree(preorder, inorder[:ind]) #4
        node.right = self.buildTree(preorder, inorder[ind+1:]) #5
     
        return node
