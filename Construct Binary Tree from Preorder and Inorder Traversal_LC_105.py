# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
    #     # bottom - up recursion
    #     # TC: n^2 
    #     if not preorder and not inorder:
    #         return None
    #     rootVal = preorder[0]
    #     root = TreeNode(rootVal)
    #     # index = -1
    #     # for i in range(len(inorder)):
    #     #     if inorder[i] == rootVal:
    #     #         index = i

    #     index = inorder.index(rootVal)

    #     leftInorder = inorder[:index]
    #     rightInorder = inorder[index + 1:]

    #     leftPreorder = preorder[1:index + 1]
    #     rightPreorder = preorder[index + 1:]

    #     root.left = self.buildTree(leftPreorder, leftInorder)
    #     root.right = self.buildTree(rightPreorder, rightInorder)
        
    #     return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.dic = {val: idx for idx, val in enumerate(inorder)}
        self.idx = 0
        return self.recurse(preorder, 0, len(inorder) - 1)

    def recurse(self, preorder, start, end):
        # base case
        if start > end:
            return None
        # logic
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        index = self.dic[rootVal]
        root.left = self.recurse(preorder, start, index - 1)
        root.right = self.recurse(preorder, index + 1, end)
        return root
