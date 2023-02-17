#All TC on leetcode passed

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    #Here we follow inorder traversal approach and check each time if prev node val is greater than cur node val. If yes return False. If not continue.
    #Another approach is checking the upper and lower ranges for each node.
    #Time complexity: O(2n) -> O(n) -> where n is total no. of nodes. Because each node is visited twice
    #Space complexity: O(h) -> where h is the height of tree because at any time the max no. of nodes in the stack is equal to ht of tree
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True

        def helper(root, minV, maxV):
            if not root:
                return
            
            if root.val<=minV or root.val>=maxV:
                self.flag = False
            
            helper(root.left, minV, root.val)
            helper(root.right, root.val, maxV)
        
        helper(root, -math.inf, math.inf)
        return self.flag

            
#-----------------------------------OR---------------------------------------------

        #Boolean Recurrsive range check approach
        def helper(root, minV, maxV):
            if not root:
                return True

            if root.val<=minV or root.val>=maxV:
                return False

            left = helper(root.left, minV, root.val)
            right = helper(root.right, root.val, maxV)

            return left and right
        
        return helper(root, -math.inf, math.inf)


#--------------------------------------OR------------------------------------------
        
        #Iterative range check approach
        stack = []
        stack.append([root, -math.inf, math.inf])

        while stack:
            root, minV, maxV = stack.pop()

            if minV>=root.val or root.val>=maxV:
                return False

            if root.left:
                stack.append([root.left, minV, root.val])
            
            if root.right:
                stack.append([root.right, root.val, maxV])

        return True


#-------------------------------------OR-----------------------------------------

        #Iterative inorder
        stack = []
        prev = None

        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev and prev.val>=root.val:
                return False
            
            prev = root
            root = root.right
        
        return True

#---------------------------------------------OR----------------------------------

        #void recurrsive inorder
        self.flag = True
        self.prev = None

        def inorder(root):
            if not root:
                return
            
            inorder(root.left)

            if self.prev and self.prev.val>=root.val:
                self.flag = False
            self.prev = root

            inorder(root.right)

        inorder(root)
        return self.flag


#-----------------------------------------OR---------------------------------------

        #boolean recurrsive inorder
        def inorder(root):
            if not root:
                return True
            
            left = inorder(root.left)

            if self.prev and self.prev.val>=root.val:
                return False
            self.prev = root

            right = inorder(root.right)

            return left and right
        
        self.prev = None
        return inorder(root)


#------------------------------------OR--------------------------------------------

        stack = [(-math.inf, root, math.inf)]
        
        while stack:       
            l,node,r = stack.pop()
                
            if node.val<=l or node.val>=r:
                return False
            
            if node.left:
                stack.append((l,node.left,node.val))
            if node.right:
                stack.append((node.val,node.right,r))
        
        return True
        
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
                