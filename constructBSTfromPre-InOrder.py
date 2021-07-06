class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    # Time Complexity : O(n), where n is the length of preorder or inorder array.
    # Space Complexity : O(n^2), because at each node there are 4 new arrays made.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # for each number distinguish it's left and right subtrees in the
    # arrays by finding the parent iteratively from the inorder array.
    # Recursively call the function to recreate the subtrees for every node.
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        idx = -1
        # find index to differentiate left and right subtree of a node
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                idx = i
        # two arrays from preorder
        preLeft, preRight = preorder[1:idx + 1], preorder[idx + 1:]
        # two arrays from inorder
        inLeft, inRight = inorder[:idx], inorder[idx + 1:]
        # recursive calls to from left and right subtrees of each node
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        return root

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the length of preorder or inorder array.
    # Space Complexity : O(h), recursive stack space.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # For each number distinguish it's left and right subtrees in the
    # arrays by finding the parent stored in a hashmap, O(1) lookup.
    # Recreate the two subtrees for each node by passing in indices
    # to distinguish it's subtrees from the original array.
    def __init__(self):
        self.store = {}
        self.index = 0

    def buildTreeBetterSpace(self, preorder, inorder):
        for idx, elem in enumerate(inorder):
            self.store[elem] = idx
        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, start, end):
        # base case
        if start > end or self.index == len(preorder):
            return None
        # logic
        root = TreeNode(preorder[self.index])
        idx = self.store[root.val]
        self.index += 1
        root.left = self.helper(preorder, inorder, start, idx - 1)
        root.right = self.helper(preorder, inorder, idx + 1, end)
        return root
