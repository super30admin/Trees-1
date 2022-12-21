# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0
    myMap = dict()

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if inorder == None or preorder == None or len(inorder) == 0:
            return None

        for i in range(len(inorder)):
            self.myMap[inorder[i]] = i
        # print(myMap)
        return self.recurse(preorder, inorder, 0, len(preorder)-1)

    def recurse(self, preorder: List[int], inorder: List[int], start, end):

        # base
        if start > end:
            return None

        # logic
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        print(rootVal)
        rootIdx = self.myMap[rootVal]

        root.left = self.recurse(preorder, inorder, start, rootIdx-1)
        root.right = self.recurse(preorder, inorder, rootIdx+1, end)

        return root
