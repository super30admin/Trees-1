"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        if not root:
            return True

        stack = [(root, -float('inf'), float('inf'))]
        while len(stack) != 0:
            root, low, high = stack.pop()

            if not root:
                continue
            else:
                value = root.val

                if value >= high or value<= low:
                    return False

                stack.append((root.right,value,high))
                stack.append((root.left,low,value))
        return True
