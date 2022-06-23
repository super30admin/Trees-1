# 98. Validate Binary Search Tree
"""
Time Complexity :  O(n)
Space Complexity : O(height of tree)

First logic : simple recursion with flag as global variable
    maintaining a prev node and comparing it with current root node value.

Second logic : recursion with passing min and max value
    passing min amx max value i.e. range in whic hcurrent root node should lie in.
    If that condition is broken then tree is not BST
    max will remain same for all right nodes and min will remain same for all left nodes


"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# [30,20,40,10,25,35,60,0,15,22,23,32,39,50,80

class Solution:
    """
    flag = True
    prev = TreeNode()
    prev = None
    def helper(self, root):
        if root == None:
            return

        self.helper(root.left)
        #st.pop
        print("up", root.val)

        if self.prev!=None :
            if self.prev.val >= root.val :
                self.flag = False

        self.prev = root

        self.helper(root.right)
        #st.pop
        #print("down", root.val)
    """
    flag = True

    def helper(self, root, mi, ma):
        if root == None:
            return

        self.helper(root.left, mi, root.val)

        print("up", root.val)

        if mi != None and mi >= root.val:
            print("here1")
            self.flag = False

        if ma != None and ma <= root.val:
            print("here2")
            self.flag = False

        self.helper(root.right, root.val, ma)

        # print("down", root.val)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        flag = True
        # print(root.left.val)
        self.helper(root, None, None)
        print(self.flag)
        return self.flag