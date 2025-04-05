from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Time Complexity: O(3n * n) = O(n^2)
# Space Complexity: O(2n), for storing inleft, inright, preleft, and preright arrays
# Approach:
# We observe that the first element of the preorder array will always give us the root of the tree.
# Once we identify the root, we can identify the index of the root in the inorder array.
# All the elements to the left of this index, will give us the inorder list for the left sub-tree and all the elements to its right will give us the inorder list for the right sub-tree. Since in-order = left-root-right
# Similarly, we can generate preorder list for left and right sub-trees by copying the elements equivalent to the length of the inleft from next to the root and remainder of the elements respectively. Since pre-order = root-left-right
# We can recursively construct the left and right subtrees.
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Base case
        if len(preorder) == 0 or len(inorder) == 0:
            return
        rootVal = preorder[0]
        idx = -1
        # O(n)
        # Find the index of the root in the inorder array
        for i in range(len(inorder)):
            if inorder[i] == preorder[0]:
                idx = i
                break

        # O(2n)
        # Generate the preorder and inorder arrays for the left and right sub-trees
        inleft = inorder[:idx]
        inright = inorder[idx+1:]
        preleft = preorder[1:len(inleft)+1]
        preright = preorder[len(inleft)+1:]

        # Create a node with the value of the current root
        root = TreeNode(rootVal)

        # building the left sub-tree
        # Attach the node returned to the left of the root
        root.left = self.buildTree(preleft, inleft)
        # building the right sub-tree
        # Attach the node returned to the right of the root
        root.right = self.buildTree(preright, inright)

        return root
    

# Time Complexity: O(n) where n is the number of nodes in the tree
# Space Complexity: O(n) for storing the hashmap.
# Approach:
# In the previous approach, there are following inefficiencies:
# 1. We are constructing new arrays for each node, which take O(n^2) time - we can overcome this by passing indices for start and end of the array.
# 2. We are finding the position of the root node in the inorder list in O(n) time - we can overcome this by using a hashmap
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Initializing and populating the hashmap - with values as keys and index as values for the inorder array
        hashMap = {}
        for i in range(len(inorder)):
            hashMap[inorder[i]] = i
        # Initializing the idx, to keep track of the index of the current root as a global variable
        self.idx = 0

        # Recursively building the left and right sub-trees
        def helper(start, end):
            # If the start and end pointers cross each other, it means we do not have any nodes for the sub-tree and so we return
            if start > end:
                return

            # Getting the value for the current root
            rootVal = preorder[self.idx]
            # Once we got the value of the root, we can increment the idx to point to the next root
            self.idx += 1
            # Getting the index of the root in the inorder array
            rootIdx = hashMap[rootVal]
            # Creating a new node with the value as rootVal
            root = TreeNode(rootVal)

            # Recursively building the left and right sub-trees
            root.left = helper(start, rootIdx-1)
            root.right = helper(rootIdx+1, end)
            # Finally, we return the root
            return root

        return helper(0, len(preorder)-1)