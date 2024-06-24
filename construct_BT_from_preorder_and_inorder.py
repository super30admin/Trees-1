"""
Trees-1
Problem 2
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Time Complexity : O(n) which is storing hashmap or in worst case recursive stack space of h that has n elements.
Space Complexity : O(n) which is hashmap space.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to understand that root element will be at preorder and inorder indices can be stored using the hashmap. Now we can
iterate over the elements by keeping track of preorder index and along with finding root index and passing it's left part to
contruct left sub tree and it's right to construct right sub tree.
"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Brute force O(n^2) O(n^2) because at every n node we're making n copies so it is n^2
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:        
        if not preorder or len(preorder) == 0 or not inorder or len(inorder) == 0:
            return None

        root_val = preorder[0]
        root_node = TreeNode(root_val)
        root_idx = -1 

        for i in range(len(inorder)):
            if inorder[i] == root_val:
                root_idx = i
                break

        inorder_left = inorder[0:root_idx]
        inorder_right = inorder[root_idx+1:len(inorder)]
        preorder_left = preorder[1:root_idx+1]
        preorder_right = preorder[root_idx+1:len(preorder)]

        root_node.left = self.buildTree(preorder_left, inorder_left)
        root_node.right = self.buildTree(preorder_right, inorder_right)

        return root_node
        
# Optimal O(n)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:        
        if not preorder or len(preorder) == 0 or not inorder or len(inorder) == 0:
            return None

        self.hash_map = {}
        self.index = 0

        for i in range(len(inorder)):
            self.hash_map[inorder[i]] = i

        def recurse(preorder, start, end):
            #base
            if start > end:
                return None

            #logic
            root_val = preorder[self.index]
            self.index += 1
            root_node = TreeNode(root_val)
            root_idx = self.hash_map[root_val]

            root_node.left = recurse(preorder, start, root_idx - 1)
            root_node.right = recurse(preorder, root_idx + 1, end)
            return root_node

        return recurse(preorder, 0, len(preorder)-1)
    
