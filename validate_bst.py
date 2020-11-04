# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        stack = []
        prev = None
        while root != None or stack != []:
            while root != None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev != None and prev >= root.val:
                return False
            prev = root.val
            root = root.right
        return True
        #         def inorder(root,prev):
        #             # global prev
        #             if root==None:
        #                 return True
        #             # if:

        #             if not inorder(root.left,prev):
        #                 return False
        #             # print('prev',prev)
        #             # print('root',root.val)
        #             if prev!=None and prev>=root.val:
        #                 return False
        #             prev=root.val
        #             # print(prev)
        #             # inorder(root.left,prev)
        #             return inorder(root.right,prev)
        #             # return True
        #         # prev=TreeNode(None)
        #         return inorder(root,None)
        prev = None

        def inorder(root):
            global prev

            if root == None:
                return True
            # if:

            if not inorder(root.left):
                return False
            print('prev', prev)
            # print('root',root.val)
            if prev != None and prev >= root.val:
                return False
            prev = root.val
            # print(prev)
            # inorder(root.left,prev)
            return inorder(root.right)

        return inorder(root)

    #recursion time-O(n) space=O(height)
    #iteration time-O(n**2) sapce=O(height)