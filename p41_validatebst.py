"""
# Trees-1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


TC: recursive inorder traversal - O(n+m) where n are the number of number of nodes and m are number of edges
Sc: recursive- o(height)
iterative inorder traversal - On), space O(n)/ O(height)
"""
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#
#     def isValidBST(self, root) -> bool:
#         """
#         Recursive inorder traversal
#         """
#         result=True
#         self.inorder(root)
#         # prev=None
#         return result
#
#     def inorder(self, root):
#
#         if root ==None:
#             return
#         self.inorder(root.left)
#         if self.prev!=None and self.prev>=root:
#             return False
#         self.prev=root
#         self.inorder(root.right)
#
#
#

class Solution:

    def isValidBST(self, root) :
        self.result=True
        self.prev = None
        # self.helperInorder(root)
        self.helperInorder(root)
        return self.result
        # return result




    def helperInorder(self, root):
        if root==None:
            return
        self.helperInorder(root.left)
        ##here pop will happen in the stack in background and the new root
        ##3becomes automatically the root in the background

        # if prev  prev!=None and prev.val>= root.val:
        #     result=False
        if self.prev!=None and self.prev.val >= root.val:
            self.result=False

        self.prev=root
        self.helperInorder(root.right)
        # self.prev=root
        # self.helperInorder(root.right)





# stack = []
        # prev=None
        # while root != None or not len(stack)==0:
        #     while root != None:
        #         stack.append(root)
        #         print("root appended", root)
        #         root = root.left
        #         print("new root from root.left", root)
        #     root = stack.pop()
        #     if prev!=None and prev.val >= root.val:
        #         return False
        #     prev=root
        #     print(root.val)
        #     root = root.right
        #     # return True
        #
        # return True




root = [2,1,3]
solve=Solution()
solve.isValidBST(root)