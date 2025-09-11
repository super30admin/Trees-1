"""
TC: O(N) {at worst case we traverse all nodes once to build the tree}
SC: O(N) {if we consider the stack space used by recursion it’s O(N), otherwise O(1) excluding the hashmap}

Approach:

We are given preorder and inorder traversals. From preorder we always know the root since it is the first element in the range.
From inorder we know how many nodes fall in the left subtree and how many fall in the right subtree because the inorder sequence always appears as [left | root | right].
To speed up the process we build a hashmap of inorder values to indices so that root lookups take O(1). 
For every recursive call we pick the root from preorder[pre_start], then use the hashmap to find its position in inorder. The number of nodes in the left subtree is simply idx - in_start. Using this count we divide the preorder range into left and right segments and recursively build both subtrees.
This avoids repeated slicing of arrays, which would otherwise result in O(N²) time, and ensures we only traverse each node once in O(N). 

The problem ran successfully on Leetcode.
"""




from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def helper(self, pre_start, pre_end, in_start, in_end):
        #base case out of bounds array
        if pre_start > pre_end or in_start > in_end:
            return None

        root = TreeNode(self.preorder[pre_start])

        idx = self.d1[self.preorder[pre_start]]
        left_size = idx - in_start

        root.left = self.helper(pre_start = pre_start + 1, pre_end = pre_start + left_size, in_start = in_start ,in_end = idx - 1)

        root.right = self.helper(pre_start = pre_start + left_size + 1, pre_end = pre_end, in_start = idx + 1, in_end = in_end)
    
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
            self.d1 = {val: idx for idx, val in enumerate(inorder)}
            self.preorder = preorder
            pre_start, pre_end = 0, len(preorder) - 1
            in_start, in_end = 0, len(inorder) - 1

            return self.helper(pre_start, pre_end, in_start, in_end)
           
