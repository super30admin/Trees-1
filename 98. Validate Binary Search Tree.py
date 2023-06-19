# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Using global vs class variables in python

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    '''
    - BST property that Inorder traversal will be sorted is used
    - A global variable prev will keep track of previous node's value and compare with current one
    - Anytime that property is broken during inorder traversal, it will change flag to false and break further recursion
    '''
    def isValidBST(self, root):
        global flag
        global prev
        flag = True
        prev = None
        self.inorder(root)
        return flag

    def inorder(self,root):
        global flag
        global prev
        if root == None:
            return
        if flag == True:
            self.inorder(root.left)
        if prev != None and prev >= root.val:
            flag = False
        prev = root.val
        if flag == True:
            self.inorder(root.right)


# Test case :
def test_isValidBST():
    # Create a binary search tree with valid BST property
    root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(3)

    # Create a binary search tree with invalid BST property
    root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(4)
    root2.right.left = TreeNode(3)
    root2.right.right = TreeNode(6)

    # Test the isValidBST method with valid and invalid binary search trees
    s = Solution()
    assert s.isValidBST(root1) == True
    assert s.isValidBST(root2) == False

test_isValidBST()