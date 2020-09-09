# Leetcode problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n^2) => Recursion function by passing sliced arrays to every recursive call for finding root and left and right subtree for each subproblem. The issue here is finding the root in inorder array for each traversal
    
        Iterative approach: O(n) => The intuition behind this approach is preorder traversal will always have root node at the first position of the array.
        1. Find the index of root in inorder array
        2. Left subtree will be the size of inorder array from 0 to index
        3. Right subtree will be index to length of inorder array
        4. Left subtree size from step 2 can be used to get the preorder left subtree and rest will be right preorder subtree in preorder array
        5. Solve at each step recursively for each subtree.
        Here, hashmap can be used to optimize the search of index in inorder array.
        
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursive without hashmap and with array slicing
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

#         if not preorder:
#             return None

#         root = TreeNode(preorder[0])

#         index = -1

#         for i in range(len(inorder)):
#             if inorder[i] == root.val:
#                 index = i
#                 break

#         inLeft = inorder[0:index]
#         preLeft = preorder[1:index+1]

#         inRight = inorder[index+1:len(inorder)]
#         preRight = preorder[index+1:len(preorder)]

#         root.left = self.buildTree(preLeft,inLeft)
#         root.right = self.buildTree(preRight,inRight)

#         return root

    
    # recursive with size range and hashmap
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        inorder_map = {}
        # create hashmap once
        for i,node in enumerate(inorder):
            inorder_map[node] = i
        
        def helper(preStart,preEnd,inStart,inEnd):
            # edge case when prestart and preEnd are same
            if preEnd - preStart == 0:
                return None
            
            # create root from the first element of preorder array which starts from lower bound for preOrder
            root = TreeNode(preorder[preStart])
            
            # find index of root in inorder array
            index = inorder_map[root.val]
            
            # keeping these here for reference as slicing is relative to start and end passed in the recursive call
#             inLeft = inorder[0:index]
#             preLeft = preorder[1:index+1]

#             inRight = inorder[index+1:len(inorder)]
#             preRight = preorder[index+1:len(preorder)]
           
            # refer inLeft and preLeft slice start and end index relative to current preStart and inStart
            root.left = helper(preStart+1,preStart+index-inStart+1,inStart,index-1)
            # refer inRight and preRight slicing index
            root.right = helper(preStart+index-inStart+1,preEnd,index+1,inEnd)
        
            return root
        # start from the input array bounds
        return helper(0,len(preorder),0,len(inorder))
                