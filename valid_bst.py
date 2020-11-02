# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- Do an inorder traversal of the tree,an inorder traversal of a BST should always be in the sorted order. So while doing this inorder traversal maintain a stack of the elements seen so far and keep on appending to the stack if the element being appended to the stack is less or equal to the topmost element on the stack, it is not a valid BST.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.res=[]
        self.final=True
        def vbst(root):
            if root is None:
                return
            vbst(root.left)
            if len(self.res)>=1:
                if root.val<=self.res[-1]:
                    self.final=False
                    return
            self.res.append(root.val)
            vbst(root.right)
        vbst(root)
        return self.final

        # Another approach:- While doing the inorder traversal maintain the element at the top of the stack instead of maintaing the stack,
        # and compare with this element. This way we still have the recursion stack but do away with another auxillary stack
        # self.prev=None
        # self.final=True
        # def vbst(root):
        #     if root is None:
        #         return
        #     vbst(root.left)
        #     if self.prev is not None and root.val<=self.prev:
        #             self.final=False
        #             return
        #     self.prev=root.val
        #     vbst(root.right)
        # vbst(root)
        # return self.final