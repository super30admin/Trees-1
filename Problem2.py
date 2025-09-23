# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Given preorder and inorder traversal of a tree, construct the binary tree.

# Note: You may assume that duplicates do not exist in the tree.

# Can you do it both iteratively and recursively?

# For example, given

# preorder = [3,9,20,15,7]

# inorder = [9,3,15,20,7] Return the following binary tree:

# 3

# / \

# 9 20

# /  \
# 15 7

# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(N) -- inorder hashmap + O(h), h = max height of the tree that is recursive stack space
# calls. h = N in worst case and h = logN in best case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Preorder gives us the root at every step. From this root val we create the root tree node. We search this
# root val in inorder array. Inorder array gives us the span of the left subtree and right subtree of the current
# root we got from preorder array. Since we are searching the index of root val we got from preorder array in the 
# inorder array, we maintain a hashmap of the inorder values to its indices. In every recursive call we create the
# current root node. For getting the current root node from preorder array we keep a global pointer to the preorder
# array, that we increment once we get the current root. We then search the current root index in inorder map to
# get the span of the left and right subtree. For this we maintain two pointers on the inorder array.
# When making left recursive call to get the left child of current tree node our start = parent start and 
# end = idx - 1. Similarly When making right recursive call to get the right child of current tree node our
# start = idx + 1 start and end = parent end.

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution(object):
    def __init__(self):
        # used for keeping track of new root from the preorder traversal
        self.index = 0
    def buildTree(self, preorder, inorder):
        # low, high is used to mark the start and end of node in 
        # inorder traversal
        def helper(preorder, low, high):
            # base case
            if(low > high):
                return None

            # new root node of current tree would be at preorder[self.index]
            root = TreeNode(preorder[self.index])

            # get the new inorder range
            idx = inorderMap[preorder[self.index]]
            self.index += 1

            # low to idx - 1 is left subtree of the root
            # idx + 1 to high is right subtree of the root
            root.left = helper(preorder, low, idx - 1)
            root.right = helper(preorder, idx + 1, high)

            return root

        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        # preorder array would give us the next root
        # inorder would give us the left and right subtree span
        # of the root

        # since we need to search the index in inorder for the root in
        # preorder. we can create hash map as it is give preorder and inorder consist of unique values, for inorder traversal with
        # key = node val and value = index id

        inorderMap = {}
        for i in range(len(inorder)):
            inorderMap[inorder[i]] = i

        # keep track of inorder array using pointers
        # leftIn
        # rightIn
        # no need of inorder array, as we have inorder map to get
        # the index
        return helper(preorder, 0, len(inorder) - 1)
    
def printBinaryTreeInorder(root):
    if(not root):
        return
    
    printBinaryTreeInorder(root.left)
    print(root.val, end=" ")
    printBinaryTreeInorder(root.right)


def printBinaryTreePreorder(root):
    if(not root):
        return
    
    print(root.val, end=" ")
    printBinaryTreePreorder(root.left)
    printBinaryTreePreorder(root.right)

sol = Solution()
root = sol.buildTree([9,3,15,20,7], [9,15,7,20,3])
print("printBinaryTreeInorder")
printBinaryTreeInorder(root)
print()
# print(root.val)
print("printBinaryTreePreorder")
printBinaryTreePreorder(root)

print()
sol = Solution()
root = sol.buildTree([-1], [-1])
print("printBinaryTreeInorder")
printBinaryTreeInorder(root)
print()
# print(root.val)
print("printBinaryTreePreorder")
printBinaryTreePreorder(root)

print()
sol = Solution()
root = sol.buildTree([3,9,8,6,5,20,15,7], [9,6,8,5,3,15,20,7])
print("printBinaryTreeInorder")
printBinaryTreeInorder(root)
print()
# print(root.val)
print("printBinaryTreePreorder")
printBinaryTreePreorder(root)