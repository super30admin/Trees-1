
# In order traversal: Iterative
# TC & SC : O(N)
# We preserve prev node in a aux node to compare and check if it is less than the current. In order traversal of tree gives a ascending sequence. We check for break after each pop off the stack.
class Solution1:
    def isValidBST(self, root):
        if root == None: return root
        prev = None
        stack = []
        while root!= None or stack:
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev != None and prev.val >= root.val: return False
            prev = root
            root = root.right
            
        return True

# In Order Traversal: Recursive 
class Solution2:
    prev = None
    def isValidBST(self, root):
        if root == None: return root
        return self.inorder(root)
    
    def inorder(self, root):
        if root == None: return True
        if self.inorder(root.left) == False: return False
        if self.prev != None and self.prev.val >= root.val: return False
        self.prev = root
        return self.inorder(root.right)

# Root Value should be in between min and max values
# At each node we can ascertain min and max value range for it to be a BST. If any nodes fails- not BST
class Solution:
    def isValidBST(self, root):
        return self.isValid(root, None, None)
    
    def isValid(self, root, minValue, maxValue):
        if root == None: return True
        if minValue != None and root.val <= minValue: return False
        if maxValue != None and root.val >= maxValue: return False
        return self.isValid(root.left, minValue, root.val) and self.isValid(root.right, root.val, maxValue)
