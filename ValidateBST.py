# Time Complexity :
# O(N)

# Space Complexity :  
# O(H)  ,  H = height of tree, recursion creates a stack where all nodes upto the left most child will be stored at max. 



# Approach:
# DFS Traversal of the tree. Keep track of previous node for eac node travelled,
# and return false wherever you found prev's value became greater than current node's value.


class Solution(object):
    prev = None
    isValid = True
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        
        self.inOrder(root)
        
        return self.isValid
        
    
    def inOrder(self, root):
        if root is None: # if not root
            return
        
        self.inOrder(root.left)

        #check with prev node
        if (self.prev and self.prev.val>=root.val):
            self.isValid = False
            return
        self.prev = root

        self.inOrder(root.right)