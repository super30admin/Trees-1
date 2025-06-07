"""
This module reconstructs a binary tree from its preorder and inorder traversal arrays.

Classes:
--------
TreeNode:
    A class representing a binary tree node with a value, left child, and right child.

Solution:
    Contains the method `buildTree` to construct the tree.

Methods:
--------
buildTree(preorder, inorder):
    Public method that initiates tree construction.

helper(preorder, inorder):
    Recursively constructs the binary tree using preorder and inorder traversal lists.
    - The first element in preorder is always the root.
    - Find the index of the root in inorder to divide left and right subtrees.
    - Recurse on the left and right segments accordingly.

printLevelOrder(root):
    Helper function to print the level order traversal of the binary tree using a queue.

Approach:
---------
Use the preorder list to identify the root, and use the inorder list to determine the structure 
of left and right subtrees.

Time Complexity:
----------------
O(N^2), where N is the number of nodes, because for each recursive call we do a linear search 
to find the root in the inorder list.

Space Complexity:
-----------------
O(H), where H is the height of the tree due to recursion stack.

Note:
-----
This implementation can be optimized to O(N) time by using a hash map to store the index of each 
element in the inorder list.
"""

class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    def buildTree(self, preorder, inorder):
        return self.helper(preorder, inorder)
    
    def helper(self, preorder, inorder):
        if len(preorder) == 0 or len(inorder) == 0:
            return
        
        rootVal = preorder[0]
        rootIdx = 0
        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                rootIdx = i
        root = TreeNode(rootVal)
        leftIn = inorder[:rootIdx]
        leftPre = preorder[1: len(leftIn)+1]
        rightIn = inorder[rootIdx+1:]
        rightPre= preorder[len(leftIn)+1:]
        root.left = self.helper(leftPre, leftIn)
        root.right = self.helper(rightPre, rightIn)
        return root

# Helper to print tree level order
from collections import deque

def printLevelOrder(root):
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        result.append(node.val if node else None)
        if node:
            queue.append(node.left)
            queue.append(node.right)
    # Remove trailing None values for clean output
    while result and result[-1] is None:
        result.pop()
    print(result)

# ---------- MAIN FUNCTION ----------
if __name__ == "__main__":
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    sol = Solution()
    treeRoot = sol.buildTree(preorder, inorder)
    print("Level order traversal of constructed tree:")
    printLevelOrder(treeRoot)