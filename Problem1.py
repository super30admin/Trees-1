"""
98. Validate Binary Search Tree
Time Complexity - O(Depth of tree) 
Space Complexity - O(dept of tree)
Worst Case depth of tree can be all elements
Here we observed that if we push all elements in a stack as we know the last node in left will be smallest element in the tree.Hence pop element from stack check if it has right element and right element value is greater that root poped element.Following in-order traversal we will be able to get element in sorted order if any disrupcy is observed return False
else
Return True"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root == None:
            return True
        prev = None
        stack = []
        while(len(stack) != 0 or root != None):
            while(root != None):
                stack.append(root)
                root = root.left
            
            current = stack.pop()
            
            if (prev != None and current.val <= prev.val):
                return False
            prev = current
            root = current.right
        return True