# Time Complexity: O(n^2) solution because we are doing a linear search on inorder array to find the index of the root
# Space Complexity: O(n) 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # return self.helper(preorder, inorder)
        map_inorder = dict()
        for index,val in enumerate(inorder):
            map_inorder[val] = index
        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, map_inorder)

    def helper(self, preorder, prestart, preend, inorder, instart, inend, map_inorder):
        #base
        # if len(preorder) == 0:
        #     return None
        if prestart > preend or instart > inend:
            return None
        #logic
        rootVal = preorder[prestart]
        rootidx = map_inorder[rootVal]
        root = TreeNode(rootVal)
        num_left = rootidx - instart
        root.left = self.helper(preorder, prestart + 1, prestart + num_left,inorder, instart, rootidx - 1, map_inorder)
        root.right = self.helper(preorder, prestart + num_left + 1, preend, inorder, rootidx + 1, inend, map_inorder)
        return root
        # root = TreeNode(preorder[0])

        # rootIdx = -1
        # # Search is taking O(n)
        # for i in range(len(inorder)):
        #     if inorder[i] == root.val:
        #         rootIdx = i
        #         break
        # # Use HashMap in O(1)

        # # We are making deep copy of element O(n)
        # inleft = inorder[:rootIdx]
        # inright = inorder[rootIdx+1:]

        # preleft = preorder[1:rootIdx+1]
        # preright = preorder[rootIdx+1:]

        # root.left = self.helper(preleft, inleft)
        # root.right = self.helper(preright, inright)
        # return root