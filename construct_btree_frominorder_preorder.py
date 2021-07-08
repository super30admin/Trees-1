"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
Suboptimal - Given below

Space Optimal
@Space optimal solution
- We only consider boundary for inorder with 2 pointers start_idx and end_idx
- left -> [start_idx,index-1]
- right -> [index+1,end_idx]
- Also we use map to store the inorder value-index map, so as to get the index in O(1)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        """
        1. Edge case if preorder is empty return None
        2. Get the root element from the preorder - preorder[0]
        3. Get the index of root in inorder
        4. Get the pre_left -> [1,index+1), in_left -> [0,index)
        5. Get the pre_right -> [index+1,end), in_right -> [index+1,end)
        6. left = buildtree( pre_left, in_left)
        7. right = buildtree( pre_righ, in_right)
        8. root.left = left
        9. root.right = right
        10. return root
        """
        #Method1-Space suboptimal
        def helper(preorder,inorder):
            if not preorder:
                return None
            root = TreeNode(preorder[0])
            #index = inorder.index(root.val)
            index = index_dict[root.val]
            # pre_left = preorder[1:index+1]
            # in_left = inorder[0:index]
            # pre_right = preorder[index+1:]
            # in_right = inorder[index+1:]
            root.left = self.buildTree(preorder[1:index+1],inorder[0:index])
            root.right = self.buildTree(preorder[index+1:],inorder[index+1:])
            return root
        

        #Method2 - Space optimal
        def helper(preorder,inorder,start_idx,end_idx):
            if start_idx > end_idx or not preorder:
                return None
            
            root = TreeNode(preorder.pop(0))
            index = index_dict[root.val]
            root.left = helper(preorder,inorder,start_idx,index-1)
            root.right = helper(preorder,inorder,index+1,end_idx)
            return root

        index_dict = dict((v,i) for i,v in enumerate(inorder))
        return helper(preorder,inorder)