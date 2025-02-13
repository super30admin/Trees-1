# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC : O(h^2)
# SC: O(h^2)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        hashv = {}
        index = 0
        for i in range(len(inorder)):
            hashv[inorder[i]] = i

        
        def createTree(preorder, start, end):
            nonlocal index
            # base
            if start > end:
                return None

            # logic
            rootval = preorder[index]
            index = index +1
            root = TreeNode(rootval)
            rootindex = hashv[rootval]
            root.left = createTree(preorder,start, rootindex - 1 )
            root.right = createTree(preorder,rootindex +1, end)

            return root
        return createTree(preorder, 0 , len(preorder) - 1 )

            


      

