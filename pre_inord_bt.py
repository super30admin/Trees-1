# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder :
            return None
        hashmap={}
        for i,no in enumerate(inorder):
            hashmap[no]=i
        rootIdx = hashmap[preorder[0]]

        root = TreeNode(preorder[0])

        preLeft = preorder[1:rootIdx+1]
        preRight = preorder[rootIdx+1:]
        inLeft = inorder[:rootIdx]
        inRight= inorder[rootIdx+1:]

        root.left = self.buildTree(preLeft,inLeft)
        root.right = self.buildTree(preRight,inRight)

        return root
        