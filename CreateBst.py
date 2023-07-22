# Create Bst (validate bst code at 135 line)
# Time complexity: O(n)
# Space complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return True

    def inorder(self, root: TreeNode):
        # base case
        if root is None: return
        # stack.push ->root
        self.inorder(root.left)
        # stack.pop ->root
        print("up",root.val)
        # stack.push ->root
        self.inorder(root.right)
        # stack.pop ->root
        print("down",root.val)


#inorder traversal (left , root, right)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        print(l)
        return True


    def inorder(self, root: TreeNode):
        # base case
        if root is None: return
        self.inorder(root.left)
        l.append(root.val)      #changing this line above and below makes preorder and post order
        #print("up",root.val)
        self.inorder(root.right)
        #print("down",root.val)

l = []

#preorder traversal(root, left , right)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        print(l)
        return True


    def inorder(self, root: TreeNode):
        # base case
        if root is None: return
        l.append(root.val) 
        self.inorder(root.left)
        
        #print("up",root.val)
        self.inorder(root.right)
        #print("down",root.val)

l = []


# postorder traversal( left, right, root)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        print(l)
        return True


    def inorder(self, root: TreeNode):
        # base case
        if root is None: return
        
        self.inorder(root.left)
        
        #print("up",root.val)
        self.inorder(root.right)
        l.append(root.val)
        #print("down",root.val)

l = []



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)

        return True


    def inorder(self, root: TreeNode):
        # base case
        if root is None: return
        #.
        self.inorder(root.left)
        #.
        self.inorder(root.right)
        print(root.val)  #.
        

l = []


###################################
# Time complexity: O(n)
# Space complexity: O(h) h : height of tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.inorder(root)
        return self.flag
    def inorder(self, root: TreeNode):
        # base
        if root == None : 
            return

        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root
       
        self.inorder(root.right)
       
    
    
    
# approach2
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right



# left (-inf, root)
# right (root, inf)
class Solution:
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        return self.inorder(root, None, None)
        
    def inorder(self, root: TreeNode, minimum : int, maximum : int):
        # base
        if root == None : 
            return True
        if maximum != None and maximum <= root.val:
            return False
        if minimum != None and minimum >= root.val:
            return False

        left = self.inorder(root.left, minimum ,root.val)
           
       
        right = self.inorder(root.right,root.val, maximum)
        return left and right

        #if not self.inorder(root.left, minimum ,root.val):
        #    return False
       
        #return self.inorder(root.right,root.val, maximum)
            
       
    
        