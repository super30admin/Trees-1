# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Time Complexity: 0(n)
    Space Complexity: 0(h)
    Approach:
        Iterative in-order traversal
    """
    def __init__(self):
        self.isValid = True
        self.stack = []
        self.previousVal = None

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        node = root

        while node != None or len(self.stack) != 0:

            # iteration on lhs
            while node != None:
                self.stack.append(node)
                node = node.left
            
            # end of lhs -- stack.pop 
            node = self.stack.pop()

            # comparison for isValid
            if self.previousVal != None and self.previousVal >= node.val:
                # invalid
                self.isValid = False
                break
            
            # update previosu
            self.previousVal = node.val

            # ptr to right
            node = node.right

            continue
        
            # end of while loop

        return self.isValid
