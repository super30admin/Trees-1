## Problem 1

# https://leetcode.com/problems/validate-binary-search-tree/


# Node class used to make the tree
class Node(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

# Method1: Using Inorder Traversal Concept to Validate BST. Brute Force Void based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using Inorder Traversal Concept to Validate BST. We know InOrder traversal of BST would always give sorted order. So instead of 
# storing the sorted order in a list and using two pointers to validate the list, we compare current and previous by keeping two pointers
# in the tree traversal itself. Keep a global variable prev to keep note of the previous node. If at any time (prev.val >= curr.val), it
# means it is not a valid BST and we update our global flag. Since we have not mentioned conditions to stop exploring nodes
# even when we got the invalid case, we would still be exploring all the nodes even when we have got a breach early in the traversal
# as we are not stopping the traversal in any case

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # valid BST global flag
        self.flag = True
        # one node previous to the current node. global variable
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # Method1: Using Inorder Traversal Concept
        # Inorder traversal of BST would always give a sorted list
        # Verifying elements of the sorted order using two pointers
        # on the tree traversal
        
        def helper(root):
            # base case
            if(root == None):
                return

            # logic: inorder
            helper(root.left)

            if(self.prev and (self.prev.val >= root.val)):
                self.flag = False

            self.prev = root

            helper(root.right)


        helper(root)
        return self.flag

sol = Solution()
print("Method1: Using Inorder Traversal Concept to Validate BST. Brute Force Void based Recursion")
root = Node(10)

node6 = Node(6)
root.left = node6
node15 = Node(15)
root.right = node15
node4 = Node(4)
node6.left = node4
node8 = Node(8)
node6.right = node8
node13 = Node(13)
node15.left = node13
node18 = Node(18)
node15.right = node18
node2 = Node(2)
node4.left = node2
node5 = Node(5)
node4.right = node2
node9 = Node(9)
node8.right = node9
node12 = Node(12)
node13.left = node12
node20 = Node(20)
node18.right = node20

def inOrder(root):
    if(not root):
        return
    
    inOrder(root.left)
    print(root.val, end=" ")
    inOrder(root.right)

print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method2: Using Inorder Traversal Concept to Validate BST. Conditional Void based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is same as above. Here we optimizing our recursion. If we got a breach or case where BST is not valid, then do not make
# any further recursive calls. In this way we can eliminate further exploration of nodes once the breach of BST has reached

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # valid BST global flag
        self.flag = True
        # one node previous to the current node. global variable
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # Method1: Using Inorder Traversal Concept
        # Inorder traversal of BST would always give a sorted list
        # Verifying elements of the sorted order using two pointers
        # on the tree traversal
        # Once breach has happened, dont make any further recursive calls
        
        def helper(root):
            # base case
            if(root == None):
                return

            # logic: inorder
            # only make further recursive calls if the breach has not happened yet
            if(self.flag):
                helper(root.left)

            if(self.prev and (self.prev.val >= root.val)):
                self.flag = False
            
            self.prev = root

            # only make further recursive calls if the breach has not happened yet
            if(self.flag):
                helper(root.right)


        helper(root)
        return self.flag

sol = Solution()
node4.right = node2
print("Method2: Using Inorder Traversal Concept to Validate BST. Conditional Void based Recursion")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method3: Using Inorder Traversal Concept to Validate BST. Brute Force Boolean based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is same as above. In place doing void based recursion and keeping a global flag, we are doing boolean based recursion here
# We return the result from our recursive functions. Here we would be exploring further nodes even when we have got an invalid BST
# case. This is equivalent to our Brute force void based recursion

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # valid BST global flag
        # self.flag = True
        # one node previous to the current node. global variable
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # Method1: Using Inorder Traversal Concept
        # Inorder traversal of BST would always give a sorted list
        # Verifying elements of the sorted order using two pointers
        # on the tree traversal
        # Once breach has happened, dont make any further recursive calls

        # boolean based recursion
        
        def helper(root):
            # base case
            if(root == None):
                return True

            # logic: inorder
            leftBSTCheck = helper(root.left)

            if(self.prev and (self.prev.val >= root.val)):
                # returns to the parent function
                return False
            
            self.prev = root

            rightBSTCheck = helper(root.right)

            return (leftBSTCheck and rightBSTCheck)


        return helper(root)

sol = Solution()
node4.right = node2
print("Method3: Using Inorder Traversal Concept to Validate BST. Brute Force Boolean based Recursion")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method4: Using Inorder Traversal Concept to Validate BST. Conditional Boolean based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is exactly the same. We can optimize our recursive calls by returning as soon as we got the breach or doing further recursive 
# calls only if we have not yet found any invalid case

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # valid BST global flag
        # self.flag = True
        # one node previous to the current node. global variable
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # Method1: Using Inorder Traversal Concept
        # Inorder traversal of BST would always give a sorted list
        # Verifying elements of the sorted order using two pointers
        # on the tree traversal
        # Once breach has happened, dont make any further recursive calls

        # boolean based recursion
        
        def helper(root):
            # base case
            if(root == None):
                return True

            # logic: inorder
            # if found breach here, return from here only
            if(not helper(root.left)):
                return False

            if(self.prev and (self.prev.val >= root.val)):
                # returns to the parent function
                return False
            
            self.prev = root

            # just check for right tree now
            return helper(root.right)


        return helper(root)

sol = Solution()
node4.right = node2
print("Method4: Using Inorder Traversal Concept to Validate BST. Conditional Boolean based Recursion")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method5: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Preorder
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here at any node we maintain the range of min and max value in which our current node value can lie. We start with keeping min = -infinity
# and max = +infinity for the root node. Then when go towards left child(child value < parent value) then min remains same and max = parent value.
# When go towards right child(child value > parent value) then max remains same and min = parent value. If the node lies out of that range then 
# it is not a valid BST. We keep min and max variables as input parameters of the recursion so that when the node function comes out of the stack
# it brings along with it its own min and max rather than bringing the min and max of the previous nodes. Also here we can choose any DFS traversal 
# inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the 
# recursive stack it will then bring its own min and max. Here I am doing preorder (root, left, right)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # global flag for validate BST
        self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try preorder (root, left, right)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None):
            return

        # logic
        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            self.flag = False

        # left call: min same, max = root.val
        self.helper(root.left, currMin, root.val)
        # right call: max same, min = root.val
        self.helper(root.right, root.val, currMax)



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root, float('-inf'), float('inf'))
        return self.flag
    
