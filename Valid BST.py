#// Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No because i attended the class and then did the solution



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        flag = True
        def inorder(root,mini,maxi):
            nonlocal flag
            if root == None:
                return
            
            if mini != None and root.val <= mini:
                flag = False
            if maxi != None and root.val >= maxi:
                flag = False
            
            inorder(root.left,mini,root.val)
            inorder(root.right,root.val,maxi)
        
        inorder(root,None,None)

        return flag
    

# Approach
# 1. We will use the inorder traversal of the tree to check if the tree is a valid BST
# 2. We will use a global variable flag to check if the tree is a valid BST
# 3. We will use a helper function inorder(root,mini,maxi) to traverse the tree in
# order and check if the tree is a valid BST
# 4. We will pass the root of the tree, the minimum value and the maximum value to the
# helper function inorder(root,mini,maxi)

# the intution here is that the left child should be in the range min should be parents minumum and the maximum shoulld be parents value
# and for the right child the the minimum is parents value and the maximum is the parents maximum 