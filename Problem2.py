'''
Problem: Construct Binary Tree from preorder and inorder
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(n) for the hashmap
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        create hashmap on inorder for O(1) of search
        recurse on preorder using start and end index for left and right
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        idx = 0
        hashmap ={}
        for i,val in enumerate(inorder):
            hashmap[val]=i

        def helper(preorder, start, end):
            nonlocal idx
            #base
            if start>end:
                return None

            #logic
            rootval = preorder[idx]
            idx+=1
            root = TreeNode(rootval)
            rootidx =  hashmap[rootval]

            root.left = helper(preorder, start, rootidx-1)
            root.right = helper(preorder, rootidx+1, end)
            return root

        return helper(preorder, 0, len(inorder)-1)