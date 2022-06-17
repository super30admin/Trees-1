# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# iterative
# by checking min and max at each and every node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.dictu = {}

    def helper(self, preorder, p_start, p_end, inorder, i_start, i_end):
        if p_start > p_end or i_start > i_end:
            return
        root = preorder[p_start]
        rootNode = TreeNode(root)
        rootidx = self.dictu[root]
        count = rootidx - i_start
        rootNode.left = self.helper(preorder, p_start + 1, p_start + count, inorder, i_start, rootidx - 1)
        rootNode.right = self.helper(preorder, p_start + count + 1, p_end, inorder, rootidx + 1, i_end)
        return rootNode

    def buildTree(self, preorder: list[int], inorder: list[int]):
        for i in range(len(inorder)):
            self.dictu[inorder[i]] = i
        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)


check1 = Solution()
print(check1.buildTree([3, 9, 4, 5, 20, 15, 7], [4, 9, 5, 3, 15, 20, 7]))


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.dictu = {}
#         self.idx = 0
#
#     def helper(self, preorder, start, end):
#         if start > end:
#             return
#         root = TreeNode(preorder[self.idx])
#         rootIndex = self.dictu[preorder[self.idx]]
#         self.idx += 1
#         root.left = self.helper(preorder, start, rootIndex-1)
#         root.right = self.helper(preorder, rootIndex+1, end)
#         return root
#
#     def buildTree(self, preorder: list[int], inorder: list[int]):
#         for i in range(len(preorder)):
#             self.dictu[inorder[i]] = i
#         return self.helper(preorder, 0, len(inorder)-1)
#
#
# check1 = Solution()
# print(check1.buildTree([3, 9, 4, 5, 20, 15, 7], [4, 9, 5, 3, 15, 20, 7]))


# TC - O(n*n); SC - O(n*n)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def buildTree(self, preorder: list[int], inorder: list[int]):
#         if len(preorder) == 0:
#             return
#         root = TreeNode(preorder[0])
#         rootIndex = -1
#         for i in range(len(inorder)):
#             if inorder[i] == preorder[0]:
#                 rootIndex = i
#         preleft = preorder[1:rootIndex+1]
#         preright = preorder[rootIndex+1:]
#         inleft = inorder[:rootIndex]
#         inright = inorder[rootIndex+1:]
#         root.left = self.buildTree(preleft, inleft)
#         root.right = self.buildTree(preright, inright)
#         return root
#
#
# check1 = Solution()
# print(check1.buildTree([3, 9, 4, 5, 20, 15, 7], [4, 9, 5, 3, 15, 20, 7]))