sol = Solution()
node4.right = node2
print("Method5: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Preorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))



# Method6: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Inorder
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is exactly same as above. We are just processing the nodes at the inorder level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # global flag for validate BST
        self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try inorder (left, root, right)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None):
            return

        # logic
        

        # left call: min same, max = root.val
        self.helper(root.left, currMin, root.val)

        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            self.flag = False
        
        # right call: max same, min = root.val
        self.helper(root.right, root.val, currMax)



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root, float('-inf'), float('inf'))
        return self.flag
    

sol = Solution()
node4.right = node2
print("Method6: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Inorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method7: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Postorder
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is exactly same as above. We are just processing the nodes at the inorder level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # global flag for validate BST
        self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try postorder (left, right, root)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None):
            return

        # logic
        

        # left call: min same, max = root.val
        self.helper(root.left, currMin, root.val)
        
        # right call: max same, min = root.val
        self.helper(root.right, root.val, currMax)

        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            self.flag = False



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root, float('-inf'), float('inf'))
        return self.flag
    
sol = Solution()
node4.right = node2
print("Method7: Using Min Max Algo to Validate BST. Brute Force Void based Recursion, Postorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method8: Using Min Max Algo to Validate BST. Conditional Void based Recursion, Preorder
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We can use any of the above DFS traversals and add condition to stop the recursion once we have got an invalid BST case. We can add the condition
# in base case or we can put it at the recursive calls as well

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        # global flag for validate BST
        self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try postorder (left, right, root)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None or (not self.flag)):
            return

        # logic
        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            self.flag = False
            # return

        # left call: min same, max = root.val
        # if(self.flag):
        self.helper(root.left, currMin, root.val)
        
        # right call: max same, min = root.val
        # if(self.flag):
        self.helper(root.right, root.val, currMax)



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root, float('-inf'), float('inf'))
        return self.flag
    

sol = Solution()
node4.right = node2
print("Method8: Using Min Max Algo to Validate BST. Conditional Void based Recursion, Preorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method9: Using Min Max Algo to Validate BST. Brute Force Boolean based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is same as before, we can use any DFS traversal here as well. Just instead of void based we are having boolean based recursion. 
# This is brute force as it going through all the nodes even when we have got the invalid BST case

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # def __init__(self):
        # global flag for validate BST
        # self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try postorder (left, right, root)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None):
            return True

        # logic
        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            return False

        # left call: min same, max = root.val
        # if(self.flag):
        leftValidateBST = self.helper(root.left, currMin, root.val)

        
        # right call: max same, min = root.val
        # if(self.flag):
        rightValidateBST = self.helper(root.right, root.val, currMax)


        return (leftValidateBST and rightValidateBST)



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.helper(root, float('-inf'), float('inf'))
        # return self.flag

sol = Solution()
node4.right = node2
print("Method9: Using Min Max Algo to Validate BST. Brute Force Boolean based Recursion, Preorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))


# Method10: Using Min Max Algo to Validate BST. Condition Boolean based Recursion
# Time Complexity : O(n) --- going through all the nodes
# Space Complexity : O(h) --- height of the tree, that would the max at any point in the recursion stack. 
# Space Complexity : Best case = O(logn) - balanced and complete binary search tree. Worst Case = O(n) - incase of skewed binary search tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Logic is same as before, we can use any DFS traversal here as well. Just instead of void based we are having boolean based recursion. 
# This is the conditional recursion, where we not exploring further nodes once we have got an invalid BST case

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # def __init__(self):
        # global flag for validate BST
        # self.flag = True
    
    # we can choose any traversal here inorder or preorder or postorder because we would be processing the same node but at different times. Whenever that node would come out of the recursive stack it will then bring its own min and max
    # let try postorder (left, right, root)
    def helper(self, root, currMin, currMax):
        # base
        if(root == None):
            return True

        # logic
        # check if node is in the correct range
        if(not (root.val > currMin and root.val < currMax)):
            # condition is same as (root.val <= currMin or root.val >= currMax)
            return False

        # left call: min same, max = root.val
        # if(self.flag):
        leftValidateBST = self.helper(root.left, currMin, root.val)

        if(not leftValidateBST):
            # no need to further explore the node, as we have got an invalid BST case
            return False

        
        # right call: max same, min = root.val
        # if(self.flag):
        rightValidateBST = self.helper(root.right, root.val, currMax)


        return (leftValidateBST and rightValidateBST)



    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.helper(root, float('-inf'), float('inf'))
        # return self.flag

sol = Solution()
node4.right = node2
print("Method10: Using Min Max Algo to Validate BST. Conditional Boolean based Recursion, Preorder")
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))

node4.right = node5
sol = Solution()
print("Inorder")
inOrder(root)
print("Function Check")
print(sol.isValidBST(root))