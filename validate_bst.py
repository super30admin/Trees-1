#TC = O(n)
#SC = O(n)
#Compiled and run on LC


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def Validate(node, low=-math.inf, high=math.inf):
            if (not node): # Empty trees are valid BSTs.
                return True
            # The current node's value must be between low and high.
            if ((low != None and node.val <= low) and (high != None and node.val >= high)):
                return False
            # The left and right subtree must also be valid
            return (Validate(node.left, low, node.val) and Validate(node.right, node.val, high))

        return Validate(root)