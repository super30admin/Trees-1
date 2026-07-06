#https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Time Complexity: O(n), We visit every node exactly once and each visit does constant work using dictionary lookup and a moving pointer
# Space Complexity: O(n), We use a dictionary of size n to store index positions and the recursion stack can go up to depth n in the worst case
# Approach: The first value in preorder is always the root of the current subtree so we read it using a pointer that moves forward
# We use a dictionary to instantly find where that root sits in inorder so we know how many nodes go to the left and right
# We always build the left subtree before the right subtree because reading preorder forward gives root then left side then right side

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # this dictionary will store the index of every value in inorder so we never have to search for it later
        self.map = {}

        # this pointer starts at the first index of preorder and will move forward as we build each root
        self.preorder_index = 0

        # fill the dictionary once so lookups later take constant time
        for i in range(len(inorder)):
            self.map[inorder[i]] = i

        # start building the tree using the full range of inorder, from index 0 to the last index
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        # if start has gone past end it means there are no elements left in this range so there is nothing to build
        if start > end:
            return None

        # the value at our current pointer position in preorder is always the root of this subtree
        root_value = preorder[self.preorder_index]

        # move the pointer one step forward so the next call reads the correct next value
        self.preorder_index += 1

        # look up where this root value sits in inorder so we know how to split left and right parts
        root_index = self.map[root_value]

        # create the node for this root value
        node = TreeNode(root_value)

        # build the left subtree first since reading preorder forward gives left side nodes before right side nodes
        node.left = self.helper(preorder, start, root_index - 1)
        # only after the left subtree is fully built do we build the right subtree
        node.right = self.helper(preorder, root_index + 1, end)

        # return this node with both children attached back to whoever called this
        return node
        