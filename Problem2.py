# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Construct Binary Tree from Preorder and Inorder Traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.smap = {val: idx for idx, val in enumerate(inorder)}
        self.idx = 0
        for i in range(len(inorder)):
            self.smap[inorder[i]]=i

        return self.helper(preorder, 0, len(inorder) - 1)
        

    def helper(self, preorder, start, end) -> TreeNode:
        if start > end:
            return None

        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        rootIdx = self.smap[rootVal]

        root.left = self.helper(preorder, start, rootIdx - 1)  # Left subtree
        root.right = self.helper(preorder, rootIdx + 1, end)   # Right subtree

        return root


        # if len(preorder) == 0:
        #     return None
        # rootVal = preorder[0]
        # rootIdx = -1

        # for i in range(len(inorder)):
        #     if inorder[i] == rootVal:
        #         rootIdx = i
        #         break

        # root = TreeNode(rootVal)
        # inLeft = inorder[0:rootIdx]
        # inRight = inorder[rootIdx + 1: len(inorder)]
        # preLeft = preorder[1: len(inLeft) + 1]
        # preRight = preorder[len(inLeft) + 1: len(inorder)]


        # root.left = self.buildTree(preLeft, inLeft)
        # root.right = self.buildTree(preRight, inRight)
    
        # return root