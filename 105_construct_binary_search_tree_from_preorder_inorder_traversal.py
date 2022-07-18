'''

## Problem 105: Construct binary tree from pre-order and in-order traversal

## Author: Neha Doiphode
## Date:   07-16-2022


## Description:
    Given two integer arrays preorder and inorder
    where preorder is the preorder traversal of a binary tree and i
    norder is the inorder traversal of the same tree,
    construct and return the binary tree.

## Examples:
    Example 1:
        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]

    Example 2:
        Input: preorder = [-1], inorder = [-1]
        Output: [-1]

## Constraints:
    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.

## Time complexity: O(n^2), n to build each node.
                            n to search the node in the list and copying each node.

## Space complexity: O(n^2), n times we build 4 auxiliary arrays.

'''

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def get_input():
    print("Enter list of tree nodes in in-order: ", end = "")
    inp_list = input()
    inorder = [int(val) for val in inp_list.split()]

    print("Enter list of tree nodes in pre-order: ", end = "")
    inp_list = input()
    preorder = [int(val) for val in inp_list.split()]

    return inorder, preorder


class Solution:
    lookup = {}
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0 or len(inorder) == 0:
            return None

        root_index = 0
        root_value = preorder[0]
        root = TreeNode(root_value)

        # To find where the root is located in inorder array we traverse inorder array
        # to find root index.
        # Hash  map can be used to search to improve time/optimize the solution
        for i in range(len(inorder)):
            if inorder[i] == root_value:
                root_index = i
                break

        # Now we would have to split inorder array around this index
        # to find the left sub-tree and right sub-tree
        inorder_left  = inorder[0:root_index]
        inorder_right = inorder[root_index + 1:]

        # Now we know lengths of left sub-tree and right sub-stree
        # So we should split pre-order based on sub-tree lengths
        preorder_left = preorder[1:root_index + 1]
        preorder_right = preorder[root_index + 1:]

        # Now, recursively call the build tree with left and right inorder and preorder trees.
        root.left  = self.buildTree(preorder_left, inorder_left)
        root.right = self.buildTree(preorder_right, inorder_right)

        return root

    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        # base case
        if start > end:
            return None

        # logic
        root_value = preorder[self.idx]
        self.idx += 1
        root = TreeNode(root_value)
        root_index = self.lookup[root_value]

        root.left = self.helper(preorder, inorder, start, root_index - 1)
        root.right = self.helper(preorder, inorder, root_index + 1, end)

        return root

    def buildTree_optimized(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        '''
        ## Time complexity: O(n), iterating n to build n nodes.

        ## Space complexity: O(n), auxiliary hash map to store n elements.
                                  O(h) to store recursive stack.
                                  since h < n we consider O(n).
        '''
        if len(preorder) == 0 or len(inorder) == 0:
            return None

        for index, num in enumerate(inorder):
            self.lookup[num] = index

        # Now call the helper function starting index and ending index
        return self.helper(preorder, inorder, 0, len(preorder) - 1)
