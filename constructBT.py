# hashmap approach
# tc = O(n)
# sc = O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
        self.inorder_hashmap = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # base case
        if preorder is None or len(preorder) == 0 or len(inorder) == 0: return None

        # inorder_hashmap to store inorder values and indices as k-v pair
        for idx, val in enumerate(inorder):
            self.inorder_hashmap[val] = idx

        # helper method to build the tree
        # we traverse through inorder list to divide the list into left and rght subtrees
        # we traverse through preorder list to find root at every level
        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, start, end):
        # base
        if start > end: return None

        # logic
        # we dont do preorder[0] since root value keeps changing at every level
        rootVal = preorder[self.idx]  # --> to get the value of the root

        # increment the idx since root changes at every level - Root-L-R
        self.idx += 1

        root = TreeNode(rootVal)

        # find the index of the rootVal in inorder hashmap to futher divide into left and right subtrees in inorder list
        rootIdx = self.inorder_hashmap.get(rootVal)

        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)

        return root
