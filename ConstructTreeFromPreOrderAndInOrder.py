# Time Complexity :
# O(n)


# Space Complexity :  
# O(n) 


# Approach:
# Using Hashmap and Binary tree basics to construct the tree iteratively.
# Use recusion to look for left and right sub-tree after constructing given node.



class Solution:
    def __init__(self):
        self.map = {}
        self.index = 0

    def treeBuilder(self, preorder, start, end):
        if start > end:
            return None
        rootval = preorder[self.index]
        self.index += 1
        root = TreeNode(rootval)
        rootIndex = self.map[rootval]
        root.left = self.treeBuilder(preorder, start, rootIndex - 1)
        root.right = self.treeBuilder(preorder, rootIndex + 1, end)
        return root

    def buildTree(self, preorder, inorder):
        if not preorder or not inorder:
            return None
        self.index = 0
        self.map = {val: idx for idx, val in enumerate(inorder)}
        return self.treeBuilder(preorder, 0, len(inorder) - 1)