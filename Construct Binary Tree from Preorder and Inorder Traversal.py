# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(h) where h is the recursion stack space maximum height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a helper function to build the tree.
# The helper function takes two parameters - the left and right boundaries of the inorder array.
# If the left boundary is greater than the right boundary, I am returning None.
# I am popping the first element from the preorder array to get the root value and creating a TreeNode with that value.
# I am finding the index of the root value in the inorder array using a hashmap for O(1) access.
# I am recursively calling the helper function for the left and right subtrees, updating the boundaries accordingly.
# Finally, I am returning the root of the tree.

from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(left,right):
            if left > right:
                return None
            root = TreeNode(preorder.pop(0))
            index = has[root.val]
            root.left = helper(left,index-1)
            root.right = helper(index+1,right)
            return root


        has = {v:i for i,v in enumerate(inorder)}
        return helper(0,len(inorder)-1)
        