#time complexity: O(n). where n is the total no of nodes as we are traversing each node
#space complexity: O(h). where h is the height of the binary tree
    #because it is determined by the maximum depth of the recursion stack
    #in worst case where tree looks like a linked list the height is equal to n -> O(n)
    # in best case where it is perfectly balenced so -> O(log(n))


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
            #this is the helper function which takes the current node and minimum
        #and mximum allowed values for this node 
        def validate(node, min_val, max_val):
            #base case where tree is empty that is also a BST
            if not node:
                return True
            
            #checking if the current node value is between the min_val and max_val 
            #if it does not satisfy the property then it is not the BST
            
            #The edge cases to handle when node.val == float(-inf) or float(inf)
            
            #we don't need to worry because they provide initial bounds that are guarenteed
            #to be outside the range of any possible node.val
            if not (min_val < node.val < max_val):
                return False
            
            # Now we recursively validate left node for that
            #the min val becomes the miN_val only but the 
            #max_val becomes the value of the current node

            is_leftvalid = validate(node.left, min_val, node.val)

            #similarly for the riight node , min_val change to node.val

            is_rightvalid = validate(node.right, node.val, max_val)

            #the given BST with root node is valid only if its right and left bst is also valid
            #so both variables should return true for it to be valid

            return is_leftvalid and is_rightvalid

        return validate(root, float('-inf'), float('inf'))

        
