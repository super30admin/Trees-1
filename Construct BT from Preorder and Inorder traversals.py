# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        #Approach: Recursive
        #Time Complexity: O(n)
        #Space Complexity: O(n) // for inorder hashmap
        #where, n is the length of the list
        
        #edge
        if len(preorder) == 0:
            return None
        
        self.idx = 0
        self.inorder_map = {} #val -> index
        for i in range(len(inorder)):
            self.inorder_map[inorder[i]] = i
            
        return self.helper(preorder, 0, len(preorder) - 1)
    
    def helper(self, preorder, start, end):
        #base
        if start > end:
            return None
        
        #logic
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        
        rIdx = self.inorder_map[rootVal]            #rootIndex in inorder
        root.left = self.helper(preorder, start, rIdx - 1)
        root.right = self.helper(preorder, rIdx + 1, end)
        
        return root
    
    #Solution 2
    """
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        #Approach: Brute-force recursive
        #Time Complexity: O(n^2) // finding idx in every recursion call
        #Space Complexity: O(n^2) // in/pre-Arrays in every recursion call
        #where, n is the length of the list
        
        #edge / base
        if len(preorder) == 0:
            return None
        
        #logic
        rootVal = preorder[0]
        root = TreeNode(rootVal)
        
        idx = inorder.index(rootVal)
        
        inLeft = inorder[:idx]
        inRight = inorder[idx + 1:]
        preLeft = preorder[1:idx + 1]
        preRight = preorder[idx + 1:]
        
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root
    """