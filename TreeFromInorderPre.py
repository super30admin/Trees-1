#Time complexity-o(n^2)
#space complexiy-o(n)
#run on leetcode-yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        rootVal=preorder[0]
        root=TreeNode(rootVal)
        for i in range(len(inorder)):
            if(inorder[i]==preorder[0]):
                index=i
                break
        root.right=self.buildTree(preorder[i+1:],inorder[i+1:])
        root.left=self.buildTree(preorder[1:i+1],inorder[0:i])
        return root
