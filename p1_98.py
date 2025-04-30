# 98. Validate Binary Search Tree

# TC: O(n) where n is the number of nodes in the tree.
    # The algorithm visits each node exactly once during the in-order traversal.
    # Each node requires constant time operations (comparison and assignment).

# SC: O(h) where h is the height of the tree.
    # The recursion stack will have at most h function calls at any time, where h is the height of the tree.
    # In the worst case (a skewed tree), h = n, making the space complexity O(n).
    # In a balanced tree, h = log(n), making the space complexity O(log n).

# Approach: This solution uses an in-order traversal 
            # (left → root → right) to validate a Binary Search Tree (BST). 
            # In a valid BST, an in-order traversal will visit nodes in strictly increasing order.
            # The key insight is that we don't need to compare each node with every other node. 
            # Instead, we just need to verify that each node's value 
            # is greater than the previously visited node's value during the in-order traversal.

def helper(self, root):
    # Base case: empty tree is a valid BST
    if root is None:
        return True
        
    # Recursively check if left subtree is a valid BST
    if not self.helper(root.left):
        return False
        
    # Check BST property: current node's value must be greater than previous node's value
    # This works because in-order traversal visits nodes in ascending order in a valid BST
    if self.prev != None and self.prev.val >= root.val:
        return False
        
    # Update previous node to current node for future comparisons
    self.prev = root
    
    # Recursively check if right subtree is a valid BST
    return self.helper(root.right)
    
def isValidBST(self, root):
    # Initialize prev as instance variable (not class variable)
    # This ensures each validation gets a fresh prev value
    self.prev = None
    # Start the recursive validation from the root
    return self.helper(root)