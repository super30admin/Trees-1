# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

# Time Complexity: O(n^2)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if len(preorder) == 0:
            return None
            
        rootVal = preorder[0]
        rootIdx = -1

        for i, num in enumerate(inorder):
            if num == rootVal:
                rootIdx = i

        inleft = inorder[0:rootIdx]
        inright = inorder[rootIdx+1:len(inorder)]
        preleft = preorder[1:len(inleft)+1]
        preright = preorder[1+len(inleft):len(preorder)]

        root = TreeNode(rootVal)
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)

        return root
    
# Time Complexity: O(n)

# Use a hashmap to store the value and index of inorder array. We will maintain a global pointer idx for preorder list.
# For every subtree, preorder will provide us the root. Preorder[idx] will be the root and then idx ++. The idx poiinter 
# pointing to the idx in hm will be a rootIdx. We need the rootIdx to calculate start and end for left and right subtrees.
# For left, start = same, end = rootIdx -1. For right subtree, start = rootIdx +1, end = same

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0
    hm = {}
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        for i, num in enumerate(inorder):
                self.hm[num] = i
        return self.helper(preorder, 0, len(inorder)-1)


    def helper(self, preorder, start, end):

        if start > end:
            return None

        rootVal = preorder[self.idx]
        self.idx = self.idx + 1

        rootIdx = self.hm[rootVal]

        root = TreeNode(rootVal)
        root.left = self.helper(preorder, start, rootIdx-1)
        root.right = self.helper(preorder, rootIdx+1, end)

        return root



        