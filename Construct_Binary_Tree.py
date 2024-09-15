#Time Complexity : O(N)
#Space Complexity: O(N)
#Yes it ran on leetcode


class Solution(object):
    def buildTree(self, preorder, inorder):
        global dic
        dic = {}
        global idx
        idx = 0
        if len(preorder) == 0 and len(inorder) == 0:
            return None
        for i in range(len(inorder)):
            dic[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder) - 1)

    def helper(self, preorder, inorder, start, end):
        global dic
        global idx
        # base
        if idx == len(preorder) or start > end:
            return None

        # logic

        rootIdx = dic[preorder[idx]]
        root = TreeNode(preorder[idx])
        idx += 1
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)

        return root