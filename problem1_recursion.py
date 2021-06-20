# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    result = True
    def isValidBST(self, root: TreeNode) -> bool:

        
        def inorder(root):
            #while root != null and stack is not Empty():
            if root == None:
                return
            inorder(root.left)
            print("\nPop happens here for left call: ", root.val)
            if self.prev !=None and self.prev >= root.val:
                self.result = False
                return
            self.prev = root.val
            inorder(root.right)
            print("\nPop happens here for right call: ", root.val)
        
        
        inorder(root)
        return self.result  
# Time complexity is O(n) where n is number of nodes
# Space complexity is O(h) where h is height of the tree
# recursion is used to compare the node value with previous value