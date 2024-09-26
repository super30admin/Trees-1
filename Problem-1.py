"""
## Problem 1

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


"""



# def ValidBST(root:Node):
#     if root == None:
#         return False
#     return helper(root)
#
# def helper(root):
#     if root == None:  #base case
#         return
#     if root.val < left_child.val or root.val > right_child.val:
#         return False
#     return helper(root,root.right) and helper(root,root.left)


#print(ValidBST([5,1,4,None,None,3,6]))
class Node:
    def __init__(self, x):
        self.val = x
        self.right = None
        self.left = None

class Solution():
    class Node(object):
        def __init__(self,x):
            self.val = x
            self.right = None
            self.left = None

    def validBst(self,root:Node):
        stack=[]
        prev = None
        while root != None or len(stack) !=0:
            while root!= None:
                stack.append(root)
                root=root.left
            root = stack.pop()
            if prev != None and prev.val >= root.val:
                return False
            prev=root
            root=root.right
        return True

root = Node(2)
root.left      = Node(1)
root.right     = Node(3)
root.right.left  = Node(3)
root.right.right  = Node(6)
"""
## Problem 1

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

TIME - O(N)
Spaces - O(N)
LEETCODE - YES
"""



#print(ValidBST([5,1,4,None,None,3,6]))
class Node:
    def __init__(self, x):
        self.val = x
        self.right = None
        self.left = None

class Solution():
    class Node(object):
        def __init__(self,x):
            self.val = x
            self.right = None
            self.left = None

    def validBst1(self,root:Node):  # HERE WE ARE BUILDING THE RECURSION STACK PHYSICALLY
        stack=[]
        prev = None
        while root != None or len(stack) !=0:  # THIS LOOP IS FOR RIGHT RECURSION
            while root!= None:      # THIS LOOP IS FOR LEFT RECURSION
                stack.append(root)
                root=root.left
            root = stack.pop()
            if prev != None and prev.val >= root.val:   # LOGIC PREV VISITED ROOT SHOULD ALWAYS BE LESS THAN CURRENT ROOT
                return False
            prev=root      # ASSIGN CURRENT ROOT AS PREVIOUS BEFORE GOING TO NEXT ROOT
            root=root.right
        return True


# RECURSION
    def validBst2(self,root:Node):
        self.prev = None
        if root ==None:
            return None
        return self.helper(root)

    def helper(self,root):
        if root ==None:
            return True
        if self.helper(root.left) == False:
            return False
        if self.prev != None and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.helper(root.right)



root = Node(2)
root.left      = Node(1)
root.right     = Node(3)
# root.right.left  = Node(3)
# root.right.right  = Node(6)

bst = Solution()
print(bst.validBst1(root))
print(bst.validBst2(root))