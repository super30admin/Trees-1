
"""
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Input: root = [2,1,3]
Output: true

To check if the tree is a BST, we will traverse the tree in preorder manner and check if it is sorted

We traverse inorder and at each node we check if it is greater than the previous pointer,
we basically maintain a previous pointer and compare it with current pointer 


**IMPORTANT**
Incorrect Ways : if we pass previous as a local variable, we will not be able to track the root correctly and 
we may not be able to check the null conditions at required places

hence previous has to be a global variable


TC = O(n)
SC = O(n) 
"""
from operator import truediv



class Treenode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.right = right
        self.left = left
root = [Treenode]
root = [2,1,3]

class Solution : 
    flag = True
    previous =  Treenode()
    def isValidBST(self, root) -> bool :
        flag = True
        inorder(self, root)
        return(flag)

def inorder(self, root) :
    if root == None:
        return
    inorder(root.left)
    if previous!=None and previous>=root.val:
        flag = False
    previous = root
    inorder(root.right)
    

object = Solution()
ans = object.isValidBST(root)
print(root)
print(ans)