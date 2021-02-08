# Time Complexity :O(n) where n is number of nodes
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 105

#
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):

    # Wrote a dictionary global dictionary which makes it easy to lookup the position in inorder array at any time in o(1)
    def __init__(self):
        self.mydict = {}

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        # Takes 4 argumnents. Start and end are the array positions from where the preorder array should start and end.
        def helper(preorder, inorder, start, end):
            # preorder = preorder[preStart:preEnd]
            # inorder = inorder[inStart:inEnd]

            if start > end:
                return None
            # If this is empty then we got our answer.
            if not preorder:
                return

            # We just pop the value from the preorder array as everytime we pop, we know that is the root.
            root = TreeNode(preorder.pop())
            # We find the index of that root value in inorder array and all of it to the left is the left subtree and right is right subtree
            index = self.mydict[root.val]

            # Hence the left will be start, index - 1 and right would be index + 1, end.
            root.left = helper(preorder, inorder, start, index - 1)
            root.right = helper(preorder, inorder, index + 1, end)
            return root

        # We create the hashmap for easy lookup on index
        for index in range(len(inorder)):
            self.mydict[inorder[index]] = index
        # We reverse preorder because we really don'tneed the order.
        preorder.reverse()
        return helper(preorder, inorder, 0, len(preorder))

print(Solution().buildTree([3,9,20,15,7],[9,3,15,20,7]))
