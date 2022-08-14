"""
Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
"""

class Solution:
    def isValidBST(self, root) -> bool:
        """
        Validate BST using stack. traversing left child first then right child of a node.
        Time Complexity: O(N)
        Space COmplexity: O(H),  H height of the tree
        Note: if it is a skewed tree it will be O(N), number of nodes.
        If it is a perfectly balanced BSt then O(logN)
        """
        if root is None: return True
        prev = None
        st = []
        
        
        while st and root:
            while root is not None:
                st.append(root.val)
                root = root.left
            
            root = st.pop()
            
            if (prev != None and prev <= root):
                return False
            
            prev = root
            
            root = root.right
            
        return True

# Approach - 2 
class Solution:
    def isValidBST(self, root) -> bool:
        """
        Inorder Recursion
        Time Complexity: O(N)
        Space Complexity:O(N)
        """
        self.prev = None
        self.flag = True
        def inorder_traversal(root):
            # base Condition 
            if root is None:
                return
            if self.flag:
                inorder_traversal(root.left)
                
            if(self.prev != None and self.prev.val >= root.val):
                self.flag = False
                
            self.prev = root
            if self.flag:
                inorder_traversal(root.right)
            
        inorder_traversal(root)   
        return self.flag

# Approach - 3 (optimized solution)
class Solution:
    def isValidBST(self, root) -> bool:
        """
        Recursive approach with valid range. Comparing root.val with low value and high value.
        Time Complexity: O(N)
        Space Complexity:O(N)
        """
        
        def helper(root, low = float("-inf"), high = float("inf")):
            if root is None: return True
            
            if root.val <= low or root.val >= high:
                return False
            
            return (helper(root.left, low, root.val)and helper(root.right, root.val, high))
        
        return helper(root)
       
