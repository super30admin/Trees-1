#Approach3: storing all elements from root to leftleaf in stack
# then popping it one by one from stack to check wether they satisfy validating BST criteria and checking same for right childs
#If no breach then returning it as Valid BST

#Time Complexity O(N) for traversing all TreeNodes
#Space Complexity O(h) height of tree which we will store in stack
#It successfully runs on the leetcode

#iterative (using physical stack but implementing it just like recursive idea)
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        prev, s = None, []
        while root or s:
            while root:
                s.append(root)
                root = root.left
            root = s.pop()
            if prev and root.val <= prev.val: return False
            prev = root
            root = root.right
        return True

#Approach2: Dividing valid BST into smaller sub problems.
# wether all the subtree are valid for that using recursive approach and prev pointer to keep track of node to be compared with
# checking all the nodes in tree comparing with that weather they are satisfying BST properties, and passing result to parents

#Time Complexity O(N) for traversing all TreeNodes
#Space Complexity O(h) height of tree (recursion call stack)
#It successfully runs on the leetcode
    
#Void return recursive
class Solution:
    prev = None
    isvalid= True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.isValid(root)
        return self.isvalid
    def isValid(self, root):
        if not root:
            return
        self.isValid(root.left)
        if self.prev and self.prev.val >= root.val: 
            self.isvalid = False
        self.prev = root
        if self.isvalid:
            self.isValid(root.right)

#Boolean Recursive
class Solution:
    prev = None
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isValid(root)
        
    def isValid(self, root):
        if not root:
            return True
        if not self.isValid(root.left): return False
        if self.prev and self.prev.val >= root.val: 
            return False
        self.prev = root
        return self.isValid(root.right)
        

#Approach1: Find the range for each node in the Tree, setting initial range as max negative for left and max positive for right
#later for left child: set max as that of root val, for right child set min as that of root val
#if there is a breach in range return False

#Time Complexity O(N) for traversing all TreeNodes
#Space Complexity O(h) height of tree (recursion call stack)
#It successfully runs on the leetcode

# by setting min max as null
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isvalid(root,None,None)
    
    def isvalid(self, root, left, right):
        if root:
            if (left!=None and root.val <= left) or (right!=None and root.val >= right): return False
            return self.isvalid(root.left, left, root.val) and self.isvalid(root.right, root.val, right) 
        return True
        
#by setting min max as infinity
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.isvalid(root,float("-inf"), float("inf"))
       
        
    def isvalid(self, root, left,right):
        if root:
            if root.val <= left or root.val >= right: return False
            return self.isvalid(root.left, left, root.val) and self.isvalid(root.right, root.val, right)
        return True
        