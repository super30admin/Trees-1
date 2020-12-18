# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: Recursive using pointers

# In this approach we are going take the advantage of the way preorder and inorder traversal is done. If we obesrver closely, we can see that out of the give lists, first element in preorder list is the root. Now the elements towards left of the index at which root (found in preorder) makes up the left subtree and the elements towards the right of the root makes up the right tree.

# So at every recursive call we will find the left and right subtree elements in inorder and preorder and pass them as an argument. So the root's left would be the tree made up of left elements in preorder and inorder and same goes for the right subtree.

# Time complexity: O(n); n = length of the given list
# Space complexity: O(n); n = length of the given list

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.hmap = {}
        self.idx = 0
        
        if inorder == None or len(inorder) == 0:
            return None
        
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
            
        return self.helper(preorder, 0, len(inorder) - 1)
    
    def helper(self, preorder, start, end):
        if start > end:
            return None

        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        
        rootIdx = self.hmap[rootVal]
        
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)
        return root
        
        
        