# time complexity:
# leetcode:
# explaination:
# doubts
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        self.root = TreeNode(preorder[0])
        # print(self.root.val)
        index = -1
        for i in range(len(inorder)):
            if inorder[i] == (self.root.val):
                index = i
            print(index)
        preleft = preorder[1:index + 1]
        inleft = inorder[0:index]
        preright = preorder[index + 1:len(preorder)]
        inright = inorder[index + 1:len(preorder)]
        self.root.left = self.buildTree(preleft, inleft)
        self.root.right = self.buildTree(preright, inright)
        return self.root

