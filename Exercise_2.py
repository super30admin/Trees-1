# ## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Given preorder and inorder traversal of a tree, construct the binary tree.


# Note:
# You may assume that duplicates do not exist in the tree.

# Can you do it both iteratively and recursively?

# For example, given

# preorder = [3,9,20,15,7]


# inorder = [9,3,15,20,7]
# Return the following binary tree:

#    3


#    / \


#   9  20


#     /  \


#    15   7

# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder, inorder):
        # creaing a hashmap of {inorder values: inorder index}
        self.hmap = {}
        # preorder array index
        self.idx = 0
        # creating hashmap
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, start, end):
        # base

        # logic
        # getting root value from preorder
        rootVal = preorder[self.idx]
        # creating a treenode of it
        root = TreeNode(rootVal)
        # incrementing preorder index
        self.idx += 1
        # finding root idx value from hmap
        rootIdx = self.hmap.get(rootVal)
        # recursing to left --> end --> root - 1
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        # recursing to left --> start --> root + 1
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)

        return root

# // Time Complexity : O(n2)
# // Space Complexity : O(n2)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# class Solution:
#     def buildTree(self, preorder, inorder):
#         # base
#         if len(preorder) == 0:
#             return None
#         # logic
#         # we get rootValue
#         rootValue = preorder[0]
#         # make a tree
#         root = TreeNode(rootValue)
#         # inorder idx
#         root_idx = -1
#         # iterate through the inorder array and find index of rootValue in inorder
#         for i in range(len(inorder)):
#             if inorder[i] == rootValue:
#                 root_idx = i
#                 break
#         # create sub arrays
#         inLeft = inorder[:root_idx + 1]
#         inRight = inorder[root_idx + 1:]
#         preLeft = preorder[1: len(inLeft) + 1]
#         preRight = preorder[len(inLeft) + 1:]

#         # recursing
#         root.left = self.buildTree(preLeft, inLeft)
#         root.right = self.buildTree(preRight, inRight)

#         return root
sol = Solution()
preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]

print(sol.buildTree(preorder, inorder))
