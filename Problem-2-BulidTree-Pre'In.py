# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    out_arr = []

    def buildTree(self, preorder, inorder):

        if len(preorder) == 0:
            return None

        current_head = preorder[0]

        curr_node = TreeNode(current_head)

        curr_index = 0

        for i in range(len(inorder)):
            if inorder[i] == current_head:
                curr_index = i
                self.out_arr.append(inorder[i])

        pl = preorder[1:curr_index + 1]
        pr = preorder[curr_index + 1: len(preorder)]

        il = inorder[0: curr_index]
        ir = inorder[curr_index + 1: len(inorder)]

        curr_node.left = self.buildTree(pl, il)
        curr_node.right = self.buildTree(pr, ir)

        return curr_node

