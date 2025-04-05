# Time Complexity : O(n) -> n = number of tree nodes
# Space Complexity : O(logn) or height of BST || O(n) if BST is skewed
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Difficulty understanding different coding styles in recursion

# Approach:
# We observe that if we traverse the BST in an inorder fashion, all the elements will be in sorted form.
# We maintain 2 pointers, node and prev to keep track of the current node we're visiting and the previous node.
# If at any point, we encounter a node whose value is less than previous, it is a breach and not a valid BST.
# We set the flag as False.
# Finally, we return the flag.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # Initialize prev and flag to keep track of previous node and identify breach
    prev = None
    flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # call the recursive function to traverse the binary tree
        self.inorder(root)
        # Return flag
        return self.flag
    
    # Recursive function to traverse the binary tree
    def inorder(self, node):
        # If we encounter a node that is null, we cannot traverse any further, so return to the previous function call.
        if node == None:
            return
        # recursive call to the left child
        self.inorder(node.left)
        # When we are done traversing the left child we want to check if the current node is less than or equal to the previous node 
        if self.prev != None and node.val <= self.prev.val:
            # If it is <= previous node, we encountered a breach, so we want to set the flag as False.
            self.flag = False
        # When we have traversed the left child, we want to update the prev to the current node,
        self.prev = node
        # and then traverse the right child of the current node
        self.inorder(node.right)
        # This way, we are performing an in-order traversal.

# Approach:
# In this approach, we are checking if we already encounterd a breach before visiting the left and right child of a node.
# This way, we avoid traversing the sub-tree if a breach has already been identified, and we simply return.
class Solution:
    prev = None
    flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.flag

    def inorder(self, node):
        # Check if a node is null (leaf node) or if we already encounterd a breach
        if not node or not self.flag:
            # Return to previous function call in both cases
            # Thus we avoid visiting left and right children (sub-trees) if a breach has already been identified.
            return
        
        self.inorder(node.left)
        print(node.val)
        if self.prev != None and node.val <= self.prev.val:
            self.flag = False
        self.prev = node
        self.inorder(node.right)

# Approach:
# In this approach, we perform a boolean based recursion.
# We only traverse to the right sub-tree if the left sub-tree is true ie, a breach has not been encountered in the left sub-tree.
class Solution:
    prev = None
    flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root)

    def inorder(self, node):
        if not node:
            return True
        left = self.inorder(node.left)
        print(node.val)
        if self.prev != None and node.val <= self.prev.val:
            return False
        self.prev = node
        if left: right = self.inorder(node.right)
        return left and right
    
# Approcah:
# Here, we are passing the prev node as a local variable to the recursive function.
# If we want to maintain the state of a variable across the function call, we should have it as a global variable.
# However, a global behavior for a variable can be achieved when we pass it as another data structure eg: array as a local variable.
class Solution:
    # prev = None
    flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Here, we initialize prev as a local array
        # A data structure will be passed as the same reference in every function call.
        # Thus maintaining the state across all function calls
        prev = [None]
        return self.inorder(root, prev)
        # return self.flag

    def inorder(self, node, prev):
        if not node:
            return True
        if not self.inorder(node.left, prev):
            return False
        if prev[0] != None and node.val <= prev[0].val:
            return False
        # When we make changes to the prev, it goes to the reference and modifies the array present at that refernce.
        prev[0] = node
        # When we pass it as a local variable, the reference for it is passed and the reference preserves the current state of the variable (in case of an array)
        return self.inorder(node.right, prev)

# Approach:
# For each node, we can assume that it should lie between a minimum value and a maximum value.
# To start with, the root node will lie between -inf to +inf.
# When we go to the left child, the root's left child should be less than root, so it should lie betweem -inf to root.
# When we go to the right child, the root's right child should be greater than root, so it should lie between root to +inf.
# Thus, we conclude that whenever we move left, minimum = previous minimum and maximum = root.val
# And, whenever we move right, minimum = root.val and maximum = previous maximum.
# Now, since minimum and maximum depend solely on the root, and their state doesn't need to be maintained once they are travsesed, we can pass them as local variables.s
class Solution:
    flag = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.inorder(root, float('-inf'), float('inf'))

    def inorder(self, node, mn, mx):
        if not node:
            return True
        
        left = self.inorder(node.left, mn, node.val)

        if not (node.val > mn and node.val < mx):
            return False
        
        right = self.inorder(node.right, node.val, mx)

        return left and right
    
# Approach:
# Same logic as above, implemented using void based recursion
class Solution:
    # prev = None
    flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # prev = [None]
        self.inorder(root, float('-inf'), float('inf'))
        return self.flag

    def inorder(self, node, mn, mx):
        if not node:
            return
        self.inorder(node.left, mn, node.val)
        if not (node.val > mn and node.val < mx):
            self.flag = False
        # if prev[0] != None and node.val <= prev[0].val:
        #     return False
        # prev[0] = node
        self.inorder(node.right, node.val, mx)