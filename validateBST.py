# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Using recursion
# Time complexity - O(n)
# Space complexity - O(h) recursive stack
# Did this solution run on leetcode? - yes
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        def validBST(node, minval, maxval):
            if not node:    # base case, if not does not exists, return True.
                return True
            elif node.val <= minval or node.val >= maxval:  # check whether the node value lies within the bound.
                return False
            # check whether the left and right subtree is a valid subtree.
            return validBST(node.left, minval, node.val) and validBST(node.right, node.val, maxval) 
        
        minval, maxval = float('-inf'), float('inf')
        # edge case
        if not root: return True
        # check if the tree is a valid tree.
        return validBST(root, minval, maxval)
    
    
# Iterative approach
# Time complexity - O(n)
# Space complexity - O((n/2)+1) = O(n)
from collections import deque
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # keep node, min val and max val (bounds of the node)
        nodeq = deque([(root, float('-inf'), float('inf'))])
        
        while nodeq:
            node, minval, maxval = nodeq.popleft()
            # if the node is not in the bounds, return False
            if node.val <= minval or node.val >= maxval: return False
            # traverse to the left child
            if node.left:
                nodeq.append((node.left, minval, node.val))
            # traverse to the right child
            if node.right:
                nodeq.append((node.right, node.val, maxval))
        
        return True
    
    
# Inorder traversal
# Time complexity - O(n)
# Space complexity - O(h)
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        nodeStack = deque() # using stacks
        minval = float('-inf')
        while root or nodeStack:
            # traverse till the left child 
            while root:
                nodeStack.append(root)
                root = root.left
        
            # pop the topmost element out of the stack
            root = nodeStack.pop()
            if root.val > minval:
                minval = root.val
            else:
                return False
            root = root.right # check the right node of the current node
        return True

# Recursive Inorder traversal
# time complexity - O(n)
# space complexity - O(h)
# cannot use a local minval variable here. 
# ex - [1,2,3]
# stack has [(1, null), (2, null)]
# so when we pop out the values, the previous value of 1 is null instead of 2.  
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.minval = float('-inf')
        
        def validNode(node):
            if not node:
                return True
            
            # traverse to the left child
            if not validNode(node.left):
                return False
            
            if node.val <= self.minval:
                return False
            self.minval = node.val
            
            # traverse to the right child
            return validNode(node.right)
           
        return validNode(root)
    