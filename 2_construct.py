# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hashmap = {}  # contain index of inorder
        self.ptr = 0  # this pointer will traverse the preorder list

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        '''
        Method 1: Brute Force
        time complexity : O(n)
        Space Complexity : O(n)

        logic:
        - preorder first element will be root of the tree.
        - find that element in inorder list. Left part will construct left tree
        - right part of inorder list will be right side of the tree.
        '''
        # hash map
        self.hashmap = {}
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i

        return self.Tree(inorder, preorder, 0, len(preorder) - 1)

    def Tree(self, inorder, preorder, start, end):
        # base case
        if self.ptr == len(preorder) or start > end:
            return None

        # root value
        root_val = preorder[self.ptr]

        # get index
        idx = self.hashmap[preorder[self.ptr]]

        # tree
        root = TreeNode(root_val)
        self.ptr += 1

        # left tree
        root.left = self.Tree(inorder, preorder, start, idx - 1)

        # right Tree
        root.right = self.Tree(inorder, preorder, idx + 1, end)

        return root