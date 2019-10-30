#leetcode 105
#inorder --  letf root right
#postorder --  left right root
#preorder root left right

# [3,9,20,15,7] --  preorder traversal  ---  3 is root 9 is left subtrree and 20,15,7 right subtree and 3 is root --we will know this only after we
#  comapre both in and preorder traversal
#in preorder the first element is root hence 3 is root and since only 9 i to left of 3 in inorder traversal 9 is left subtree and 20,15,7 right subtree
#[9,3,15,20,7] --- In inorder traversal the 9 are going to be left art of subtree and 3 is root and 20,15,7in right subtree
#from preorder once u get the root , elements to the left of the it belong to left subtree and elements to right of it belong to right subtree
#Algo:
#go to preorder, take the first element, whatevere elemets to the left of this first element in inorder are cosnisdered left subtree and
# elements to the right of the first element(obtained for preorder) in inorder traversal array are going to be part of right subtree.
#time and space compelxit-- 0(


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        # edge case first in any code
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        index = -1
        for i in range(0, len(inorder), 1):
            if inorder[i] == root.val:
                index = i
                break;
        preleft = preorder[1: index + 1]  # preorder traversal of left subtree
        preright = preorder[index + 1:]  # preorder traversal of right subtree
        inleft = inorder[:index]  # inorder traversal of left subtree
        inright = inorder[index + 1:]  # inorder traversal of right subtree
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root
#if instead of preorder, postorder is give then we tahe the last element of post order as root and from 1st to index is left subtree and inex +1 to end is right subtree
#python soecific slution
class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        def chk(preorder, inorder):
            if not inorder:
                return None
            if len(inorder) == 1:
                return TreeNode(inorder[0])
            ind = inorder.index(preorder[0])
            node = TreeNode(inorder[ind])
            node.left = chk(preorder[1:ind + 1], inorder[:ind])
            node.right = chk(preorder[ind + 1:], inorder[ind + 1:])
            return node

        return chk(preorder, inorder)

