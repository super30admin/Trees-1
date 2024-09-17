# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        rootindex = 0
        # root=TreeNode(preorder[0])
        root = TreeNode(preorder[0])
        # print(root)
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                rootindex = i

        inorderleft = inorder[:rootindex]
        inorderright = inorder[rootindex + 1:]
        preorderleft = preorder[1:len(inorderleft) + 1]
        preorderright = preorder[len(inorderleft) + 1:]
        # preorderleft=preorder[1:len(inorderright)+1]
        ##can also be written as 1:rootindex+1 and rootindex+1 to end since both are same
        # preorderright=preorder[len(inorderleft)+1:]
        root.left = self.buildTree(preorderleft, inorderleft)
        root.right = self.buildTree(preorderright, inorderright)
        # print(root)
        return root

