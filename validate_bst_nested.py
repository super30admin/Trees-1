# Time Complexity : O(N) when N is number of nodes in the tree
# Space Complexity : O(1)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.is_valid = True
        self.prev = None
        
        def inOrder(curr):
            #Base Condition
            if curr == None:
                return

            #Logic
            #Exploring left subtree
            inOrder(curr.left)

            #Printing current node 
    
            if self.prev != None and self.prev >= curr.val:
                self.is_valid = False

            self.prev = curr.val

            #Exploring left subtree
            inOrder(curr.right)
        
        inOrder(root)
        
        return self.is_valid