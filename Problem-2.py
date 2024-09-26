"""
## Problem 2

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7


TIME- O(N)
SPACE - O(N)
LEETCODE - YES

"""


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution():
    def BT(self, preorder, inorder):
        if len(preorder)==0:    # IF LEN OF PREORDER IS 0, RETURN
            return None
        root = TreeNode(preorder[0])      # MAKE FIRST ELEMENT OF PREORDER LIST AS ROOT

        # CHECK INDEX OF ROOT IN INORDER LIST
        # WE CAN SE DIC OR NORMAL FOR LOOP OR INDEX FUNCTION TO GET THE INDEX OF THE ROOT IN INORDER LIST
        index = inorder.index(preorder[0])

        # left root recursion, left tree will have elements from preorder list FROM 1ST POSITION TILL INDEX + 1
        # INORDER LIST - FROM STARTING TILL THE INDEX
        root.left = self.BT(preorder[1:index+1], inorder[0:index])

        # RIGHT root recursion, left tree will have elements from preorder list FROM  INDEX + 1 TO; END
        # INORDER LIST  - FROM  THE INDEX +1 TIL END
        root.right = self.BT(preorder[index+1:], inorder[index+1:])
        return root

    def BT2(self, preorder, inorder):
        if len(inorder) == 0:
            return None
        poped=preorder.pop(0)
        ind = inorder.index(poped)
        root = TreeNode(inorder[ind])
        root.left = self.BT2(preorder, inorder[0:ind])
        root.right = self.BT2(preorder, inorder[ind + 1:])
        return root


construct_bt= Solution()
print(construct_bt.BT(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]))
print(construct_bt.BT2(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]))
#print(construct_bt.BT3(preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]))