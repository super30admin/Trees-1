# APPROACH 1: Intermediate solution
# Time Complexity : O(n^2), n: number of nodes
# Space Complexity : O(n^2), n: number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Current Root will always be the first element of the current preorder array.
# 2. Find the index of the root in inorder -> to know the left and right subtree elements.
# 3. Then recursively call the function with left and right subtree elements of both inorder and preorder

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        
        root_val = preorder[0]
        for ind in range(len(inorder)):
            if inorder[ind] == root_val:
                root_inorder_ind = ind
                
        preLeft = preorder[1 : root_inorder_ind + 1]
        preRight = preorder[root_inorder_ind + 1 : ]
        inLeft = inorder[ : root_inorder_ind]
        inRight = inorder[root_inorder_ind + 1 : ]
        
        root = TreeNode(root_val)
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        
        return root





# APPROACH 2: Optimal solution
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(n), n: number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None 
#
#
# Your code here along with comments explaining your approach
# 1. Instead of searching the root in inorder list each time, build a hashmap that stores the element and it's position as key and value respectively.
# 2. Instead of creating copies of array each time (left and right subtrees of preorder and inorder), maintain two pointers - start and end of inorder for current iteration.
# 3. Preorder is used only for obtaining the root and we dont need to know the left and right subtree from it

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.root_preorder_ind = 0
        self.hashmap_inorder = {}
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        
        for ind in range(len(inorder)):
            self.hashmap_inorder[inorder[ind]] = ind
            
        return self.helper(preorder, inorder, 0, len(inorder) - 1)
        
        
    def helper(self, preorder, inorder, start, end):
        if start > end:
            return
        
        root_inorder_ind = self.hashmap_inorder[preorder[self.root_preorder_ind]]
        self.root_preorder_ind += 1
        
        root = TreeNode(inorder[root_inorder_ind])
        root.left = self.helper(preorder, inorder, start, root_inorder_ind - 1)
        root.right = self.helper(preorder, inorder, root_inorder_ind + 1, end)
        
        return root
