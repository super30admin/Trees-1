# 105. Construct Binary Tree from Preorder and Inorder Traversal
"""
Time Complexity :  O(n)
Space Complexity : O(n)
Element from Preorder (left to right) will decide what will be curent root node
Left and right elements of current element(from preorder), will decide left children and right children.

root_index is obtained from inorder (dict is used to make search in O(1))
root_value is obtained from preorder



"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    d = dict()
    x = 0
    p_list = list()

    def helper(self, start, end):
        # base
        if start > end:
            return None
        # logic

        root_value = self.p_list[self.x]
        self.x = self.x + 1

        root = TreeNode(root_value)

        root_index = self.d.get(root_value)

        root.left = self.helper(start, root_index - 1)
        root.right = self.helper(root_index + 1, end)

        # final return
        # print(root.val)
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # null

        if len(preorder) == 0:
            return None

        for i in range(0, len(inorder)):
            self.d.update({inorder[i]: i})

        self.p_list = preorder
        start = 0
        end = len(inorder) - 1
        return self.helper(start, end)