# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Thinking about the logic


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        lookup = {}
        for i, val in enumerate(inorder):
            lookup[val] = i
        
        stack = []
        head = None
        for item in preorder:
            if not head:
                head = TreeNode(item)
                stack.append(head)
            else:
                node = TreeNode(item)
                if lookup[item] < lookup[stack[-1].val]:
                    stack[-1].left = node
                    stack.append(node)
                else:
                    while stack and lookup[item] > lookup[stack[-1].val]:
                        temp = stack.pop()
                    temp.right = node
                    stack.append(node)
        return head