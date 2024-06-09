'''
Problem 1: https://leetcode.com/problems/validate-binary-search-tree/

For all solutions:
Time complexity: O(n) where n is number of nodes
Space complexity: O(h) where h is max height of the tree
(required for recursion stack or iterative stack)

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Solution1: Iterative inorder traversal using stack

class Solution1:
  def isValidBST(self, root):
    stack = []
    node = root
    previous = None
    while node != None or len(stack) > 0:

      #left recurisve call
      while node != None:
        stack.append(node)
        node = node.left

      #compare root with previous
      node = stack.pop()
      if previous != None and previous.val >= node.val:
        return False

      #right recursive call
      previous = node
      node = node.right
    return True

############################################################################

#Solution2: Recursive inorder traversal (using boolean return)

class Solution2:
  def isValidBST(self, root):
    if not root:
      return True

    self.previous = None

    return self.inorder(root)

  def inorder(self, root):
    if not root:
      return True

    #left recurisve call
    isLeftValid = self.inorder(root.left)

    #compare root with previous
    if self.previous and self.previous.val >= root.val:
      return False

    self.previous = root

    #right recursive call
    isRightValid = self.inorder(root.right)

    return isLeftValid and isRightValid

############################################################################

#Solution3: Recursive inorder traversal (with void return and global instance variable isValid)

class Solution3:
  def isValidBST(self, root):
    if not root:
      return True

    self.previous = None
    self.isValid = True

    self.inorder(root)

    return self.isValid

  def inorder(self, root):
    if not root:
      return

    #left recurisve call
    self.inorder(root.left)

    #compare root with previous
    if self.previous and self.previous.val >= root.val:
      self.isValid = False

    self.previous = root

    #right recursive call
    self.inorder(root.right)

    return self.isValid

############################################################################

#Solution4: Checking node values within range (recursive function with boolean return)

class Solution4:
  def isValidBST(self, root):
    return self.isValidRecusive(root, float('-inf'), float('inf'))

  def isValidRecusive(self, root, leftLimit, rightLimit):
    #base case
    if root == None:
      return True

    #comparision
    if root.val <= leftLimit or root.val >= rightLimit:
      return False

    #recursive calls
    return self.isValidRecusive(root.left, leftLimit, root.val) and self.isValidRecusive(root.right, root.val, rightLimit)

#############################################################################

#Solution5: Checking node values within range (recursive function with void return global instance variable isValid)

class Solution5:
  def isValidBST(self, root):
    self.isValid = True
    self.isValidRecusive(root, float("-inf"), float("inf"))

    return self.isValid

  def isValidRecusive(self, root, leftLimit, rightLimit):
    #base case
    if root == None:
      return

    #comparision
    if root.val <= leftLimit or root.val >= rightLimit:
      self.isValid = False
      return
    
    #recursive calls
    self.isValidRecusive(root.left, leftLimit, root.val)

    if not self.isValid:
      return

    self.isValidRecusive(root.right, root.val, rightLimit)
