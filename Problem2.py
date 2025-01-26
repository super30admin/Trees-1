# "1. We use preorder to find the index of root and split right and left in the inorder array and recursively update root
# 2. Hashmap approach: store inorder array in a hashmap with it's index. Get root idx from the hashmap and recursively update and construct root"
# TC: O(N)
# SC: O(H)
# Yes this worked in Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    rootidx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        self.rootidx = 0
        self.rootmap = {val:idx for idx, val in enumerate(inorder)}
        return self.createTree(preorder, 0, len(inorder) - 1)
    
    def createTree(self, preorder, start, end):
        if start > end:
            return None
        rootval = preorder[self.rootidx]
        self.rootidx += 1
        root = TreeNode(rootval)
        inoidx = self.rootmap[rootval]
        root.left = self.createTree(preorder, start, inoidx - 1)
        root.right = self.createTree(preorder, inoidx + 1, end)
        return root
    




        # root = TreeNode(preorder[0])
        # rootidx = inorder.index(root.val)
        # # for i in range(len(inorder)):
        # #     if inorder[i] == root.val:
        # #         rootidx = i
        # #         break
        # inorderleft = inorder[:rootidx]
        # inorderright = inorder[rootidx+1:]
        # preorderleft = preorder[1:rootidx+1]
        # preorderright = preorder[rootidx+1:]
        # root.left = self.buildTree(preorderleft, inorderleft)
        # root.right = self.buildTree(preorderright, inorderright)

        # return root
