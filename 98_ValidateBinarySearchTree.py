from Driver.TreeSerializerDeserializer import deserializer


"""
Leetcode- https://leetcode.com/problems/validate-binary-search-tree/
TC- O(N) - check on each element in the tree, SC- O(1) - no space used
Lecture- https://www.youtube.com/watch?v=FSY8UFbnvgw&t=922s
FAQ-
Why is your previous global and not local to your recursion function?
Passing previous element in recursive function, we will lose our new previous when we pop our elements from
recursive stack.
Can you do write a boolean function? Yes, we can.
Can you think of any optimization? We can only do the check on the right tree of the node if validity of BST is not
breached.

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 104].
-2^31 <= Node.val <= 2^31 - 1
"""

'''
Ideation-
The idea here is that the inorder traversal for a valid BST will always be in increasing order, so, if we create our
inorder traversal and check if the elements are in ascending sorted order, it will be a valid BST.

This can be achieved either by storing the traversal in a list and checking if curr element is greater than previous,
or this same thing can be achieved by doing it during our inorder traversal which can save us space.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Void function solution
class Solution:
    prev = None
    isBST = True

    def isValidBST(self, root):
        self.inorder(root)
        return self.isBST

    def inorder(self, root):
        if root is None:
            return None
        self.inorder(root.left)
        #  consider it checking in an imaginary in-order traversal list, if the previous is greater than you current,
        # the validation condition is violated and flag is set to false.
        if self.prev and self.prev.val >= root.val:
            self.isBST = False
        self.prev = root
        # this solution can be further optimized by only calling the check on right if isBST = True
        self.inorder(root.right)


# boolean recursive function
class Solution1:
    prev = None

    def isValidBST(self, root):
        return self.inorder(root, True)

    def inorder(self, root, isBST):
        if root is None:
            return True
        lBST = self.inorder(root.left, isBST)
        #  consider it checking in an imaginary in-order traversal list, if the previous is greater than you current,
        # the validation condition is violated and flag is set to false.
        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root
        # this solution can be further optimized by only calling the check on right if isBST = True
        rBST = self.inorder(root.right, isBST)

        return lBST and rBST


treeInp = '[2,2,2]'
root = deserializer(treeInp)
isBST = Solution1().isValidBST(root)
print(isBST)