""" Explanation: We first recursively get the root of the bst, in the inorder traversal manner. Then we simply check if those values
    traversed are in the ascending order. 
    Time Complexcity: O(n)
    Space Complexcity: O(1)
    Code Passed All cased on LC: Yes
"""



# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def is_valid_inorder(node, prev_value):
            if not node:
                return True
            
            # Traverse left subtree
            if not is_valid_inorder(node.left, prev_value):
                return False
            
            # Visit the current node
            if node.val <= prev_value[0]:
                return False
            
            prev_value[0] = node.val  # Update the previous value
            
            # Traverse right subtree
            return is_valid_inorder(node.right, prev_value)
        
        # Initialize the previous value with negative infinity
        prev_value = [float('-inf')]
        
        # Check if the in-order traversal is valid
        return is_valid_inorder(root, prev_value)
        