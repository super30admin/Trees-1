# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flagg = True

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Approach 1
        # Time Complexity: O(n) n are all the nodes
        # Space Complexity: O(1)
        # flag = [1]
        # def validate(node, range):
        #     if flag[0] == 0:
        #         return
        #     if node:
        #         if node.val > range[0] and node.val < range[1]:
        #             validate(node.left, [range[0], node.val])
        #             validate(node.right, [node.val, range[1]])
        #         else:
        #             flag[0] = 0
        # validate(root, [-float(inf), float(inf)])
        # if flag[0] == 1:
        #     return True
        # return False

        # Approach 2 Recursion Using Void Recursion
        # Time Complexity: O(1)
        # Space Complexity: O(1)
        self.prev = TreeNode(-2 ** 31)

        def recursiveinorder(root):
            if not root:
                return
            if flag[0] == 0:
                return
            recursiveinorder(root.left)
            if self.prev and self.prev.val >= root.val:
                flag[0] = 0
                return
            self.prev = root
            recursiveinorder(root.right)

        flag = [1]
        prevv = 0
        recursiveinorder(root)
        if flag[0] == 0:
            return False
        return True



