# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


'''
Solution 1: Void function based Recursion (Brute Force) - InOrder Traversal
Prev_node here is a datastruture in datastructure.
In-order will give us ascending order. We check if any point, the node is smaller 
than prev, then there is a breach
Time Complexity: O(N), N nodes, visiting each node 
space Complexity: O(h), h is the height of tree, (worst case can be equal to N). Recursive stack  
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None # previous Node parent
        self.flag = True # true represents valid 
        self.helper(root)
        
        return self.flag
    
    def helper(self,node):
        # base
        if node==None:
            return
        # logic
        # left traverse
        self.helper(node.left)
        if self.prev!=None and node.val<=self.prev.val:
            self.flag = False
        # update the prev parent/root node
        self.prev = node
        # right traverse
        self.helper(node.right)

'''
Solution 2: Void function based Recursion (Conditional) - InOrder Traversal
Prev_node here is a datastruture in datastructure.
In-order will give us ascending order. We check if any point, the node is smaller 
than prev, then there is a breach
Time Complexity: O(N), N nodes, visiting each node 
space Complexity: O(h), h is the height of tree, (worst case can be equal to N). Recursive stack  
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None # previous Node parent
        self.flag = True # true represents valid 
        self.helper(root)
        
        return self.flag
    
    def helper(self,node):
        # base
        if node==None or self.flag==False: # if breach has happened, no more recursion needed
            return
        
        # logic
        # left traverse
        self.helper(node.left)
        if self.prev!=None and node.val<=self.prev.val:
            self.flag = False
        # update the parent/root node to prev
        self.prev = node
        # right traverse
        self.helper(node.right)

'''
Solution 3: Bool function based Recursion (Brute Force) - InOrder Traversal
Prev_node here is a datastruture in datastructure.
In-order will give us ascending order. We check if any point, the node is smaller 
than prev, then there is a breach
Time Complexity: O(N), N nodes, visiting each node 
space Complexity: O(h), h is the height of tree, (worst case can be equal to N). Recursive stack  
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None # previous Node parent 
        return self.helper(root)
    
    def helper(self,node):
        # base
        if node==None:
            return True
        # logic
        # left traverse
        left_subtree = self.helper(node.left)
        if self.prev!=None and node.val<=self.prev.val:
            return False
        # update the prev parent/root node
        self.prev = node
        # right traverse
        right_subtree = self.helper(node.right)

        return left_subtree and right_subtree

'''
Solution 4: Bool function based Recursion (Conditional) - InOrder Traversal
Prev_node here is a datastruture in datastructure.
In-order will give us ascending order. We check if any point, the node is smaller 
than prev, then there is a breach
Time Complexity: O(N), N nodes, visiting each node 
space Complexity: O(h), h is the height of tree, (worst case can be equal to N). Recursive stack  
'''
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None # previous Node parent 
        return self.helper(root)
    
    def helper(self,node):
        # base
        if node==None:
            return True
        # logic
        # left traverse
        left_subtree = self.helper(node.left)
        if self.prev!=None and node.val<=self.prev.val:
            return False
        # update the prev parent/root node
        self.prev = node
        
        # right traverse
        right_subtree = False
        if left_subtree: # only traverse if left_subtree is valid BST
            right_subtree = self.helper(node.right)

        return left_subtree and right_subtree