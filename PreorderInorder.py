# Time Complexity : O(n), n is no of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# given - preorder and inorder traversal of a tree
# we are using preorder to find the root
# then searching the root in inorder (using hashmap)
# then using two pointers - start and end to mark the start and end of left and right subtree
# from rootidx in inorder, start to rootidx - 1 is the left subtree
# and from rootidx + 1 to end is the right subtree
# then we move our idx (iterating over preorder) to the next element
# thus, we are picking root from preorder and adding its node in the tree
# then we check left and right roots from the inorder map, if both left and right of the current root are done
# then we move to the next element in preorder


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.map = []
        self.idx = 0
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: Optional[TreeNode]
        """
        
        # getting the root from the preorder traversal
        # getting left and right subtrees from inorder
        # but we will have to linear search for every node in inorder to find its position
        # that is why we store all values and indices from inorder in hashmap

        if preorder is None or inorder is None:
            return None
        
        self.map = {}
        # to iterate oven preorder
        idx = 0

        # putting elements in a map, to optimize linear search
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        
        return self.createTree(preorder, 0, len(preorder) - 1)
    
    def createTree(self, preorder, start, end):
        if start > end:
            return None
        
        # idx is iterating the preorder list
        # rootval is the value of the current root we are processing, we get it from preorder
        rootval = preorder[self.idx]
        # index moves to the next element
        self.idx += 1
        # creating the root node with rootval
        root = TreeNode(rootval)
        # index of the root in inorder
        rootidx = self.map[rootval]
        # making left subtree
        root.left = self.createTree(preorder, start, rootidx - 1)
        # making right subtree
        root.right = self.createTree(preorder, rootidx + 1, end)

        return root

