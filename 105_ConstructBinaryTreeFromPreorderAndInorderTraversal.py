"""
Leetcode - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ (submitted)
TC- O(N) - number of elements in tree, SC- O(1) hashmap
Lecture- https://www.youtube.com/watch?v=M_YPbb6vlNY, https://youtu.be/JW2KxAHFqv8?t=3718
FAQ-
Why do you need two traversals? Can you do with a single traversal?
There can be multiple possible trees from just one traversal. That's why we need at least two traversals.


Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Ideation - Brute force recursion O(N^2) - number of elements * [finding root index + creating sub preorder and
    inorder]

    first element in the preorder will be our root.
    Find the root in inorder
    Inorder - left subsequence to the inorder will be our left subtree and right index to the inorder will be our right
    subtree.
    Preorder - from next element to the root to length of left subsequence in inorder will be our preorder for left
    subtree, and similarly we will have our right subtree preorder after our left subtree preorder.

    This gives us a repeated subproblem so we call our recursion on it.
    """
    rootIdx = - 1

    def buildTree1(self, preorder, inorder):
        n = len(preorder)
        if n == 0:
            return None
        root = TreeNode(preorder[0])
        # find root in inorder - unique values - O(N)
        for i in range(n):
            if inorder[i] == root.val:
                self.rootIdx = i
                break
        # creating left tree (subsequence) and right tree (subsequence) of both inorder and preorder - O(N)
        inLeft = inorder[: self.rootIdx]
        inRight = inorder[self.rootIdx + 1:]
        preLeft = preorder[1:len(inLeft) + 1]
        preRight = preorder[1 + len(preLeft):]

        # call recursion on left and right
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root

    """
    Ideation - Using Hashmap O(N)
    
    We can reduce the time of finding the root in Inorder for each element in the tree by adding it to hashmap.
    To make the TC O(N), we need to also reduce generating sub arrays for inorder and preorder.
    So what we can do is, once you know the index of the root, you can make recursive call for left and right by sending
    the index, start and end, in the recursion. 
    Also increment preorder index by 1 after each node is visited. Doing so in preorder, we keep going to left, left
    then right, which is what preorder does. Refer lecture if it doesn't make sense.
    """

    def buildTree(self, preorder, inorder):
        n = len(preorder)
        self.preIdx = 0
        if n == 0:
            return None

        # create hashmap to store inorder elements
        map = {}
        for i in range(n):
            if inorder[i] not in map:
                map[inorder[i]] = i
        return self.helper(preorder, map, 0, n - 1)

    # start and end for inorder
    def helper(self, preorder, map, startI, endI):
        if startI > endI:
            return None

        curr = preorder[self.preIdx]
        root = TreeNode(curr)
        self.preIdx += 1

        rootIdx = map[curr]

        root.left = self.helper(preorder, map, startI, rootIdx - 1)
        root.right = self.helper(preorder, map, rootIdx + 1, endI)

        return root


preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]
root = Solution().buildTree(preorder, inorder)
print(root)
