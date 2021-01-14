# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 
    #Solution 1
    def isValidBST(self, root: TreeNode) -> bool:
        #Approach: recursive; uses the min-max constraints over nodes in BST
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, h is the height of the BST
        
        return self.isValid(root, None, None)
    
    def isValid(self, root, minimum, maximum):
        #base
        if not root:
            return True
        
        #logic
        if minimum != None and root.val <= minimum:
            return False
        if maximum != None and root.val >= maximum:
            return False
        
        return (self.isValid(root.left, minimum, root.val) and 
                self.isValid(root.right, root.val, maximum))
        
    
    #Solution 2
    """
    def isValidBST(self, root: TreeNode) -> bool:
        #Approach: iterative; but exactly the same under the hood as solutions 3 and 4
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, h is the height of the BST
        
        st = []
        prev = None
        while root or st:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            if prev and prev.val >= root.val:
                return False
            prev = root
            root = root.right
            
        return True
    """
    
    #Solution 3
    """
    def isValidBST(self, root: TreeNode) -> bool:
        #Approach: recursion; returns validity of BST at that node
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, h is the height of the BST
        
        if not root:
            return True
        
        self.prev = None
        return self.inorder(root)
    
    def inorder(self, root):
        #base
        if not root:
            return True
        
        #logic
        #if we always return, the control won't go to code below
        #but we still have to check the right side if True
        if self.inorder(root.left) == False:
            return False
        
        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root
        
        return self.inorder(root.right)
    """
    
    #Solution 4
    """
    def isValidBST(self, root: TreeNode) -> bool:
        #Approach: recursion; void - returns nothing; but otherwise the same as solution 3
        #Time Complexity: O(n)
        #Space Complexity: O(h)
        #where, h is the height of the BST
        
        if not root:
            return True
        
        self.isValid = True
        self.prev = None
        
        self.inorder(root)
        return self.isValid
        
    def inorder(self, root):
        #base
        if not root:
            return
        
        #logic
        self.inorder(root.left)
        
        if self.prev and self.prev.val >= root.val:
            self.isValid = False
            #will still get the correct answer if we comment the return out
            #will just traverse through the entire tree each time
            return 
        
        self.prev = root
        
        self.inorder(root.right)
    """