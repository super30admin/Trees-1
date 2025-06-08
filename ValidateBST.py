#Time Complexity: O(N)
#Space Complexity: O(H) or O(logN) Height of the binary tree, Recursive call stack


class Solution(object):

    def __init__(self):
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        def validate(node, low, high):

            if node is None:
                return  True # base case: empty tree is valid
            
            
            # Condition: node value must lie between low and high
            if not (low < node.val < high):
                return False
            
            return (validate(node.left, low, node.val) and validate(node.right, node.val, high))


        return validate(root, float('-inf'),float('inf'))

        


