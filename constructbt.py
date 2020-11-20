# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# By creating the copy of preorder and inorder array on the left and right subtrees.
# Time complexity - O(n^2) for every node in preorder array, we are traversing the inorder array 
# Space complexity - O(2n)+O(h) // O(h) recursive stack and O(2n) for creating array copies
# Did this solution run on leetcode? - yes
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # Base case
        if len(preorder)==0:
            return None
        
        # Logic
        node = TreeNode(preorder[0])
        
        # find the index of the root node in the inorder array
        for idx in range(len(inorder)): 
            if preorder[0] == inorder[idx]:
                break
        
        # add the subtrees to the left and right child.
        node.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
        node.right = self.buildTree(preorder[idx+1:], inorder[idx+1:])
        
        return node
    
# Time complexity - O(n+) // O(n) for creating hash map
# Space complexity - O(n)
'''
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    # element: location
    inHash = {9:0, 3:1, 15:2, 20:3, 7:4}
'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        inHash = dict()
        for i, val in enumerate(inorder):
            inHash[val] = i
        self.index = 0
        
        def createTree(preorder, inorder, start, end):
            # base case
            if start > end or self.index == len(preorder):
                return None
            
            # create Tree Node
            node = TreeNode(preorder[self.index])
            
            # find index of element in inorder list using location information in the hash map.
            idx = inHash[node.val]
            
            self.index += 1
            
            # create left and right subtree.
            node.left = createTree(preorder, inorder, start, idx-1)
            node.right = createTree(preorder, inorder, idx+1, end)
            
            return node
        
        return createTree(preorder, inorder, 0, len(preorder)-1) 
