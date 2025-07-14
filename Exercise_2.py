# Time Complexity: O(n)
# Space Complexity: O(h)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        mapping = {}

        #create mappings of inorder 
        for i in range(len(inorder)):
            mapping[inorder[i]] = i

        # use queue for O(1) popleft operation
        # since we will be using preorder to build the tree
        # for each root, we will pop the first element from preorder
        preorder = deque(preorder)

        def buildNodes(start, end) -> Optional[TreeNode]:
            # if start index is greater than end index, return None
            # this is the base case for recursion, this case is seen when a leaf node is reached
            if start>end:
                return None

            # pop the first element from preorder, this will be the root of the current subtree
            # and we will build the left and right subtrees from this root
            root = TreeNode(preorder.popleft())

            # find the index of the root in inorder
            mid = mapping[root.val]    

            # recursively build the left and right subtrees
            # left subtree will be built from the elements before the root in inorder
            # right subtree will be built from the elements after the root in inorder
            root.left = buildNodes(start, mid-1)
            root.right = buildNodes(mid+1, end)
            
            return root

        return buildNodes(0, len(preorder)-1)