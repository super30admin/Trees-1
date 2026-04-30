# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n)
# Space Complexity --> O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        n = len(preorder)
        self.idx = 0
        hmap = {}
        for i in range(len(inorder)):
            hmap[inorder[i]] = i 
        return self.helper(preorder, 0, n-1, hmap) 

    def helper(self, preorder, st, end, hmap):
        # base
        if st>end:
            return None
        # logic
        root_val = preorder[self.idx] 
        self.idx += 1
        root_idx = hmap[root_val]
        root = TreeNode(root_val)

        root.left = self.helper(preorder, st, root_idx-1, hmap)
        root.right = self.helper(preorder, root_idx+1, end, hmap)

        return root

'''
# Time Complexity --> O(n^2)
# Space Complexity --> O(n^2)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0:
            return None
        root_val = preorder[0]
        hmap = {}
        for i in range(len(inorder)):
            hmap[inorder[i]] = i
        
        root_idx = hmap[root_val]

        inleft = inorder[:root_idx]
        inright = inorder[root_idx+1:]
        preleft = preorder[1:len(inleft)+1]
        preright = preorder[len(inleft)+1:]

        root = TreeNode(root_val)
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)

        return root 
'''
