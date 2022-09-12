# ## Problem 2

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Given preorder and inorder traversal of a tree, construct the binary tree.



# Note:
# You may assume that duplicates do not exist in the tree.

# Can you do it both iteratively and recursively?

# For example, given

# preorder = [3,9,20,15,7]


# inorder = [9,3,15,20,7]
# Return the following binary tree:

#    3


#    / \


#   9  20


#     /  \


#    15   7

# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid+1:])
        
        return root
