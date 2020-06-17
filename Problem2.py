"""
// Time Complexity : mentioned in code
// Space Complexity : mentioned in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

--> the first element in preorder is always the root
--> we find the root from preorder and use inorder to get the left and right subtrees

// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
RECURSIVE SOLUTION
using dictionary

Time complexity: o(n), number nodes
Space complexity: o(n), size of dictionary

"""

class Solution:
    pre_ind = 0 # GLOBAL, pointer to iterate over preorder list

    def helper(self,in_map, preorder, inorder, in_start, in_end):
        #base
        if self.pre_ind > len(preorder) or in_start > in_end :
            return None
        
        root = TreeNode(preorder[self.pre_ind]) #new node
        self.pre_ind += 1 #update pointer to point to the next root value
        
        in_idx = in_map[root.val] #get index of root in inorder
        
        
        root.left = self.helper(in_map, preorder, inorder, in_start, in_idx-1) #update start and end pointers for inorder, always go for left child first, the next value in preorder will be the left child, so left child should be explored before right
        root.right = self.helper(in_map, preorder, inorder, in_idx+1, in_end)
        
        return root
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        in_map = dict()
        
        for i, val in enumerate(inorder): #create map of values in inorder
            in_map[val] = i
            
        return self.helper(in_map, preorder, inorder, 0, len(inorder)-1)
        
        
        """

        without dictionary
        Time complexity: o(n^2), number nodes, searching
        Space complexity: o(n), unsure

        if not preorder: #base 
            return None

        root = TreeNode(preorder[0]) #new node
        
        for i in range(len(inorder)): #search for index in inorder
            if inorder[i] == root.val:
                inorder_idx = i
              
        preLeft = preorder[1:inorder_idx+1] #Update all lists for next iteration
        preRight = preorder[inorder_idx+1:]
        inLeft = inorder[:inorder_idx]
        inRight = inorder[inorder_idx+1:]
        
        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)
        
        return root
        """