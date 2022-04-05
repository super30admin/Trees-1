# time Complexity : - O(n^2)
# Space Complexity : - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.startindex = 0
        self.preindex = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        endindex = len(inorder) - 1

        order = self.buildTreeacc(preorder, inorder, self.startindex, endindex)
        return order

    def buildTreeacc(self, preorder, inorder, startindex, endindex):

        ##Base condition
        if startindex > endindex:
            return None

        ##Recursive condition
        val = preorder[self.preindex]
        index = self.getindex(preorder, inorder, startindex, endindex, val)
        self.preindex += 1

        root = TreeNode(val)
        root.left = self.buildTreeacc(preorder, inorder, startindex, index - 1)
        root.right = self.buildTreeacc(preorder, inorder, index + 1, endindex)

        return root

    def getindex(self, preorder, inorder, startindex, endindex, val):

        for i in range(len(inorder)):
            if inorder[i] == val:
                return i

        return -1






