"""
Problem 2

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Time Complexity : O(N^2)
        Space Complexity : O(N)
        """
        if len(preorder) == 0 or len(inorder) == 0: return None
        # the first element in the preorder list will always be the root 
        root = TreeNode(preorder[0])
        
        
        # finding the index of root value in the inoder list 
        index = inorder.index(preorder[0])
                
        # dividing the two array list in 4 sub parts for recursive calls
#         pre_left = preorder[1: index + 1]
#         in_left = inorder[0: index]
#         pre_right = preorder[index + 1: len(preorder)]
#         in_right = inorder[index + 1: len(inorder)]
        
        # recursive call to build the tree
        root.left = self.buildTree(preorder[1: index + 1], inorder[0: index])
        root.right = self.buildTree(preorder[index + 1: len(preorder)], inorder[index + 1: len(inorder)])
        
        return root
                            
# Approach - 2
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        Using hash_map for searching the index of the root node and moving one place behind the root value position 
        in preorder list for left tree and for right moving one place ahead.
        Time Complexity: O(N)
        Sapce Complexity : O(1)
        """
        self.index = 0
        self.index_map = {}
        for i in range(len(inorder)):
            self.index_map[inorder[i]] = i
            
       
      
        def helper(start, end):
            # if the list gets empty
            if start > end:
                return None

            # creating node with the index element
            root = TreeNode(preorder[self.index])

            self.index += 1

            # Building left and right subtree
            root.left = helper(start, self.index_map[root.val] - 1)
            root.right = helper(self.index_map[root.val] + 1, end)

            return root
        
        return helper(0, len(preorder) - 1)
        
        
            
        
        
        
              
        
            
        
        
        
        