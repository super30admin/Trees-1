# Brute force solution
# Time complexity : O(n^2) --> we do n iterations for each node
# Space complexity : O(n^2) --> making copy of each node
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
      
        # check if the preorder list is empty or the node is None
        if len(preorder) == 0 or preorder is None:
            return None
        #print(preorder[0])
        # making the root as the first element in preorder list as it is filled as root-left-right
        rootval = preorder[0]
        
        # making the root as first value in preorder list
        root = TreeNode(rootval)
        
        # find the index of that value in in-order list
        idx = -1
        for i in range(len(inorder)):
            if rootval == inorder[i]:
                idx = i
                break
        
        # breaking up the list into 2 each, one for left sub-tree and other for right-subtree, according to the index that we have found
        in_left = inorder[0:idx]
        pre_left = preorder[1:len(in_left)+1]
        in_right = inorder[len(in_left)+1:]
        pre_right = preorder[idx+1:]
        
        #print(in_left)
        #print(pre_left)
        #print(in_right)
        #print(pre_right)
        # recursively call the buildTree function on those sub-trees and store it as root.left and roo.right
        root.left = self.buildTree(pre_left, in_left)
        root.right = self.buildTree(pre_right, in_right)
        
        # at the end, just return the head which is the root
        return root
        
