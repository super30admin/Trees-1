# Leetcode problem link : https://leetcode.com/problems/validate-binary-search-tree/
# Time Complexity : O(n)
#  Space Complexity : O(n) fr recursive stack (basically max depth of tree)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n) => Recursion function by passing min and max for each call
    
        Iterative approach: O(n) => The intuition behind this approach is elements are sorted in inorder traversal for a valid BST. Hence we just need to tarverse the tree in inorder and make sure elemnt just before the current one is smaller that the current. If this condition fails then its not a valid BST
        1. Maintain a stack and keep pushing elements till the leftmost node.
        2. When there is no more left node left to push to stack, pop nodes from stack and go to its right. Again keep pushing the left elements of the current root
        3. Maintain a prev node which specifies the element before the current element in inorder traversal. Check if prev value is lesser than the current one. 
        
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursve solution
    # def isValidBST(self, root: TreeNode) -> bool:
    #     def helper(root,low=float('-inf'),high=float('inf')):
    #         if not root:
    #             return True
    #         value = root.val
    #         if not value > low or not value < high:
    #             return False
    #         return helper(root.left,low,value) and helper(root.right,value,high)
    #     return helper(root)
   
    # iterative solution
    def isValidBST(self, root: TreeNode) -> bool:
        # base case
        if not root:
            return True
        # 1
        stack = []
        # intialize a dummy tree node for comparison of the leftmost node in tree
        prev = TreeNode(float(-inf))
        # traverse till either stack has elements or root is pointing to a node
        while(stack or root):
            # keep going to leftmost node
            while root:
                stack.append(root)
                root = root.left
            # no more left elements then pop element from stack
            root = stack.pop()
            # valid bst will have sorted elements in inroder traversal
            if root.val <= prev.val:
                return False
            # initialize for next iteration
            prev = root
            
            # got to right as already explored left in prev while loop
            root = root.right
        # if reached here then its a valid bst
        return True